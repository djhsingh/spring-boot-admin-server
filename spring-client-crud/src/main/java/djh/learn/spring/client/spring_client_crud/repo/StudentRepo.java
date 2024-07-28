package djh.learn.spring.client.spring_client_crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import djh.learn.spring.client.spring_client_crud.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long>{

    
} 
