package com.gl.main;

import java.util.List;
import java.util.Scanner;

import com.gl.dao.ContactsService;
import com.gl.daoimpl.ContactsServiceImpl;
import com.gl.model.Contacts;

public class Contact_Main {

	public static void main(String[] args) {
		ContactsService service = new ContactsServiceImpl();
		Scanner scan = new Scanner(System.in);
		System.out.println("Press 1 to add Contacts");
		System.out.println("Press 2 to get contacts");
		System.out.println("Press 3 to update contacts");
		System.out.println("Press 4 to Delete contacts");
		System.out.println("Press 5 to exit");
		int choice = scan.nextInt();
		do {
			switch (choice) {
			case 1:
				System.out.println("enter contact id");
				int contactId = scan.nextInt();
				System.out.println("enter contact name");
				scan.nextLine();
				String contactName = scan.nextLine();
				System.out.println("enter email");
				String email = scan.next();
				System.out.println("enter address");
				scan.nextLine();
				String address = scan.nextLine();
				System.out.println("enter mobileNumber");
				String mobileNumber = scan.next();
				Contacts saveContact = new Contacts(contactId, contactName, email, address, mobileNumber);
				String addContact = service.addContact(saveContact);
				System.out.println(addContact);
				break;
			case 2:
				List<Contacts> contacts = service.getAllContacts();
				contacts.forEach(System.out::println);
				break;
			case 3:
				System.out.println("enter contact id");
				int id = scan.nextInt();
				System.out.println("enter mobileNumber");
				String number = scan.next();
				String update = service.updateContact(id, number);
				System.out.println(update);
				break;
			case 4:
				System.out.println("enter contact id");
				int cid = scan.nextInt();
				String delete = service.deleteContact(cid);
				System.out.println(delete);
				break;
			case 5:
				System.exit(0);
			default:
				System.out.println("Invalid input");
				break;
			}
			System.out.println("Enter choice");
			scan = new Scanner(System.in);
			choice = scan.nextInt();
		} while (choice > 0 && choice < 6);
		scan.close();

	}

}
