package org.uberfire.backend.server.impl;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CorsFilter implements Filter {

    public CorsFilter() {
    }

    public void init( FilterConfig fc ) throws ServletException {
    }

    public void destroy() {
    }

    public void doFilter( ServletRequest request,
                          ServletResponse response,
                          FilterChain chain ) throws IOException, ServletException {

        HttpServletResponse r = (HttpServletResponse) response;
        String origin = ( (HttpServletRequest) request ).getHeader( "origin" );
        if(origin!=null){
            r.addHeader( "Access-Control-Allow-Origin", origin );
            r.addHeader( "Access-Control-Allow-Headers",
                         "Accept,Accept-Encoding,Accept-Language,Cache-Control,Connection,Content-Length,Content-Type," +
                                 "Cookie,Host,Pragma,Referer,RemoteQueueID,User-Agent" );
            r.addHeader( "Access-Control-Allow-Credentials", "true" );
        }
        chain.doFilter( request, response );
    }
}