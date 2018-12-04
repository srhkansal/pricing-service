package com.fedex.microservices.pricingservice.services;

import com.fedex.microservices.pricingservice.beans.DiscountBean;
import com.fedex.microservices.pricingservice.beans.PricingBean;
import com.fedex.microservices.pricingservice.dao.PricingRepository;
import com.fedex.microservices.pricingservice.proxy.DiscountServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PricingService {

	@Autowired
	private PricingRepository pricingRepository;
   // @Autowired
    //private DiscountServiceProxy discountServiceProxy;

    public PricingBean findById(Long id){
        Optional<PricingBean> pricingBean =  pricingRepository.findById(id);
        pricingBean.ifPresent(psBean -> psBean.setFinalPrice(psBean.getPrice()));
        return pricingBean.get();
    }

    public List<PricingBean> findAll(){
        List<PricingBean> pricingBeanList = pricingRepository.findAll();
        Optional.of(pricingBeanList).ifPresent(pricingBeans ->  pricingBeans.forEach(pricingBean -> pricingBean.setFinalPrice(pricingBean.getPrice())));
        return pricingRepository.findAll();
    }

    public PricingBean findByType(String type){
        return pricingRepository.findByType(type);
    }

    public PricingBean createPrice(PricingBean pricingBean){
        return pricingRepository.save(pricingBean);
    }

    public void deletePrice(Long id){
        pricingRepository.deleteById(id);
    }

    public PricingBean findDiscountedByType(@PathVariable String type){
        PricingBean pricingBean =  findByType(type);

        if(pricingBean!=null) {
            DiscountBean discountBean = retrieveDiscount(type);
            double finalPrice = pricingBean.getPrice();
            if(discountBean!=null) {
                double price = pricingBean.getPrice();
                double discount = discountBean.getAmount();
                pricingBean.setDiscount(discount);
                finalPrice = price - discount;
            }
            pricingBean.setFinalPrice(finalPrice);
        }
        return pricingBean;
    }

    public DiscountBean retrieveDiscount(@PathVariable String type){
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl= "http://localhost:8100/discount-service/discounts/type/{type}";
        Map<String, String> params = new HashMap<>();
        params.put("type", type);
        ResponseEntity<DiscountBean> response = restTemplate.getForEntity(resourceUrl , DiscountBean.class, params);
        DiscountBean discountBean = response.getBody();//discountServiceProxy.findByType(type);
        return discountBean;
    }
 }
