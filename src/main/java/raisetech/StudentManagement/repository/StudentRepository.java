package raisetech.StudentManagement.repository;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import raisetech.StudentManagement.data.Student;
import raisetech.StudentManagement.data.StudentsCourses;

@Mapper
public interface StudentRepository {

  @Select("SELECT * FROM students")
  List<Student> searchStudents();

  @Select("SELECT * FROM students WHERE id = #{id}")
  Student searchStudent(String id);

  @Select("SELECT * FROM students_courses")
  List<StudentsCourses> searchStudentsCoursesList();

  @Select("SELECT * FROM students_courses WHERE students_id = #{studentId}")
  List<StudentsCourses> searchStudentsCourses(String studentId);

  @Insert(
      "INSERT INTO students(name, furigana, nickname, email, region, age, gender, remarks, is_deleted) "
      + "VALUES(#{name}, #{furigana}, #{nickname}, #{email}, #{region}, #{age}, #{gender}, #{remarks}, false)")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void registerStudent(Student student);

  @Insert("INSERT INTO students_courses(students_id, course, classopen, classcomp)"
      + "VALUES(#{studentId}, #{course}, #{classopen}, #{classcomp})")
  @Options(useGeneratedKeys = true, keyProperty = "id")
  void registerStudentsCourses(StudentsCourses studentsCourses);

  @Update("UPDATE students SET name = #{name}, furigana = #{furigana}, nickname = #{nickname}, "
          + "email = #{email}, region = #{region}, age = #{age}, gender = #{gender}, remarks = #{remarks}, is_deleted = #{isDeleted} WHERE id = #{id}")
  void updateStudent(Student student);

  @Update("UPDATE students_courses SET course = #{course} WHERE id = #{id}")
  void updateStudentsCourses(StudentsCourses studentsCourses);
}
