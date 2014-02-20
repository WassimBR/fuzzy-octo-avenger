package tn.edu.esprit.gl8.attarManClient.junitTests;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import tn.edu.esprit.gl8.attarMan.domain.Product;
import tn.edu.esprit.gl8.attarManClient.bestPractice.buisnesDelegate.StockManagementDelegate;

public class TestStockManagementServices {

	@Test
	public void itShouldAddProduct() {
		Product product = new Product("batata", "5odhra", 4);
		Assert.assertTrue(StockManagementDelegate.doAddProduct(product));
	}

	@Test
	public void itShouldUpdateProduct() {
		Product productFound = StockManagementDelegate.doFindProductById(1);
		productFound.setName("new look");
		Assert.assertTrue(StockManagementDelegate.doUpdateProduct(productFound));
	}

	@Test
	public void itShouldDeleteProduct() {
		Product productFound = StockManagementDelegate.doFindProductById(1);
		Assert.assertTrue(StockManagementDelegate.doDeleteProduct((productFound
				.getId())));
	}

	@Test
	public void itShouldFindProductById() {
		Product productFound = StockManagementDelegate.doFindProductById(1);
		Assert.assertEquals("batata", productFound.getName());
	}

	@Test
	public void itShouldFindAllProducts() {
		List<Product> products = StockManagementDelegate.doFindAllProducts();
		Assert.assertEquals(2, products.size());
	}
}
