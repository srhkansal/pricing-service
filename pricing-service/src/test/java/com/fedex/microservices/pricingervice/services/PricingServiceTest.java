package com.fedex.microservices.pricingervice.services;

import com.fedex.microservices.pricingservice.beans.PricingBean;
import com.fedex.microservices.pricingservice.dao.PricingRepository;
import com.fedex.microservices.pricingservice.proxy.DiscountServiceProxy;
import com.fedex.microservices.pricingservice.services.PricingService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.*;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {PricingServiceTest.class, PricingService.class,PricingRepository.class, PricingBean.class})
public class PricingServiceTest {

    @Autowired
    private PricingService pricingService;

    @MockBean
    private PricingRepository pricingRepository;



    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findByTypeShouldReturnPricing() {
        PricingBean pricingBean = new PricingBean();
        pricingBean.setId(1001L);
        pricingBean.setType("sale_price");

        when(pricingRepository.findByType(Mockito.anyString())).thenReturn(pricingBean);
        assertNotNull(pricingService.findByType("1001L"));
    }
    
}