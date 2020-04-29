package com.sa.apigateway;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

@Component
public class ResponseFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(ResponseFilter.class);

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        log.info(String.format("From postFilter: Response to %s with code %s", request.getRequestURI(), requestContext.getResponseStatusCode()));

        String responseBody = null;
        try (final InputStream responseDataStream = requestContext.getResponseDataStream()) {
            responseBody = StreamUtils.copyToString(responseDataStream, StandardCharsets.UTF_8);
            requestContext.setResponseBody(responseBody);
        } catch (IOException e) {
            log.warn("Error reading body",e);
        }

        System.out.println("ResponseBody: " + responseBody.toUpperCase());
        return requestContext.getResponse();
    }
}
