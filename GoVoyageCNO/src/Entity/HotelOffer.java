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
public class HotelOffer {

    private int id_offre_hotel;
    private String titre_offre_hotel;
    private String photo_offre_hotel;
    private String description_offre_hotel;
    private String date_debut_dispo;
    private String date_fin_dispo;
    private String prix;
    private int id_hotel;

    public HotelOffer() {
    }
    
    

    public HotelOffer(int id_offre_hotel, String titre_offre_hotel, String photo_offre_hotel, String description_offre_hotel, String date_debut_dispo, String date_fin_dispo, String prix, int id_hotel) {
        this.id_offre_hotel = id_offre_hotel;
        this.titre_offre_hotel = titre_offre_hotel;
        this.photo_offre_hotel = photo_offre_hotel;
        this.description_offre_hotel = description_offre_hotel;
        this.date_debut_dispo = date_debut_dispo;
        this.date_fin_dispo = date_fin_dispo;
        this.prix = prix;
        this.id_hotel = id_hotel;
    }

    public int getId_offre_hotel() {
        return id_offre_hotel;
    }

    public void setId_offre_hotel(int id_offre_hotel) {
        this.id_offre_hotel = id_offre_hotel;
    }

    public String getTitre_offre_hotel() {
        return titre_offre_hotel;
    }

    public void setTitre_offre_hotel(String titre_offre_hotel) {
        this.titre_offre_hotel = titre_offre_hotel;
    }

    public String getPhoto_offre_hotel() {
        return photo_offre_hotel;
    }

    public void setPhoto_offre_hotel(String photo_offre_hotel) {
        this.photo_offre_hotel = photo_offre_hotel;
    }

    public String getDescription_offre_hotel() {
        return description_offre_hotel;
    }

    public void setDescription_offre_hotel(String description_offre_hotel) {
        this.description_offre_hotel = description_offre_hotel;
    }

    public String getDate_debut_dispo() {
        return date_debut_dispo;
    }

    public void setDate_debut_dispo(String date_debut_dispo) {
        this.date_debut_dispo = date_debut_dispo;
    }

    public String getDate_fin_dispo() {
        return date_fin_dispo;
    }

    public void setDate_fin_dispo(String date_fin_dispo) {
        this.date_fin_dispo = date_fin_dispo;
    }

    public String getPrix() {
        return prix;
    }

    public void setPrix(String prix) {
        this.prix = prix;
    }

    public int getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }

    @Override
    public String toString() {
        return "HotelOffer{" + "id_offre_hotel=" + id_offre_hotel + ", titre_offre_hotel=" + titre_offre_hotel + ", photo_offre_hotel=" + photo_offre_hotel + ", description_offre_hotel=" + description_offre_hotel + ", date_debut_dispo=" + date_debut_dispo + ", date_fin_dispo=" + date_fin_dispo + ", prix=" + prix + ", id_hotel=" + id_hotel + '}';
    }


}
