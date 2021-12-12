package com.xworkz.mobile.tester;

import com.xworkz.mobile.entity.MobileEntity;
import com.xworkz.mobile.service.MobileService;
import com.xworkz.mobile.service.MobileServiceImpl;

public class MobileTester {

	public static void main(String[] args) {
		MobileEntity entity = new MobileEntity("Sony", "Black", true,45000);
		MobileEntity entity1 = new MobileEntity("Honor", "Blue", true,11000);
		
	
		MobileService service = new MobileServiceImpl();
		service.save(entity);
	     service.save(entity1);
		//dao1.read(2);
		
		double name=(service.readPriceByName("Samsung S8"));
		System.out.println(name);
		
		System.out.println(service.readTotalPrice());
		
		System.out.println(service.readMaxPrice());
		
		System.out.println(service.readMinPrice());
		
		service.updatePriceByName(28000,"Realme 5");

	}

}
