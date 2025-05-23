package com.arsoft.contactmanagerapp;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

// The @Database annotation marks this class as a Room database.
// - 'entities' specifies the list of entity classes (tables) included in the database.
//   You can add multiple entities by separating them with commas inside the curly braces, e.g.:
//   entities = {Contacts.class, Users.class, Messages.class}
// - 'version' specifies the database version, used for migrations when the schema changes.

// This class must be declared 'abstract' because Room generates the actual implementation
// at compile time. You provide abstract methods to access your DAOs, and Room creates
// the concrete class behind the scenes.
@Database(entities = {Contacts.class}, version = 1)
public abstract class ContactDatabase extends RoomDatabase {

    // Connecting the database to the ContactDAO using this getContactDAO()
    public abstract ContactDAO getContactDAO();

    /// Holds a "single instance" of the ContactDatabase to implement the Singleton pattern.
    /// This ensures only one database instance exists throughout the app lifecycle.
    private static ContactDatabase dbInstance;


    // Returns the single instance of ContactDatabase.
    // - Uses the Singleton pattern to avoid multiple instances.
    // - 'synchronized' ensures thread safety: only one thread can access this method at a time.
    // - This prevents race conditions when multiple threads try to create the database at once.
    public static synchronized ContactDatabase getInstance(Context context){

        if (dbInstance == null){
            dbInstance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    ContactDatabase.class,
                    "contacts_db"
            ).fallbackToDestructiveMigration()
                    .build();
        }
        return dbInstance;
    }

}
