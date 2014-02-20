package tn.edu.esprit.gl8.attarMan.services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.esprit.gl8.attarMan.domain.Product;

@Remote
public interface StockManagementRemote {

	boolean addProduct(Product product);

	boolean deleteProduct(int id);

	Product findProductById(int id);

	boolean updateProduct(Product product);

	List<Product> findAllProducts();

}
