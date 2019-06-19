/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Agence;
import Entity.VolReservation;
import GUI.AddVolReservationScreen;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class ServiceReservation {

    public boolean addVolReservation(VolReservation reservation) {
        ConnectionRequest con = new ConnectionRequest();
        // con.setUrl("http://127.0.0.1:8080/Webservice/getDetailsHotel.php?id=" + id);
        //bouraoui
        String url = "http://127.0.0.1/Webservice/AddReservation.php?id_user=" + reservation.getId_user()
                + "&id_vol=" + reservation.getId_vol()
                + "&date_depart_vol_reservation=" + reservation.getDate_depart_vol_reservation()
                + "&date_arrivée_hotel_reservation=" + reservation.getDate_arrivée_hotel_reservation()
                + "&heure_dapart_hotel_reservation=" + reservation.getHeure_dapart_hotel_reservation()
                + "&heure_arrivee_hotel_reservation=" + reservation.getHeure_arrivee_hotel_reservation();
        con.setUrl(url);
        System.out.println(url);
        //con.setPost(false);
        con.addResponseListener((evt) -> {
            String response = new String(con.getResponseData());
            System.out.println(response);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return true;
    }

}
