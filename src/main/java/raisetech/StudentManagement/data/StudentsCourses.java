package raisetech.StudentManagement.data;

import java.sql.Timestamp;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentsCourses {
  private String id;
  private String studentId;
  private String course;
  private Timestamp classopen;
  private Timestamp classcomp;
}