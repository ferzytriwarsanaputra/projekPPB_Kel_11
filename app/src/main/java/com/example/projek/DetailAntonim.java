package com.example.projek;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DetailAntonim extends AppCompatActivity {

    TextView TVkata,TVantonim;
    private DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_antonim);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setToolbarBackButtonColor(android.R.color.white);

//        mengambil textView
        TVkata = findViewById(R.id.kata);
        TVantonim = findViewById(R.id.antonim);

//        menginsialisasi database
        database = FirebaseDatabase.getInstance().getReference();
        Intent intent = getIntent();
        String key = intent.getStringExtra("key");
//            mengambil 1 data berdasarkan key
        database.child("Antonim").child(key).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                String kata = snapshot.child("kata").getValue(String.class);
                String antonim = snapshot.child("antonim").getValue(String.class);

                TVkata.setText("Kata\n" + kata);
                TVantonim.setText("Antonim\n" + antonim);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                finish();
            }
        });
    }

    private void setToolbarBackButtonColor(int white) {
        Drawable backDrawable = ContextCompat.getDrawable(this, R.drawable.ic_back); // Replace with your back button drawable
        backDrawable.setColorFilter(ContextCompat.getColor(this, white), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(backDrawable);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish(); // Close the current activity and go back to the parent activity
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}