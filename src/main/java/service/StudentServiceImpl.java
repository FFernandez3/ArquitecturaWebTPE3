package service;

import java.util.List;

import org.springframework.stereotype.Service;

import dto.StudentDTO;
import repository.StudentRepository;
import serviceInterface.StudentService;

@Service
public class StudentServiceImpl /*implements StudentService*/{
	//private repositorio
	private StudentRepository studentRepository;
	
	//save 
	
	public List<StudentDTO>findAll(Long dni){
		return this.studentRepository.findAll(dni).stream().map(student->new StudentDTO(student.getDni(), student.getName(), student.getSurname(), student.getGenre(), student.getAge(), student.getStudentId(), student.getCity())).toList();
		
	}
	
	public List<StudentDTO> findBy(char genre){
		return this.studentRepository.findBy(genre).stream().map(student->new StudentDTO(student.getDni(), student.getName(), student.getSurname(), student.getGenre(), student.getAge(), student.getStudentId(), student.getCity())).toList();
		
	}
	public StudentDTO findBy(Long studentId) {
		return this.studentRepository.findBy(studentId).map(student->new StudentDTO(student.getDni(), student.getName(), student.getSurname(), student.getGenre(), student.getAge(), student.getStudentId(), student.getCity()));
	}
	

}
