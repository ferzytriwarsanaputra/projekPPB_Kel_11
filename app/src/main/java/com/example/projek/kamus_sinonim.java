package com.example.projek;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class kamus_sinonim extends Fragment {

    public kamus_sinonim() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private DatabaseReference database;
    ListView listView;
    private ArrayList<SinonimModel> listSinonim;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_kamus_sinonim, container, false);

        listView = view.findViewById(R.id.itemsList);

//        menginsiasi database Firebase
        database = FirebaseDatabase.getInstance().getReference();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SinonimModel sinonim = (SinonimModel) adapterView.getItemAtPosition(i);
                Intent intent1 = new Intent(requireContext(), DetailSinonim.class);
                intent1.putExtra("key", sinonim.getkey());
                startActivity(intent1);
            }
        });

        return view;
    }
    public void populateListview(){
        try {
            AdapterSinonim itemsAdapter = new AdapterSinonim(requireContext(), listSinonim);
            listView.setAdapter(itemsAdapter);
            itemsAdapter.notifyDataSetChanged();
            registerForContextMenu(listView);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void populateDataSinonim(){
        database.child("Sinonim").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listSinonim = new ArrayList<>();
                for (DataSnapshot sinonimSnapshot : snapshot.getChildren()) {
                    SinonimModel sinonim = sinonimSnapshot.getValue(SinonimModel.class);
                    sinonim.setKey(sinonimSnapshot.getKey());
                    listSinonim.add(sinonim);
                }
                populateListview();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        populateDataSinonim();
    }
}