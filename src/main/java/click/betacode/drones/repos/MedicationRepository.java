package click.betacode.drones.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import click.betacode.drones.entities.Medication;

public interface MedicationRepository extends JpaRepository<Medication, Long> {

}
