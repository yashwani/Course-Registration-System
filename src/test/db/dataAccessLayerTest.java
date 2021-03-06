package test.db;

import main.db.DataAccessLayer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class dataAccessLayerTest {

    @Test
    void executeDeleteQuery1(){
        DataAccessLayer db = new DataAccessLayer();
        String tableName = "students";
        String[] keyName = new String[]{"student_id"};
        String[] keyID = new String[]{"10829"};

        boolean actual = db.executeDeleteQuery(tableName, keyName, keyID);
        assertTrue(actual);
    }


    @Test
    void executeInsertQuery1(){
        DataAccessLayer db = new DataAccessLayer();
        String tableName = "students";
        String[] insertColumn = new String[]{"student_id", "last_name", "first_name", "enroll_date", "isHold"};
        String[] columnValue = new String[]{"10829", "'Umesh'", "'Nikhil'","2020", "0"};

        boolean actual = db.executeInsertQuery(tableName, insertColumn, columnValue);
        assertTrue(actual);
    }

    @Test
    void executeUpdateQuery1(){
        DataAccessLayer db = new DataAccessLayer();
        String tableName = "grades";
        String[] updateColumn = new String[]{"grade"};
        String[] updateValue = new String[]{"'A'"};
        String[] keyName = new String[]{"student_id", "course_id"};
        String[] keyId = new String[]{"10821", "10000"};

        boolean actual = db.executeUpdateQuery(tableName, updateColumn, updateValue, keyName, keyId);
        assertTrue(actual);
    }

    @Test
    void executeUpdateQueryRecordDNE(){
        DataAccessLayer db = new DataAccessLayer();
        String tableName = "grades";
        String[] updateColumn = new String[]{"grade"};
        String[] updateValue = new String[]{"'A'"};
        String[] keyName = new String[]{"student_id", "course_id"};
        String[] keyId = new String[]{"10821", "-1"};

        boolean actual = db.executeUpdateQuery(tableName, updateColumn, updateValue, keyName, keyId);
        assertFalse(actual);
    }


    @Test
    void executeSelectQuery1(){
        DataAccessLayer db = new DataAccessLayer();
        String[] columnsSelected = new String[]{"last_name"};
        String tableName = "students";
        String[] keyName = new String[]{"student_id"};
        String[] keyId = new String[]{"10823"};
        ArrayList<ArrayList<String>> actual = db.executeSelectQuery(columnsSelected, tableName, keyName, keyId);

        System.out.println(actual);

        int arr = actual.size();
        for (int i = 0; i < arr; i++) {
            int edgeCount = actual.get(i).size();
            for (int j = 0; j < edgeCount; j++) {
                System.out.println(actual.get(i).get(j));
            }
        }

    }

    @Test
    void executeSelectQuery2(){
        DataAccessLayer db = new DataAccessLayer();
        String[] columnsSelected = new String[]{"prereq1_id", "prereq2_id", "prereq3_id"};
        String tableName = "courses";
        String[] keyName = new String[]{"course_id"};
        String[] keyId = new String[]{"10003"};
        ArrayList<ArrayList<String>> actual = db.executeSelectQuery(columnsSelected, tableName, keyName, keyId);

        ArrayList<ArrayList<String>> expected = new ArrayList<>();
        ArrayList<String> inner1 = new ArrayList<>();
        inner1.add("10001");
        inner1.add(null);
        inner1.add("10002");
        expected.add(inner1);

        assertEquals(expected, actual);

        int arr = actual.size();
        for (int i = 0; i < arr; i++) {
            int edgeCount = actual.get(i).size();
            for (int j = 0; j < edgeCount; j++) {
                System.out.println(actual.get(i).get(j));
            }
        }

    }

    @Test
    void executeSelectQuery3(){
        DataAccessLayer db = new DataAccessLayer();
        String[] columnsSelected = new String[]{"status"};
        String tableName = "course_permission";
        String[] keyName = new String[]{"course_id", "student_id"};
        String[] keyId = new String[]{"10002", "10823"};
        ArrayList<ArrayList<String>> actual = db.executeSelectQuery(columnsSelected, tableName, keyName, keyId);

        ArrayList<ArrayList<String>> expected = new ArrayList<>();
        ArrayList<String> inner1 = new ArrayList<>();
        inner1.add("DENIED");
        expected.add(inner1);

        assertEquals(expected, actual);

        int arr = actual.size();
        for (int i = 0; i < arr; i++) {
            int edgeCount = actual.get(i).size();
            for (int j = 0; j < edgeCount; j++) {
                System.out.println(actual.get(i).get(j));
            }
        }

    }

    @Test
    void executeSelectEverything(){
        DataAccessLayer db = new DataAccessLayer();
        String[] columnsSelected = new String[]{"course_id"};
        String tableName = "courses";
        String[] keyName = new String[]{"course_id"};
        String[] keyId = new String[]{"course_id"};
        ArrayList<ArrayList<String>> actual = db.executeSelectQuery(columnsSelected, tableName, keyName, keyId);

        System.out.println(actual);




    }





// TESTS BELOW ARE FOR PRIVATE METHOD, MADE PUBLIC TEMPORARILY FOR TESTING

//    @Test
//    void buildDeleteStatement1(){
//        DataAccessLayer db = new DataAccessLayer();
//        String tableName = "students";
//        String[] keyName = new String[]{"last_name", "first_name", "student_id"};
//        String[] keyID = new String[]{"'Vayani'", "'Omar'", "10826"};
//
//        String actual = db.buildDeleteStatement(tableName, keyName, keyID);
//        String expected = "DELETE FROM students WHERE last_name = 'Vayani' AND first_name = 'Omar' AND student_id = 10826";
//
//        System.out.println(actual);
//        System.out.println(expected);
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void buildDeleteStatement2(){
//        DataAccessLayer db = new DataAccessLayer();
//        String tableName = "students";
//        String[] keyName = new String[]{ "student_id"};
//        String[] keyID = new String[]{"10826"};
//
//        String actual = db.buildDeleteStatement(tableName, keyName, keyID);
//        String expected = "DELETE FROM students WHERE student_id = 10826";
//
//        System.out.println(actual);
//        System.out.println(expected);
//
//        assertEquals(expected, actual);
//    }

//    @Test
//    void buildInsertStatement(){
//        DataAccessLayer db = new DataAccessLayer();
//        String tableName = "students";
//        String[] insertColumn = new String[]{"student_id", "last_name", "first_name", "enroll_date", "isHold"};
//        String[] columnValue = new String[]{"10827", "'Vayani'", "'Omar'","2020", "0"};
//
//        String actual = db.buildInsertStatement(tableName, insertColumn, columnValue);
//        String expected = "INSERT INTO students (student_id, last_name, first_name, enroll_date, isHold) VALUES (10827, 'Vayani', 'Omar', 2020, 0)";
//
//        System.out.println(actual);
//        System.out.println(expected);
//
//        assertEquals(expected, actual);
//    }




//    @Test
//    void buildUpdateStatement(){
//        DataAccessLayer db = new DataAccessLayer();
//        String tableName = "grades";
//        String[] updateColumn = new String[]{"grade"};
//        String[] updateValue = new String[]{"'E'"};
//        String[] keyName = new String[]{"student_id", "course_id"};
//        String[] keyId = new String[]{"10821", "10000"};
//        String actual = db.buildUpdateStatement(tableName, updateColumn, updateValue, keyName, keyId);
//        String expected = "UPDATE grades SET grade='E' WHERE student_id = 10821 AND course_id = 10000";
//
//        System.out.println(actual);
//        System.out.println(expected);
//
//        assertEquals(expected, actual);
//    }

//    @Test
//    void selectStatementSelectEverything(){
//        DataAccessLayer db = new DataAccessLayer();
//        String[] columnsSelected = new String[]{"*"};
//        String tableName = "courses";
//        String[] keyName = new String[]{"course_id"};
//        String[] keyId = new String[]{"course_id"};
//        String actual = db.buildSelectStatement(columnsSelected, tableName, keyName, keyId);
//        String expected = "SELECT * FROM courses WHERE course_id = course_id";
//
//        System.out.println(actual);
//        System.out.println(expected);
//
//        assertEquals(expected, actual);
//    }


//    @Test
//    void selectStatementBuilder(){
//        xDataAccessLayer db = new xDataAccessLayer();
//        String[] columnsSelected = new String[]{"last_name"};
//        String tableName = "students";
//        String[] keyName = new String[]{"student_id"};
//        String[] keyId = new String[]{"10823"};
//        String actual = db.buildSelectStatement(columnsSelected, tableName, keyName, keyId);
//        String expected = "SELECT last_name FROM students WHERE student_id = 10823";
//
//        System.out.println(actual);
//        System.out.println(expected);
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void selectStatementBuilder2(){
//        xDataAccessLayer db = new xDataAccessLayer();
//        String[] columnsSelected = new String[]{"last_name"};
//        String tableName = "students";
//        String[] keyName = new String[]{"first_name"};
//        String[] keyId = new String[]{"'Carlton'"};
//        String actual = db.buildSelectStatement(columnsSelected, tableName, keyName, keyId);
//        String expected = "SELECT last_name FROM students WHERE first_name = 'Carlton'";
//
//        System.out.println(actual);
//        System.out.println(expected);
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void selectStatementBuilder3(){
//        xDataAccessLayer db = new xDataAccessLayer();
//        String[] columnsSelected = new String[]{"prereq1_id", "prereq2_id", "prereq3_id"};
//        String tableName = "courses";
//        String[] keyName = new String[]{"course_id"};
//        String[] keyId = new String[]{"10003"};
//        String actual = db.buildSelectStatement(columnsSelected, tableName, keyName, keyId);
//        String expected = "SELECT prereq1_id, prereq2_id, prereq3_id FROM courses WHERE course_id = 10003";
//
//        System.out.println(actual);
//        System.out.println(expected);
//
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void selectStatementBuilder4(){
//        xDataAccessLayer db = new xDataAccessLayer();
//        String[] columnsSelected = new String[]{"status"};
//        String tableName = "course_permission";
//        String[] keyName = new String[]{"course_id","student_id"};
//        String[] keyId = new String[]{"10002","10823"};
//        String actual = db.buildSelectStatement(columnsSelected, tableName, keyName, keyId);
//        String expected = "SELECT status FROM course_permission WHERE course_id = 10002 AND student_id = 10823";
//
//        System.out.println(actual);
//        System.out.println(expected);
//
//        assertEquals(expected, actual);
//    }


}