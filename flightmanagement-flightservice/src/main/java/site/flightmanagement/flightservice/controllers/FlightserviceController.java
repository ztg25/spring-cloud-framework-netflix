package site.flightmanagement.flightservice.controllers;

//import site.framework.interfacebus.feignapi.FlightTicketServiceFeignClient;
//import site.framework.interfacebus.feignapi.OrderServiceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import site.framework.interfacebus.feignapi.FlightTicketServiceFeignClient;
import site.framework.interfacebus.feignapi.OrderServiceFeignClient;

import java.net.Inet4Address;
import java.net.UnknownHostException;


@RestController
@EnableEurekaClient
//@RequestMapping("/api/flight")
@EnableFeignClients(basePackages = "site.framework.interfacebus.feignapi")
public class FlightserviceController {

    @GetMapping("/internationflightretrive")
    public String internationFlightRetrive(String uid, String fid, String token)
    {
        String IP = null;
        try {
            IP = Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "Welcome to flight servcie - internationflightretrive! IP=" +IP;
    }

    @RequestMapping("/manterinflightretrive")
    public String manterinFlightRetrive(String uid, String fid, String token)
    {
        String IP = null;
        try {
            IP = Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "Welcome to flight servcie - manterinFlightRetrive! IP=" +IP;
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    FlightTicketServiceFeignClient flightTicketServiceFeignClient;

    @Autowired
    OrderServiceFeignClient orderServiceFeignClient;

    @RequestMapping("/flightreserve")
    public String flightReserver(String uid, String fid, String token)
    {
//        ResponseEntity<String> responseEntity =restTemplate.getForEntity("http://FLIGHT-TICKET-SERVICE/createflightticket?uid=dewey&fid=CA1127&token=84urjf73",String.class);
//
//        ResponseEntity<String> responseEntity =restTemplate.getForEntity("http://order-create-service:12101/createflightticket?uid=dewey&fid=CA1127&token=84urjf73",String.class);
//        String body = responseEntity.getBody();
//        HttpStatus statusCode = responseEntity.getStatusCode();
//        int statusCodeValue = responseEntity.getStatusCodeValue();
//        HttpHeaders headers = responseEntity.getHeaders();
//        StringBuffer result = new StringBuffer();
//        result.append("responseEntity.getBody()：").append(body).append("<hr>")
//                .append("responseEntity.getStatusCode()：").append(statusCode).append("<hr>")
//                .append("responseEntity.getStatusCodeValue()：").append(statusCodeValue).append("<hr>")
//                .append("responseEntity.getHeaders()：").append(headers).append("<hr>");
//        return result.toString();

//        String result = orderServiceFeignClient.createOrder(uid,fid,token);
//        return result;
        String result = flightTicketServiceFeignClient.createFlightTicket("dewey","CA1820","idee94j4");
        return result;
    }
}