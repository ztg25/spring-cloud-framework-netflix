package site.flightmanagement.flightticketservice.controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.framework.interfacebus.feignapi.FlightServiceFeignClient;

import java.net.Inet4Address;
import java.net.UnknownHostException;


@RestController
@EnableEurekaClient
@EnableFeignClients(basePackages = "site.framework.interfacebus.feignapi")
@EnableHystrix
public class FlightticketserviceController {

    public static void main(String[] args) {
        SpringApplication.run(FlightticketserviceController.class, args);
    }


    @Autowired
    FlightServiceFeignClient flightServiceFeignClient;


    @RequestMapping("/createflightticket")
    @HystrixCommand(fallbackMethod = "createFlightTicketHystrixCommand")
    public String createFlightTicket(String uid, String fid, String token)
    {
        String IP = null;
        try {
            // 熔断测试，跳转createFlightTicketHystrixCommand
            if(uid==null) {
                int a = 1 / 0;
            }
            IP = Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (Exception e) {
            return "{error:exception, code:1026, msg:服务异常}";
        }
        return "Welcome to flight ticket servcie - createFlightTicket! IP=" +IP;
    }

    @RequestMapping("/flightticketreserve")
    public String flightTicketReserver(String uid, String fid, String token){
        String result = flightServiceFeignClient.internationFlightRetrive("dewey","CA1820","idee94j4");
        return result;
    }

    public String createFlightTicketHystrixCommand(String uid, String fid, String token){
        return "{error:exception, code:1026, msg:服务异常}";
    }
}
