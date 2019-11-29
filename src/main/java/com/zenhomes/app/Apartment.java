package com.zenhomes.app;

public class Apartment {

    public int number;

    public double price;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Apartment(int number, double price) {
		super();
		this.number = number;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Apartment [number=" + number + ", price=" + price + "]";
	}

}