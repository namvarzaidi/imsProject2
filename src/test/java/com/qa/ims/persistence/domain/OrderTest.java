package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class OrderTest {
	
	Order order;
	Item item;
	Long customerId = (long) 1;
	Long id = (long) 2;
	String dateOrdered = "2022/07/25";
	List<Item> orderItems = new ArrayList<Item>();

	
	@Test
	public void constructorOne() {
		order = new Order(id, customerId, date, orderItems);
	}
	
	@Test
	public void constructorTwo() {
		order = new Order(customerId, date);
	}
	
}