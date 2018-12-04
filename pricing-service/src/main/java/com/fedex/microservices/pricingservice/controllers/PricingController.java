package com.fedex.microservices.pricingservice.controllers;

import java.util.List;

import com.fedex.microservices.pricingservice.beans.PricingBean;
import com.fedex.microservices.pricingservice.services.PricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableFeignClients("com.fedex.microservices.pricingservice")
public class PricingController {

	@Autowired
	private PricingService pricingService;

    @GetMapping("/pricing-service/prices/{id}")
    public PricingBean findById(@PathVariable Long id){
        PricingBean pricingBean =  pricingService.findById(id);
        return pricingBean;
    }
 
	@GetMapping("/pricing-service/prices")
    public List<PricingBean> findAll(){
    	return pricingService.findAll();
    }

    @GetMapping("/pricing-service/prices/type/{type}")
    public PricingBean findByType(@PathVariable String type){
        return pricingService.findByType(type);
    }

    @PostMapping(name="/pricing-service/prices")
    public PricingBean createPrice(@RequestBody PricingBean pricingBean){
    	return pricingService.createPrice(pricingBean);
    }

    @DeleteMapping("/pricing-service/prices/{id}")
    public void deletePrice(@PathVariable Long id){
        pricingService.deletePrice(id);
    }

    @GetMapping("/pricing-service/discounted-prices/type/{type}")
    public PricingBean findDiscountedPricesByType(@PathVariable String type){
        PricingBean pricingBean =  pricingService.findDiscountedByType(type);
        return pricingBean;
    }
}
