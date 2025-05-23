package com.arsoft.contactmanagerapp;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.arsoft.contactmanagerapp.databinding.ActivityMainBinding;
import com.arsoft.contactmanagerapp.databinding.ContactListItemBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Data Source
    private ContactDatabase contactDatabase;
    private ArrayList<Contacts> contactsArrayList = new ArrayList<>();

    // Adapter
    private MyAdapter myAdapter;

    // Binding
    private ActivityMainBinding mainBinding;
    private MainActivityClickHandlers handlers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        handlers = new MainActivityClickHandlers(this);

        mainBinding.setClickHandler(handlers);

        // RecyclerView
        RecyclerView recyclerView = mainBinding.recyclerview;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


        // Database:
        contactDatabase = ContactDatabase.getInstance(this);

        // ViewModel
        MyViewModel viewModel = new ViewModelProvider(this)
                .get(MyViewModel.class);

        // Inserting a new Contact (Just for Testing):
        //Contacts contacts1 = new Contacts("Jack", "Jack@gmail.com");
        //viewModel.addNewContact(contacts1);

        // Loading the Data from ROOM DB
        viewModel.getAllContacts().observe(this,
                new Observer<List<Contacts>>() {
                    @Override
                    public void onChanged(List<Contacts> contacts) {

                        for(Contacts c: contacts){
                            Log.v("TAGY", c.getName());
                            contactsArrayList.add(c);
                        }

                        // Update UI with updated data
                        myAdapter.notifyDataSetChanged();
                    }
                });

        // Adapter
        myAdapter = new MyAdapter(contactsArrayList);

        // Linking the RecyclerView With the Adapter
        recyclerView.setAdapter(myAdapter);



    }
}