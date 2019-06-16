/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Amir
 */
public class Offre {

    int id_offre;
    String nom_offre;
    String detail_offre;

    public Offre() {
    }

    public Offre(int id_offre, String nom_offre, String detail_offre) {
        this.id_offre = id_offre;
        this.nom_offre = nom_offre;
        this.detail_offre = detail_offre;
    }

    public int getId_offre() {
        return id_offre;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }

    public String getNom_offre() {
        return nom_offre;
    }

    public void setNom_offre(String nom_offre) {
        this.nom_offre = nom_offre;
    }

    public String getDetail_offre() {
        return detail_offre;
    }

    public void setDetail_offre(String detail_offre) {
        this.detail_offre = detail_offre;
    }

    @Override
    public String toString() {
        return "Offre{" + "id_offre=" + id_offre + ", nom_offre=" + nom_offre + ", detail_offre=" + detail_offre + '}';
    }

}
