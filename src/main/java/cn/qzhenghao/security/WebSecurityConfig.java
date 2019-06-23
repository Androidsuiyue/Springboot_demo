package cn.qzhenghao.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author suiyue
 * @date 2019/1/12 14:15
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //通过注解@Bean将CustomUserService装进Spring容器，并在configureGlobal方法中注册CustomUserService
    @Bean
    public CustomUserService customUserService(){
        return new CustomUserService();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()//启用默认登录页面
                .failureUrl("/login?error")//失败是返回
                .defaultSuccessUrl("/ayUser/test")//登录成功时跳转
                .permitAll();//登录页面全部权限可以访问
        super.configure(http);
    }

    //全局 配置内存用户
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .userDetailsService(customUserService());
//                .inMemoryAuthentication()
//                .withUser("qian")
//                .password("123456")
//                .roles("AMDIN")
//                .and()
//                .withUser("ff")
//                .password("123456")
//                .roles("USER");
    }

}
