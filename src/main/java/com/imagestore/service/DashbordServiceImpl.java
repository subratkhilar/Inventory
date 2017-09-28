package com.imagestore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imagestore.dao.DashbordDao;
import com.imagestore.model.Inventory;

@Service("dashbordService")
public class DashbordServiceImpl implements DashbordService {
	@Autowired
	private DashbordDao dashboardDao;

	@Override
	public List<Inventory> getAllInventory() {

		return dashboardDao.getAllInventory();
	}

}
