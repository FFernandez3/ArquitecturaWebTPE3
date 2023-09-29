package controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import domain.Career;
import domain.Student;
import dto.EnrolledDTO;
import lombok.RequiredArgsConstructor;
import service.CareerServiceImpl;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/careers")
public class CareerController {
	private CareerServiceImpl careerService;
	
	@GetMapping("/{careerName}&&{city}") //esto esta bien?
	public List<EnrolledDTO> getStudentsByCarrerAndCity(String careerName, String city){
		return this.careerService.getStudentsByCarrerAndCity(careerName, city);
	}
	
	@PostMapping("")
	public Career save(Career entity) throws Exception{
		return this.careerService.save(entity);
	}

}
