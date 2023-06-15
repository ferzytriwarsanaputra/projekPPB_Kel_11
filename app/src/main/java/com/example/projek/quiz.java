package com.example.projek;

import android.graphics.Color;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class quiz extends Fragment {

    public quiz() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    TextView tvBenar, tvSoal, tvJumlahSoal, tvTimer;
    Button btnPilihanJawaban1, btnPilihanJawaban2, btnPilihanJawaban3, btnPilihanJawaban4;
    int skor=0, benar=0, jumlahSoal=0;
    int arr;
    int x;
    String jawaban;
    Soal soalKuis = new Soal();
    CountDownTimer timer;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);

        tvBenar = view.findViewById(R.id.benar);
        tvSoal = view.findViewById(R.id.pertanyaan);
        tvJumlahSoal = view.findViewById(R.id.jumlahSoal);
        tvTimer = view.findViewById(R.id.timer);
        btnPilihanJawaban1 = view.findViewById(R.id.PilihanJawaban1);
        btnPilihanJawaban2 = view.findViewById(R.id.PilihanJawaban2);
        btnPilihanJawaban3 = view.findViewById(R.id.PilihanJawaban3);
        btnPilihanJawaban4 = view.findViewById(R.id.PilihanJawaban4);

        timer = new CountDownTimer(20000, 1000) { // 20 seconds timer
            @Override
            public void onTick(long millisUntilFinished) {
                tvTimer.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                ulangQuiz ulangQuiz1 = new ulangQuiz();
                ulangQuiz1.show(getActivity().getSupportFragmentManager(), "ulangQuiz");
                timer.cancel();
            }
        };

        setKonten();

        btnPilihanJawaban1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnPilihanJawaban1.setSelected(true);
                cekJawaban();
            }
        });

        btnPilihanJawaban2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnPilihanJawaban2.setSelected(true);
                cekJawaban();
            }
        });

        btnPilihanJawaban3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnPilihanJawaban3.setSelected(true);
                cekJawaban();
            }
        });

        btnPilihanJawaban4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnPilihanJawaban4.setSelected(true);
                cekJawaban();
            }
        });
        return view;
    }

    public void setKonten(){
        arr = soalKuis.pertanyaan.length;
        btnPilihanJawaban1.setBackgroundColor(Color.WHITE);
        btnPilihanJawaban2.setBackgroundColor(Color.WHITE);
        btnPilihanJawaban3.setBackgroundColor(Color.WHITE);
        btnPilihanJawaban4.setBackgroundColor(Color.WHITE);
        if(x >= arr){
            timer.cancel();
            String jumlahSkor = String.valueOf(skor);
            String jumlahBenar = String.valueOf(benar);
            hasilQuiz hasilQuiz1 = new hasilQuiz();
            Bundle args = new Bundle();
            args.putString("skorAkhir", jumlahSkor);
            args.putString("skorBenar", jumlahBenar);
            hasilQuiz1.setArguments(args);
            hasilQuiz1.show(getChildFragmentManager(), "hasilQuiz");
        }else{
            timer.start();
            tvSoal.setText(soalKuis.getPertanyaan(x));
            btnPilihanJawaban1.setText(soalKuis.getPilihanJawaban1(x));
            btnPilihanJawaban2.setText(soalKuis.getPilihanJawaban2(x));
            btnPilihanJawaban3.setText(soalKuis.getPilihanJawaban3(x));
            btnPilihanJawaban4.setText(soalKuis.getPilihanJawaban4(x));
            jawaban = soalKuis.getJawabanBenar(x);
            jumlahSoal++;
            tvJumlahSoal.setText("" + jumlahSoal);
        }
        x++;
    }

    public void cekJawaban() {
        if (btnPilihanJawaban1.isPressed()) {
            if (btnPilihanJawaban1.getText().toString().equals(jawaban)) {
                skor = skor + 10;
                benar = benar + 1;
                tvBenar.setText("" + benar);
                btnPilihanJawaban1.setBackgroundColor(Color.GREEN);
            } else {
                tvBenar.setText("" + benar);
                btnPilihanJawaban1.setBackgroundColor(Color.RED);
            }
        } else if (btnPilihanJawaban2.isPressed()) {
            if (btnPilihanJawaban2.getText().toString().equals(jawaban)) {
                skor = skor + 10;
                benar = benar + 1;
                tvBenar.setText("" + benar);
                btnPilihanJawaban2.setBackgroundColor(Color.GREEN);
            } else {
                tvBenar.setText("" + benar);
                btnPilihanJawaban2.setBackgroundColor(Color.RED);
            }
        } else if (btnPilihanJawaban3.isPressed()) {
            if (btnPilihanJawaban3.getText().toString().equals(jawaban)) {
                skor = skor + 10;
                benar = benar + 1;
                tvBenar.setText("" + benar);
                btnPilihanJawaban3.setBackgroundColor(Color.GREEN);
            } else {
                tvBenar.setText("" + benar);
                btnPilihanJawaban3.setBackgroundColor(Color.RED);
            }
        } else if (btnPilihanJawaban4.isPressed()) {
            if (btnPilihanJawaban4.getText().toString().equals(jawaban)) {
                skor = skor + 10;
                benar = benar + 1;
                tvBenar.setText("" + benar);
                btnPilihanJawaban4.setBackgroundColor(Color.GREEN);
            } else {
                tvBenar.setText("" + benar);
                btnPilihanJawaban4.setBackgroundColor(Color.RED);
            }
        } else {
            Toast.makeText(getContext(), "Silahkan pilih jawaban dulu!", Toast.LENGTH_SHORT).show();
            return;
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setKonten();
            }
        }, 1000);
    }
}