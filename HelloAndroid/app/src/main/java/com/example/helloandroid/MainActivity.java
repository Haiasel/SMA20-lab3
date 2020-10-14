package com.example.helloandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.helloandroid.lifecycle.ActivityA;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MAIN ACTIVITY" ;
    Button bClick, bShare, bSearch;
    TextView tName;
    EditText eName;
    AlertDialog.Builder builder;
    Spinner spinner;
    Intent sendIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bClick = (Button) findViewById(R.id.bClick);
        bShare = (Button) findViewById(R.id.bShare);
        bSearch = (Button) findViewById(R.id.bSearch);
        tName = (TextView) findViewById(R.id.tName);
        eName = (EditText) findViewById(R.id.eName);
        spinner = (Spinner) findViewById(R.id.spinner);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
        R.array.colors_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        builder = new AlertDialog.Builder(getApplicationContext());


        // #####################################################
        // #####################################################
        // #####################################################
        // BUTTON "bClick" on Click
        // #####################################################
        // #####################################################
        // #####################################################

        bClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = eName.getText().toString().matches("") ?
                        "Hello, stranger!" : "Hello, " + eName.getText().toString() + "!";
                tName.setText(text);
                createDialog(text, "Greetings");
            }
        });

        // #####################################################
        // #####################################################
        // #####################################################
        // BUTTON "bShare" on Click
        // #####################################################
        // #####################################################
        // #####################################################

        bShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendIntent = new Intent();

                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, eName.getText().toString());
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }
        });

        // #####################################################
        // #####################################################
        // #####################################################
        // BUTTON "bSearch" on Click
        // #####################################################
        // #####################################################
        // #####################################################

        bSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY,  eName.getText().toString()); // query contains search string
                startActivity(intent);
            }
        });


        // #####################################################
        // #####################################################
        // #####################################################
        // Spinner "spinner" interface
        // #####################################################
        // #####################################################
        // #####################################################
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0: bClick.setTextColor(Color.BLUE);
                        break;
                    case 1: bClick.setTextColor(Color.GREEN);
                        break;
                    case 2: bClick.setTextColor(Color.RED);
                        break;
                case 3: bClick.setTextColor(Color.YELLOW);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                bClick.setTextColor(Color.BLACK);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(MainActivity.TAG, "onStart Main");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(MainActivity.TAG, "onResume Main");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(MainActivity.TAG, "onDestroy Main");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(MainActivity.TAG, "onPause Main");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(MainActivity.TAG, "onStop Main");
    }

    @Override
    protected void  onRestart() {
        super.onRestart();
        Log.d(MainActivity.TAG, "onRestart Main");
    }

    private void createDialog(String message, String title) {
        Dialog dialog = new Dialog(message, title);
        dialog.show(getSupportFragmentManager(), "dialog");
    }

    public void clicked(View view) {
        startActivity(new Intent(this, ActivityA.class));
    }
}