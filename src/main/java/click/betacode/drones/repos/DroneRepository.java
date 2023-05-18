package click.betacode.drones.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import click.betacode.drones.entities.Drone;

public interface DroneRepository extends JpaRepository<Drone, Long> {

}
