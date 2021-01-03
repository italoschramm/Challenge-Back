package com.italoschramm.apivotacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.italoschramm.apivotacao.dto.ParticipantDTO;
import com.italoschramm.apivotacao.model.Participant;
import com.italoschramm.apivotacao.service.participant.ParticipantService;

@RestController
@RequestMapping("/participant")
public class ParticipantController {

	@Autowired
	private ParticipantService participantService;
	
	@PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody ParticipantDTO participant) {
		
		if (participantService.existsParticipant(participant.getName()))
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Participant already exists!");
		
		if(participantService.registerParticipant(participant.getName(), participant.getAge(), participant.getState(), participant.getActive()))
			 return ResponseEntity.status(HttpStatus.CREATED).body("Saved successfully.");
		else
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Save error!");
	}
	
	@GetMapping("/listActiveParticipants")
    public ResponseEntity<List<Participant>> listAtctive() {
		List<Participant> list = participantService.listParticipantsActive();
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping("/listInactiveParticipants")
    public ResponseEntity<List<Participant>> listInactive() {
		return ResponseEntity.status(HttpStatus.OK).body(participantService.listParticipantsInactive());
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		if(participantService.deleteParticipant(id));
			return ResponseEntity.status(HttpStatus.OK).body("Successfully deleted!");
	}
	
	@PutMapping("/inactive/{id}")
	public ResponseEntity<String> inactive(@PathVariable Long id){
		if(participantService.inactiveParticipant(id));
			return ResponseEntity.status(HttpStatus.OK).body("Successfully inactved!");
	}
	
	@PutMapping("/active/{id}")
	public ResponseEntity<String> active(@PathVariable Long id){
		if(participantService.activeParticipant(id));
			return ResponseEntity.status(HttpStatus.OK).body("Successfully actived!");
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody ParticipantDTO participantClient){
		Participant participant = participantService.getParticipantById(participantClient.getId());
		if(participant != null) {
			participant.setActive(participantClient.getActive());
			participant.setName(participantClient.getName());
			participant.setAge(participantClient.getAge());
			participant.setState(participantClient.getState());
		}else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Participant not found!");
		if(participantService.updateParticipant(participant));
			return ResponseEntity.status(HttpStatus.OK).body("Successfully actived!");
	}
}
