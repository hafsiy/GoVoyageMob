/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class User {

    private int id_user;
    private String login_user;
    private String nom_user;
    private String prenom_user;
    private String email_user;
    private String date_naissance_user;
    private String password_user;
    private int tel_user;
    private String longitude_user;
    private String lattitude_user;
    private int is_active_user;
    private int is_admin_user;
    private int is_hotel;
    private int is_agency;
    private int is_client;

    public User(int id_user, String login_user, String nom_user, String prenom_user, String email_user, String date_naissance_user, String password_user, int tel_user, String longitude_user, String lattitude_user, int is_active_user, int is_admin_user, int is_hotel, int is_agency, int is_client) {
        this.id_user = id_user;
        this.login_user = login_user;
        this.nom_user = nom_user;
        this.prenom_user = prenom_user;
        this.email_user = email_user;
        this.date_naissance_user = date_naissance_user;
        this.password_user = password_user;
        this.tel_user = tel_user;
        this.longitude_user = longitude_user;
        this.lattitude_user = lattitude_user;
        this.is_active_user = is_active_user;
        this.is_admin_user = is_admin_user;
        this.is_hotel = is_hotel;
        this.is_agency = is_agency;
        this.is_client = is_client;
    }

    public User() {
    }
    

    public User(int id_user, String nom_user, String prenom_user) {
        this.id_user = id_user;
        this.nom_user = nom_user;
        this.prenom_user = prenom_user;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNom_user() {
        return nom_user;
    }

    public String getLogin_user() {
        return login_user;
    }

    public void setLogin_user(String login_user) {
        this.login_user = login_user;
    }

    public void setNom_user(String nom_user) {
        this.nom_user = nom_user;
    }

    public String getPrenom_user() {
        return prenom_user;
    }

    public void setPrenom_user(String prenom_user) {
        this.prenom_user = prenom_user;
    }

    public String getDate_naissance_user() {
        return date_naissance_user;
    }

    public void setDate_naissance_user(String date_naissance_user) {
        this.date_naissance_user = date_naissance_user;
    }

    public String getPassword_user() {
        return password_user;
    }

    public void setPassword_user(String password_user) {
        this.password_user = password_user;
    }

    public int getTel_user() {
        return tel_user;
    }

    public void setTel_user(int tel_user) {
        this.tel_user = tel_user;
    }

    public String getLongitude_user() {
        return longitude_user;
    }

    public void setLongitude_user(String longitude_user) {
        this.longitude_user = longitude_user;
    }

    public String getLattitude_user() {
        return lattitude_user;
    }

    public void setLattitude_user(String lattitude_user) {
        this.lattitude_user = lattitude_user;
    }

    public int getIs_active_user() {
        return is_active_user;
    }

    public void setIs_active_user(int is_active_user) {
        this.is_active_user = is_active_user;
    }

    public int getIs_admin_user() {
        return is_admin_user;
    }

    public void setIs_admin_user(int is_admin_user) {
        this.is_admin_user = is_admin_user;
    }

    public int getIs_hotel() {
        return is_hotel;
    }

    public void setIs_hotel(int is_hotel) {
        this.is_hotel = is_hotel;
    }

    public int getIs_agency() {
        return is_agency;
    }

    public void setIs_agency(int is_agency) {
        this.is_agency = is_agency;
    }

    public int getIs_client() {
        return is_client;
    }

    public void setIs_client(int is_client) {
        this.is_client = is_client;
    }

    public String getEmail_user() {
        return email_user;
    }

    public void setEmail_user(String email_user) {
        this.email_user = email_user;
    }

}
