package site.config.client.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "spring cloud config") // http://localhost:3722/swagger-ui.html
@RestController
@RefreshScope
public class ConfigController {

    @Value("${url}")
    private String url;

    @Autowired
    private Environment env;

    @ApiOperation(value = "get url in the application-dev.properties file, method 1")
    @GetMapping("/config/url")
    public String url(){
        // 取得config-center/application-dev.properties中值-方法1
        // https://github.com/ztg25/spring-cloud-config/blob/main/config-center/application-dev.properties
        return url;
    }

    @ApiOperation(value = "get url in the application-dev.properties file, method 2")
    @GetMapping("/config/url2")
    public String url2(){
        // 取得config-center/application-dev.properties中值-方法2
        return env.getProperty("url");
    }

    @ApiOperation(value = "get url in the application-dev.properties file with env")
    @ApiImplicitParam(name="env", value = "master", required = false)
    @ApiResponse(code = 404, message = "error")
    @GetMapping("/config/url/{env}")
    public String url3(){
        // 取得config-center/application-dev.properties中值-方法1
        // https://github.com/ztg25/spring-cloud-config/blob/main/config-center/application-dev.properties
        return url;
    }
}
