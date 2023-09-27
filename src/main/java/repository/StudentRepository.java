package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.Student;

@Repository /*esta anotacion se usa en las clases concretas q implementan la interface repo*/
public class StudentRepository extends BaseJPARepository<Student, Long> {

}
