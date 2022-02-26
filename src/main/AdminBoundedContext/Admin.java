package main.AdminBoundedContext;

import main.Modifiable;

public class Admin {

    public Admin(){

    }


    public boolean create(Modifiable modifiable){
        return modifiable.createNew();
    }

    public boolean delete(Modifiable modifiable){
        return true;
    }

    public boolean modify(Modifiable modifiable, String[] updateColumn, String[] updateValue){
        return true;
    }




}
