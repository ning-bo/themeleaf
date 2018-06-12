package com.example.themeleaf.common.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author NingBo
 * @create 2018-05-24 16:13
 * @desc @Configuration 让SpringBoot自动加载类内的配置
 *  继承WebMvcConfigurerAdapter这个类，这个类是SpringBoot内部提供专门处理用户自行添加的配置，
 *  里面不仅仅包含了修改视图的过滤还有其他很多的方法，包括我们后面章节要讲到的拦截器，过滤器，Cors配置等
 **/
@Configuration
public class InterceptorConfiguration extends WebMvcConfigurerAdapter {

    /**
     * 拦截器相关
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截

        /*1.registry.addInterceptor(getInterfaceAuthCheckInterceptor()).addPathPatterns("/api*//**");
         这种方式无论什么情况都可以
         2.registry.addInterceptor(new InterfaceAuthCheckInterceptor()).addPathPatterns("/api*//**");
         这种情况时，自定义的interceptor中不能注入其他内容，比如redis或者其他service，如果要注入，必须使用上面这种方法*/
        registry.addInterceptor(getTestInterceptor()).addPathPatterns("/xin/**");    //以 /xin  开头的才会进入此拦截器

        super.addInterceptors(registry);
    }
    @Bean
    public TestInterceptor getTestInterceptor() {
        return new TestInterceptor();
    }


    /**
     * 第九章  静态文件地址修改
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //通过 /xin/...  访问静态文件时  会在 classpath:/static/...(resources/static/...)下寻找
        registry.addResourceHandler("/xin").addResourceLocations("classpath:/static");
    }
}
