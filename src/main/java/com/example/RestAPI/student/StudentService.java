package com.example.RestAPI.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Response addNewStudent(Student student) {
        Optional<Student> studentOptional= studentRepository
                .findStudentByEmail(student.getEmail());
        if(studentOptional.isPresent()){
            throw new IllegalMonitorStateException("email already registered");
        }
        studentRepository.save(student);
        return new Response(student.getName());
    }

    public void deleteStudent(Long id) {
       boolean exists = studentRepository.existsById(id);
       if(!exists){
           throw new IllegalStateException(
                   "Student with id "+id+" does not exists"
           );
       }
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student=studentRepository.findById(studentId)
                .orElseThrow(()->new IllegalStateException(
                        "Student with id "+studentId+"does not exist"));
    if (name!=null && name.length()>0 && !Objects.equals(student.getName(),name)){
        student.setName(name);
    }
    if(email!=null && email.length()>0 && !Objects.equals(student.getEmail(),email)){
         Optional<Student> studentOptional=studentRepository.findStudentByEmail(email);
         if(studentOptional.isPresent()){
             throw new IllegalStateException("Email already exist");
         }
         student.setEmail(email);
    }
    }
}
