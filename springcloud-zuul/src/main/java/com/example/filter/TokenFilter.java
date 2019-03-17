package com.example.filter;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 验证每一次请求必须在请求头中携带参数token，否则不进行路由转发
 * @author ycn
 *
 */
@Component
public class TokenFilter extends ZuulFilter{
	
	Logger log = LoggerFactory.getLogger(TokenFilter.class);

	@Override
	public Object run() {
//		RequestContext requestContext = RequestContext.getCurrentContext();
//		HttpServletRequest request = requestContext.getRequest();
//		String token = request.getHeader("token");
//		if (StringUtils.isEmpty(token)) {
//			requestContext.setSendZuulResponse(false);
//			requestContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
//			requestContext.setResponseBody("{\"code\":401}");
//			log.warn("用户请求校验未通过！" + request.getRequestURI());
//
//		}
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1;
	}

	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

}
