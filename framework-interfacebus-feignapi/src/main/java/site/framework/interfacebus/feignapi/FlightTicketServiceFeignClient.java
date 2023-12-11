package site.framework.interfacebus.feignapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Component
@FeignClient(value = "FLIGHT-TICKET-SERVICE")
public interface  FlightTicketServiceFeignClient {
    @RequestMapping("/createflightticket")
    public String createFlightTicket(@RequestParam("uid") String uid,
                                     @RequestParam("fid") String fid,
                                     @RequestParam("token") String token);
}



