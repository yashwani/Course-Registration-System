package main.AdminBoundedContext;

import main.Modifiable;
import main.Modifier;

public class Admin {

    public Admin(){
    }

    public boolean create(Modifiable modifiable){
        Modifier modifier = modifiable.getDataAccessLayer();
        return modifier.createNew(modifiable);
    }

    public boolean delete(Modifiable modifiable){
        Modifier modifier = modifiable.getDataAccessLayer();
        return modifier.delete(modifiable);
    }

    public boolean modify(Modifiable modifiable, String[] updateColumn, String[] updateValue){
        Modifier modifier = modifiable.getDataAccessLayer();
        return modifier.update(modifiable, updateColumn, updateValue);
    }


}
