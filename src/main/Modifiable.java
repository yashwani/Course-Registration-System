package main;

import main.db.DataAccessLayer;

public interface Modifiable {

    public Modifier getDataAccessLayer();

    public String[] listAttributes();

}
