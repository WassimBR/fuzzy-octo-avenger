package tn.edu.esprit.gl8.attarManClient.bestPractice.buisnesDelegate;

import java.util.List;

import tn.edu.esprit.gl8.attarMan.domain.Product;
import tn.edu.esprit.gl8.attarMan.services.interfaces.StockManagementRemote;
import tn.edu.esprit.gl8.attarManClient.bestPractice.serviceLocater.ServiceLocater;

public class StockManagementDelegate {

	private static final String jndiName = "ejb:/tn.edu.esprit.gl8.attarMan/StockManagement!"
			+ StockManagementRemote.class.getCanonicalName();

	private static StockManagementRemote getProxy() {
		return (StockManagementRemote) ServiceLocater.getInstance().getProxy(
				jndiName);

	}

	public static boolean doAddProduct(Product product) {
		return getProxy().addProduct(product);
	}

	public static boolean doDeleteProduct(int id) {
		return getProxy().deleteProduct(id);
	}

	public static boolean doUpdateProduct(Product product) {
		return getProxy().updateProduct(product);
	}

	public static Product doFindProductById(int id) {
		return getProxy().findProductById(id);
	}

	public static List<Product> doFindAllProducts() {
		return getProxy().findAllProducts();
	}

}
