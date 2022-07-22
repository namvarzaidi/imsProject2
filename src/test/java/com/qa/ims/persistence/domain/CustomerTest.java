package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class CustomerTest {
	
	Customer customer;
	Long id = (long) 1;
	String firstName = "Ferb";
	String surname = "Fletcher";
	
	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Customer.class).verify();
	}
	
	
	@Test
	public void testToString() {
		customer = new Customer(id, firstName, surname);
		assertEquals(("id:" + customer.getId() + " first name:" + customer.getFirstName() + " surname:" + customer.getSurname()), customer.toString());

	}
	
	@Test
	public void firstConstructorTest() {
		Customer customer = new Customer("Ferb", "Fletcher");
		assertEquals("Ferb", customer.getFirstName());
		assertEquals("Fletcher", customer.getSurname());
	}
	
	@Test
	public void secondConstructorTest() {
		Customer customer = new Customer(1L, "Ferb", "Fletcher");
		assertEquals(Long.valueOf("1"), customer.getId());
		assertEquals("Ferb", customer.getFirstName());
		assertEquals("Fletcher", customer.getSurname());
	
	}
	
}