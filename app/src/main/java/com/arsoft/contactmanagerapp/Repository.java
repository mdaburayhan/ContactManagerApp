package com.arsoft.contactmanagerapp;


import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Repository class that abstracts access to multiple data sources.
// In this case, it manages data operations and provides a clean API for accessing Contact data.
// Acts as a bridge between the ViewModel and the Room database (DAO).
// Helps maintain separation of concerns and makes the app easier to test and maintain.
public class Repository {
    // The Available Data Sources:
    // - ROOM Database

    private final ContactDAO contactDAO;
    ExecutorService executor;
    Handler handler;

    public Repository(Application application) {
        ContactDatabase contactDatabase = ContactDatabase.getInstance(application);
        this.contactDAO = contactDatabase.getContactDAO();

        // Creates a single-threaded executor to run tasks asynchronously on a background thread.
        // This helps prevent blocking the main (UI) thread during database operations.
        executor = Executors.newSingleThreadExecutor();

        // Creates a Handler associated with the main (UI) thread's Looper.
        // Used to post tasks that need to run on the main thread, such as updating the UI.
        handler = new Handler(Looper.getMainLooper());

    }

    // Method in DAO being executed from Repository
    public void addContact(Contacts contacts){

        // Runnable: Executing Task on Separate Thread
        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactDAO.insert(contacts);
            }
        });
    }
    public void deleteContact(Contacts contacts){

        executor.execute(new Runnable() {
            @Override
            public void run() {
                contactDAO.delete(contacts);
            }
        });
    }
    public LiveData<List<Contacts>> getAllContacts(){

        return contactDAO.getAllContacts();
    }



}
