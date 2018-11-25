package com.example.veraaaa.finalproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Field;

public class JourneyActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    break;
                case R.id.navigation_dashboard:
                    Intent a = new Intent(JourneyActivity.this, DashBoradActivity.class);
                    startActivity(a);
                case R.id.navigation_notifications:
                    break;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journey);

        Button b1 = (Button)this.findViewById(R.id.button1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText editText = new EditText(JourneyActivity.this);
                AlertDialog.Builder inputDialogBuilder = new AlertDialog.Builder(
                        JourneyActivity.this);
                inputDialogBuilder.setTitle("Add New Journey").setView(editText);
                inputDialogBuilder.setPositiveButton("ADD", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Toast.makeText(JourneyActivity.this,"You are going to" + " " + editText.getText().toString(), Toast.LENGTH_SHORT).show();
                        try {
                            Intent a = new Intent(JourneyActivity.this, addJourney.class);
                            a.putExtra("destination", editText.getText().toString());
                            startActivity(a);
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                });
                inputDialogBuilder.setNegativeButton("Back", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(JourneyActivity.this,"Hello", Toast.LENGTH_SHORT).show();
                        try{
                            Field field = dialogInterface.getClass().getSuperclass().getDeclaredField( "mShowing" );
                            field.setAccessible( true );
                            field.set( dialogInterface, true);
                        }
                        catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                });
                inputDialogBuilder.show();
            }
        });
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }
}
