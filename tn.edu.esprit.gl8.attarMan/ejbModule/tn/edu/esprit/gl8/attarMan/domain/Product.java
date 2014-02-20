package tn.edu.esprit.gl8.attarMan.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Entity implementation class for Entity: Product
 * 
 */
@Entity
public class Product implements Serializable {

	private int id;
	private String name;
	private String type;
	private int quantity;
	private static final long serialVersionUID = 1L;

	public Product() {
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product(String name, String type, int quantity) {
		super();
		this.name = name;
		this.type = type;
		this.quantity = quantity;
	}

}
