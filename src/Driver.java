import java.sql.*;

public class Driver {
    public static void main(String[] args) throws SQLException {

//        StudentDataAccessLayer studentdb = new StudentDataAccessLayer(10821);
//        System.out.println(studentdb.getLastName());

//        Student x = new Student(10824);
//        System.out.println(x.getFirstName());
//        x.addCourse(10000);

        AddCourseHandler chain = new HoldHandler();
        System.out.println(chain.check(10823, 10000));


    }
}
