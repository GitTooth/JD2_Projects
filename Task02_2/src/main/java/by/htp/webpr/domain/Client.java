package by.htp.webpr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "clients")
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String name;
	
	@Column(name = "surname")
	@NotNull(message="is required")
	@Size(min=1, message="is required")
	private String surname;
	
	@Column(name = "telephone")
	@NotNull(message="is required")
	@Pattern(regexp="[0-9]{3}-[0-9]{2}-[0-9]{2}", message="wrong input")
	private String telephone;
	
	public Client() {
		
	}
		
	public Client(String name, String surname, String telephone) {
		this.name = name;
		this.surname = surname;
		this.telephone = telephone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
}








