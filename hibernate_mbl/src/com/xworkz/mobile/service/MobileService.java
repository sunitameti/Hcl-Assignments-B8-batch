package com.xworkz.mobile.service;

import com.xworkz.mobile.entity.MobileEntity;

public interface MobileService {
	int save(MobileEntity entity);

	double readPriceByName(String name);

	double readTotalPrice();

	double readMaxPrice();

	double readMinPrice();

	boolean updatePriceByName(double price, String name);

}
