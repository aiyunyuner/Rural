package com.TypeDelta.filter;

import com.TypeDelta.pojo.LogMe;
import com.TypeDelta.service.LogService;
import com.TypeDelta.utils.JWTUtils;
import com.TypeDelta.utils.TimeUtils;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.TypeDelta.utils.Info.*;

@Component
public class LoginFilter extends ZuulFilter {
    @Autowired
    private LogService logService;
    @Value("${server.port}")
    private String server_port;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER - 1; //负数的优先级最高
    }

    @Override
    public boolean shouldFilter() {
        //        获取请求上下文
        RequestContext ctx = RequestContext.getCurrentContext(); //有点像request域 zuul整个流程都有这个域
        HttpServletRequest request = ctx.getRequest();

        String uri = request.getRequestURI();
        //不拦截登录页和注册页
        if (uri.contains(LOGIN_URI) || uri.contains(REGISTER_URI) || uri.contains(IMG_URI)) {
            return false;
        }
        //其余的都拦截
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //        获取请求上下文
        RequestContext ctx = RequestContext.getCurrentContext(); //有点像request域 zuul整个流程都有这个域
        HttpServletRequest request = ctx.getRequest();
        String ip = request.getRemoteAddr();
//        String ip2 = request.getHeader("x-forwarded-for");
//        System.out.println("x-forwarded-for ip: " + ip2);
//        System.out.println("ip" + ip);
        //        获取请求的参数
        String token = request.getHeader("token");
//        String token = request.getParameter("access-token");
//        判断是否存在
        try {
            JWTUtils.verify(token);
            String id = JWTUtils.getTokenInfo(token).getClaim("id").asString();
            Map<String, List<String>> requestQueryParams = ctx.getRequestQueryParams();

            if (requestQueryParams == null) requestQueryParams = new HashMap<>();
            //将要新增的参数添加进去,被调用的微服务可以直接 去取,就想普通的一样,框架会直接注入进去
            ArrayList<String> paramsList = new ArrayList<>();
            paramsList.add(id);
            requestQueryParams.put("u_id", paramsList);
            LogMe logMe = new LogMe();
            logMe.setU_id(Integer.parseInt(id));
            logMe.setIp(ip);
            if (request.getRequestURI().contains("/sights")) {
                logMe.setType("风景");
            } else if (request.getRequestURI().contains("/agricultural")) {
                logMe.setType("活动");
            } else if (request.getRequestURI().contains("/rural")) {
                logMe.setType("动态");
            } else if (request.getRequestURI().contains("/employment")) {
                logMe.setType("就业");
            }
            if (request.getRequestURI().contains("/user")){
                ctx.setRequestQueryParams(requestQueryParams);
                ctx.setSendZuulResponse(true);
            }else {
                logMe.setAction(request.getRequestURI());
                logMe.setWhere("四川");
                logMe.setTime(TimeUtils.setTime());
                logService.insertLog(logMe);
                ctx.setRequestQueryParams(requestQueryParams);
                ctx.setSendZuulResponse(true);
            }

        } catch (SignatureVerificationException e) {
            e.printStackTrace();

//            ctx.setResponseBody("无效签名");
            ctx.setResponseBody("token error");
            ctx.setSendZuulResponse(false);
        } catch (TokenExpiredException e) {
            e.printStackTrace();

//            ctx.setResponseBody("token过期");
            ctx.setResponseBody("token error");
            ctx.setSendZuulResponse(false);
        } catch (AlgorithmMismatchException e) {
            e.printStackTrace();

//            ctx.setResponseBody("token算法不一致");
            ctx.setResponseBody("token error");
            ctx.setSendZuulResponse(false);
        } catch (Exception e) {
            e.printStackTrace();
            ctx.setResponseBody("token error");
            ctx.setSendZuulResponse(false);

        }
        System.out.println("现在是zuul：" + server_port);
//        存在不做处理，存在
        return null;
    }
}
