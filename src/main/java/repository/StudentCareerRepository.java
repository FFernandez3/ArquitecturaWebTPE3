package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Career;
import domain.Student;
import domain.StudentCareer;
import dto.CareerReportDTO;
import dto.EnrolledDTO;


//debemos hacer un id compuesto pq no podemos pasar los dos a la vez
@Repository
public interface StudentCareerRepository extends JpaRepository<StudentCareer, Career> {
	//el insert (save) lo vamos a pedir directo en el service al JPARepository
	
	@Query("SELECT c.id, c.name, COUNT(c.id) "
			+ "AS quantity FROM Career c "
			+ "JOIN StudentCareer sc ON c.id = sc.career"
			+ "  GROUP BY c.name ORDER BY quantity")
	List<EnrolledDTO>getCareersOrderByQuantity();
	
	@Query("SELECT \r\n" + "    c.career_name AS nombre_carrera,\r\n"
			+ "    years.anio AS anio,\r\n"
			+ "    COALESCE(inscriptos.count, 0) AS inscriptos,\r\n"
			+ "    COALESCE(egresados.count, 0) AS egresados\r\n" 
			+ "FROM\r\n" + "    career c\r\n"
			+ "CROSS JOIN (\r\n" 
			+ "    SELECT DISTINCT entryYear AS anio FROM studentcareer\r\n"
			+ "    UNION\r\n"
			+ "    SELECT DISTINCT graduationYear AS anio FROM studentcareer WHERE graduationYear IS NOT NULL\r\n"
			+ ") years\r\n"
			+ "LEFT JOIN (\r\n" 
			+ "    SELECT\r\n" + "        sc.career,\r\n"
			+ "        sc.entryYear AS anio,\r\n" + "        COUNT(DISTINCT s.dni) AS count\r\n" + "    FROM\r\n"
			+ "        studentcareer sc\r\n" 
			+ "    JOIN\r\n" + "        student s ON sc.student = s.dni\r\n"
			+ "    GROUP BY\r\n" + "        sc.career, sc.entryYear\r\n"
			+ ") inscriptos ON c.id = inscriptos.career AND years.anio = inscriptos.anio\r\n"
			+ "LEFT JOIN (\r\n"
			+ "    SELECT\r\n" + "        sc.career,\r\n" + "        sc.graduationYear AS anio,\r\n"
			+ "        COUNT(DISTINCT s.dni) AS count\r\n" + "    FROM\r\n" + "        studentcareer sc\r\n"
			+ "    JOIN\r\n" + "        student s ON sc.student = s.dni\r\n" 
			+ "    WHERE\r\n"
			+ "        sc.graduationYear IS NOT NULL\r\n" + "    GROUP BY\r\n"
			+ "        sc.career, sc.graduationYear\r\n"
			+ ") egresados ON c.id = egresados.career AND years.anio = egresados.anio\r\n"
			+ "ORDER BY\r\n"
			+ "    c.career_name, years.anio"
			)
	List<CareerReportDTO>getReport();
	
}
