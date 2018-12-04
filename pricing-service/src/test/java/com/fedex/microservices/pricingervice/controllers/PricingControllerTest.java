package com.fedex.microservices.pricingervice.controllers;

import com.fedex.microservices.pricingservice.controllers.PricingController;

import com.fedex.microservices.pricingservice.services.PricingService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.*;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = PricingController.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PricingControllerTest {

    //@Autowired
    private MockMvc mockMvc;

    //@Autowired
    private PricingService pricingService;

    //@Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    //@Test
    public void testFindDiscountedPricesByType() throws Exception{
        //when(pricingService.findDiscountedByType(Mockito.anyString())).thenReturn(new PricingBean());
        //this.mockMvc.perform(get("/pricing-service/discounted-prices/type/{type}", "iru")).andExpect(status().isOk());

        //verify(pricingService, times(1)).findById(1L);
        //verifyNoMoreInteractions(pricingService);
    }

    /*public void findByTypeShouldReturnPricing() {
    	PricingBean pricingBean = new PricingBean();
    	pricingBean.setId(1001L);
    	pricingBean.setType("sale_price");

    	when(pricingRepository.findByType(Mockito.anyString())).thenReturn(pricingBean);
    	assertNotNull(pricingRepository.findByType("1001L"));
    }*/
    
}