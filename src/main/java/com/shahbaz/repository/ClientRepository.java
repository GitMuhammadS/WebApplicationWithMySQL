package com.shahbaz.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shahbaz.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{
	
	@Query("SELECT priorityOfWork,COUNT(priorityOfWork) FROM com.shahbaz.entity.Client GROUP BY priorityOfWork")
	public List<Object[]> getPriorityOfWorkAndCount();
	
	@Query("SELECT typeOfWork,COUNT(typeOfWork) FROM com.shahbaz.entity.Client GROUP BY typeOfWork")
	public List<Object[]> getTypeOfWorkAndCount();
	
	@Query("SELECT natureOfWork,COUNT(natureOfWork) FROM com.shahbaz.entity.Client GROUP BY natureOfWork")
	public List<Object[]> getNatureOfWorkAndCount();
	
	@Query("SELECT COUNT(workOrderNo) FROM com.shahbaz.entity.Client WHERE workOrderNo=:workOrderNo")
	public Integer getWorkOrderNoCount(String workOrderNo);
	
	Page<Client> findByClientNameContaining(String clientName,Pageable pageable);
}
