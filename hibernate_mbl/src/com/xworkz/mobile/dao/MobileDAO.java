package com.xworkz.mobile.dao;

import com.xworkz.mobile.entity.MobileEntity;

public interface MobileDAO {
	int save(MobileEntity entity);

	void readAll(int id);

	double readPriceByName(String name);

	double readTotalPrice();

	double readMaxPrice();

	double readMinPrice();

	void updatePriceByName(double price, String name);

}
