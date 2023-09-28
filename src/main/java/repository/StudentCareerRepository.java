package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import domain.Career;
import domain.Student;
import domain.StudentCareer;


//debemos hacer un id compuesto pq no podemos pasar los dos a la vez
@Repository
public interface StudentCareerRepository extends JpaRepository<StudentCareer, Career> {

	
}
