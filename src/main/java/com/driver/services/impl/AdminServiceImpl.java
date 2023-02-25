package com.driver.services.impl;

import java.util.List;

import com.driver.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.driver.model.Admin;
import com.driver.model.Customer;
import com.driver.model.Driver;
import com.driver.repository.AdminRepository;
import com.driver.repository.CustomerRepository;
import com.driver.repository.DriverRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepository1;

	@Autowired
	DriverRepository driverRepository1;

	@Autowired
	CustomerRepository customerRepository1;

	@Override
	public void adminRegister(Admin admin) {
		adminRepository1.save(admin);
		//Save the admin in the database
	}

	@Override
	public Admin updatePassword(Integer adminId, String password) {
		Admin admin = adminRepository1.findById(adminId).get();
		admin.setPassword(password);
		adminRepository1.save(admin);
		return admin;
		//Update the password of admin with given id

	}

	@Override
	public void deleteAdmin(int adminId){
		// Delete admin without using deleteById function
		adminRepository1.deleteById(adminId);

	}

	@Override
	public List<Driver> getListOfDrivers() {

		//Find the list of all drivers
		List<Driver> l = driverRepository1.findAll();
		return l;

	}

	@Override
	public List<Customer> getListOfCustomers() {
		List<Customer> l = customerRepository1.findAll();
		return l;
		//Find the list of all customers
	}
}
