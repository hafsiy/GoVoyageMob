/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author lenovo
 */
public class HotelDetails {

    private int id_hotel;
    private String nom_hotel;
    private String adresse_hotel;
    private String stars_hotel;
    private int chambre;
    private int prix;
    private String photo_hotel;

    @Override
    public String toString() {
        return "HotelDetails{" + "id_hotel=" + id_hotel + ", nom_hotel=" + nom_hotel + ", adresse_hotel=" + adresse_hotel + ", stars_hotel=" + stars_hotel + ", chambre=" + chambre + ", prix=" + prix + ", photo_hotel=" + photo_hotel + '}';
    }

    public int getId_hotel() {
        return id_hotel;
    }

    public void setId_hotel(int id_hotel) {
        this.id_hotel = id_hotel;
    }

    public String getNom_hotel() {
        return nom_hotel;
    }

    public void setNom_hotel(String nom_hotel) {
        this.nom_hotel = nom_hotel;
    }

    public String getAdresse_hotel() {
        return adresse_hotel;
    }

    public void setAdresse_hotel(String adresse_hotel) {
        this.adresse_hotel = adresse_hotel;
    }

    public String getStars_hotel() {
        return stars_hotel;
    }

    public void setStars_hotel(String stars_hotel) {
        this.stars_hotel = stars_hotel;
    }

    public int getChambre() {
        return chambre;
    }

    public void setChambre(int chambre) {
        this.chambre = chambre;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public String getPhoto_hotel() {
        return photo_hotel;
    }

    public void setPhoto_hotel(String photo_hotel) {
        this.photo_hotel = photo_hotel;
    }

    public HotelDetails() {
    }

    public HotelDetails(String nom_hotel, String adresse_hotel, String stars_hotel, int chambre, int prix, String photo_hotel) {
        this.nom_hotel = nom_hotel;
        this.adresse_hotel = adresse_hotel;
        this.stars_hotel = stars_hotel;
        this.chambre = chambre;
        this.prix = prix;
        this.photo_hotel = photo_hotel;
    }

    public HotelDetails(int id_hotel, String nom_hotel, String adresse_hotel, String stars_hotel, int chambre, int prix, String photo_hotel) {
        this.id_hotel = id_hotel;
        this.nom_hotel = nom_hotel;
        this.adresse_hotel = adresse_hotel;
        this.stars_hotel = stars_hotel;
        this.chambre = chambre;
        this.prix = prix;
        this.photo_hotel = photo_hotel;
    }
}
