package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {

	
	private final CustomerDAO customerDAO = new CustomerDAO();
	private final ItemDAO itemDAO = new ItemDAO();
	private final OrderDAO DAO = new OrderDAO(customerDAO, itemDAO);
	
	@Before
	public void setup() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
		final Order order = new Order(1L,"2022/08/25");
		DAO.create(order);
	}

	@Test
	public void testCreate() {
		final Order order = new Order(2L,"2022/02/13");
		assertEquals(null, DAO.create(order));
	}
	
	@Test
	public void testReadAll() {
		List<Order> order = new ArrayList<>();
		order.add(new Order(1L, (long)1, "2022/06/12", null));
		assertEquals(order, DAO.readAll());
	}

	@Test
	public void testReadLatest() {
		assertEquals(new Order(1L, (long) 1,"2022/06/12", null), DAO.readLatest());
	}

	@Test
	public void testRead() {
		final long ID = 1L;
		assertEquals(new Order(1L, (long) 1,"2022/06/12", null), DAO.read(ID));
	}

	@Test
	public void testUpdate() {
		
	}

	
	@Test
	public void testaddToOrder() {
		List<Item> items = new ArrayList<>();
		final Order updated = new Order(2L,2L, "2022/05/12", items);
		items.add(new Item(2L, "mug", 70.00));
		assertEquals(updated, DAO.addToOrder(2L, 2L));
	}
	
	@Test
	public void testDeleteItem() {
		List<Item> items = new ArrayList<>();
		items.add(new Item(1L, "mug", 70.00));
		final Order updated = null;
		assertEquals(updated, DAO.deleteFromOrder(2L, 2L));
	}
	
	@Test
	public void testDelete() {
		assertEquals(1, DAO.delete(1));
	}
}
