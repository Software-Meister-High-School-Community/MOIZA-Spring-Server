package com.example.moizaspringserver.global.filter;

import com.example.moizaspringserver.global.security.JwtTokenProvider;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtTokenFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;
    public JwtTokenFilter(JwtTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwtToken = this.parseJwtToken(request);
            if(StringUtils.isEmpty(jwtToken)) request.setAttribute("unauthorization", "token required");
            else if(!jwtTokenProvider.validation(jwtToken)) request.setAttribute("unauthorization", "invalid or expired token");

        }catch (Exception ex) {
            request.setAttribute("unauthorization", "something went wrong");
        }
        filterChain.doFilter(request, response);
    }

    private String parseJwtToken(HttpServletRequest req) {
        String token = req.getHeader("Authorization");
        if(StringUtils.isEmpty(token) || !token.startsWith("Bearer ")) return null;

        return token.split("Bearer ")[1];
    }

}
