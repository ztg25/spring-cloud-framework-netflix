package site.framework.interfacebus.feignapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Component
@FeignClient(value = "ORDER-CREATE-SERVICE")
public interface OrderServiceFeignClient {

    @GetMapping("/createorder")
    public String createOrder(@RequestParam("uid") String uid,
                                           @RequestParam("fid") String fid,
                                           @RequestParam("token") String token);
}
