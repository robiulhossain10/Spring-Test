package com.abc.SpringCrud.Service;

import com.abc.SpringCrud.Entity.Student;
import com.abc.SpringCrud.Repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAll() {
        return repository.findAll();
    }

    public Student getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Student save(Student student) {
        return repository.save(student);
    }

    public Student update(Long id, Student student) {
        Student existing = getById(id);
        existing.setName(student.getName());
        existing.setEmail(student.getEmail());
        existing.setPhone(student.getPhone());
        return repository.save(existing);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
