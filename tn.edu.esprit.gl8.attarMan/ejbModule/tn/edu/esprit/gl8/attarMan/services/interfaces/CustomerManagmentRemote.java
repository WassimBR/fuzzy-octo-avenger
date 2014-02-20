package tn.edu.esprit.gl8.attarMan.services.interfaces;

import javax.ejb.Remote;

import tn.edu.esprit.gl8.attarMan.domain.Customer;

@Remote
public interface CustomerManagmentRemote {
	boolean addCustomer(Customer customer);

}
