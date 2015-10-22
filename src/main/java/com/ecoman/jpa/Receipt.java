package com.ecoman.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="receipts")
public class Receipt implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="receipt_id",nullable=false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id = 0L;
	
	@Column(name="ps_id",nullable=false)
	protected Long psId = 0L;

	@Column(name="company_id",nullable=false)
	protected String companyId;

	@Column(name="receipt_no",nullable=false)
	protected Long receiptNo = 0L;

	@Column(name="status",nullable=true)
	protected String status;

	@Column(name="customer_key",nullable=true)
	protected Long customerKey;

	@Column(name="customer_id",nullable=true)
	protected String customerId;

	@Column(name="supplier_key",nullable=true)
	protected Long supplierKey;

	@Column(name="supplier_id",nullable=true)
	protected String supplierId;

	@Column(name="entered_date",nullable=true)
	protected Date enteredDate;

	@Column(name="warehouse_id",nullable=true)
	protected String warehouseId;

	@Column(name="reference_no",nullable=true)
	protected String referenceNo;

	@Column(name="po_no",nullable=true)
	protected String poNo;

	@Column(name="bol_no",nullable=true)
	protected String bolNo;

	@Column(name="container_no",nullable=true)
	protected String containerNo;

	@Column(name="seals",nullable=true)
	protected String seals;

	@Column(name="scac",nullable=true)
	protected String scac;

	@Column(name="carrier_id",nullable=true)
	protected String carrierId;

	@Column(name="schedule_date",nullable=true)
	protected Date scheduleDate;

	@Column(name="appointment_date",nullable=true)
	protected Date appointmentDate;

	@Column(name="in_yard_date",nullable=true)
	protected Date inYardDate;

	@Column(name="devanner_date",nullable=true)
	protected Date devannerDate;

	@Column(name="last_free_date",nullable=true)
	protected Date lastFreeDate;

	@Column(name="receipt_type",nullable=true)
	protected String receiptType;

	@Column(name="note",nullable=true)
	protected String note;

	@Column(name="carton_label_printed",nullable=true)
	protected Boolean cartonLabelPrinted;

	@Column(name="plate_printed",nullable=true)
	protected Boolean platePrinted;

	@Column(name="receipt_ticket_printed",nullable=true)
	protected Boolean receiptTicketPrinted;

	@Column(name="tally_sheet_printed",nullable=true)
	protected Boolean tallySheetPrinted;

	@Column(name="receipt_printed",nullable=true)
	protected Boolean receiptPrinted;

	@Column(name="link_sequence_no",nullable=true)
	protected String linkSequenceNo;

	@Column(name="re_control_no",nullable=true)
	protected String reControlNo;

	@Column(name="edi_order",nullable=true)
	protected Boolean ediOrder;

	@Column(name="send944",nullable=true)
	protected Boolean send944;

	@Column(name="send947",nullable=true)
	protected Boolean send947;

	@Column(name="date_created",nullable=true)
	protected Date dateCreated;

	@Column(name="user_created",nullable=true)
	protected String userCreated;

	@Column(name="date_updated",nullable=true)
	protected Date dateUpdated;

	@Column(name="user_updated",nullable=true)
	protected String userUpdated;

	@Column(name="detail_id",nullable=true)
	protected Long detailId;

	@Column(name="print_date",nullable=true)
	protected Date printDate;

	@Column(name="print_user",nullable=true)
	protected Long printUser;

	@Column(name="print_number",nullable=true)
	protected Integer printNumber;

	@Column(name="close_user",nullable=true)
	protected Long closeUser;
	
	@OneToMany(mappedBy="receipt", cascade=CascadeType.ALL, orphanRemoval=true, fetch=FetchType.EAGER)
	Set<ReceiptLine> lines = new HashSet<ReceiptLine>();
	
	

	public Set<ReceiptLine> getLines() {
		return lines;
	}

	public void setLines(Set<ReceiptLine> lines) {
		this.lines = lines;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPsId() {
		return psId;
	}

	public void setPsId(Long psId) {
		this.psId = psId;
	}

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

	public Long getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(Long receiptNo) {
		this.receiptNo = receiptNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getCustomerKey() {
		return customerKey;
	}

	public void setCustomerKey(Long customerKey) {
		this.customerKey = customerKey;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public Long getSupplierKey() {
		return supplierKey;
	}

	public void setSupplierKey(Long supplierKey) {
		this.supplierKey = supplierKey;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public Date getEnteredDate() {
		return enteredDate;
	}

	public void setEnteredDate(Date enteredDate) {
		this.enteredDate = enteredDate;
	}

	public String getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getPoNo() {
		return poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	public String getBolNo() {
		return bolNo;
	}

	public void setBolNo(String bolNo) {
		this.bolNo = bolNo;
	}

	public String getContainerNo() {
		return containerNo;
	}

	public void setContainerNo(String containerNo) {
		this.containerNo = containerNo;
	}

	public String getSeals() {
		return seals;
	}

	public void setSeals(String seals) {
		this.seals = seals;
	}

	public String getScac() {
		return scac;
	}

	public void setScac(String scac) {
		this.scac = scac;
	}

	public String getCarrierId() {
		return carrierId;
	}

	public void setCarrierId(String carrierId) {
		this.carrierId = carrierId;
	}

	public Date getScheduleDate() {
		return scheduleDate;
	}

	public void setScheduleDate(Date scheduleDate) {
		this.scheduleDate = scheduleDate;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public Date getInYardDate() {
		return inYardDate;
	}

	public void setInYardDate(Date inYardDate) {
		this.inYardDate = inYardDate;
	}

	public Date getDevannerDate() {
		return devannerDate;
	}

	public void setDevannerDate(Date devannerDate) {
		this.devannerDate = devannerDate;
	}

	public Date getLastFreeDate() {
		return lastFreeDate;
	}

	public void setLastFreeDate(Date lastFreeDate) {
		this.lastFreeDate = lastFreeDate;
	}

	public String getReceiptType() {
		return receiptType;
	}

	public void setReceiptType(String receiptType) {
		this.receiptType = receiptType;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Boolean getCartonLabelPrinted() {
		return cartonLabelPrinted;
	}

	public void setCartonLabelPrinted(Boolean cartonLabelPrinted) {
		this.cartonLabelPrinted = cartonLabelPrinted;
	}

	public Boolean getPlatePrinted() {
		return platePrinted;
	}

	public void setPlatePrinted(Boolean platePrinted) {
		this.platePrinted = platePrinted;
	}

	public Boolean getReceiptTicketPrinted() {
		return receiptTicketPrinted;
	}

	public void setReceiptTicketPrinted(Boolean receiptTicketPrinted) {
		this.receiptTicketPrinted = receiptTicketPrinted;
	}

	public Boolean getTallySheetPrinted() {
		return tallySheetPrinted;
	}

	public void setTallySheetPrinted(Boolean tallySheetPrinted) {
		this.tallySheetPrinted = tallySheetPrinted;
	}

	public Boolean getReceiptPrinted() {
		return receiptPrinted;
	}

	public void setReceiptPrinted(Boolean receiptPrinted) {
		this.receiptPrinted = receiptPrinted;
	}

	public String getLinkSequenceNo() {
		return linkSequenceNo;
	}

	public void setLinkSequenceNo(String linkSequenceNo) {
		this.linkSequenceNo = linkSequenceNo;
	}

	public String getReControlNo() {
		return reControlNo;
	}

	public void setReControlNo(String reControlNo) {
		this.reControlNo = reControlNo;
	}

	public Boolean getEdiOrder() {
		return ediOrder;
	}

	public void setEdiOrder(Boolean ediOrder) {
		this.ediOrder = ediOrder;
	}

	public Boolean getSend944() {
		return send944;
	}

	public void setSend944(Boolean send944) {
		this.send944 = send944;
	}

	public Boolean getSend947() {
		return send947;
	}

	public void setSend947(Boolean send947) {
		this.send947 = send947;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getUserCreated() {
		return userCreated;
	}

	public void setUserCreated(String userCreated) {
		this.userCreated = userCreated;
	}

	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	public String getUserUpdated() {
		return userUpdated;
	}

	public void setUserUpdated(String userUpdated) {
		this.userUpdated = userUpdated;
	}

	public Long getDetailId() {
		return detailId;
	}

	public void setDetailId(Long detailId) {
		this.detailId = detailId;
	}

	public Date getPrintDate() {
		return printDate;
	}

	public void setPrintDate(Date printDate) {
		this.printDate = printDate;
	}

	public Long getPrintUser() {
		return printUser;
	}

	public void setPrintUser(Long printUser) {
		this.printUser = printUser;
	}

	public Integer getPrintNumber() {
		return printNumber;
	}

	public void setPrintNumber(Integer printNumber) {
		this.printNumber = printNumber;
	}

	public Long getCloseUser() {
		return closeUser;
	}

	public void setCloseUser(Long closeUser) {
		this.closeUser = closeUser;
	}
	
	@PrePersist
	public void beforeSave(){
		if(this.dateCreated == null){
			dateCreated = new Date();
			this.dateUpdated = dateCreated;
		}
	}
	
	@PreUpdate
	public void beforeUpdate(){
		this.dateUpdated = new Date();
	}
	
}
