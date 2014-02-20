package tn.edu.esprit.gl8.attarManClient.junitTests;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import tn.edu.esprit.gl8.attarMan.domain.Milk;
import tn.edu.esprit.gl8.attarMan.services.interfaces.MilkServicesRemote;

public class TestRealPlatform {

	private Context context;
	private MilkServicesRemote proxy;

	@Before
	public void init() throws NamingException {
		context = new InitialContext();
		String jndiName = "ejb:/tn.edu.esprit.gl8.attarMan/MilkServices!"
				+ MilkServicesRemote.class.getCanonicalName();
		proxy = (MilkServicesRemote) context.lookup(jndiName);

	}

	@Test
	@Ignore
	public void itShouldFindMilkStock() {
		List<Milk> milks = proxy.findMilkStock();

		Assert.assertEquals(2, milks.size());

	}

	@Test
	@Ignore
	public void itShouldAddMilk() {
		Milk milk = new Milk();
		milk.setBrand("nido");

		Assert.assertTrue(proxy.addMilk(milk));

	}

	@Test
	@Ignore
	public void itShouldFindMilkById() {
		Milk milk = proxy.findMilkById(1);
		Assert.assertEquals("nido", milk.getBrand());
	}

	@Test
	public void itShouldDeleteFoundMilk() {
		Assert.assertTrue(proxy.deleteMilk(proxy.findMilkById(1)));

	}
}
