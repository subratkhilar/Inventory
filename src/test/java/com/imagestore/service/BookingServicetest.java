package com.imagestore.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.imagestore.dao.InventoryRepository;
import com.imagestore.model.Booking;

@RunWith(SpringRunner.class)
public class BookingServicetest {
	@Mock
	private InventoryRepository inventoryRepository;
	@InjectMocks
	private BookServiceImpl bookingService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAllBookingDetails() {
		List<Booking> bookingList = new ArrayList<Booking>();
		bookingList.add(new Booking("1", "test", "xyz", "123"));
		when(inventoryRepository.findAll()).thenReturn(bookingList);
		List<Booking> results = bookingService.getAllBookingDetails();
		assertEquals(1, results.size());
	}

	@Test
	public void createBooking() {
		Booking booking = new Booking("1", "test", "xyz", "123");
		when(inventoryRepository.save(booking)).thenReturn(booking);
		
	}
}
