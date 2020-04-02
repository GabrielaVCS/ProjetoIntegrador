package com.example.integrador;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final Button btnSair = (Button)findViewById(R.id.btnSair);
        final ListView lwCandidatos = (ListView)findViewById(R.id.lwCandidatos);
        ArrayList<String> arrayList = new ArrayList<>();
        List<Candidato> listCandidato = BancoTemporario.getListCandidato();
        for (Candidato forCandidato : listCandidato) {
            arrayList.add(forCandidato.nome);
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayList);
        lwCandidatos.setAdapter(arrayAdapter);
        lwCandidatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedItem=(String) lwCandidatos.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),clickedItem,Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        Usuario usuario = BancoTemporario.getUsuario(Integer.parseInt(id));
//        Sistema.setIdUsuario(Integer.parseInt(id));

        Toast.makeText(getApplicationContext(), "Bem vindo, " + usuario.getLogin(), Toast.LENGTH_LONG).show();

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder sair = new AlertDialog.Builder(Home.this);
                sair.setTitle("Deseja fazer o logout?");
                sair.setPositiveButton("Sim",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
//                                Sistema.setIdUsuario(null);
                                Intent main = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(main);
                            }
                        });
                sair.setNegativeButton("Não",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {}
                        });
                sair.show();
            }
        });

    }
}

