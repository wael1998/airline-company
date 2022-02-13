package com.esprit.microservices.candidate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
@EnableAutoConfiguration
@EnableDiscoveryClient
	@RestController
	@RequestMapping(value = "/api/pilotes")
	public class Pilote1RestAPI {
		private String title = "Hello, I'm the pilote Microservice";
		@Autowired
		private Pilote1Service piloteService;
		@RequestMapping("/hello")
		public String sayHello() {
			System.out.println(title);
			return title;
		}
		@PostMapping
		@ResponseStatus(HttpStatus.CREATED)
		public ResponseEntity<Pilote1> createPilote(@RequestBody Pilote1 pilote) {
			return new ResponseEntity<>(piloteService.addPilote(pilote), HttpStatus.OK);
		}
		@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseStatus(HttpStatus.OK)
	    public ResponseEntity<Pilote1> updatePilote(@PathVariable(value = "id") int id,
	    										@RequestBody Pilote1 pilote){
			return new ResponseEntity<>(piloteService.updatePilote(id, pilote), HttpStatus.OK);
		}
		@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	    @ResponseStatus(HttpStatus.OK)
	    public ResponseEntity<String> deletePilote(@PathVariable(value = "id") int id){
			return new ResponseEntity<>(piloteService.deletePilote(id), HttpStatus.OK);
		}
	}


