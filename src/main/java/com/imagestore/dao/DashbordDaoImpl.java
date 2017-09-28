package com.imagestore.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.imagestore.model.Inventory;

@Repository("dashboardDao")
public class DashbordDaoImpl implements DashbordDao {

	@Override
	public List<Inventory> getAllInventory() {
		List<Inventory> invList = new ArrayList<Inventory>();
		Inventory inv = new Inventory();
		inv.setId(1);
		inv.setName("xyz");
		inv.setAddress("bangalore");
		invList.add(inv);
		return invList;
	}

}
