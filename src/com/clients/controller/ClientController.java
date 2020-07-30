package com.clients.controller;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.clients.dao.ClientDAO;
import com.clients.dao.ClientDAOImpl;
import com.clients.entities.Client;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ClientController extends ActionSupport implements ModelDriven<Client>{
	private static final long serialVersionUID = 1L;
	private Client client = new Client();
	private List<Client> clientList = new ArrayList<Client>();
	private ClientDAO clientDAO = new ClientDAOImpl();
	
	public Client getModel() {
		return client;
	}
	
	public String add()
	{
		clientDAO.saveClient(client);
		return SUCCESS;
	}
	
	public String list()
	{
		clientList = clientDAO.listClient();
		return SUCCESS;
	}
		
	public Client getClient() {
		return client;
	}

	/* block de modification */ 
	public String delete()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
		clientDAO.deleteClient(Integer.parseInt(request.getParameter("code")));
		return SUCCESS;
	}
	public String edit()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get( ServletActionContext.HTTP_REQUEST);
		client = clientDAO.listClientById(Integer.parseInt(request.getParameter("code")));
		return SUCCESS;
	}
	
	
	/*
	 * public String edit() { clientDAO.editClient(client); return SUCCESS; }
	 */
	/* end block */

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Client> getClientList() {
		return clientList;
	}

	public void setClientList(List<Client> clientList) {
		this.clientList = clientList;
	}

	

}
