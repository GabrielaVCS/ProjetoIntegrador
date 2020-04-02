package com.example.integrador;

import android.widget.Toast;

public class Usuario{
    private Integer id;
    private String login;
    private String senha;
    private String cpf;
    private Integer idade;
    private Integer tipoUsuario; //admin - 0 e usuario comum - 1

    public String getLogin(){
        return login;
    }
    public Boolean setLogin(String login){
        if(login.isEmpty()) return false; //TODO implements Exception in code
        if(login.length()<5) return false; //TODO implements Exception in code
        this.login = login;
        return true;
    }

    public String getSenha(){
        return senha;
    }
    public Boolean setSenha(String senha){
        if(senha.isEmpty()) return false; //TODO implements Exception in code
        if(senha.length()<5) return false; //TODO implements Exception in code
        this.senha = senha;
        return true;
    }

    public String getCpf(){
        return cpf;
    }
    public Boolean setCpf(String cpf){
        if(cpf.isEmpty()) return false; //TODO implements Exception in code
        if(cpf.length()<11) return false; //TODO implements Exception in code{
        this.cpf = cpf;
        return true;
    }

    public Integer getIdade(){
        return idade;
    }
    public Boolean setIdade(Integer idade){
        if(idade==0) return false; //TODO implements Extends in code
        this.idade = idade;
        return true;
    }

    public Integer getId() {
        return id;
    }
    public Boolean setId(Integer id){
        if(id<0) return false; //TODO implements Exception in code
        this.id = id;
        return true;
    }

    public Integer getTipoUsuario(){
        return tipoUsuario;
    }
    public Boolean setTipoUsuario(String tipoUsuario){
        if(tipoUsuario.isEmpty()) return false; //TODO implements Exception in code
        if(tipoUsuario.equals("Administrador")){
            this.tipoUsuario = 0;
        }else if(tipoUsuario.equals("Usuário comum")){
            this.tipoUsuario = 1;
        }else{
            return false; //TODO implements Exception in code
        }
        return true;
    }

    public static Usuario cadastrar(Usuario usuario){
//        TODO Cadastrar no banco
        return BancoTemporario.addUsuario(usuario);
    }
}
