package com.gl.model;

public class Contacts {

	private int contactId;
	private String name;
	private String email;
	private String address;
	private String mobileNumber;

	public Contacts() {
	}

	public Contacts(int contactId, String name, String email, String address, String mobileNumber) {
		super();
		this.contactId = contactId;
		this.name = name;
		this.email = email;
		this.address = address;
		this.mobileNumber = mobileNumber;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "contacts [contactId=" + contactId + ", name=" + name + ", email=" + email + ", address=" + address
				+ ", mobileNumber=" + mobileNumber + "]";
	}

}
