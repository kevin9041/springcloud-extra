package com.forezp.filter;

import com.netflix.zuul.ZuulFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Component;

/**
 * Created by forezp on 2017/8/3.
 */
@Component
public class LoggerFilter extends ZuulFilter {

    @Autowired
    Tracer tracer;
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 900;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {

		//链路数据中添加自定义数据
        tracer.addTag("operator","weihuanbo");
		
        System.out.print(tracer.getCurrentSpan().traceIdString());
        return null;
    }
}
