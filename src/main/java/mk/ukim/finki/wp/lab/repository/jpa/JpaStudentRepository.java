package mk.ukim.finki.wp.lab.repository.jpa;

import mk.ukim.finki.wp.lab.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaStudentRepository extends JpaRepository<Student, String> {
    // List<Student> findAllByNameAndSurnameLike(String text);
     List<Student> findAllByNameLike(String text);
     Student findByUsername(String name);
}
