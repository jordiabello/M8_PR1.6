package com.example.android_persistencia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        File path = getFilesDir();

        final TextView name = findViewById(R.id.nameText);
        final TextView surrname = findViewById(R.id.surnameText);
        final TextView phone = findViewById(R.id.phoneText);
        final TextView email = findViewById(R.id.emailText);

        final Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newContact = name.getText() + "," + surrname.getText() + "," + phone.getText() + "," + email.getText() + ";\n";
                System.out.println(newContact);
                name.setText("");
                surrname.setText("");
                phone.setText("");
                email.setText("");
                try {
                    FileOutputStream fos = openFileOutput("contactes.txt", Context.MODE_APPEND);
                    fos.write(newContact.getBytes());
                    fos.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}