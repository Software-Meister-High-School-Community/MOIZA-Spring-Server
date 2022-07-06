package com.example.moizaspringserver.global.security;

import com.example.moizaspringserver.global.enums.UserType;
import com.example.moizaspringserver.global.filter.JwtTokenFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtTokenProvider jwtTokenProvider;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .formLogin().disable()
                .cors()

                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()

                // auth
                .antMatchers(HttpMethod.POST,"/auth/tokens").permitAll()
                .antMatchers(HttpMethod.PUT, "/auth/tokens").permitAll()
                .antMatchers(HttpMethod.HEAD, "/auth/id-validations").permitAll()
                .antMatchers(HttpMethod.POST, "/auth/email-verifications").permitAll()

                // user
                .antMatchers(HttpMethod.POST, "/users").permitAll()
                .antMatchers(HttpMethod.PATCH, "/users").authenticated()
                .antMatchers(HttpMethod.GET, "/users/searching").authenticated()
                .antMatchers(HttpMethod.POST, "/users/graduate-verifications").hasAuthority(UserType.ROLE_USER.name())
                .antMatchers(HttpMethod.GET, "/").authenticated()
                .antMatchers(HttpMethod.GET, "/{user-id}").authenticated()

                // notice
                .antMatchers(HttpMethod.DELETE, "/notices/{notice-id}").hasAnyAuthority("ADMIN")

                // follow
                .antMatchers(HttpMethod.POST, "/follow/*").authenticated()
                .antMatchers(HttpMethod.GET, "/following/*").authenticated()
                .antMatchers(HttpMethod.DELETE, "/*/following").authenticated()

                // feeds
                .antMatchers(HttpMethod.DELETE, "/feeds/{feed-id}").authenticated()
                .antMatchers(HttpMethod.PATCH, "/feeds/temporaries/{feed-id}").hasAnyAuthority(UserType.ROLE_STUDENT.name(), UserType.ROLE_GRADUATE.name())

                // notice
                .antMatchers(HttpMethod.GET, "/notices/{notice-id}").authenticated()

                .anyRequest().denyAll()

                .and()
                .addFilterBefore(new JwtTokenFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class);
    }
}
