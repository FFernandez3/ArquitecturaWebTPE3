package controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import domain.Career;
import domain.StudentCareer;
import dto.CareerReportDTO;
import dto.EnrolledDTO;
import lombok.RequiredArgsConstructor;
import service.CareerServiceImpl;
import service.StudentCareerServiceImpl;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/enrolled")
public class StudentCareerController {
	private StudentCareerServiceImpl studentCareerService;
	
	@GetMapping("/orderBy/quantity") //esto esta bien?
	public List<EnrolledDTO> getCareersOrderByQuantity() {
		return this.studentCareerService.getCareersOrderByQuantity();
		
	}
	@GetMapping("/report")
	public List<CareerReportDTO> getReport() {
		return this.studentCareerService.getReport();
	}
	@PostMapping("")
	public StudentCareer save(StudentCareer entity) throws Exception{
		return this.studentCareerService.save(entity);
	}

}
