package com.shahbaz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shahbaz.entity.Client;
import com.shahbaz.exception.ClientNotFoundException;
import com.shahbaz.repository.ClientRepository;

@Service
public class ClientServiceImpl implements IClientService{
	@Autowired
	private ClientRepository cliRepository;
	
	@Override
	public Integer saveClient(Client client) {
		// TODO Auto-generated method stub
		return cliRepository.save(client).getId();
	}

	@Override
	public List<Client> getAllClients() {
		// TODO Auto-generated method stub
		return cliRepository.findAll();
	}

	@Override
	public void updateCustomerReport(Client client) {
		cliRepository.save(client);
		
	}

	@Override
	public void deleteClient(Integer id) {
		Client client=getOneClient(id);
		cliRepository.delete(client);
		
	}

	@Override
	public Client getOneClient(Integer id) {
		Client client=cliRepository.findById(id).orElseThrow(()-> new ClientNotFoundException("Customer Report "+id+" does not exist"));
		return client;
	}

	@Override
	public List<Object[]> getPriorityOfWorkAndCount() {
		return cliRepository.getPriorityOfWorkAndCount();
	}
	
	@Override
	public List<Object[]> getTypeOfWorkAndCount() {
		
		return cliRepository.getTypeOfWorkAndCount();
	}

	@Override
	public List<Object[]> getNatureOfWorkAndCount() {
	
		return cliRepository.getNatureOfWorkAndCount();
	}

	@Override
	public Page<Client> getAllClients(Pageable pageable) {
		// TODO Auto-generated method stub
		return cliRepository.findAll(pageable);
	}

	@Override
	public Page<Client> findByClientNameContaining(String clientName, Pageable pageable) {
		// TODO Auto-generated method stub
		return cliRepository.findByClientNameContaining(clientName, pageable);
	}

	@Override
	public Long getAllCount() {
		// TODO Auto-generated method stub
		return cliRepository.count();
	}

	@Override
	public boolean isWorkOrderNoExist(String workOrderNo) {
		// TODO Auto-generated method stub
		return cliRepository.getWorkOrderNoCount(workOrderNo)>0?true:false;
	}
	
}
