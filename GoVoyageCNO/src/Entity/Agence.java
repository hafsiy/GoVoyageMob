/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Lenovo
 */
public class Agence {

    private int id_agence;
    private String nom_agence;
    private int id_user;
    private String adresse_agence;

    public Agence() {
    }

    
    
    public int getId_agence() {
        return id_agence;
    }

    public void setId_agence(int id_agence) {
        this.id_agence = id_agence;
    }

    public String getNom_agence() {
        return nom_agence;
    }

    public void setNom_agence(String nom_agence) {
        this.nom_agence = nom_agence;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getAdresse_agence() {
        return adresse_agence;
    }

    public void setAdresse_agence(String adresse_agence) {
        this.adresse_agence = adresse_agence;
    }
    
    

    public Agence(int id_agence, String nom_agence, int id_user, String adresse_agence) {
        this.id_agence = id_agence;
        this.nom_agence = nom_agence;
        this.id_user = id_user;
        this.adresse_agence = adresse_agence;
    }

}
