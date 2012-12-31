package com.example.mycomponent.pages;


import java.util.List;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.hibernate.annotations.CommitAfter;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.hibernate.Session;

import com.example.mycomponent.entity.Address;


public class CreateAddress {
	
	@Property
	private Address address = new Address();

	@Inject
	private Session session;
	
	@CommitAfter
	Object onSuccess() {
		session.persist(address);
		return null;
	}
	
	public List<Address> getAddresses()
    {
        return session.createCriteria(Address.class).list();
    }
}
