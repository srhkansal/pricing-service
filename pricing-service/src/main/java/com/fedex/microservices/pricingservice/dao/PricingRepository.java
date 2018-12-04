package com.fedex.microservices.pricingservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fedex.microservices.pricingservice.beans.PricingBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface PricingRepository extends JpaRepository<PricingBean, Long>{
	PricingBean findByType(String type);
}
