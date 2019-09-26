package com.example.firebaseandroidauth.objeto;

import android.webkit.URLUtil;

import java.net.URL;

public class Persona {
    private String nombreCompleto;
    private String correo;
    private String nombreFamilia;
    private String nombrePila;
    private String id;
    private String idToken;
    private String serverAuthToken;
    private String zab;
    private String zac;
    private Object fotoUrl;

    public Persona() {
    }

    public Persona(String nombreCompleto, String correo, String nombreFamilia, String nombrePila, String id, String idToken, String serverAuthToken, String zab, String zac) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.nombreFamilia = nombreFamilia;
        this.nombrePila = nombrePila;
        this.id = id;
        this.idToken = idToken;
        this.serverAuthToken = serverAuthToken;
        this.zab = zab;
        this.zac = zac;
    }

    public Persona(String nombreCompleto, String correo, String nombreFamilia, String nombrePila, String id, String idToken, String serverAuthToken, String zab, String zac, URLUtil fotoUrl) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.nombreFamilia = nombreFamilia;
        this.nombrePila = nombrePila;
        this.id = id;
        this.idToken = idToken;
        this.serverAuthToken = serverAuthToken;
        this.zab = zab;
        this.zac = zac;
        this.fotoUrl = fotoUrl;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombreFamilia() {
        return nombreFamilia;
    }

    public void setNombreFamilia(String nombreFamilia) {
        this.nombreFamilia = nombreFamilia;
    }

    public String getNombrePila() {
        return nombrePila;
    }

    public void setNombrePila(String nombrePila) {
        this.nombrePila = nombrePila;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }

    public String getServerAuthToken() {
        return serverAuthToken;
    }

    public void setServerAuthToken(String serverAuthToken) {
        this.serverAuthToken = serverAuthToken;
    }

    public String getZab() {
        return zab;
    }

    public void setZab(String zab) {
        this.zab = zab;
    }

    public String getZac() {
        return zac;
    }

    public void setZac(String zac) {
        this.zac = zac;
    }

    public Object getFotoUrl() {
        return fotoUrl;
    }

    public void setFotoUrl(Object fotoUrl) {
        this.fotoUrl = fotoUrl;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombreCompleto='" + nombreCompleto + '\'' +
                ", correo='" + correo + '\'' +
                ", nombreFamilia='" + nombreFamilia + '\'' +
                ", nombrePila='" + nombrePila + '\'' +
                ", id='" + id + '\'' +
                ", idToken='" + idToken + '\'' +
                ", serverAuthToken='" + serverAuthToken + '\'' +
                ", zab='" + zab + '\'' +
                ", zac='" + zac + '\'' +
                ", fotoUrl=" + fotoUrl +
                '}';
    }
}
