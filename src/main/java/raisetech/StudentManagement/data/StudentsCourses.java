package raisetech.StudentManagement.data;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentsCourses {
  private String id;
  private String studentId;
  private String course;
  private LocalDateTime classopen;
  private LocalDateTime classcomp;
}