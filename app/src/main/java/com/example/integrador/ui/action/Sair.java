package com.example.integrador.ui.action;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.integrador.Home;
import com.example.integrador.MainActivity;
import com.example.integrador.R;

public class Sair extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        AlertDialog.Builder sair = new AlertDialog.Builder(getContext());
        sair.setTitle("Deseja fazer o logout?");
        sair.setPositiveButton("Sim",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent main = new Intent(getContext(), MainActivity.class);
                        startActivity(main);
                    }
                });
        sair.setNegativeButton("Não",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent main = new Intent(getContext(), Home.class);
                        startActivity(main);
                    }
                });
        sair.show();

        return null;
    }
}
