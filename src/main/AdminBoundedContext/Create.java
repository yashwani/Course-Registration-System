package main.AdminBoundedContext;

import main.Modifiable;
import main.Modifier;
import main.db.DataAccessLayer;

public class Create {
    Modifiable modifiable;

    public Create(Modifiable m){
        modifiable = m;
    }

    public void execute(){
        Modifier modifier = modifiable.getDataAccessLayer();
        modifier.createNew(modifiable);

    }


}
