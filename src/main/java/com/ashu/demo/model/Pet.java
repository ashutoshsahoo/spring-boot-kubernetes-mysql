package com.ashu.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pet implements Serializable {

	private static final long serialVersionUID = 4889087778273529265L;

	@Id
	private String name;

	private String owner;

	private String species;

	private char sex;

	@Temporal(TemporalType.DATE)
	private Date birth;

	@Temporal(TemporalType.DATE)
	private Date death;

	public Pet() {
		super();
	}

	public Date getBirth() {
		return birth;
	}

	public Date getDeath() {
		return death;
	}

	public String getName() {
		return name;
	}

	public String getOwner() {
		return owner;
	}

	public char getSex() {
		return sex;
	}

	public String getSpecies() {
		return species;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public void setDeath(Date death) {
		this.death = death;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	@Override
	public String toString() {
		return "Pet [name=" + name + ", owner=" + owner + ", species=" + species + ", sex=" + sex + ", birth=" + birth
				+ ", death=" + death + "]";
	}

}
