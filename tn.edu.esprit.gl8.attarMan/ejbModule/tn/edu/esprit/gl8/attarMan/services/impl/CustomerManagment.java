package tn.edu.esprit.gl8.attarMan.services.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.edu.esprit.gl8.attarMan.domain.Customer;
import tn.edu.esprit.gl8.attarMan.services.interfaces.CustomerManagmentRemote;

/**
 * Session Bean implementation class CustomerManagment
 */
@Stateless
public class CustomerManagment implements CustomerManagmentRemote {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */

	public CustomerManagment() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addCustomer(Customer customer) {
		boolean b = false;
		try {
			entityManager.persist(customer);
			b = true;
		} catch (Exception e) {
			System.err.println("yours");
		}
		return b;
	}

}
