package com.example.integrador;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.Serializable;

public class CadastrarUser extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView iwFotoCandidato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_user);

        final EditText edtLogin = (EditText)findViewById(R.id.edtLogin);
        final EditText edtCPF = (EditText)findViewById(R.id.edtCPF);
        final EditText edtIdade = (EditText)findViewById(R.id.edtIdade);
        final RadioGroup rgTipoUsuario = (RadioGroup)findViewById(R.id.rgTipoUsuario);
        final EditText edtSenha = (EditText)findViewById(R.id.edtSenha);
        final EditText edtConfirmSenha = (EditText)findViewById(R.id.edtConfirmSenha);
        final Button btnCadastrar = (Button)findViewById(R.id.btnCadastrar);

        iwFotoCandidato = (ImageView)findViewById(R.id.iwFotoCandidato);

        edtCPF.addTextChangedListener(MaskEditUtil.mask(edtCPF, MaskEditUtil.FORMAT_CPF));

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtLogin.getText().toString().trim().equals("")){
                    Toast.makeText(getApplicationContext(), R.string.campo_obrigatorio, Toast.LENGTH_SHORT).show();
                    edtLogin.requestFocus();
                    return;
                }
                if(edtCPF.getText().toString().trim().equals("")){
                    Toast.makeText(getApplicationContext(), R.string.campo_obrigatorio, Toast.LENGTH_SHORT).show();
                    edtCPF.requestFocus();
                    return;
                }
                if(edtIdade.getText().toString().trim().equals("")){
                    Toast.makeText(getApplicationContext(), R.string.campo_obrigatorio, Toast.LENGTH_SHORT).show();
                    edtIdade.requestFocus();
                    return;
                }
                if(edtSenha.getText().toString().trim().equals("")){
                    Toast.makeText(getApplicationContext(), R.string.campo_obrigatorio, Toast.LENGTH_SHORT).show();
                    edtSenha.requestFocus();
                    return;
                }
                if(edtConfirmSenha.getText().toString().trim().equals("")){
                    Toast.makeText(getApplicationContext(), R.string.campo_obrigatorio, Toast.LENGTH_SHORT).show();
                    edtConfirmSenha.requestFocus();
                    return;
                }
                if(!edtConfirmSenha.getText().toString().equals(edtSenha.getText().toString())){
                    Toast.makeText(getApplicationContext(), R.string.confimacao_campo, Toast.LENGTH_SHORT).show();
                    edtConfirmSenha.setText("");
                    edtConfirmSenha.requestFocus();
                    return;
                }

                int selectedRadioButtonID = rgTipoUsuario.getCheckedRadioButtonId();
                if(selectedRadioButtonID == -1){
                    Toast.makeText(getApplicationContext(), R.string.campo_obrigatorio, Toast.LENGTH_SHORT).show();
                    rgTipoUsuario.requestFocus();
                    return;
                }

                final RadioButton rdbtnSelecionado = (RadioButton) findViewById(selectedRadioButtonID);
                Usuario newUsuario = cadastrar(edtLogin.getText().toString(), edtSenha.getText().toString(), edtCPF.getText().toString(), edtIdade.getText().toString(), rdbtnSelecionado.getText().toString());
                if (newUsuario != null) {
                    Toast.makeText(getApplicationContext(), "Cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
                    Intent home = new Intent(getApplicationContext(), Home.class);
                    home.putExtra("id", newUsuario.getId().toString());
                    startActivity(home);
                }
            }
        });

        iwFotoCandidato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "Test image view", Toast.LENGTH_SHORT).show();
                dispatchTakePictureIntent();
            }
        });
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            iwFotoCandidato.setImageBitmap(imageBitmap);
        }
    }

    public Usuario cadastrar(String login, String senha, String cpf, String idade, String tipoUsuario){
        Usuario newUsuario = new Usuario();
        newUsuario.setLogin(login);
        newUsuario.setSenha(senha);
        newUsuario.setCpf(cpf);
        newUsuario.setIdade(Integer.parseInt(idade));
        newUsuario.setTipoUsuario(tipoUsuario);

        return Usuario.cadastrar(newUsuario);
    }
}
