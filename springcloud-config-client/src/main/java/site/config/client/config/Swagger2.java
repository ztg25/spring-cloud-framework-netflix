package site.config.client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *SwaggerConfig 一定是要配置到springboot里面
 * 所以需要添加@Configuration注解
 * @author tony
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    /**
     * 配置swagger的Docket的Bean实例
     */
    @Bean
    public Docket createRestApi(){

        // 通过判断来设置要显示的swagger环境
        boolean flag = true;

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(flag)           // 通过判断来设置要显示的swagger环境
                .groupName("A")         // 配置Api文档的分组
                .select()
                /*
                配置要扫描的接口的方式
                basePackage:指定要扫描的包
                any()：扫描全部
                none()：都不扫描
                withClassAnnotation：扫描类上的注解，参数是一个注解的反射
                withMethodAnnotation:扫描方法上的注解
                例如：.apis(RequestHandlerSelectors.withMethodAnnotation(RestController.class))
                      只会去扫描类上的RestController的这些类
                 */
                .apis(RequestHandlerSelectors.basePackage("site.config.client.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public Docket createRestApi2(){

        // 通过判断来设置要显示的swagger环境
        boolean flag = true;

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(flag)           // 通过判断来设置要显示的swagger环境
                .groupName("B")         // 配置Api文档的分组
                .select()
                /*
                配置要扫描的接口的方式
                basePackage:指定要扫描的包
                any()：扫描全部
                none()：都不扫描
                withClassAnnotation：扫描类上的注解，参数是一个注解的反射
                withMethodAnnotation:扫描方法上的注解
                例如：.apis(RequestHandlerSelectors.withMethodAnnotation(RestController.class))
                      只会去扫描类上的RestController的这些类
                 */
                .apis(RequestHandlerSelectors.basePackage("site.config.client.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 配置Swagger信息的apiInfo
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Api Documents")
                .version("1.0")
                .build();
    }
}
