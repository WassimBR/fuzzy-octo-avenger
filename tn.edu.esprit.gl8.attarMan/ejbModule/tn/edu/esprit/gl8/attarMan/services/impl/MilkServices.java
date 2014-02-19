package tn.edu.esprit.gl8.attarMan.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.edu.esprit.gl8.attarMan.domain.Milk;
import tn.edu.esprit.gl8.attarMan.services.interfaces.MilkServicesRemote;

/**
 * Session Bean implementation class MilkServices
 */
@Stateless
public class MilkServices implements MilkServicesRemote {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public MilkServices() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Milk> findMilkStock() {
		return entityManager.createQuery("select m from Milk m")
				.getResultList();
	}

	@Override
	public boolean addMilk(Milk milk) {
		boolean b = false;
		try {
			entityManager.persist(milk);
			b = true;

		} catch (Exception e) {
			System.err.println("i can't do it sorry mama ...");
		}
		return b;
	}

	@Override
	public Milk findMilkById(int id) {

		return entityManager.find(Milk.class, id);
	}

	@Override
	public boolean deleteMilk(Milk milk) {
		boolean b = false;
		try {
			entityManager.remove(entityManager.merge(milk));
			b = true;

		} catch (Exception e) {
			System.err.println("i can't do it sorry mama ...");
		}
		return b;
	}

}
