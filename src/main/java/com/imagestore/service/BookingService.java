package com.imagestore.service;

import java.util.List;

import com.imagestore.model.Booking;

public interface BookingService {
	public void createBooking(Booking booking);

	public List<Booking> getAllBookingDetails();

}
