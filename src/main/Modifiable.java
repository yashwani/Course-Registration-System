package main;

import main.db.DataAccessLayer;

public interface Modifiable {

    public Modifier getDataAccessLayer();

    public String[] listAttributes();

    public String[] modifiableAttributes();

    public String primaryKey();

}
