package com.example.integrador.ui.home;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.integrador.BancoTemporario;
import com.example.integrador.Candidato;
import com.example.integrador.MainActivity;
import com.example.integrador.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        final ListView lwCandidatos = root.findViewById(R.id.lwCandidatos);
        ArrayList<String> arrayList = new ArrayList<>();
        List<Candidato> listCandidato = BancoTemporario.getListCandidato();
        for (Candidato forCandidato : listCandidato) {
            arrayList.add(forCandidato.nome);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, arrayList);
        lwCandidatos.setAdapter(arrayAdapter);
        lwCandidatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedItem = (String) lwCandidatos.getItemAtPosition(position);
                Toast.makeText(getContext(), clickedItem, Toast.LENGTH_LONG).show();
            }
        });

//        Intent intent = getIntent();
//        String id = intent.getStringExtra("id");
//        Usuario usuario = BancoTemporario.getUsuario(Integer.parseInt(id));
//
//        Toast.makeText(getContext(), "Bem vindo, " + usuario.getLogin(), Toast.LENGTH_LONG).show();

        return root;
    }
}
