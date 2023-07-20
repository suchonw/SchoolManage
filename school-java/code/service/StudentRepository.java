package service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface StudentRepository extends CrudRepository<Student_info, Integer> { 
    Iterable findByGrade(Integer grade);    
}
