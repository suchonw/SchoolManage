package service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class StudentController {
    @Autowired StudentRepository studentRepository;
    
    @RequestMapping("/api/list-all")
    Iterable showAll() {
	return studentRepository.findAll();
    }            
    
    @RequestMapping("/api/list-by-id")
    Optional showById(int id) {
	return studentRepository.findById(id);
    } 
    
        
    @RequestMapping("/api/list-by-grade")
    Iterable showByGrade(int grade) { 
        return studentRepository.findByGrade(grade);
    }
                     
    @RequestMapping("/api/add")
    String addStudent(String name,int grade) {        
        Student_info newly = new Student_info();
        newly.name = name;
        newly.grade = grade;
        studentRepository.save(newly);
        return "Success";
    }
    
    @RequestMapping("/api/edit")
    String editStudent(int id,String name){
        Student_info s = studentRepository.findById(id).get(); 
        s.setName(name);
        studentRepository.save(s);
        return "Success";     
    }
    
    @RequestMapping("/api/delete")
    String deleteStudent(int id) {
        studentRepository.deleteById(id);
        return "Success"; 
    }
}
