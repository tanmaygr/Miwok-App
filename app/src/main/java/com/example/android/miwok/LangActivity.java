package com.example.android.miwok;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android.miwok.R;

public class LangActivity extends AppCompatActivity {

    Button eng,hindi;
   public static char l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lang);
        eng=findViewById(R.id.eng);
        hindi=findViewById(R.id.hin);

        eng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(LangActivity.this,MainActivity.class);
                l='e';
                startActivity(intent);
            }
        });

        hindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(LangActivity.this,MainActivity.class);
                l='h';
                startActivity(intent);
            }
        });
    }
}
