/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author admin
 */
public class Vol {

    int id_vol;
    int nb_escale;
    String prix;
    String origine;
    String destination;
    String heureDepart;
    String heureArrive;
    String depart;
    String arrivee;
    int id_agence;

    public Vol(int id_vol, int nb_escale, String prix, String origine, String destination, String heureDepart, String heureArrive, String depart, String arrivee, int id_agence) {
        this.id_vol = id_vol;
        this.nb_escale = nb_escale;
        this.prix = prix;
        this.origine = origine;
        this.destination = destination;
        this.heureDepart = heureDepart;
        this.heureArrive = heureArrive;
        this.depart = depart;
        this.arrivee = arrivee;
        this.id_agence = id_agence;
    }

    public Vol() {
    }
    
    

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public int getId_agence() {
        return id_agence;
    }

    public void setId_agence(int id_agence) {
        this.id_agence = id_agence;
    }


    
    
    
    
    
    public String getArrivee() {
        return arrivee;
    }

    public void setArrivee(String arrivee) {
        this.arrivee = arrivee;
    }

    public int getId_vol() {
        return id_vol;
    }

    public int getNb_escale() {
        return nb_escale;
    }

    public void setId_vol(int id_vol) {
        this.id_vol = id_vol;
    }

    public void setNb_escale(int nb_escale) {
        this.nb_escale = nb_escale;
    }

    public String getOrigine() {
        return origine;
    }

    public String getDestination() {
        return destination;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getHeureDepart() {
        return heureDepart;
    }

    public String getHeureArrive() {
        return heureArrive;
    }

    public void setHeureDepart(String heureDepart) {
        this.heureDepart = heureDepart;
    }

    public void setHeureArrive(String heureArrive) {
        this.heureArrive = heureArrive;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

}
