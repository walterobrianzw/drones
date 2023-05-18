package click.betacode.drones.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import click.betacode.drones.entities.Drone;
import click.betacode.drones.entities.Medication;
import click.betacode.drones.enums.State;
import click.betacode.drones.repos.DroneRepository;
import click.betacode.drones.repos.MedicationRepository;

@RestController
public class DroneController {
@Autowired
DroneRepository dr;
@Autowired
MedicationRepository mr;
int getDroneBattery(Drone d) {
	return d.getBatteryCapacity();
}

@GetMapping(path="/drones")
public List<Drone> getDrones() {
	 return dr.findAll();
}
@GetMapping(path="/drones/{id}")
public Drone getDrone(@PathVariable("id") long id) {
	 return dr.findById(id).get();
}
@GetMapping(path="/drones/batterycapacity/{id}")
public int getDroneBatteryCapacity(@PathVariable("id") long id) {
	Drone d=dr.findById(id).get();
	 return d.getBatteryCapacity();
}
@GetMapping(path="/drones/state/{id}")
public State getDroneState(@PathVariable("id") long id) {
	Drone d=dr.findById(id).get();
	 return d.getDroneState();
}
@GetMapping(path="/drones/load/{id}")
public List<Medication> getDroneLoad(@PathVariable("id") long id) {
	Drone d=dr.findById(id).get();
	 return d.getLoad();
}

@PostMapping(path="/drones/load")
public String loadDrone(@RequestBody List<Medication> meds) {
	int totalMedsWeight=0;
	Drone dro=new Drone();
	for(Medication med: meds) {
		totalMedsWeight+=med.getWeight();
	}
	for(Drone d: getDrones()) {
		if(d.getDroneState()==State.IDLE && d.getBatteryCapacity()>=25 && (d.getWeightLimit()>=totalMedsWeight)) {
			d.setDroneState(State.LOADING);
			for(Medication med: meds) {
					med.setDrone(d);
					mr.save(med);
			}
				d.setLoad(meds);
			d.setDroneState(State.LOADED);
			d.setDroneState(State.DELIVERING);
			
				dro=dr.save(d);
			
			return "Drone id :"+dro.getId()+" has ben loaded, now delivering the load" ;
			
	}
		
	}
	
	return "No Drone is Available At the Moment";
}
@PostMapping(path="/drones")
	 public Drone registerDrone(@RequestBody Drone drone) {
		 return dr.save(drone);
	 }
@PutMapping(path="/drones")
public Drone updateDrone(@RequestBody Drone drone) {
	 return dr.save(drone);
}
@DeleteMapping(path="/drones/{id}")
public void deleteDrone(@PathVariable("id") long id) {
	 dr.deleteById(id);
}


}
