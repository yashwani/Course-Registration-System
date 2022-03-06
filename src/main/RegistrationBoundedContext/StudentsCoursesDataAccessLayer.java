package main.RegistrationBoundedContext;

import main.CoursesBoundedContext.Course;
import main.StudentBoundedContext.Student;
import main.db.DataAccessLayer;

import java.util.ArrayList;

public class StudentsCoursesDataAccessLayer extends DataAccessLayer {

    private String tableName = "courses_students";

    public StudentsCoursesDataAccessLayer(){
        super();
    }

    public boolean studentInCourse(int studentID, int courseID){
        String[] columnsSelected = new String[]{"student_status"};
        String[] keyName = new String[]{"course_id", "student_id"};
        String[] keyID = new String[]{String.valueOf(courseID), String.valueOf(studentID)};

        ArrayList<ArrayList<String>> result = super.executeSelectQuery(columnsSelected,tableName,keyName,keyID);

        if (result.isEmpty()){
            return false;
        } else{
            return true;
        }
    }

    public boolean addStudentToCourse(Student student, Course course){
        String[] insertColumn = new String[]{"course_id", "student_id","student_status"};
        String[] columnValue = new String[]{String.valueOf(course.getID()), String.valueOf(student.getID()), "'Enrolled'"};
        return super.executeInsertQuery(tableName,insertColumn,columnValue);
    }

    public boolean deleteStudentFromCourse(Student student, Course course){
        String[] keyNames = new String[]{"student_id", "course_id"};
        String[] keyValues = new String[]{String.valueOf(student.getID()), String.valueOf(course.getID())};
        return super.executeDeleteQuery(tableName, keyNames, keyValues);
    }

    public ArrayList<ArrayList<String>> getCoursesForStudent(Student student){
        String[] columnsSelected = new String[]{"course_id"};
        String[] keyName = new String[]{"student_id", "student_status"};
        String[] keyID = new String[]{String.valueOf(student.getID()), "'Enrolled'"};

        ArrayList<ArrayList<String>> result = super.executeSelectQuery(columnsSelected,tableName,keyName,keyID);
        return result;
    }



}
