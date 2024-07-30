package com.shahbaz.entity;

import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="ELITE_TAB")
//@SQLDelete(sql = "UPDATE ELITE_TAB SET deleted = true WHERE id=?")
//@Where(clause = "deleted=false")
public class Client {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="CLIENT_NAME")
	private String clientName;
	
	@Column(name="WORK_ORDER_NO")
	private String workOrderNo;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="CALL_REPORTED_BY")
	private String callReportedBy;
	
	@Column(name="CALL_REPORTED_TIME")
	private LocalDateTime callReportedTime;
	
	@Column(name="INVOICE_NO")
	private String invoiceNo;
	
	@Column(name="NATURE_OF_PROBLEM")
	private String natureOfProblem;
	
	@Column(name="PRIORITY_OF_WORK")
	private String priorityOfWork;
	
	@Column(name="TYPE_OF_WORK")
	private String typeOfWork;
	
	@Column(name="NATURE_OF_WORK")
	private String natureOfWork;
	
	@Column(name="CALL_ATTENDED_BY")
	private String callAttendedBy;
	
	@Column(name="CALL_ATTENDED_TIME")
	private LocalDateTime callAttendedTime;
	
	@Column(name="STATUS_OF_WORK")
	private String statusOfWork;
	
	@Column(name="OBSERVATION")
	private String observation;
	
	@Column(name="WORKDONE")
	private String workDone;
	
	@Column(name="REMARKS")
	private String remarks;
	
	//@Column(name="DELETED")
	//private boolean deleted=Boolean.FALSE;
}