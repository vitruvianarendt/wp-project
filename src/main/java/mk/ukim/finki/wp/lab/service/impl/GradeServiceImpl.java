package mk.ukim.finki.wp.lab.service.impl;

import mk.ukim.finki.wp.lab.model.Course;
import mk.ukim.finki.wp.lab.model.Grade;
import mk.ukim.finki.wp.lab.model.Student;
import mk.ukim.finki.wp.lab.repository.jpa.JpaGradeRepository;
import mk.ukim.finki.wp.lab.service.GradeService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GradeServiceImpl implements GradeService {

    public final JpaGradeRepository gradeRepository;

    public GradeServiceImpl(JpaGradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    @Override
    public Grade saveGrade(Character grade, Student student, Course course,  LocalDateTime time) {
        Grade g = new Grade(grade, student, course, time);
        return gradeRepository.save(g);
    }
}
