package com.example.veraaaa.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class addJourney extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent b = new Intent(addJourney.this, MainActivity.class);
                case R.id.navigation_dashboard:
                    Intent a = new Intent(addJourney.this, DashBoradActivity.class);
                    startActivity(a);
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_journey);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        final TextView dest = new TextView(addJourney.this);
        final TextView check_hint = new TextView(addJourney.this);
        Intent a = getIntent();
        String deststr = a.getStringExtra("destination");
        dest.findViewById(R.id.dest_text_view);
        dest.setText(deststr);
        check_hint.findViewById(R.id.check_hint);
        check_hint.setText("Choose Items");
        final List<String> list = new ArrayList<>();
        addListenerOnCheckBox(list);
        final Button add = (Button)this.findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(addJourney.this, showJourney.class);
                intent.putStringArrayListExtra("items",  (ArrayList<String>) list);
                startActivity(intent);
            }
        });

    }

    public void addListenerOnCheckBox(final List<String> checklist){
        final CheckBox cb1 = (CheckBox) this.findViewById(R.id.check_sweater);
        cb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checklist.add(cb1.getText().toString());
            }
        });
        final CheckBox cb2 = (CheckBox) findViewById(R.id.check_coat);
        cb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checklist.add(cb2.getText().toString());
            }
        });
        final CheckBox cb3 = (CheckBox) findViewById(R.id.check_bottle);
        cb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checklist.add(cb3.getText().toString());
            }
        });
        final CheckBox cb4 = (CheckBox) findViewById(R.id.check_passport);
        cb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checklist.add(cb4.getText().toString());
            }
        });
        final CheckBox cb5 = (CheckBox) findViewById(R.id.check_tickets);
        cb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checklist.add(cb5.getText().toString());
            }
        });
        final CheckBox cb6 = (CheckBox) findViewById(R.id.check_wallet);
        cb6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checklist.add(cb6.getText().toString());
            }
        });

    }
}
