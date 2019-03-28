package nl.group3.techlab.database;


import nl.group3.techlab.models.User;


public class Filldatabase {

    public static void FillDatabaseWithTestData(DatabaseHelper DB) {
        User user = new User(1, "John", "Doe");
        DB.InsertUser(user);
    }
}
