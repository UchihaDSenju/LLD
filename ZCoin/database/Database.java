package database;

public class Database {
    private static Database databaseInstance = null;

    private Database(){}

    public static Database getDatabaseInstance(){
        if(databaseInstance == null){
            databaseInstance = new Database();
        }
        return databaseInstance;
    }
}
