package com.esprit.microservices.candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Service;
@EnableAutoConfiguration
@EnableDiscoveryClient
@Service
public class Pilote1Service {

	@Autowired
	private Pilote1Repository piloteRepository;

	public Pilote1 addPilote(Pilote1 pilote) {
		return piloteRepository.save(pilote);
	}
	public Pilote1 updatePilote(int id, Pilote1 newPilote) {
		if (piloteRepository.findById(id).isPresent()) {
			Pilote1 existingPilote = piloteRepository.findById(id).get();
			existingPilote.setNom(newPilote.getNom());
			existingPilote.setPrenom(newPilote.getPrenom());

			return piloteRepository.save(existingPilote);
		} else
			return null;
	}
	public String deletePilote(int id) {
		if (piloteRepository.findById(id).isPresent()) {
			piloteRepository.deleteById(id);
			return "Pilote supprimé";
		} else
			return "Pilote non supprimé";
	}
}
