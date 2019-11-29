package com.zenhomes.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * A landlord can rent out a separate apartment, the whole building or several apartments to another party.
	 */
	public void testUseCase1() {

		System.out.println("Use Case 1");

		Apartment apartment1 = new Apartment(1, 1000.00);
		Landlord landlord = new Landlord(1,"L1", Type.LegalPerson);
		Tenant tenant1 = new Tenant(1,"T1", Type.NaturalPerson);

		Contract contract = new Contract.
				ContractBuilder(1, new Date(), new Date(), landlord, tenant1, apartment1)
				.build();

		System.out.println(contract);

		assertTrue(contract.getApartment().getPrice()>0);
	}

	/**
	 * A landlord can sign a rental contract with one or multiple tenants.
	 */
	public void testUseCase2() {

		System.out.println("Use Case 2");

		Apartment apartment1 = new Apartment(1, 1000.00);
		Landlord landlord = new Landlord(1,"L1", Type.LegalPerson);
		Tenant tenant1 = new Tenant(1,"T1", Type.NaturalPerson);
		Tenant tenant2 = new Tenant(2, "T2", Type.NaturalPerson);

		List<Person> tenants = new ArrayList<Person>();
		tenants.add(tenant1);
		tenants.add(tenant2);

		Contract contract = new Contract.
				ContractBuilder(1, new Date(), new Date(), landlord, tenants, apartment1)
				.build();

		System.out.println(contract);

		assertTrue(contract.getApartment().getPrice()>0);
	}

	/**
	 * One tenant can rent multiple apartments from the same landlord.
	 * One tenant can rent multiple apartments simultaneously.
	 */
	public void testUseCase3() {

		System.out.println("Use Case 3");

		Apartment apartment1 = new Apartment(1, 1000.00);
		Apartment apartment2 = new Apartment(2, 2000.00);
		Landlord landlord = new Landlord(1,"L1", Type.LegalPerson);
		Tenant tenant1 = new Tenant(1,"T1", Type.NaturalPerson);

		Contract contract1 = new Contract.
				ContractBuilder(1, new Date(), new Date(), landlord, tenant1, apartment1)
				.build();

		System.out.println(contract1);

		assertTrue(contract1.getApartment().getPrice()>0);

		Contract contract2 = new Contract.
				ContractBuilder(2, new Date(), new Date(), landlord, tenant1, apartment2)
				.build();

		System.out.println(contract2);

		assertTrue(contract2.getApartment().getPrice()>0);
	}

	/**
	 * A landlord can also be a tenant of another landlord.
	 */
	public void testUseCase4() {

		System.out.println("Use Case 4");

		Apartment apartment1 = new Apartment(1, 1000.00);
		Landlord landlord1 = new Landlord(1,"L1", Type.LegalPerson);
		Tenant tenant1 = new Tenant(1,"T1", Type.NaturalPerson);

		Contract contract1 = new Contract.
				ContractBuilder(1, new Date(), new Date(), landlord1, tenant1, apartment1)
				.build();

		System.out.println(contract1);

		assertTrue(contract1.getApartment().getPrice()>0);

		Apartment apartment2 = new Apartment(2, 2000.00);
		Landlord landlord2 = new Landlord(1,"L1", Type.LegalPerson);
		Tenant tenant2 = new Tenant(1,"T1", Type.NaturalPerson); //the same person from landloard in database

		Contract contract2 = new Contract.
				ContractBuilder(1, new Date(), new Date(), landlord2, tenant2, apartment2)
				.build();

		System.out.println(contract2);

		assertTrue(contract1.getApartment().getPrice()>0);
	}

}
