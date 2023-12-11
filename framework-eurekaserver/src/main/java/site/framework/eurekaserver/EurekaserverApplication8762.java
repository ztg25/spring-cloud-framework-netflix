package site.framework.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 高可用eureka集群
 * Program arguments 指定运行的配置文件application-eureka8762.yml
 * --spring.profiles.active=eureka8762
 */

@SpringBootApplication
@EnableEurekaServer
public class EurekaserverApplication8762 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaserverApplication8762.class, args);
    }

}
