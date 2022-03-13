package main;

import main.CoursesBoundedContext.Course;

public interface Builder {

    public Modifiable build();

    public Builder ID(int id);
}
