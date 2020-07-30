package com.clients.dao;

import java.util.List;

import com.clients.entities.Client;

public interface ClientDAO {
	public void saveClient(Client user);
	public List<Client> listClient();
	public void deleteClient(int code);
	/* public void editClient(Client client); */
	public Client listClientById(int code);

}
