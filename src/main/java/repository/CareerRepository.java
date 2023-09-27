package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.Career;

@Repository
public class CareerRepository extends BaseJPARepository<Career, Integer> {

}
