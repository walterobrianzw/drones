package click.betacode.drones.scheduled;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import click.betacode.drones.entities.Drone;
import click.betacode.drones.repos.DroneRepository;

@Component
@EnableScheduling
public class DroneBatteryLevels {
	private static final org.slf4j.Logger LOGGER=LoggerFactory.getLogger(DroneBatteryLevels.class);
	@Autowired
	private DroneRepository dr;
	@Scheduled(fixedDelay=120000)
	void checkDroneBatteryLevels() {
		try{
			List<Drone> drones= dr.findAll();
			for(Drone d: drones) {
			
				LOGGER.info("Drone ID: "+d.getId()+" Battery Level is "+d.getBatteryCapacity()+"%.");
				if(d.getBatteryCapacity()<25) {
					LOGGER.info("Please Charge now!!!");
				}
			}
		}catch(Exception e) {
			LOGGER.info("Error occured"+e.getMessage());
		}
	}
	
}
