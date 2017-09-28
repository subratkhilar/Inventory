package com.imagestore.dao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.imagestore.model.Booking;
@Transactional

public interface InventoryRepository extends CrudRepository	<Booking, String>  {
	// public Booking findByDeparture(String departure);
}
