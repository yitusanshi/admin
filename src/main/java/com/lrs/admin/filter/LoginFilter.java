package com.lrs.admin.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.lrs.admin.entity.Const;
import com.lrs.admin.entity.User;
import com.lrs.admin.service.IUserService;
import com.lrs.admin.util.ParameterMap;

/**
 * 登录拦截
 * @author rstyro
 *
 */
@WebFilter(filterName="loginFilter",urlPatterns={"/*"})
public class LoginFilter implements Filter{
	//静态资源文件地址
	private static final String PTAH_REG=".*\\.((js)|(css)|(png)|(jpg)|(woff)|(woff2)|(map)|(svg)|(ttf)|(ico))";
	//不过滤的地址
	private static final String NOT_FILTER="/((login)|(logout)|(regist)|(toLogin)|(error)|(upload)|(editPassword)|(index)|(include)).*";

	@Autowired
	private IUserService userService;
	
    @Override
    public void destroy() {}
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
    	 HttpServletRequest request = (HttpServletRequest) req;
         HttpServletResponse response = (HttpServletResponse) res;
         String path = request.getServletPath();
         System.out.println("过滤器的路径是"+path+"=========================");
         
/*         if(!path.matches(PTAH_REG) && !path.matches(NOT_FILTER) && !path.equals("/")){
        	 if(userService == null){
        		 BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext()); 
        		 userService = (IUserService) factory.getBean("userService"); 
        	 }
        	 User sessionUser = (User) request.getSession().getAttribute(Const.SESSION_USER);
        	 if(sessionUser == null){
        		 response.sendRedirect(request.getContextPath()+"/toLogin");
        		 return;
        	 }
        	 ParameterMap pm = new ParameterMap();
        	 pm.put("user_id", sessionUser.getUserId());
        	 User user = userService.getUserInfo(pm);
        	 System.out.println("sessionUser="+sessionUser);
        	 System.out.println("user="+user);
        	 if(user == null){
        		 response.sendRedirect(request.getContextPath()+"/toLogin");
        	 }else{
        		 if(!sessionUser.getSessionId().equals(user.getSessionId())){
        			 response.sendRedirect(request.getContextPath()+"/toLogin");
        		 }
        	 }
         }*/
    	
        chain.doFilter(request, response);
    }
    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }
}
