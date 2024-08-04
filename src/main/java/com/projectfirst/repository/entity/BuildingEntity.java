package com.projectfirst.repository.entity;

import java.util.Date;

public class BuildingEntity {
	private String name, street, ward, structure, direction, level, rentpriceDescriptio,
	serviceFee, carFee, motorbikeFee, overTimeFee, waterFee, electricityFee, deposit, 
	payment, renttime, decorationtime, type, note, linkOfBuilding, map, avatar, createdby,
	motifiedby, managerName, managerPhoneNumber;
	private Date createddate, motifieddate;
	private int id, numberOfBasement, floorArea, rentPrice, districtid;
	private double brokerageFee;
	public String getName() {
		return name;
	}
	public int getDistrictid() {
		return districtid;
	}
	public void setDistrictid(int districtid) {
		this.districtid = districtid;
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
	public String getRentpriceDescriptio() {
		return rentpriceDescriptio;
	}
	public void setRentpriceDescriptio(String rentpriceDescriptio) {
		this.rentpriceDescriptio = rentpriceDescriptio;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Date getCreateddate() {
		return createddate;
	}
	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
	public Date getMotifieddate() {
		return motifieddate;
	}
	public void setMotifieddate(Date motifieddate) {
		this.motifieddate = motifieddate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumberOfBasement() {
		return numberOfBasement;
	}
	public void setNumberOfBasement(int numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}
	public int getFloorArea() {
		return floorArea;
	}
	public void setFloorArea(int floorArea) {
		this.floorArea = floorArea;
	}
	public int getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(int rentPrice) {
		this.rentPrice = rentPrice;
	}
	public double getBrokerageFee() {
		return Double.parseDouble(String.format("%.2f", brokerageFee));
	}
	public void setBrokerageFee(double brokerageFee) {
		this.brokerageFee = brokerageFee;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public String getMotifiedby() {
		return motifiedby;
	}
	public void setMotifiedby(String motifiedby) {
		this.motifiedby = motifiedby;
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
	
}
