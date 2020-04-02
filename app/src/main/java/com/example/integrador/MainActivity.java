package com.example.integrador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edtLogin = (EditText)findViewById(R.id.edtLogin);
        final EditText edtSenha = (EditText)findViewById(R.id.edtSenha);

        Button btnEntrar = (Button)findViewById(R.id.btnEntrar);
        Button btnCadastrar = (Button)findViewById(R.id.btnCadastrar);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent home;
                Usuario usuario = entrar(edtLogin.getText().toString(), edtSenha.getText().toString());
                if(usuario!=null){
                    home = new Intent(getApplicationContext(), Home.class);
                    home.putExtra("id", usuario.getId().toString());
                }else{
                    Toast.makeText(getApplicationContext(), R.string.erro_login, Toast.LENGTH_SHORT).show();
                    home = new Intent(getApplicationContext(), MainActivity.class);
                }
                startActivity(home);
            }
        });

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent menu = new Intent(getApplicationContext(), CadastrarUser.class);
                startActivity(menu);
            }
        });
    }

    public Usuario entrar(String login, String senha){
        List<Usuario> listUsuario = BancoTemporario.getListUsuario();
        for (Usuario forUsuario : listUsuario) {
            if(login.equals(forUsuario.getLogin())){
                if(senha.equals(forUsuario.getSenha())){
                    return forUsuario;
                }
            }
        }
        return null;
    }
}

