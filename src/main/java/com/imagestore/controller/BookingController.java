package com.imagestore.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.imagestore.model.Booking;
import com.imagestore.service.BookingService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping("/booking")
@EnableSwagger2
public class BookingController {
	Logger logger = Logger.getLogger(BookingController.class);
	@Autowired
	private BookingService bookingService;
	  @ApiOperation(value = "create a booking")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<Void> create(@RequestBody Booking booking) {
		logger.info("create booking Details>>>>>>>>>> ");
		try {
			bookingService.createBooking(booking);
		} catch (Exception e) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@ApiOperation(value = "View a list of booking", response = Iterable.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully retrieved list"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
	)
	@RequestMapping(value="/read-all",method = RequestMethod.GET)
	public ResponseEntity<List<Booking>> getAllInv() {
		logger.info(" getAllInv Details>>>>>>>>>> ");
		List<Booking> list = (List<Booking>) bookingService.getAllBookingDetails();
		if (list == null || list.isEmpty()) {
			return new ResponseEntity<List<Booking>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Booking>>(list, HttpStatus.OK);
	}
}
