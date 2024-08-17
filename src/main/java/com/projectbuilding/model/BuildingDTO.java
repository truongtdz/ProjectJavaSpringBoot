package com.projectbuilding.model;

import java.util.List;

public class BuildingDTO {
	 	private String name;
	    private String Address;
	    private Long numberOfBasement;
	    private String managerName;
	    private String managerPhone;
	    private Long floorArea;
	    private String rentArea;
	    private Integer rentPrice;
	    private List<String> typeCode;
	    private String serviceFee;
	    private String carFee;
	    private String motoFee;
	    private String overtimeFee;
	    private String electricityFee;
	    private Integer brokerageFee;
	    private String deposit;
	    private String payment;
	    private String rentTime;
	    private String decorationtime;
	    private String structure;
	    private String direction;
	    private String level;
	    private String note;
	    private String rentPriceDescription;
	    
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getStructure() {
			return structure;
		}
		public void setStructure(String structure) {
			this.structure = structure;
		}
		public String getAddress() {
			return Address;
		}
		public void setAddress(String address) {
			Address = address;
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
		public String getRentArea() {
			return rentArea;
		}
		public void setRentArea(String rentArea) {
			this.rentArea = rentArea;
		}
		public Integer getRentPrice() {
			return rentPrice;
		}
		public void setRentPrice(Integer rentPrice) {
			this.rentPrice = rentPrice;
		}
		public String getRentPriceDescription() {
			return rentPriceDescription;
		}
		public void setRentPriceDescription(String rentPriceDescription) {
			this.rentPriceDescription = rentPriceDescription;
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
		public String getMotoFee() {
			return motoFee;
		}
		public void setMotoFee(String motoFee) {
			this.motoFee = motoFee;
		}
		public String getOvertimeFee() {
			return overtimeFee;
		}
		public void setOvertimeFee(String overtimeFee) {
			this.overtimeFee = overtimeFee;
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
		public String getRentTime() {
			return rentTime;
		}
		public void setRentTime(String rentTime) {
			this.rentTime = rentTime;
		}
		public String getDecorationtime() {
			return decorationtime;
		}
		public void setDecorationtime(String decorationtime) {
			this.decorationtime = decorationtime;
		}
		public String getManagerName() {
			return managerName;
		}
		public void setManagerName(String managerName) {
			this.managerName = managerName;
		}
		public String getManagerPhone() {
			return managerPhone;
		}
		public void setManagerPhone(String managerPhone) {
			this.managerPhone = managerPhone;
		}
		public Integer getBrokerageFee() {
			return brokerageFee;
		}
		public void setBrokerageFee(Integer brokerageFee) {
			this.brokerageFee = brokerageFee;
		}
		public String getNote() {
			return note;
		}
		public void setNote(String note) {
			this.note = note;
		}
		public List<String> getTypeCode() {
			return typeCode;
		}
		public void setTypeCode(List<String> typeCode) {
			this.typeCode = typeCode;
		}
	    
}