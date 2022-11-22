package com.frank.demo.config;

import com.frank.demo.config.interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : Frank.Ren
 * @version : 1.0
 * @Project : biteClass1
 * @Package : com.frank.demo.config
 * @createTime : 2022/11/8 16:48
 * @Email : sc19lr@leeds.ac.uk
 * @github : https://github.com/frankRenlf
 * @Description :
 */
@Configuration
public class LoginConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    // 添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**") // 拦截所有接⼝
                .excludePathPatterns("/**/*.js")
                .excludePathPatterns("/**/*.css")
//                .excludePathPatterns("/**/*.png")
//                .excludePathPatterns("/**/*.jpg")
                .excludePathPatterns("/blogpro/images/**")
                .excludePathPatterns("/**/blog_login.html")
                .excludePathPatterns("/**/blog_register.html")
                .excludePathPatterns("/**/login")
                .excludePathPatterns("/**/testAdvice/**")
                .excludePathPatterns("/**/register")
                .excludePathPatterns("/ImageEditorJavaScript/**")
                .excludePathPatterns("/LeedsInfo/**")
                .excludePathPatterns("/photo-editor/**")
                .excludePathPatterns("/advanced/**")
                .excludePathPatterns("/home/**");
        ; // 排除接⼝
    }

    public LoginInterceptor getLoginInterceptor() {
        return loginInterceptor;
    }

    public void setLoginInterceptor(LoginInterceptor loginInterceptor) {
        this.loginInterceptor = loginInterceptor;
    }
}
