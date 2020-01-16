package com.uc.uccentergateway.config;import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;import org.springframework.http.HttpHeaders;import org.springframework.http.HttpStatus;import org.springframework.http.MediaType;import org.springframework.http.client.ClientHttpResponse;import org.springframework.stereotype.Component;import java.io.ByteArrayInputStream;import java.io.IOException;import java.io.InputStream;/** * @author 9527 * @ClassName CustomFallBack * @Date 2020/1/15 * @Description TODO * @Version 1.0 */@Componentpublic class CustomZuulFallBack implements FallbackProvider {    @Override    public String getRoute() {        return "*";    }    @Override    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {        return new ClientHttpResponse() {            @Override            public HttpStatus getStatusCode() throws IOException {                return HttpStatus.OK;            }            @Override            public int getRawStatusCode() throws IOException {                return HttpStatus.OK.value();            }            @Override            public String getStatusText() throws IOException {                return HttpStatus.OK.getReasonPhrase();            }            @Override            public void close() {            }            @Override            public InputStream getBody() throws IOException {                String fallback = "{\"status\":500,\"message\":\"zuul fallback\"}";                return new ByteArrayInputStream(fallback.getBytes("UTF-8"));            }            @Override            public HttpHeaders getHeaders() {                HttpHeaders httpHeaders = new HttpHeaders();                httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);                return httpHeaders;            }        };    }}