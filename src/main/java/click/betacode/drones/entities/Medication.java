package click.betacode.drones.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
public class Medication {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long id;

@Pattern(regexp = "[a-zA-Z_0-9-]+",
message = "only letters, numbers, underscore and hyphen allowed")
private String name;
@Min(value = 1, message = "Weight should not be less than 1")
@Max(value = 500, message = "Weight should not be greater than 500")
@NotNull(message = "It can not be null. Please provide no. in b/w 4 to 6")
private int weight;
@Pattern(regexp = "[A-Z0-9_]+",
message = "only upper case letters, underscore and numbers allowed")
private String code;
private String image;
@ManyToOne (fetch = FetchType.LAZY)
@JoinColumn(name="drone_id")
@JsonIgnore
private Drone drone;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Drone getDrone() {
	return drone;
}
public void setDrone(Drone d) {
	this.drone = d;
}
public int getWeight() {
	return weight;
}
public void setWeight(int weight) {
	this.weight = weight;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public Medication() {
	this.drone=null;
}

}
