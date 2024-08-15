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
	private Long value;

	public BuildingEntity getBuilding() {
		return building;
	}

	public void setBuilding(BuildingEntity building) {
		this.building = building;
	}

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}
	
	
}
