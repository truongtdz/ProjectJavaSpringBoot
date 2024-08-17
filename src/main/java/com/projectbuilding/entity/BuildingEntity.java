package com.projectbuilding.entity;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "building")
public class BuildingEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "ward")
	private String ward;
	
	@Column(name = "structure")
	private String structure;
	
	@Column(name = "numberofbasement")
	private Long numberOfBasement;
	
	@Column(name = "floorarea")
	private Long floorArea;
	
	@Column(name = "direction")
	private String direction;
	
	@Column(name = "level")
	private String level;
	
	@Column(name = "rentprice")
	private Long rentPrice;
	
	@Column(name = "rentpricedescription")
	private String rentpriceDescription;
	
	@Column(name = "servicefee")
	private String serviceFee;
	
	@Column(name = "carfee")
	private String carFee;
	
	@Column(name = "motorbikefee")
	private String motorbikeFee;
	
	@Column(name = "overtimefee")
	private String overTimeFee;
	
	@Column(name = "waterfee")
	private String waterFee;
	
	@Column(name = "electricityfee")
	private String electricityFee;
	
	@Column(name = "deposit")
	private String deposit;
	
	@Column(name = "payment")
	private String payment;
	
	@Column(name = "renttime")
	private String renttime;
	
	@Column(name = "decorationtime")
	private String decorationtime;
	
	@Column(name = "brokeragefee")
	private Double brokerageFee;
	
	@Column(name = "note")
	private String note;
	
	@Column(name = "linkofbuilding")
	private String linkOfBuilding;
	
	@Column(name = "map")
	private String map;
	
	@Column(name = "createddate")
	private Date createdDate;
	
	@Column(name = "modifieddate")
	private Date modifiedDate;
	
	@Column(name = "createdby")
	private String createdBy;
	
	@Column(name = "modifiedby")
	private String modifiedBy;
	
	@Column(name = "managername")
	private String managerName;
	
	@Column(name = "managerphonenumber")
	private String managerPhoneNumber;
	
	@Column(name = "typecode")
	private String typeCode;
	
	@Column(name = "district")
	private String district;
	
	@OneToMany(mappedBy = "building", fetch = FetchType.LAZY)
	private List<RentAreaEntity> rentAreaEntities = new ArrayList<>();	

	public List<RentAreaEntity> getRentAreaEntities() {
		return rentAreaEntities;
	}

	public void setRentAreaEntities(List<RentAreaEntity> rentAreaEntities) {
		this.rentAreaEntities = rentAreaEntities;
	}

	public void setRentpriceDescription(String rentpriceDescription) {
		this.rentpriceDescription = rentpriceDescription;
	}

	public String getTypeCode() {
		return typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public Long getNumberOfBasement() {
		return numberOfBasement;
	}

	public void setNumberOfBasement(Long numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}

	public Long getFloorArea() {
		return floorArea;
	}

	public void setFloorArea(Long floorArea) {
		this.floorArea = floorArea;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public Long getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(Long rentPrice) {
		this.rentPrice = rentPrice;
	}

	public String getRentpriceDescription() {
		return rentpriceDescription;
	}

	public void setRentpriceDescriptio(String rentpriceDescription) {
		this.rentpriceDescription = rentpriceDescription;
	}

	public String getServiceFee() {
		return serviceFee;
	}

	public void setServiceFee(String serviceFee) {
		this.serviceFee = serviceFee;
	}

	public String getCarFee() {
		return carFee;
	}

	public void setCarFee(String carFee) {
		this.carFee = carFee;
	}

	public String getMotorbikeFee() {
		return motorbikeFee;
	}

	public void setMotorbikeFee(String motorbikeFee) {
		this.motorbikeFee = motorbikeFee;
	}

	public String getOverTimeFee() {
		return overTimeFee;
	}

	public void setOverTimeFee(String overTimeFee) {
		this.overTimeFee = overTimeFee;
	}

	public String getWaterFee() {
		return waterFee;
	}

	public void setWaterFee(String waterFee) {
		this.waterFee = waterFee;
	}

	public String getElectricityFee() {
		return electricityFee;
	}

	public void setElectricityFee(String electricityFee) {
		this.electricityFee = electricityFee;
	}

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getRenttime() {
		return renttime;
	}

	public void setRenttime(String renttime) {
		this.renttime = renttime;
	}

	public String getDecorationtime() {
		return decorationtime;
	}

	public void setDecorationtime(String decorationtime) {
		this.decorationtime = decorationtime;
	}

	public Double getBrokerageFee() {
		return brokerageFee;
	}

	public void setBrokerageFee(Double brokerageFee) {
		this.brokerageFee = brokerageFee;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getLinkOfBuilding() {
		return linkOfBuilding;
	}

	public void setLinkOfBuilding(String linkOfBuilding) {
		this.linkOfBuilding = linkOfBuilding;
	}

	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date motifiedDate) {
		this.modifiedDate = motifiedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String motifiedBy) {
		this.modifiedBy = motifiedBy;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerPhoneNumber() {
		return managerPhoneNumber;
	}

	public void setManagerPhoneNumber(String managerPhoneNumber) {
		this.managerPhoneNumber = managerPhoneNumber;
	}
	
	
//	private String name, street, ward, structure, direction, level, rentpriceDescriptio,
//	serviceFee, carFee, motorbikeFee, overTimeFee, waterFee, electricityFee, deposit, 
//	payment, renttime, decorationtime, type, note, linkOfBuilding, map, avatar, createdby,
//	motifiedby, managerName, managerPhoneNumber;
//	private Date createddate, motifieddate;
//	private long id, numberOfBasement, floorArea, rentPrice, districtid;
//	private double brokerageFee;
}
