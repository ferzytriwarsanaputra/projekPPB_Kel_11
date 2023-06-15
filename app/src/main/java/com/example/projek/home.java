package com.example.projek;

import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class home extends Fragment {
    public home() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        CardView MateriSino,MateriAnto,KamusSino,KamusAnto,About;

        MateriSino = view.findViewById(R.id.mat_sino);
        MateriAnto = view.findViewById(R.id.mat_anto);
        KamusSino = view.findViewById(R.id.kam_sino);
        KamusAnto = view.findViewById(R.id.kam_anto);
        About = view.findViewById(R.id.about);

        MateriSino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                materi_sinonim materi_sinonim1 = new materi_sinonim();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frmlayout,materi_sinonim1,"null").addToBackStack(null).commit();
            }
        });

        MateriAnto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                materi_antonim materi_antonim1 = new materi_antonim();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frmlayout,materi_antonim1,"null").addToBackStack(null).commit();
            }
        });

        KamusSino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kamus_sinonim kamus_sinonim1 = new kamus_sinonim();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frmlayout,kamus_sinonim1,"null").addToBackStack(null).commit();
            }
        });

        KamusAnto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                kamus_antonim kamus_antonim1 = new kamus_antonim();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frmlayout,kamus_antonim1,"null").addToBackStack(null).commit();
            }
        });

        About.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                about about1 = new about();
                about1.show(getChildFragmentManager(), "about");
            }
        });

        return view;
    }
}