package com.gl.dao;

import java.util.List;

import com.gl.model.Contacts;

public interface ContactsService {
	String addContact(Contacts contacts);

	List<Contacts> getAllContacts();

	String updateContact(int contactId, String mobileNumber);

	String deleteContact(int contactId);

}
