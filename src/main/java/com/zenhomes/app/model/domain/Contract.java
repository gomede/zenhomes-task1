package com.zenhomes.app.model.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {

    private int number;

    private Date date;

    private Date term;

    private Landlord landlord;

    private List<Person> tenant;

    private Apartment apartment;

	public int getNumber() {
		return number;
	}

	public Date getDate() {
		return date;
	}

	public Date getTerm() {
		return term;
	}

	public Person getLandlord() {
		return landlord;
	}

	public List<Person> getTenant() {
		return tenant;
	}

	public Apartment getApartment() {
		return apartment;
	}

	private Contract(ContractBuilder builder) {
		this.number = builder.number;
		this.date = builder.date;
		this.term = builder.term;
		this.landlord = builder.landlord;
		this.tenant = builder.tenant;
		this.apartment = builder.apartment;
    }

	 @Override
	public String toString() {
		return "Contract [number=" + number + ", date=" + date + ", term="
				+ term + ", landlord=" + landlord + ", tenant=" + tenant
				+ ", apartment=" + apartment + "]";
	}


	public static class ContractBuilder {

		private int number;

		private Date date;

		private Date term;

		private Landlord landlord;

		private List<Person> tenant = new ArrayList<Person>();

		private Apartment apartment;

		public ContractBuilder(int number, Date date, Date term, Landlord landlord, Person tenant, Apartment apartment) {
			this.number = number;
			this.date = date;
			this.term = term;
			this.landlord = landlord;
			this.tenant.add(tenant);
			this.apartment = apartment;
		}

		public ContractBuilder(int number, Date date, Date term, Landlord landlord, List<Person> tenant, Apartment apartment) {
			this.number = number;
			this.date = date;
			this.term = term;
			this.landlord = landlord;
			this.tenant = tenant;
			this.apartment = apartment;
		}

		public Contract build() {
			Contract contract = new Contract(this);
			validateContractObject(contract);
			return contract;
		}

		private void validateContractObject(Contract contract) {
			if (contract.getApartment().getPrice()<=0) {
				System.out.println("There is a rent with 0!");
			}
		}
	}

}