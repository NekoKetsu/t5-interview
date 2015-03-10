package com.talentroc.t5.interview.pages.contact;

import com.talentroc.t5.interview.entities.Contact;
import com.talentroc.t5.interview.services.ContactManager;
import com.talentroc.t5.interview.utils.BusinessException;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;

import java.util.List;

public class ContactIndex {
    @Inject
    private ContactManager contactManager;

    @Property
    private Contact contact;

    public List<Contact> getContacts() {
        return contactManager.retrieveAll();
    }
    
	void onActionFromDelete(Contact contact) throws BusinessException {
		contactManager.delete(contact);
	}
}
