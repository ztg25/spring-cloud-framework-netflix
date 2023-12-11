package site.framework.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 高可用eureka集群
 * Program arguments 指定运行的配置文件application-eureka8761.yml
 * --spring.profiles.active=eureka8761
 */

@SpringBootApplication
@EnableEurekaServer
public class EurekaserverApplication8761 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaserverApplication8761.class, args);
    }

}
