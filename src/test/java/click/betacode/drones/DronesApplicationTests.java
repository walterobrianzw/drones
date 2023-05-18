package click.betacode.drones;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import click.betacode.drones.entities.Drone;
import click.betacode.drones.repos.DroneRepository;

@SpringBootTest
class DronesApplicationTests {
	@Autowired
	private DroneRepository dr;
	@Test
	void testRegisterDrone() {
		Drone d=new Drone();
		d.setId(1);
		d.setSerialNumber("12345");
		d.setWeightLimit(20);
		d.setBatteryCapacity(30);
		dr.save(d);
		
		Drone savedDr=dr.findById((long) 1).get();
	//	System.out.println(savedDr.getSerialNumber());
	//	print(savedDr.getSerialNumber());
		Assert.notNull(savedDr,"Something is there");
	}
	

}
