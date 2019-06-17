/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.hotelReservation;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;

/**
 *
 * @author Yosr Hafsi
 */
public class ServiceReservation {
    
    public void ajoutreservation (hotelReservation u) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://127.0.0.1/getReservationHotel.php?nom=" + u.getDate_debut_hotel_reservation() + "&date_fin=" + u.getDate_fin_hotel_reservation() + "&txt_enafant=\"" + u.getEnfant_hotel_reservation() + "\"&txt_adulte=\"" + u.getAdulte_hotel_reservation() + "\"&txt_nuit=\"" + u.getNuit_hotel_reservation() + "\"&txt_id_user=\"" + u.getId_user() + "\"&txt_id_hotel_offre=\"" + u.getId_hotel_offre() + "\""; // création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }

}
