package tn.edu.esprit.gl8.attarMan.services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.edu.esprit.gl8.attarMan.domain.Product;
import tn.edu.esprit.gl8.attarMan.services.interfaces.StockManagementRemote;

/**
 * Session Bean implementation class StockManagement
 */
@Stateless
public class StockManagement implements StockManagementRemote {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public StockManagement() {
	}

	@Override
	public boolean addProduct(Product product) {
		boolean b = false;
		try {
			entityManager.persist(product);
			b = true;
		} catch (Exception e) {
			System.err.println(" emmm c'est ça ...");
		}
		return b;
	}

	@Override
	public boolean deleteProduct(int id) {
		boolean b = false;
		try {
			entityManager.remove(findProductById(id));
			b = true;
		} catch (Exception e) {
			System.err.println(" emmm c'est ça ...");
		}
		return b;
	}

	@Override
	public Product findProductById(int id) {
		return entityManager.find(Product.class, id);
	}

	@Override
	public boolean updateProduct(Product product) {
		boolean b = false;
		try {
			entityManager.merge(product);
			b = true;
		} catch (Exception e) {
			System.err.println(" emmm c'est ça ...");
		}
		return b;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> findAllProducts() {
		String jpql = "select p from Product p";
		Query query = entityManager.createQuery(jpql);

		return query.getResultList();
	}

}
