package in.nareshtech.roomdatabase.Databases;

import androidx.room.Database;
import androidx.room.RoomDatabase;

// TODO 3: create an abstract class that extends Room Database
@Database(entities = {Person.class},version = 1)
public abstract class PersonDatabase extends RoomDatabase {
    public abstract PersonDAO personDAO();
}
