package main;

import main.StudentBoundedContext.Student;

public interface Modifier {

    public boolean createNew(Modifiable m);

    public boolean delete(Modifiable m);

    public boolean update(Modifiable m, String[] updateColumn, String[] updateValue);
}
