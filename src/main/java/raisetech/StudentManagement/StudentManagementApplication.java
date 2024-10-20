package raisetech.StudentManagement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class StudentManagementApplication {

	@Autowired
	private StudentRepository studentRepository;
	private StudentRepository studentsCoursesRepository;

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}

	@GetMapping("/studentList")
	public List<Student> getStudentList(){
		return studentRepository.searchStudents();
	}

	@GetMapping("/studentsCoursesList")
	public List<StudentsCourses> getStudentsCoursesList(){
		return studentRepository.searchStudentsCourses();
	}
}
