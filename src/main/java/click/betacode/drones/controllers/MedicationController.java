package click.betacode.drones.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import click.betacode.drones.entities.Medication;
import click.betacode.drones.repos.MedicationRepository;

@RestController
public class MedicationController {
 @Autowired
 MedicationRepository mr;
 @GetMapping(path="/medications")
 public List<Medication> getMedicatiions() {
 	 return mr.findAll();
 }
 @GetMapping(path="/medications/{id}")
 public Medication getDrone(@PathVariable("id") int id) {
 	 return mr.findAll().get(id);
 }
 @PostMapping(path="/medications")
 	 public Medication registerDrone(@RequestBody Medication med) {
 		 return mr.save(med);
 	 }
 @PutMapping(path="/medications")
 public Medication  updateDrone(@RequestBody Medication med) {
 	 return mr.save(med);
 }
 @DeleteMapping(path="/medications/{id}")
 public void deleteDrone(@PathVariable("id") long id) {
 	 mr.deleteById(id);
 }
 
}
