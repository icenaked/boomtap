package com.zyq.boomtap.filter;

import com.alibaba.fastjson.JSONObject;
import com.zyq.boomtap.model.vo.ResultVO;
import com.zyq.boomtap.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
//一定导入servlet的Filter
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import java.io.IOException;

@Slf4j
//指定拦截路径
@WebFilter(urlPatterns = "/user/*")
public class DemoFilter implements Filter {
    //初始化，web服务器启动时调用一次
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter,启动！");
    }

    //每次拦截都会调用
    @Override
    public void destroy() {
        System.out.println("filter,销毁！");
    }

    //销毁方法，关闭服务器时调用一次
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //System.out.println("filter拦截到一个跟user相关的请求！");

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String url = req.getRequestURL().toString();
        log.info("请求的url： "+url);

        if(url.contains("login")){
            log.info("登陆操作，放行");
            filterChain.doFilter(req, resp);
            return;
        }

        //读取header中的token字段
        String jwt = req.getHeader("token");

        if (!StringUtils.hasLength(jwt)){
            log.info("请求头为空,不予放行");
            ResultVO err = ResultVO.buildFailure("未登录!");
            //不是controller,所以要手动转为json
            String notLogin = JSONObject.toJSONString(err);
            //转完直接给浏览器
            resp.getWriter().write(notLogin);
            return;
        }

        try {
            JwtUtils.parseJwt(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析令牌失败");
            ResultVO err = ResultVO.buildFailure("登录信息异常!");
            String notLogin = JSONObject.toJSONString(err);
            resp.getWriter().write(notLogin);
            return;
        }

        //放行
        log.info("没问题，可放行！");
        filterChain.doFilter(req, resp);
    }
}
