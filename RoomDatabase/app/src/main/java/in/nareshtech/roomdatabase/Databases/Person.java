package in.nareshtech.roomdatabase.Databases;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
// TODO 1: Create a class (Table) with fields (Coloumns) - These are called entities.
//  you can create as many tables as you want to.
@Entity(tableName = "person")
public class Person {
    @PrimaryKey(autoGenerate = true)
    int person_id;
    String person_name;
    int person_age;

    public Person() {

    }

    public Person(String person_name, int person_age) {
        this.person_name = person_name;
        this.person_age = person_age;
    }

    public int getPerson_id() {
        return person_id;
    }

    public String getPerson_name() {
        return person_name;
    }

    public int getPerson_age() {
        return person_age;
    }
}
