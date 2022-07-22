package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import nl.jqno.equalsverifier.EqualsVerifier;

public class ItemTest {
	
	
	Item item;
	Long id = (long) 2;
	String name = "mug";
	Double price = 70.00;
	
	
	@Test
	public void oneConstructor() {
		item = new Item(id, name, price);
	}
	
	@Test
	public void twoConstructor() {
		item = new Item(name, price);
	}

	
	@Test
	public void testGetItemName() {
		item = new Item(id, name, price);
		assertEquals(name, item.getName());
	}
	
	
	
	@Test
	public void testSetId() {
		item = new Item(id, name, price);
		item.setId((long)6);
		assertEquals(6, item.getId(), 6);
	}
	
	@Test
	public void testSetItemName() {
		item = new Item(id, name, price);
		item.setName("mug");
		assertEquals("mug", item.getName());
		
	}
	
	@Test
	public void testSetPrice() {
		item = new Item(id, name, price);
		item.setPrice((double) 200);
		assertEquals(200, item.getPrice(), 200);
	}
	
	
	
	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Item.class).verify();
	}

}
