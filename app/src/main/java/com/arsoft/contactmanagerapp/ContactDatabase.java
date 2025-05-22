package com.arsoft.contactmanagerapp;

import androidx.room.Database;
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

}
