package com.example.a16022809.demodialogs;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.itemConfirmation) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Are  you sure?")

            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "You clicked yes", Toast.LENGTH_LONG).show();
                }
            })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, "You clicked no", Toast.LENGTH_LONG).show();
                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
        else if (item.getItemId() == R.id.itemSimpleList) {
            String [] list = new String [] {"Monday", "Tuesday", "Wednesday", "Thursdary", "Friday" };

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Which is your freest weekday?")

                    .setItems(list, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            if (which == 0 ){
                                Toast.makeText(MainActivity.this, "You said Monday", Toast.LENGTH_LONG).show();
                            } else if (which == 4) {
                                Toast.makeText(MainActivity.this, "You said Friday", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(MainActivity.this, "You said middle of the week Friday", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
        else if (item.getItemId() == R.id.itemPassPhrase) {
            LayoutInflater inflater = (LayoutInflater)
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            LinearLayout passPhrase = (LinearLayout) inflater.inflate(R.layout.passphrase, null);
            final EditText etPassphrease = (EditText) passPhrase.findViewById(R.id.editTextPassPhrase);
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Please Enter")
                    .setView(passPhrase)
                    .setPositiveButton("Done", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this, "You had entered " + etPassphrease.getText().toString(), Toast.LENGTH_LONG).show();
                        }
                    });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
        return super.onOptionsItemSelected(item);
    }
}
