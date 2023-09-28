package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Career;
import dto.EnrolledDTO;

import org.springframework.data.jpa.repository.Query;

@Repository // aca poner las querys con metodos
public interface CareerRepository extends JpaRepository<Career, Integer> {
@Query("SELECT c.id, c.name, s.name, s.city FROM Student s JOIN StudentCareer sc ON s.dni = "
		+ "sc.student JOIN Career c ON sc.career = c.id WHERE c.name = :careerName AND s.city = :city")
List<EnrolledDTO> getStudentsByCarrerAndCity(String careerName, String city);

}
