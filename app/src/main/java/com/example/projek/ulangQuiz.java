package com.example.projek;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatDialogFragment;

public class ulangQuiz extends AppCompatDialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_ulang_quiz, null);

        Button btnMuatUlang = view.findViewById(R.id.muatUlang);
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
