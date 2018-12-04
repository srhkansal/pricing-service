package com.fedex.microservices.pricingservice.beans;

import javax.persistence.*;

@Entity
public class PricingBean {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@Column(name="start_date")
	private String start_date;

	@Column(name="end_date")
	private String end_date;

	@Column(name="display_name")
	private String display_name;

	@Column(name="description")
	private String description;

	@Column(name="type")
	private String type;

	private double price;

	@Transient
	private double discount;

	@Transient
	private double finalPrice;

    public PricingBean() {

    }

	public PricingBean(Long id, String start_date, String end_date, String display_name, String description, String type, double price) {
		this.id = id;
		this.start_date = start_date;
		this.end_date = end_date;
		this.display_name = display_name;
		this.description = description;
		this.type = type;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getDisplay_name() {
		return display_name;
	}

	public void setDisplay_name(String display_name) {
		this.display_name = display_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getFinalPrice() {
		return finalPrice;
	}

	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "PricingBean{" +
				"id=" + id +
				", start_date='" + start_date + '\'' +
				", end_date='" + end_date + '\'' +
				", display_name='" + display_name + '\'' +
				", description='" + description + '\'' +
				", type='" + type + '\'' +
				", price=" + price +
				", discount=" + discount +
				", finalPrice=" + finalPrice +
				'}';
	}
}
