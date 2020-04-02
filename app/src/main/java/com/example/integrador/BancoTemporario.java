package com.example.integrador;

import java.util.ArrayList;
import java.util.List;

public class BancoTemporario {
    private static List<Usuario> listUsuario = new ArrayList<Usuario>();
    private static Integer indexListUsuario = 0;
    private static List<Candidato> listCandidato = new ArrayList<Candidato>();
    private static Integer indexListCandidato = 0;

    public static Usuario addUsuario(Usuario usuario){
        Usuario newUsuario = usuario;
        newUsuario.setId(indexListUsuario);
        indexListUsuario++;
        listUsuario.add(newUsuario);
        return newUsuario;
    }

    public static List<Usuario> getListUsuario(){
        return listUsuario;
    }

    public static Usuario getUsuario(Integer id){
        for (Usuario forUsuario: listUsuario) {
            if(forUsuario.getId() == id) return forUsuario;
        }
        return null;
    }

    public static Candidato addCandidato(Candidato candidato){
        Candidato newCandidato = candidato;
        newCandidato.id = indexListCandidato;
        indexListCandidato++;
        listCandidato.add(newCandidato);
        return  newCandidato;
    }

    public static List<Candidato> getListCandidato(){
        listCandidato.clear();
        mockCandidato();
        return listCandidato;
    }

    public static void mockCandidato(){
        addCandidato(new Candidato("IRTON OLIVEIRA MUZEL"));
        addCandidato(new Candidato("JURANDIR YAMAGAMI"));
        addCandidato(new Candidato("JOSÉ ALVES DE BRITO FILHO"));
        addCandidato(new Candidato("MARCIO GONÇALVES"));
        addCandidato(new Candidato("ADILSON MEDEIROS"));
        addCandidato(new Candidato("ALEX ANTONIO MARCELINO"));
        addCandidato(new Candidato("ANTONIO ARCHANJO DE OLIVEIRA"));
        addCandidato(new Candidato("ANTONIO CARLOS LIMA"));
        addCandidato(new Candidato("ANTONIO RODRIGUES SOARES"));
        addCandidato(new Candidato("APARECIDO DONIZETE CONTIJO"));
        addCandidato(new Candidato("APARECIDO PEREIRA"));
        addCandidato(new Candidato("ARILDO ROGERIO DA SILVA"));
        addCandidato(new Candidato("ARIOVALDO SILVA DA ROCHA"));
        addCandidato(new Candidato("AUGUSTO APARECIDO LIMA"));
        addCandidato(new Candidato("CELSO CUSTÓDIO NOGUEIRA"));
        addCandidato(new Candidato("CLAUDINEI MOURA"));
        addCandidato(new Candidato("DANIEL GIOLO"));
        addCandidato(new Candidato("JEAN KLEUBER NOVAIS SA TELES"));
        addCandidato(new Candidato("JOAQUIM PAULO MACHADO"));
    }
}

