package com.offcn.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//登录拦截器 -- 实现登录验证 --- 有些请求不需要拦截 --- 有些请求必须拦截
public class LoginInterceptor implements HandlerInterceptor {
    //prehandle方法的典型应用--登录验证的应用
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        //是toMain.do是放行；是list.do不放行的
        //获取到url
        String url = request.getRequestURI();
        //System.out.println(url);
        int index = url.lastIndexOf("/");
        String newUrl = url.substring(index);
        if(!"/list.do".equals(newUrl)){
            return true;
        }else{
            //验证是否登录了
            String username = (String) session.getAttribute("username");
            if(username != null){
                return true;
            }
        }

        //返回登录页面
        response.sendRedirect(request.getServletContext().getContextPath()+"/login.jsp");

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
