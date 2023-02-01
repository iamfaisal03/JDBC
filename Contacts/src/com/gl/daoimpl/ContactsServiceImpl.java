package com.gl.daoimpl;

import java.util.List;

import com.gl.dao.ContactsService;
import com.gl.exception.InfyBankException;
import com.gl.model.Contacts;
import com.gl.persistence.ConatctPersistence;

public class ContactsServiceImpl implements ContactsService {

	@Override
	public String addContact(Contacts conatcts) {
		ConatctPersistence persistence = new ConatctPersistence();
		List<Contacts> findContact = persistence.findContact(conatcts);
		try {
			if (findContact.isEmpty()) {
				String save = persistence.save(conatcts);
				return save;
			} else {
				throw new InfyBankException("Contact Already Exists");
			}
		} catch (InfyBankException e) {
			return e.getMessage();
		}
	}

	@Override
	public List<Contacts> getAllContacts() {
		ConatctPersistence persistence = new ConatctPersistence();
		List<Contacts> allContacts = persistence.getContacts();
		return allContacts;
	}

	@Override
	public String updateContact(int contactId, String mobileNumber) {
		ConatctPersistence persistence = new ConatctPersistence();
		List<Contacts> findContact = persistence.findContactById(contactId);
		try {
			if (!findContact.isEmpty()) {
				String save = persistence.update(contactId, mobileNumber);
				return save;
			} else {
				throw new InfyBankException("Contact UnAvailable");
			}
		} catch (InfyBankException e) {
			return e.getMessage();
		}
	}

	@Override
	public String deleteContact(int contactId) {
		ConatctPersistence persistence = new ConatctPersistence();
		List<Contacts> findContactById = persistence.findContactById(contactId);
		try {
			if (!findContactById.isEmpty()) {
				String save = persistence.delete(contactId);
				return save;
			} else {
				throw new InfyBankException("Movie UnAvailable");
			}
		} catch (InfyBankException e) {
			return e.getMessage();
		}
	}

}
