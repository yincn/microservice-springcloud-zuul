package com.example.filter;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.example.exception.RateLimiterException;
import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;

@Component
public class RateLimiterFilter extends ZuulFilter {
	
	// 限流
	private static final RateLimiter RATE_LIMITER = RateLimiter.create(100);

	@Override
	public Object run() {
		if (!RATE_LIMITER.tryAcquire()) {
			throw new RateLimiterException();
		}
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return FilterConstants.SERVLET_DETECTION_FILTER_ORDER - 1;
	}

	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

}
