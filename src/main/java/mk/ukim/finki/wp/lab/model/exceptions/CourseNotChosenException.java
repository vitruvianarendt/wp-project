package mk.ukim.finki.wp.lab.model.exceptions;

public class CourseNotChosenException extends RuntimeException {

    public CourseNotChosenException() {
        super("You have not chosen a course yet!");
    }
}
