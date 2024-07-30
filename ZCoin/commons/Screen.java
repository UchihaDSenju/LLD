package commons;


import java.util.*;
import controller.Controller;

public abstract class Screen{
    protected Scanner scanner;
    protected Controller controller = Controller.getControllerInstance();
    public Screen(Scanner scanner){
        this.scanner = scanner;
    }

    protected void nextScreen(Screen screen){
        screen.runScreen();
    }

    public abstract void runScreen();

    public static void startScreen(Screen screen){
        screen.runScreen();
    }// This is the starting of all screen
}