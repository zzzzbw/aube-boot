package com.github.zzzzbw.aube.web.starter.filter;

import cn.hutool.extra.servlet.ServletUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author by zzzzbw
 * @since 2020/08/13 10:27
 */
@Slf4j
@Component
public class LogFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String remoteAddr = ServletUtil.getClientIP(request);

        log.info("Starting url: [{}], method: [{}], ip: [{}]", request.getRequestURL(), request.getMethod(), remoteAddr);

        // Set start time
        long startTime = System.currentTimeMillis();

        // Do filter
        filterChain.doFilter(request, response);

        log.info("Ending url: [{}], method: [{}], ip: [{}], status: [{}], usage: [{}] ms",
                request.getRequestURL(), request.getMethod(), remoteAddr, response.getStatus(), System.currentTimeMillis() - startTime);
    }
}
