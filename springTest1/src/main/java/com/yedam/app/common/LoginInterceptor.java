package com.yedam.app.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

class LoginInterceptor extends HandlerInterceptorAdapter{


	 public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	        try {
	            //memberVO이라는 세션key를 가진 정보가 널일경우 로그인페이지로 이동
	            if(request.getSession().getAttribute("memberVO") == null ){
	                    response.sendRedirect("loginForm");
	                    return false;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        //admin 세션key 존재시 main 페이지 이동
	        return true;
	    }
	 
	 	
	    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	        super.postHandle(request, response, handler, modelAndView);
	    }
	 

	    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	        super.afterCompletion(request, response, handler, ex);
	    }
	 
	 
	    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	        super.afterConcurrentHandlingStarted(request, response, handler);
	    }
	

	
	
}
