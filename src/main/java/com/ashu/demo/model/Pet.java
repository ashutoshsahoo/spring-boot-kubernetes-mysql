package com.ashu.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
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
}
