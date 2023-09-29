package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Student;
import dto.StudentDTO;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	//estos metodos son necesarios en el repo? o directo en el service?
	@Query("SELECT s.dni, s.name, s.surname, s.genre, s.age, s.studentId, s.city FROM Student s ORDER BY s.dni DESC")
	//List<StudentDTO> getAllOrderByDni();
	List<StudentDTO>findAll(Long dni);

// metodos getallstudentbygenre y por id se pueden hacer por el metodo findBy(criterio)
	@Query("SELECT s.dni, s.name, s.surname, s.genre, s.age, s.studentId, s.city FROM Student s"
			+ " WHERE s.genre lIKE :genre")
	List<StudentDTO> findBy(char genre);
	
@Query("SELECT s.dni, s.name, s.surname, s.genre, s.age, s.studentId, s.city "
			+ "FROM Student s WHERE s.studentId = :studentId")
	StudentDTO findBy(Long studentId);
 //el insert (save) lo vamos a pedir directo en el service al JPARepository
}
