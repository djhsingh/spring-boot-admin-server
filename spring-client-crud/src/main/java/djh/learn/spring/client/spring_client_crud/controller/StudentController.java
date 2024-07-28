package djh.learn.spring.client.spring_client_crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import djh.learn.spring.client.spring_client_crud.entity.Student;
import djh.learn.spring.client.spring_client_crud.repo.StudentRepo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/students")
public class StudentController {
    
    @Autowired
    private StudentRepo studentRepo;

    @GetMapping("/")
    public List<Student> findAll(){
        return studentRepo.findAll();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable("id") Long id){
        return studentRepo.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id){
         studentRepo.deleteById(id);
    }

    @PostMapping("/")
    public Student create(@RequestBody Student student){
        return studentRepo.save(student);
    }

    @PutMapping("path/{id}")
    public Student update(@PathVariable("id") Long id, @RequestBody Student student) {
        Student oldStudent = studentRepo.findById(id).get();
        oldStudent.setName(student.getName());
        oldStudent.setAge(student.getAge());
        return studentRepo.save(oldStudent);
    }
}
