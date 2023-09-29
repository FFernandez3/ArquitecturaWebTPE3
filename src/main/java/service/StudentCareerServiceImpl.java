package service;

import java.util.List;

import org.springframework.stereotype.Service;

import domain.Student;
import domain.StudentCareer;
import dto.CareerReportDTO;
import dto.EnrolledDTO;
import lombok.RequiredArgsConstructor;
import repository.StudentCareerRepository;
import serviceInterface.StudentCareerService;

@Service
@RequiredArgsConstructor
public class StudentCareerServiceImpl /* implements StudentCareerService */ {

	private StudentCareerRepository studentCareerRepository;

	// save
	public StudentCareer save(StudentCareer entity) throws Exception {
		try {
			return this.studentCareerRepository.save(entity);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public List<EnrolledDTO> getCareersOrderByQuantity() {
		return this.studentCareerRepository.getCareersOrderByQuantity().stream().map(
				enrolled -> new EnrolledDTO(enrolled.getCareerId(), enrolled.getCareerName(), enrolled.getQuantity()))
				.toList();
	}

	public List<CareerReportDTO> getReport() {
		return this.studentCareerRepository.getReport().stream()
				.map(report -> new CareerReportDTO(report.getCareerName(), report.getYears(), report.getRegistered(),
						report.getGraduates()))
				.toList();
	}
}
