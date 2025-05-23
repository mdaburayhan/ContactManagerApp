package com.arsoft.contactmanagerapp;


import java.util.List;

// Repository class that abstracts access to multiple data sources.
// In this case, it manages data operations and provides a clean API for accessing Contact data.
// Acts as a bridge between the ViewModel and the Room database (DAO).
// Helps maintain separation of concerns and makes the app easier to test and maintain.
public class Repository {
    // The Available Data Sources:
    // - ROOM Database

    private final ContactDAO contactDAO;

    public Repository(ContactDAO contactDAO) {
        this.contactDAO = contactDAO;
    }

    // Method in DAO being executed from Repository
    public void addContact(Contacts contacts){
        contactDAO.insert(contacts);
    }
    public void deleteContact(Contacts contacts){
        contactDAO.delete(contacts);
    }

    public List<Contacts> getAllContacts(){
        return contactDAO.getAllContacts();
    }

}
