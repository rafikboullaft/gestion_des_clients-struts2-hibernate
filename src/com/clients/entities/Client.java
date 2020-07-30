package com.clients.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Client {
	@Id
	@Column(name="Code")
	int code;
	String nom;
	String prenom;
	int age;
	String ville;
	public Client(int code, String nom, String prenom, int age, String ville) {
		super();
		this.code = code;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.ville = ville;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}

}
