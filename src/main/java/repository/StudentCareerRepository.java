package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.Career;
import entity.Student;
import entity.StudentCareer;


//debemos hacer un id compuesto pq no podemos pasar los dos a la vez
@Repository
public class StudentCareerRepository extends BaseJPARepository<StudentCareer, Career> {

}
