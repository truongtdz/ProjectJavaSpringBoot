package com.projectbuilding.entity;
import javax.persistence.*;

@Entity
@Table (name = "rentarea")
public class RentAreaEntity {
	@ManyToOne
	@JoinColumn(name = "buildingid")
	private BuildingEntity building;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "value", nullable = false)
	private Integer value;

	public BuildingEntity getBuilding() {
		return building;
	}

	public void setBuilding(BuildingEntity building) {
		this.building = building;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	
	
}
