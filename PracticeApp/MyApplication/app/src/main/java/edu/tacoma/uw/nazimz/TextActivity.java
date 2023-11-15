package edu.tacoma.uw.nazimz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        TextView message = findViewById(R.id.text_view_id);
        message.setText("This is Nazim!");
    }
}
