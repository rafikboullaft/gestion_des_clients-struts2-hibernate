package com.clients.dao;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.clients.entities.Client;
import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

public class ClientDAOImpl implements ClientDAO{
	
	  @SessionTarget
	  Session session;
	  
	  @TransactionTarget 
	  Transaction transaction;
	 
	

	@SuppressWarnings("unchecked")
	public List<Client> listClient() {	
		List<Client> courses = null;
		try {
			courses = session.createQuery("from Client").list();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return courses;
	}

	public void saveClient(Client client) {
		try {
			session.save(client);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} 
	}

	@Override
	public void deleteClient(int code) {
		try {
			Client  client = (Client) session.get(Client.class, code);
			session.delete(client);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} 
		
	}
	@Override
	public Client listClientById(int code) {
		Client client = null;
		try {
			client = (Client) session.get(Client.class, code);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return client;
	}

	
	

	

}
