 package com.example.elam.android9_3;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int call = 100;
    private static final int sms = 101;
    private static final int Pick_Contact = 1;


    ListView listView;
    String[] name = new String[]{"Navin", "bala", "selva", "rani", "narmadha", "vina", "muru", "shiva", "mari", "sai"};
    String[] numb = new String[]{" 8428257682", "9585446252", "8482549687", "9855468542", "7258624852", "9854673214", "8524316798", "9426837154", "9436821574", "8763254981","8632541789"};
    List<CustomGetSet> model = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.contacts);
        for (int i = 0; i < name.length; i++) {


            CustomGetSet handler = new CustomGetSet();
            handler.setName(name[i]);
            handler.setNumber(numb[i]);
            model.add(handler);
        }
        CustomAdapter listAdaper = new CustomAdapter(this, model);
        listView.setAdapter(listAdaper);
        //registering for contextmenu
        registerForContextMenu(listView);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {


        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Choose an action");
        menu.add(0, call, 1, "call");
        menu.add(0, sms, 2, "Send sms");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if (item.getItemId()== call && item.getGroupId()==0) {

            Intent intent = new Intent(Intent.ACTION_DIAL);



            startActivityForResult(intent, Pick_Contact);
        }

        if (item.getItemId()== sms && item.getGroupId()==0) {

            Intent intent = new Intent(Intent.ACTION_SENDTO);



            startActivityForResult(intent, Pick_Contact);
        }

        return true;
    }
}