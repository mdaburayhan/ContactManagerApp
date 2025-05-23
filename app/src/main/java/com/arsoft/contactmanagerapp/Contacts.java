package com.arsoft.contactmanagerapp;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


// @Entity(tableName =  "contacts_table")
// This annotation marks the class as a Room Entity (i.e., a table in the database)
// If tableName is not specified, Room will use the class name ("Contacts") as the table name by default
@Entity(tableName =  "contacts_table")
public class Contacts {

    // @ColumnInfo(name = "contact_id")
    // This annotation is used to define custom column settings in the table
    // If not specified, the field name will be used as the column name by default
    // You can use it to rename the column or set extra options like defaultValue, collate, etc.

    // @PrimaryKey(autoGenerate = true)
    // Marks this field as the primary key of the table
    // autoGenerate = true means Room will automatically assign and increment the ID value for each new row
    @ColumnInfo(name = "contact_id")
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "contact_name")
    private String name;

    @ColumnInfo(name = "contact_email")
    private String email;


    public Contacts(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Contacts() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
