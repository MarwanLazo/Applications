package com.sprapp.jsf;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import com.sprapp.dto.TempTableDTO;
import com.sprapp.interceptor.TestEJB;
import com.sprapp.jms.InvoiceQueueSender;
import com.sprapp.service.TempTableService;
/**
 * @author Marwan
 * 
 */
@ManagedBean(name = "temp")
@ViewScoped
public class TempController implements Serializable {
	private static final long		serialVersionUID	= 1L;

	private Iterable<TempTableDTO>	results;
	private TempTableDTO			temp;
	@ManagedProperty("#{tempTableService}")
	private TempTableService		tempTableService;

	@ManagedProperty("#{invoiceQueueSender}")
	private InvoiceQueueSender		invoiceQueueSender;

	@ManagedProperty("#{myComponent}")
	private TestEJB					ejb;

	@PostConstruct
	private void init() {
		try {
			System.out.println(tempTableService.instanceTestEJB().getName("Marwan", tempTableService.getEm()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		results = tempTableService.findAllTempTable();
		temp = new TempTableDTO();
		for (TempTableDTO tempTableDTO : results) {
			System.out.println(tempTableDTO.getTempRef());
		}
	}

	public Iterable<TempTableDTO> getResults() {
		return results;
	}

	public void createTempTable(ActionEvent event) {
		temp.setTempName(temp.getTempName().replace(" ", ""));
		tempTableService.createTempTable(temp);
		results = tempTableService.findAllTempTable();
		temp = new TempTableDTO();
	}

	public void deleteTempTable(TempTableDTO temp) {
		tempTableService.deleteTempTable(temp);
		results = tempTableService.findAllTempTable();
	}

	public void updateTempTable(TempTableDTO temp) {
		this.temp = temp;
	}

	public void messageSender(ActionEvent event) {
		invoiceQueueSender.sendMesage("Test Is DONE!!");
	}

	public void messageSender() {
		invoiceQueueSender.sendMesage("Test Is DONE!! APPmm");
	}

	// ------------- Setters & getters -------------
	public TempTableDTO getTemp() {
		return temp;
	}

	public void setTemp(TempTableDTO temp) {
		this.temp = temp;
	}

	public void setTempTableService(TempTableService tempTableService) {
		this.tempTableService = tempTableService;
	}

	public void setInvoiceQueueSender(InvoiceQueueSender invoiceQueueSender) {
		this.invoiceQueueSender = invoiceQueueSender;
	}

	public void setEjb(TestEJB ejb) {
		this.ejb = ejb;
	}

}
