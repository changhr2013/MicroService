package com.changhr.cloud.gateway.zuul.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Zuul 过滤器
 *
 * @author changhr
 * @create 2018-12-12 16:43
 */
public class PreRequestLogFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(PreRequestLogFilter.class);

    /**
     * 返回过滤器的类型。
     * 有 pre、route、post、error等几种取值
     * 1. PRE: 这种过滤器在请求被路由调用之前调用。可利用这种过滤器实现身份认证、在集群中选择请求的微服务，记录调试信息等。
     * 2. ROUTING：这种过滤器将请求路由到微服务。这种过滤器用于构建发送给微服务的请求，并使用Apache HttpClient或Netflix Ribbon请求微服务。
     * 3. POST：这种过滤器在路由到微服务以后执行。这种过滤器可用来为响应添加标准的HTTP Header、收集统计信息和指标、将响应从微服务发送给客户端。
     * 4. ERROR：在其他阶段发生错误时执行该过滤器。
     * 分别对应上文的几种过滤器
     * @return String
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 返回一个int值来制定过滤器的执行顺序
     * 不同的过滤器允许返回相同的数字
     * @return int
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 返回一个boolean值来判断该过滤器是否要执行
     * true表示执行，false表示不执行
     * @return boolean
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑
     * 本过滤器让它打印了请求的HTTP方法以及请求的地址
     * @return  Object
     * @throws ZuulException 网关异常
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        PreRequestLogFilter.logger.info(String.format("send %s request to %s",
                request.getMethod(), request.getRequestURL().toString()));
        return null;
    }
}
