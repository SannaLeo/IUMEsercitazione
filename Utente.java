package com.example.myapplication;
import java.io.Serializable;
import java.util.Calendar;

public class Utente implements Serializable{

    private String username;
    private String password;
    private String citta;
    private String data;
    private boolean isAdmin = false;


    private int image = 0;

    public Utente (){

    }

    public Utente(String username, String password, String citta, boolean isadmin){
        //solo per il primo admin
        this.username = username;
        this.password = password;
        this.citta = citta;
        this.isAdmin = isadmin;

    }

    public Utente(String username, String password, String dataDiNascita, String citta){
        this.username = username;
        this.password = password;
        this.citta = citta;
        this.data = dataDiNascita;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }



    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getDataDiNascita() {
        return data;
    }

    public void setDataDiNascita(String dataDiNascita) {
        this.data = dataDiNascita;
    }


    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }


    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

}

