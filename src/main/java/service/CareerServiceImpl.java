package service;

import java.util.List;

import org.springframework.stereotype.Service;

import domain.Career;
import dto.EnrolledDTO;
import lombok.RequiredArgsConstructor;
import repository.CareerRepository;
import serviceInterface.CareerService;

@Service
@RequiredArgsConstructor
public class CareerServiceImpl /*implements CareerService*/{
	//private repositorio
	private CareerRepository careerRepository;
	
	//poner el save
	public void save (Career c) {
		
	}
	
	public List<EnrolledDTO> getStudentsByCarrerAndCity(String careerName, String city){
		//para este map uso el primer constructor
		return this.careerRepository.getStudentsByCarrerAndCity(careerName, city).stream().map(enrolled -> new EnrolledDTO(enrolled.getCareerId(), enrolled.getCareerName(), enrolled.getStudentName(), enrolled.getCity())).toList();
	}
}
