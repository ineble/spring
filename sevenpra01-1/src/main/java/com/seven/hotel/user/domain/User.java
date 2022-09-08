package com.seven.hotel.user.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="User")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userno")
	public int userno;
	
	@Column(name="userid")
	public String userid;
	@Column(name="userpwd")
	public String userpwd;
	@Column(name="username")
	public String username;
	
}
