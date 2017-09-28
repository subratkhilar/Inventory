package com.imagestore.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.imagestore.model.Inventory;
import com.imagestore.service.DashbordService;
import com.imagestore.util.ApiResponse;

@RestController
@RequestMapping("dashboard")
public class DashbordController {
	Logger logger = Logger.getLogger(DashbordController.class);
	@Autowired
	private DashbordService dashbordService;

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/getAllInventory", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public ResponseEntity getAllInventory() {
		logger.info("coming inside getAllInventory:: ");
		List<Inventory> invLists = dashbordService.getAllInventory();
		if (invLists == null || invLists.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(ApiResponse.failureResponse("no  data found", null, HttpStatus.OK.value()));
		}
		return ResponseEntity.status(HttpStatus.OK)
				.body(ApiResponse.successResponse("getInventory successful", invLists));
	}
}
