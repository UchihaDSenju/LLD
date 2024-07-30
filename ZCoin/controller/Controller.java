package controller;

import database.Database;

public class Controller {
    private static Controller controllerInstance = null;
    private Database db = Database.getDatabaseInstance();

    private Controller(){}

    public static Controller getControllerInstance(){
        if(controllerInstance == null){
            controllerInstance = new Controller();
        }

        return controllerInstance;
    }
}
