package ct.com.lxkj.config;


import ct.com.lxkj.interceptor.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Value("${prop.upload-folder}")
    private String UPLOAD_FOLDER;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptor = registry.addInterceptor(loginInterceptor);
        interceptor.excludePathPatterns("/api/lxkj/login");//过滤登录
        interceptor.excludePathPatterns("/api/lxkj/getNew");//过滤获取新闻详情
        interceptor.excludePathPatterns("/api/lxkj/getList");//过滤前端获取新闻列表
        interceptor.excludePathPatterns("/api/lxkj/BanaerList");//过滤前端获取轮播列表
        interceptor.excludePathPatterns("/img/**");
    }
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**").addResourceLocations("file:" + UPLOAD_FOLDER);
    }

}
