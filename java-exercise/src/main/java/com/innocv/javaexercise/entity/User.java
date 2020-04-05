package com.innocv.javaexercise.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Class for the user entity
 * @author Abraham Lominchar
 *
 */
@Entity
@Table(name = "users")
public class User {

	/**
	 * The id of the user
	 */
	private Integer id;
	
	/**
	 * The name of the user
	 */
	private String name;
	
	/**
	 * The birthdate of the user
	 */
	private Date birthdate;
	
	/**
	 * Default constructor
	 */
	public User() {
		super();
	}

	/**
	 * Constructor with all the parameters
	 * @param id The id of the user
	 * @param name The name of the user
	 * @param birthdate The birthdate of the user
	 */
	public User(Integer id, String name, Date birthdate) {
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
	}

	/**
	 * @return the id
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the birthdate
	 */
	@Column(name = "BIRTHDATE")
	public Date getBirthdate() {
		return birthdate;
	}

	/**
	 * @param birthdate the birthdate to set
	 */
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
}
