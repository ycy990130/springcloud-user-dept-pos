package com.jk.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

@Component
public class MyFilter extends ZuulFilter {

    /*
        filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
					pre：路由之前 ,先执行过滤器再执行后台方法
					routing：路由之时, 执行完后台方法在执行过滤器
					post： 路由之后, 执行完后台方法在执行过滤器
					error：发送错误调用，如果请求正常没有错误，则不需要执行业务逻辑判断
    */

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        return null;
    }
}
