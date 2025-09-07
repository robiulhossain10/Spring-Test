package com.abc.SpringCrud.Repository;

import com.abc.SpringCrud.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
