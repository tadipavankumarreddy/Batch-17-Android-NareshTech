package in.nareshtech.roomdatabase.Databases;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

// TODO 2: Create a dao interface where you define what queries can be run.
@Dao
public interface PersonDAO {

    @Insert
    void insertValues(Person p);

    @Query("select * from person")
    List<Person> getAllData();
}
