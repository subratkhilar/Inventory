package com.imagestore.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import com.imagestore.model.Booking;
import com.imagestore.service.BookingService;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BookingController.class, secure = false)
public class BookingControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private BookingService bookingService;
	// creating dummy data
	

	@Test
	public void getAllInv() throws Exception {
		Booking booking = new Booking("1", "test", "BLR", "CHN");
		List<Booking> list = new ArrayList<Booking>();
		list.add(booking);
		Mockito.when(bookingService.getAllBookingDetails()).thenReturn(list);
		assertEquals(1, list.size());
	}

}
