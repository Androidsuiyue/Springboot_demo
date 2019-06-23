package cn.qzhenghao.filter;

/**
 * Created by Administrator on 2018/12/9.
 */


import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DruidConfiguration {
    @Bean
    public ServletRegistrationBean druidStatViewServle(){
        ServletRegistrationBean servletRegistration =new ServletRegistrationBean(new StatViewServlet(),
                "/druid/*");
        servletRegistration.addInitParameter("allow","127.0.0.1");

        //IP黑名单 与allow同时存在时deny高于allow
        servletRegistration.addInitParameter("deny","192.168.1.73");
        servletRegistration.addInitParameter("loginUsername","admin");
        servletRegistration.addInitParameter("loginPassword", "123456");
        servletRegistration.addInitParameter("resetEnable","false");
        return servletRegistration;
    }
//    @Bean
//    public FilterRegistrationBean druidStatFilter(){
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter()
//        );
//        filterRegistrationBean.addUrlPatterns("/*");
//        filterRegistrationBean.addUrlPatterns("exclusions", "*.js,*." +
//                "gif,*.jpg,*.png,*.css,*.ico,/drui" +
//                "d/*");
//        return filterRegistrationBean;
//    }


    @Bean
    public FilterRegistrationBean druidStatFilter(){
        FilterRegistrationBean filterRegistrationBean
                = new FilterRegistrationBean(new WebStatFilter());
        //添加过滤规则.
        filterRegistrationBean.addUrlPatterns("/*");
        //添加不需要忽略的格式信息.
        filterRegistrationBean.addInitParameter("exclusions",
                "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }




}
