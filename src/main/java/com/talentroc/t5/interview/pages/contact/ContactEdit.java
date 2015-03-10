package com.talentroc.t5.interview.pages.contact;

import com.talentroc.t5.interview.entities.Contact;
import com.talentroc.t5.interview.services.ContactManager;
import com.talentroc.t5.interview.utils.BusinessException;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

public class ContactEdit {

	@Inject
	private ContactManager contactManager;

	@Property
	private Contact contact;

	void onActivate() {
		contact = new Contact();
	}

	Boolean onActivate(Contact contact) {
		this.contact = contact;
		return Boolean.TRUE;
	}

	Contact onPassivate() {
		return contact;
	}

	public Object onSuccess() throws BusinessException {
		if (contact.getId() != null)
			contactManager.update(contact);
		else
			contactManager.create(contact);

		return ContactIndex.class;
	}
}
