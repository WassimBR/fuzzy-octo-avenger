package tn.edu.esprit.gl8.attarMan.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity implementation class for Entity: Customer
 * 
 */
@Entity
public class Customer implements Serializable {

	private int id;
	private String name;
	private static final long serialVersionUID = 1L;

	public Customer() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Customer(String name) {
		super();
		this.name = name;
	}

}
