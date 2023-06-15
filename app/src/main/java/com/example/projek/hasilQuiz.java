package com.example.projek;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatDialogFragment;

public class hasilQuiz extends AppCompatDialogFragment {
    private TextView tvSkor, tvBenar;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_hasil_quiz, null);
        tvSkor = view.findViewById(R.id.hasilSkor);
        tvBenar = view.findViewById(R.id.benar);

        Bundle args = getArguments();
        if (args != null) {
            String skor = args.getString("skorAkhir");
            String benar = args.getString("skorBenar");
            tvSkor.setText(skor);
            tvBenar.setText("Total Benar : " + benar);
        }

        Button btnMuatUlang = view.findViewById(R.id.sekaliLagi);
        btnMuatUlang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                quiz quiz1 = new quiz();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frmlayout,quiz1,"null").addToBackStack(null).commit();
            }
        });

        builder.setView(view);
        return builder.create();
    }
}
