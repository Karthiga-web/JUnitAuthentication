package com.hcl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "junit")
public class JunitEntity {
	@Id
	@Column(name = "id")
	Integer id;
	@Column(name = "username")
	String username;
	@Column(name = "password")
	String password;
	@Column(name = "firstname")
	String firstname;
	@Column(name = "lastname")
	String lastname;
	@Column(name = "email")
	String email;
}
