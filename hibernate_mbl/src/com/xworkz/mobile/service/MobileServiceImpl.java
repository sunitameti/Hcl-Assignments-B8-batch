package com.xworkz.mobile.service;

import com.xworkz.mobile.dao.MobileDAO;
import com.xworkz.mobile.dao.MobileDAOImpl;
import com.xworkz.mobile.entity.MobileEntity;

public class MobileServiceImpl implements MobileService {
	private MobileDAO dao = new MobileDAOImpl();

	@Override
	public int save(MobileEntity entity) {

		boolean nameValid = false;
		boolean colorValid = false;

		if (entity != null) {
			System.out.println("entity is not null start validating");
			String name = entity.getName();
			if (name != null && !name.isEmpty() && name.length() >= 2 && name.length() <= 20) {
				System.out.println("name is valid");
				nameValid = true;
			} else {
				System.out.println("name is invalid");
				nameValid = false;
			}

			String color = entity.getColor();
			if (color != null && !color.isEmpty() && color.length() >= 2 && color.length() <= 20) {
				System.out.println("color is valid");
				colorValid = true;
			} else {
				System.out.println("color is invalid");
				colorValid = false;
			}
			if (nameValid && colorValid) {
				System.out.println("data is valid");
				dao.save(entity);
				return 1;
			}
			return 0;

		}
		System.out.println("entity is null cannot validate");
		return 0;

	}

	@Override
	public double readPriceByName(String name) {

		return dao.readPriceByName(name);

	}

	@Override

	public double readTotalPrice() {

		return this.dao.readTotalPrice();

	}

	@Override
	public double readMaxPrice() {
		return this.dao.readMaxPrice();

	}

	@Override
	public double readMinPrice() {
		return this.dao.readMinPrice();
	}

	@Override
	public boolean updatePriceByName(double price, String name) {
		boolean valid = false;
		if (!name.isEmpty() && name != null && name.length() <= 20 && name.length() > 2) {
			valid = true;
			this.dao.updatePriceByName(price, name);
			System.out.println(price);
			return valid;
		}
		return valid;

	}

}
