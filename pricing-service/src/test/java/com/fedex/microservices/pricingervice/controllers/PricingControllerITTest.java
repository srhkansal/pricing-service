package com.fedex.microservices.pricingervice.controllers;

import com.fedex.microservices.pricingservice.PricingServiceApplication;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PricingServiceApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PricingControllerITTest {

    @LocalServerPort
    private int port;

    private TestRestTemplate restTemplate;
    private HttpHeaders headers;

    @Before
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
        restTemplate = new TestRestTemplate();
        headers = new HttpHeaders();
    }

    @Test
    public void testPricingFromService() throws Exception {
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/pricing-service/prices/1"),
                HttpMethod.GET, entity, String.class);
        String expected = "{\"id\":1,\"start_date\":\"01/01/2017\",\"end_date\":\"12/31/2020\",\"display_name\":\"iru_price\",\"description\":\"Price for IRU users\",\"type\":\"iru\",\"price\":1000,\"discount\":0,\"finalPrice\":1000}";
        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    //@Test --Uncomment for testing
    public void testPricingFromServiceByType() throws Exception {
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/pricing-service/discounted-prices/type/iru"),
                HttpMethod.GET, entity, String.class);
        String expected = "{\"id\":1,\"start_date\":\"01/01/2017\",\"end_date\":\"12/31/2020\",\"display_name\":\"iru_price\",\"description\":\"Price for IRU users\",\"type\":\"iru\",\"price\":1000,\"discount\":100,\"finalPrice\":900}";
        JSONAssert.assertEquals(expected, response.getBody(), false);
    }
    
    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
}
