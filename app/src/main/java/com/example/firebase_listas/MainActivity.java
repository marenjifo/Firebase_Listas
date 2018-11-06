package com.example.firebase_listas;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db=FirebaseDatabase.getInstance();
        DatabaseReference reference=db.getReference().child("usuarios").child("ALPHA12345");

        //Crear usuario
        //Usuario aleja= new Usuario("alefa","Alejandra","mar45@gmail.com","23563e3");
        //reference.push().setValue(aleja);

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
              //  for(DataSnapshot data : dataSnapshot.getChildren()) {
               //     Usuario u =data.getValue(Usuario.class);
                 //   Log.e("NOMBRE","Nombre: "+u.nombre);
                //}
                Usuario u= dataSnapshot.getValue(Usuario.class);
                Log.e("NOMBRE","Nombre: "+u.nombre);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
