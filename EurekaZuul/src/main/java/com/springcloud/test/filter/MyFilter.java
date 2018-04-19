package com.springcloud.test.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
//zuul不仅只是路由，并且还能过滤，做一些安全验证。
@Component
public class MyFilter extends ZuulFilter {

	@Override
	public String filterType() {
		// 返回的一个字符串代表过滤器的类型
		// 在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
		// pre：路由之前
		// routing：路由之时
		// post： 路由之后
		// error：发送错误调用
		return "pre";
	}

	@Override
	public int filterOrder() {
		// filterOrder：过滤的顺序
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		// shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
		return true;
	}

	@Override
	public Object run() {
		// run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
		// 若想通过，必须携带上token参数   http://localhost:8766/api-a/getHi?name=aaa&token=22
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		System.err.println(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
		Object accessToken = request.getParameter("token");
		if (accessToken == null) {
			System.err.println("token为空，请求被拦截");
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			try {
				ctx.getResponse().getWriter().write("token is empty");
			} catch (Exception e) {
			}

			return null;
		}
		System.err.println("token不为空，放行");
		return null;
	}
}
