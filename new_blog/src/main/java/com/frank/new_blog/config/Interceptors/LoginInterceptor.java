package com.frank.new_blog.config.Interceptors;

import com.frank.new_blog.utils.Constant;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : ademo
 * @Package : com.example.ademo.config.Interceptors
 * @createTime : 2023/1/4 22:32
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        HttpSession session = request.getSession(true);
        if (session != null && session.getAttribute(Constant.SESSION_USERINFO_KEY) != null) {
            response.setStatus(200);
            return true;
        }
        response.setStatus(401);
        response.sendRedirect("login.html");
        return false;
    }
}
