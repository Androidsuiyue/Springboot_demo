package cn.qzhenghao.error;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * @author suiyue
 * @ClassName ErrorPageConfig
 * @Description TODO
 * @date 2019/1/8 14:47
 */
@Configuration
public class ErrorPageConfig {
    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer(){
        return new EmbeddedServletContainerCustomizer() {
            @Override
            public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
                ErrorPage errorPage = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
                configurableEmbeddedServletContainer.addErrorPages(errorPage);
            }
        };
    }
}
