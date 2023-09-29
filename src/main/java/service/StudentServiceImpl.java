package service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import dto.StudentDTO;
import domain.Student;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import repository.StudentRepository;
import serviceInterface.StudentService;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl /*implements StudentService*/{
	
	private StudentRepository studentRepository;
	
	//save 
	public Student save(Student entity) throws Exception{
		try {
			return this.studentRepository.save(entity);
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}		
	}
	
	 @Transactional
	public List<StudentDTO>findAll(Long dni){
		return this.studentRepository.findAll(dni).stream().map(student->new StudentDTO(student.getDni(), student.getName(), student.getSurname(), student.getGenre(), student.getAge(), student.getStudentId(), student.getCity())).toList();
		
	}
	@Transactional
	public List<StudentDTO> findByGenre(char genre){
		return this.studentRepository.findBy(genre).stream().map(student->new StudentDTO(student.getDni(), student.getName(), student.getSurname(), student.getGenre(), student.getAge(), student.getStudentId(), student.getCity())).toList();
		
	}
	 @Transactional
	 public StudentDTO findByStudentId(Long studentId) {
		 try {
			 StudentDTO student = this.studentRepository.findBy(studentId);
		     if (student != null) {
		         return new StudentDTO(student.getDni(), student.getName(), student.getSurname(), student.getGenre(), student.getAge(), student.getStudentId(), student.getCity());
		     } else {
		         // Manejar el caso en el que no se encuentre ningún estudiante con el género dado
		         return null; // O lanzar una excepción adecuada según tu lógica de negocio
		     }
			 
		 }
		 catch(Exception e) {
			 System.out.println(e);
		 }
		return null;
	     
	 }
	 @Transactional
	 public Optional<StudentDTO> findByStudentId2(Long studentId) {
	     try {
	         return this.studentRepository.findById(studentId)
	             .map(student -> new StudentDTO(student.getDni(), student.getName(), student.getSurname(), student.getGenre(), student.getAge(), student.getStudentId(), student.getCity()));
	     } catch(Exception e) {
	         System.out.println(e);
	         return Optional.empty();
	     }
	 }
	/* @Transactional
	public StudentDTO findBy(Long studentId) {
		 try {
			 Optional<StudentDTO> student=Optional.of(this.studentRepository.findBy(studentId));
			 
			 return ;
		 }
		 catch(Exception e) {
			 System.out.println(e);
		 }
		 
		
	}*/
	/*public StudentDTO findBysid(Long studentId) {
		return this.studentRepository.findBy(studentId).map(student->new StudentDTO(student.getDni(), student.getName(), student.getSurname(), student.getGenre(), student.getAge(), student.getStudentId(), student.getCity()));
	}*/
	

}
