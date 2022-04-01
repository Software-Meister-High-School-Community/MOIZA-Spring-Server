package com.example.moizaspringserver.global.filter;

import com.example.moizaspringserver.global.error.security.InvalidTokenException;
import com.example.moizaspringserver.global.security.JwtTokenAuthentication;
import com.example.moizaspringserver.global.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String jwtToken = this.parseJwtToken(request);

        Boolean validated = jwtTokenProvider.validation(jwtToken);
        JwtTokenAuthentication jwtAuthentication = new JwtTokenAuthentication(jwtToken, validated);
        SecurityContextHolder.getContext().setAuthentication(jwtAuthentication);

        filterChain.doFilter(request, response);
    }

    private String parseJwtToken(HttpServletRequest req) {
        String token = req.getHeader("Authorization");
        if(StringUtils.isEmpty(token) || !token.startsWith("Bearer ")) return null;

        return token.split("Bearer ")[1];
    }

}
