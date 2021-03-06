package com.simdy.Config;

import com.simdy.cms.interceptor.DownloadInterceptor;
import com.simdy.cms.interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @ClassName MyWebMvcConfigurerAdapter
 * @Description TODO
 * @Author simdy
 * @Date 2019/3/24 14:50
 * @Version 1.0
 **/
@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        /**
         * 资源映射路径
         * addResourceHandler：访问映射路径
         * addResourceLocations：资源绝对路径
         */
        registry.addResourceHandler("/image/**").addResourceLocations("file:D:/imageTemp/image/");
    }
    /**
     * 注册拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/manager/**").excludePathPatterns("http://localhost:8080/login").excludePathPatterns("/manager/userLogin");
        registry.addInterceptor(new DownloadInterceptor()).addPathPatterns("/download/**");
    }
}
