package click.betacode.drones.entities;

import java.util.ArrayList;
import java.util.List;

import click.betacode.drones.enums.Model;
import click.betacode.drones.enums.State;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Drone {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long id;
@Size(min = 1, max = 100, message 
= "Serial Number must be between 1 and 100 characters")
@NotNull(message = "It can not be null. Please provide no. a value")
private String serial_number;

private State drone_state;

private Model drone_model;
@Column (nullable = false)
@Min(value = 1, message = "Weight Limit should not be less than 1")
@Max(value = 500, message = "Weight Limit should not be greater than 500")
@NotNull(message = "It can not be null. Please provide no. in b/w 1 to 500")
private int weight_limit;
@Column (nullable = false)
@Min(value = 0, message = "Battery Capacity should not be less than 0")
@Max(value = 100, message = "Battery Capacity should not be greater than 100")
@NotNull(message = "It can not be null. Please provide no. in b/w 0 to 100")
private int battery_capacity;
@OneToMany(
		mappedBy="drone",
		cascade=CascadeType.ALL
	)
 List<Medication> load=new ArrayList<>();

public String getSerialNumber() {
	return serial_number;
}
public void setSerialNumber(String serialNumber) {
	this.serial_number = serialNumber;
}

public int getWeightLimit() {
	return weight_limit;
}
public void setWeightLimit(int weightLimit) {
	this.weight_limit = weightLimit;
}
public int getBatteryCapacity() {
	return battery_capacity;
}
public void setBatteryCapacity(int batteryCapacity) {
	this.battery_capacity = batteryCapacity;
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public State getDroneState() {
	return drone_state;
}
public void setDroneState(State droneState) {
	this.drone_state = droneState;
}
public Model getDroneModel() {
	return drone_model;
}
public void setDroneModel(Model droneModel) {
	this.drone_model = droneModel;
}
public List<Medication> getLoad() {
	return load;
}
public void setLoad(List<Medication> load) {
	this.load = load;
}
public Drone(){
	this.drone_state=State.IDLE;
	if(weight_limit>0 && weight_limit<=200) {

		this.drone_model=Model.Lightweight;

	}else if(weight_limit>200 && weight_limit<=300) {
		this.drone_model=Model.Middleweight;
		
	}else if(weight_limit>300 && weight_limit<=400) {
		this.drone_model=Model.Cruiserweight;
		
	}else{
		this.drone_model=Model.Heavyweight;
	}
}







}
