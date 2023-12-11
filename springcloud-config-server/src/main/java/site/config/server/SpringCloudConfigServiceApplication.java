package site.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudConfigServiceApplication {

    public static void main(String[] args) {
        // try to access by http://localhost:3721/application/main
        SpringApplication.run(SpringCloudConfigServiceApplication.class, args);
    }
}
