package mk.ukim.finki.wp.lab.repository.jpa;

import mk.ukim.finki.wp.lab.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaTeacherRepository extends JpaRepository<Teacher, Long> {
   // Teacher saveByNameAndSurname (String name, String surname);
    Optional<Teacher> findById (Long id);
}
