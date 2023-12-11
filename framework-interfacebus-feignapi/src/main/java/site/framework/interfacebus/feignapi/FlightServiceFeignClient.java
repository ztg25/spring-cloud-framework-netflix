package site.framework.interfacebus.feignapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Component
@FeignClient(value = "FLIGHT-SERVICE")
public interface FlightServiceFeignClient {

    @GetMapping("/internationflightretrive")
    public String internationFlightRetrive(@RequestParam("uid") String uid,
                                           @RequestParam("fid") String fid,
                                           @RequestParam("token") String token);

    @RequestMapping("/manterinflightretrive")
    public String manterinFlightRetrive(@RequestParam("uid") String uid,
                                        @RequestParam("fid") String fid,
                                        @RequestParam("token") String token);
}
