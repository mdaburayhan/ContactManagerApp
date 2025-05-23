package com.arsoft.contactmanagerapp;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

// This annotation marks the interface or abstract class as a Data Access Object (DAO)
// DAOs are responsible for defining methods to access the database, like insert, update, delete, and query
@Dao
public interface ContactDAO {

    // This annotation is used to define a method that inserts data into the table
    // Room will automatically generate the necessary SQLite code for this insert operation
    @Insert
    void insert(Contacts contact);

    // This annotation is used to define a method that deletes a specific row from the table
    // Room generates the necessary SQL code to delete the exact object passed to this method
    @Delete
    void delete(Contacts contacts);

    // This annotation lets you write custom SQL queries for data operations like SELECT, UPDATE, DELETE, etc.
    // You write the raw SQL inside the parentheses, and Room generates the corresponding method implementation
    @Query("SELECT * FROM contacts_table")
    LiveData<List<Contacts>> getAllContacts();

}
