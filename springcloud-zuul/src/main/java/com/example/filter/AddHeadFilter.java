package com.example.filter;

import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 每次请求返回时，往请求头里添加一个参数 X-Foo
 * @author ycn
 *
 */
@Component
public class AddHeadFilter extends ZuulFilter {

	@Override
	public Object run() {
		RequestContext requestContext = RequestContext.getCurrentContext();
		HttpServletResponse response = requestContext.getResponse();
		response.addHeader("X-Foo", UUID.randomUUID().toString().replaceAll("-", ""));
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1;
	}

	@Override
	public String filterType() {
		return FilterConstants.POST_TYPE;
	}

}
