package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Student;
import dto.StudentDTO;

@Repository 
public interface StudentRepository extends JpaRepository<Student, Long> {
@Query("SELECT s.dni, s.name, s.surname, s.genre, s.age, s.studentId, s.city FROM Student s ORDER BY s.dni DESC")	
List<StudentDTO> getAllOrderByDni();

// metodos getallstudentbygenre y por id se pueden hacer por el metodo findBy(criterio)
}
