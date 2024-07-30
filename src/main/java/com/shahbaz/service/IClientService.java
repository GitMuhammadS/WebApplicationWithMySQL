package com.shahbaz.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.shahbaz.entity.Client;

public interface IClientService {
	
	public Integer saveClient(Client client);
	public List<Client> getAllClients();
	public void updateCustomerReport(Client client);
	public void deleteClient(Integer id);
	public Client getOneClient(Integer id);
	public Long getAllCount();
	
	public List<Object[]> getPriorityOfWorkAndCount();
	public List<Object[]> getTypeOfWorkAndCount();
	public List<Object[]> getNatureOfWorkAndCount();
	public boolean isWorkOrderNoExist(String workOrderNo);
	
	public Page<Client> getAllClients(Pageable pageable);
	
	Page<Client> findByClientNameContaining(String clientName,Pageable pageable);
}
