package com.uc.uccentergateway.config;import com.netflix.zuul.ZuulFilter;import com.netflix.zuul.exception.ZuulException;import org.springframework.stereotype.Component;/** * @author 9527 * @ClassName CustomZuulFilterPost * @Date 2020/1/15 * @Description TODO * @Version 1.0 */@Componentpublic class CustomZuulFilterPost extends ZuulFilter {    @Override    public String filterType() {        return "post";    }    @Override    public int filterOrder() {        return 0;    }    @Override    public boolean shouldFilter() {        return false;    }    @Override    public Object run() throws ZuulException {        return null;    }}