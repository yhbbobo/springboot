package com.ecoman.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="receipt_lines")
public class ReceiptLine implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="receipt_line_id",nullable=false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id = 0L;

	@ManyToOne(fetch=FetchType.EAGER, cascade= CascadeType.ALL)
	@JoinColumn(name="receipt_id")
	@JsonIgnore
	Receipt receipt;

	@Column(name="company_id",nullable=true)
	protected String companyId;

	@Column(name="receipt_no",nullable=true)
	protected Long receiptNo;

	@Column(name="line_no",nullable=true)
	protected Integer lineNo;

	@Column(name="item_id",nullable=true)
	protected String itemId;

	@Column(name="warehouse_id",nullable=true)
	protected String warehouseId;

	@Column(name="zone_id",nullable=true)
	protected String zoneId;

	@Column(name="location_id",nullable=true)
	protected String locationId;

	@Column(name="pallet_size",nullable=true)
	protected String palletSize;

	@Column(name="po_no",nullable=true)
	protected String poNo;

	@Column(name="po_line_no",nullable=true)
	protected Integer poLineNo;

	@Column(name="lot_no",nullable=true)
	protected String lotNo;

	@Column(name="goods_total",nullable=true)
	protected Integer goodsTotal;

	@Column(name="damage_total",nullable=true)
	protected Integer damageTotal;

	@Column(name="expected_qty",nullable=true)
	protected Integer expectedQty;

	@Column(name="pallets",nullable=true)
	protected Double pallets;

	@Column(name="note",nullable=true)
	protected String note;

	@Column(name="qty_per_pallet",nullable=true)
	protected Integer qtyPerPallet;

	@Column(name="is_check_sn",nullable=true)
	protected Boolean isCheckSn;

	@Column(name="sn_size",nullable=true)
	protected Integer snSize;

	@Column(name="is_check_lot_no",nullable=true)
	protected Boolean isCheckLotNo;

	@Column(name="wms_item",nullable=true)
	protected String wmsItem;

	@Column(name="wms_lot_no",nullable=true)
	protected String wmsLotNo;

	@Column(name="wms_qty",nullable=true)
	protected Integer wmsQty;

	@Column(name="supplier",nullable=true)
	protected String supplier;

	@Column(name="status",nullable=true)
	protected Integer status;

	@Column(name="is_sku_type",nullable=true)
	protected Boolean isSkuType;

	@Column(name="pc_id",nullable=true)
	protected Long pcId;

	@Column(name="close_date",nullable=true)
	protected Date closeDate;

	@Column(name="close_user",nullable=true)
	protected Long closeUser;

	@Column(name="detail_id",nullable=true)
	protected Long detailId;

	@Column(name="unloading_start_time",nullable=true)
	protected Date unloadingStartTime;

	@Column(name="unloading_finish_time",nullable=true)
	protected Date unloadingFinishTime;

	@Column(name="counted_user",nullable=true)
	protected Long countedUser;

	@Column(name="scan_start_adid",nullable=true)
	protected Long scanStartAdid;

	@Column(name="scan_start_time",nullable=true)
	protected Date scanStartTime;

	@Column(name="scan_end_adid",nullable=true)
	protected Long scanEndAdid;

	@Column(name="scan_end_time",nullable=true)
	protected Date scanEndTime;

	@Column(name="close_adid",nullable=true)
	protected Long closeAdid;

	@Column(name="close_time",nullable=true)
	protected Date closeTime;

	@Column(name="assign_time",nullable=true)
	protected Date assignTime;

	@Column(name="cc_start_time",nullable=true)
	protected Date ccStartTime;

	@Column(name="cc_finish_time",nullable=true)
	protected Date ccFinishTime;

	@Column(name="cc_user",nullable=true)
	protected Long ccUser;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Receipt getReceipt() {
		return receipt;
	}

	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
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

	public Integer getLineNo() {
		return lineNo;
	}

	public void setLineNo(Integer lineNo) {
		this.lineNo = lineNo;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(String warehouseId) {
		this.warehouseId = warehouseId;
	}

	public String getZoneId() {
		return zoneId;
	}

	public void setZoneId(String zoneId) {
		this.zoneId = zoneId;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getPalletSize() {
		return palletSize;
	}

	public void setPalletSize(String palletSize) {
		this.palletSize = palletSize;
	}

	public String getPoNo() {
		return poNo;
	}

	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	public Integer getPoLineNo() {
		return poLineNo;
	}

	public void setPoLineNo(Integer poLineNo) {
		this.poLineNo = poLineNo;
	}

	public String getLotNo() {
		return lotNo;
	}

	public void setLotNo(String lotNo) {
		this.lotNo = lotNo;
	}

	public Integer getGoodsTotal() {
		return goodsTotal;
	}

	public void setGoodsTotal(Integer goodsTotal) {
		this.goodsTotal = goodsTotal;
	}

	public Integer getDamageTotal() {
		return damageTotal;
	}

	public void setDamageTotal(Integer damageTotal) {
		this.damageTotal = damageTotal;
	}

	public Integer getExpectedQty() {
		return expectedQty;
	}

	public void setExpectedQty(Integer expectedQty) {
		this.expectedQty = expectedQty;
	}

	public Double getPallets() {
		return pallets;
	}

	public void setPallets(Double pallets) {
		this.pallets = pallets;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getQtyPerPallet() {
		return qtyPerPallet;
	}

	public void setQtyPerPallet(Integer qtyPerPallet) {
		this.qtyPerPallet = qtyPerPallet;
	}

	public Boolean getIsCheckSn() {
		return isCheckSn;
	}

	public void setIsCheckSn(Boolean isCheckSn) {
		this.isCheckSn = isCheckSn;
	}

	public Integer getSnSize() {
		return snSize;
	}

	public void setSnSize(Integer snSize) {
		this.snSize = snSize;
	}

	public Boolean getIsCheckLotNo() {
		return isCheckLotNo;
	}

	public void setIsCheckLotNo(Boolean isCheckLotNo) {
		this.isCheckLotNo = isCheckLotNo;
	}

	public String getWmsItem() {
		return wmsItem;
	}

	public void setWmsItem(String wmsItem) {
		this.wmsItem = wmsItem;
	}

	public String getWmsLotNo() {
		return wmsLotNo;
	}

	public void setWmsLotNo(String wmsLotNo) {
		this.wmsLotNo = wmsLotNo;
	}

	public Integer getWmsQty() {
		return wmsQty;
	}

	public void setWmsQty(Integer wmsQty) {
		this.wmsQty = wmsQty;
	}

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Boolean getIsSkuType() {
		return isSkuType;
	}

	public void setIsSkuType(Boolean isSkuType) {
		this.isSkuType = isSkuType;
	}

	public Long getPcId() {
		return pcId;
	}

	public void setPcId(Long pcId) {
		this.pcId = pcId;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public Long getCloseUser() {
		return closeUser;
	}

	public void setCloseUser(Long closeUser) {
		this.closeUser = closeUser;
	}

	public Long getDetailId() {
		return detailId;
	}

	public void setDetailId(Long detailId) {
		this.detailId = detailId;
	}

	public Date getUnloadingStartTime() {
		return unloadingStartTime;
	}

	public void setUnloadingStartTime(Date unloadingStartTime) {
		this.unloadingStartTime = unloadingStartTime;
	}

	public Date getUnloadingFinishTime() {
		return unloadingFinishTime;
	}

	public void setUnloadingFinishTime(Date unloadingFinishTime) {
		this.unloadingFinishTime = unloadingFinishTime;
	}

	public Long getCountedUser() {
		return countedUser;
	}

	public void setCountedUser(Long countedUser) {
		this.countedUser = countedUser;
	}

	public Long getScanStartAdid() {
		return scanStartAdid;
	}

	public void setScanStartAdid(Long scanStartAdid) {
		this.scanStartAdid = scanStartAdid;
	}

	public Date getScanStartTime() {
		return scanStartTime;
	}

	public void setScanStartTime(Date scanStartTime) {
		this.scanStartTime = scanStartTime;
	}

	public Long getScanEndAdid() {
		return scanEndAdid;
	}

	public void setScanEndAdid(Long scanEndAdid) {
		this.scanEndAdid = scanEndAdid;
	}

	public Date getScanEndTime() {
		return scanEndTime;
	}

	public void setScanEndTime(Date scanEndTime) {
		this.scanEndTime = scanEndTime;
	}

	public Long getCloseAdid() {
		return closeAdid;
	}

	public void setCloseAdid(Long closeAdid) {
		this.closeAdid = closeAdid;
	}

	public Date getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}

	public Date getAssignTime() {
		return assignTime;
	}

	public void setAssignTime(Date assignTime) {
		this.assignTime = assignTime;
	}

	public Date getCcStartTime() {
		return ccStartTime;
	}

	public void setCcStartTime(Date ccStartTime) {
		this.ccStartTime = ccStartTime;
	}

	public Date getCcFinishTime() {
		return ccFinishTime;
	}

	public void setCcFinishTime(Date ccFinishTime) {
		this.ccFinishTime = ccFinishTime;
	}

	public Long getCcUser() {
		return ccUser;
	}

	public void setCcUser(Long ccUser) {
		this.ccUser = ccUser;
	}
	
	
}
