package main.AuthenticationBoundedContext;

import main.db.DataAccessLayer;

import java.util.ArrayList;

public class PasswordsDataAccessLayer extends DataAccessLayer {

    public String getPassword(int id){
        ArrayList<ArrayList<String>> result = super.executeSelectQuery(new String[]{"password"},"Passwords",new String[]{"id"}, new String[]{String.valueOf(id)});
        return result.get(0).get(0);
    }

    public String getPosition(int id){
        ArrayList<ArrayList<String>> result = super.executeSelectQuery(new String[]{"position"},"Passwords",new String[]{"id"}, new String[]{String.valueOf(id)});
        return result.get(0).get(0);
    }


}
