public abstract class AddCourseHandler {
    /**
     * abstract class that individual handlers extend when adding a course
     */


    private AddCourseHandler next;

    public AddCourseHandler nextHandler;

    public abstract boolean check(int student_id, int course_id);

    protected boolean checkNext(int student_id, int course_id){
        if (next == null){
            return true;
        } else {
            return next.check(student_id, course_id);
        }
    }



}
