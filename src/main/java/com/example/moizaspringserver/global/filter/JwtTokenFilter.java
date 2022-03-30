package com.example.moizaspringserver.global.filter;

import com.example.moizaspringserver.global.error.exception.CustomException;
import com.example.moizaspringserver.global.error.exception.ErrorCode;
import com.example.moizaspringserver.global.error.security.InvalidTokenException;
import com.example.moizaspringserver.global.error.security.NoTokenServedException;
import com.example.moizaspringserver.global.security.JwtTokenProvider;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
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
        if(StringUtils.isEmpty(jwtToken)) throw new NoTokenServedException();
        else if(!jwtTokenProvider.validation(jwtToken)) throw new InvalidTokenException();

        filterChain.doFilter(request, response);
    }

    private String parseJwtToken(HttpServletRequest req) {
        String token = req.getHeader("Authorization");
        if(StringUtils.isEmpty(token) || !token.startsWith("Bearer ")) return null;

        return token.split("Bearer ")[1];
    }

}
