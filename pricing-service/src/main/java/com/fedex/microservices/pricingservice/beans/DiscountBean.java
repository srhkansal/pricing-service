package com.fedex.microservices.pricingservice.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

public class DiscountBean {
    private Long id;
    private String from;
    private String to;
    private String type;
	private double amount;

    public DiscountBean() {

    }
    public DiscountBean(Long id, String from, String to, String type, double amount) {
        super();
        this.id = id;
        this.from = from;
        this.to = to;
        this.type = type;
        this.amount=amount;
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "DiscountBean [id=" + id + ", from=" + from + ", to=" + to + ", type=" + type + "]";
	}
  }
