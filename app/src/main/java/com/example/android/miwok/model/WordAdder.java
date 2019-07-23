package com.example.android.miwok.model;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.miwok.MainActivity;
import com.example.android.miwok.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class WordAdder extends AppCompatActivity {

    EditText miwok,word;
    Button b;
    SharedPreferences sharedPreferences;int num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_adder);
        miwok=findViewById(R.id.miwok);
        word=findViewById(R.id.word);
        b=findViewById(R.id.button);
        FirebaseDatabase firebaseDatabase= FirebaseDatabase.getInstance();
        final DatabaseReference databaseReference= firebaseDatabase.getReference("Tasks");
        sharedPreferences = getSharedPreferences("NumSaved", MODE_PRIVATE);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(final DataSnapshot dataSnapshot) {
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TaskNo Task = new TaskNo(word.getText().toString(),miwok.getText().toString());
                        num = sharedPreferences.getInt("NumSaved", 0);
                        databaseReference.child("HelloWorld"+num).setValue(Task);
                        Toast.makeText(WordAdder.this, "Saved Successfully", Toast.LENGTH_LONG).show();
//                        databaseReference.removeEventListener();
                        SharedPreferences login=getSharedPreferences("NumSaved",MODE_PRIVATE);
                        login.edit().putInt("NumSaved",num+1).apply();
                        Intent intent = new Intent(WordAdder.this, MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                    }
                });

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(WordAdder.this, databaseError.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }


}
