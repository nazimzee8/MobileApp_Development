package edu.tacoma.uw.nazimz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.*;
import android.view.View;
import android.content.*;

import android.net.*;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Creating buttons */
        Button text = findViewById(R.id.text_button);
        text.setText("Text");
        Button image = findViewById(R.id.image_button);
        image.setText("Image");
        Button web = findViewById(R.id.web_button);
        web.setText("Web");
        Button toast = findViewById(R.id.toast_button);
        toast.setText("Toast");
        Button dialog = findViewById(R.id.dialog_button);
        dialog.setText("Dialog");

        /*Set actions for button clicks*/
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImage();
            }
        });
        web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri url = openWebPage("http://developer.android.com/index.html");
                Intent intent = new Intent(Intent.ACTION_VIEW, url);
                startActivity(intent);
            }
        });
        toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast();
            }
        });
        dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createDialog();
            }
        });
    }

    /* Helper methods that define actions for each button */
    public void openActivity() {
        Intent intent = new Intent(this, TextActivity.class);
        startActivity(intent);
    }

    public void openImage() {
        Intent intent = new Intent(this, ImageActivity.class);
        startActivity(intent);
    }

    public Uri openWebPage(String url) {
        return Uri.parse(url);
    }

    public void showToast() {
        Context context = getApplicationContext();
        CharSequence text = "I want to graduate!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void createDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("This is Nazim's dialog");
        builder.setTitle("Nazim Dialog");

        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // Do something
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // Do something
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}