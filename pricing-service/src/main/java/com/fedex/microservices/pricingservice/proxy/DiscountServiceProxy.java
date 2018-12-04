package com.fedex.microservices.pricingservice.proxy;

import com.fedex.microservices.pricingservice.beans.DiscountBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name="discount-service", url="http://localhost:8100")
@Component
public interface DiscountServiceProxy {

    @GetMapping("/discount-service/discounts/type/{type}")
    public DiscountBean findByType(@PathVariable String type);
}
