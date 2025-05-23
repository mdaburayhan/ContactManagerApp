package com.arsoft.contactmanagerapp;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class AddNewContactClickHandler {

    Contacts contact;
    Context context;

    public AddNewContactClickHandler(Contacts contact, Context context) {
        this.contact = contact;
        this.context = context;
    }

    public void onSubmitBtnClicked(View view){
        if(contact.getName() == null || contact.getEmail() == null){
            Toast.makeText(context, "Fields Cannot be Empty", Toast.LENGTH_SHORT).show();
        }
        else {
            Intent i = new Intent(context, MainActivity.class);
            i.putExtra("name", contact.getName());
            i.putExtra("email", contact.getEmail());
            context.startActivity(i);
        }
    }

}
