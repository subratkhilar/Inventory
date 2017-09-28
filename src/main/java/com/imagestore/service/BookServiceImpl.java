package com.imagestore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imagestore.dao.InventoryRepository;
import com.imagestore.model.Booking;

@Service("bookingService")
public class BookServiceImpl implements BookingService {

	@Autowired
	private InventoryRepository inventoryRepository;

	@Override
	public void createBooking(Booking booking) {

		inventoryRepository.save(booking);
	}

	@Override
	public List<Booking> getAllBookingDetails() {

		return (List<Booking>) inventoryRepository.findAll();
	}

}
