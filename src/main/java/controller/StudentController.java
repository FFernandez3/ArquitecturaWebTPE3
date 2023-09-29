package controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import domain.Student;
import dto.StudentDTO;
import lombok.RequiredArgsConstructor;
import service.StudentServiceImpl;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/students")
public class StudentController {
	private StudentServiceImpl studentService;
	
	@GetMapping("/dni") //esto esta bien ?
	public List<StudentDTO>findAll(Long dni){
		return this.studentService.findAll(dni);
	}
	
	@GetMapping("/{genre}")
	public List<StudentDTO> findByGenre(char genre){
		return this.studentService.findByGenre(genre);
	}
	@GetMapping("/{studentId}")
	public StudentDTO findByStudentId(Long studentId) {
		return this.studentService.findByStudentId(studentId);
	}
	@PostMapping("")
	public Student save(Student entity) throws Exception{
		return this.studentService.save(entity);
	}
	
	
	

}
