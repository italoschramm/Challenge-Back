package com.italoschramm.apivotacao.service.participant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.italoschramm.apivotacao.model.Participant;
import com.italoschramm.apivotacao.repository.ParticipantRepository;

@Service
public class ParticipantServiceImpl implements ParticipantService{

	@Autowired
	private ParticipantRepository participantRepository;
	
	@Override
	public Participant getParticipantById(long idParticipant) {
		Participant participant = participantRepository.findById(idParticipant).orElse(null); 
		return participant;
	}
	
	@Override
	public boolean registerParticipant(String name, int age, String state, boolean active) {
		Participant participant = new Participant();
		participant.setName(name);
		participant.setAge(age);
		participant.setState(state);
		participant.setActive(active);
		try {
			participantRepository.save(participant);
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@Override
	public boolean existsParticipant(String name) {
		Participant participantResult = participantRepository.findByName(name);
		if(participantResult != null)
			return true;
		else
			return false;
	}
	
	@Override
	public List<Participant> listParticipantsActive(){
		List<Participant> participant = participantRepository.listParticipantsActive(); 
		return participant;
	}
	
	@Override
	public List<Participant> listParticipantsInactive(){
		List<Participant> participant = participantRepository.listParticipantsInactive(); 
		return participant;
	}
	
	@Override
	public boolean deleteParticipant(Long idParticipant) {
		Participant participant = getParticipantById(idParticipant);
		if(participant != null) {
			try {
				participantRepository.delete(participant);
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}else
			return false;
	}
	
	@Override
	public boolean inactiveParticipant(Long idParticipant) {
		Participant participant = getParticipantById(idParticipant);
		if(participant != null) {
			try {
				if(participantRepository.inactiveParticipant(idParticipant) > 0)
					return true;;
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
			return false;
		}else
			return false;
	}
	
	@Override
	public boolean activeParticipant(Long idParticipant) {
		Participant participant = getParticipantById(idParticipant);
		if(participant != null) {
			try {
				if(participantRepository.activeParticipant(idParticipant) > 0)
					return true;
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
			return false;
		}else
			return false;
	}
	
	@Override
	public boolean updateParticipant(Participant participant) {
		try {
			Participant ParticipantReturn = participantRepository.save(participant);
			if(ParticipantReturn != null)
				return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}
}
