package tn.edu.esprit.gl8.attarMan.services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import tn.edu.esprit.gl8.attarMan.domain.Milk;

@Remote
public interface MilkServicesRemote {

	List<Milk> findMilkStock();

	boolean addMilk(Milk milk);

	Milk findMilkById(int id);

	boolean deleteMilk(Milk milk);

}
