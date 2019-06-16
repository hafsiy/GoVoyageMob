/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.HotelDetails;
import Entity.HotelOffer;
import Entity.Offre;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lenovo
 */
public class ServiceHotel {

    public ArrayList<HotelDetails> ParseListOffresJason(String json) {

        ArrayList<HotelDetails> listHotel = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            /*
                On doit convertir notre réponse texte en CharArray à fin de
            permettre au JSONParser de la lire et la manipuler d'ou vient 
            l'utilité de new CharArrayReader(json.toCharArray())
            
            La méthode parse json retourne une MAP<String,Object> ou String est 
            la clé principale de notre résultat.
            Dans notre cas la clé principale n'est pas définie cela ne veux pas
            dire qu'elle est manquante mais plutôt gardée à la valeur par defaut
            qui est root.
            En fait c'est la clé de l'objet qui englobe la totalité des objets 
                    c'est la clé définissant le tableau de tâches.
             */
            Map<String, Object> hotel = j.parseJSON(new CharArrayReader(json.toCharArray()));

            /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche                
             */
            List<Map<String, Object>> list = (List<Map<String, Object>>) hotel.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                HotelDetails o = new HotelDetails();

                float id = Float.parseFloat(obj.get("id_hotel").toString());
                o.setId_hotel((int) id);
                o.setPhoto_hotel(obj.get("img_hotel").toString());
                o.setAdresse_hotel(obj.get("Adresse_hotel").toString());
                int stars = Integer.parseInt(obj.get("stars_hotel").toString());
                o.setId_hotel(stars);
                int chambre = Integer.parseInt(obj.get("chambre_hotel").toString());
                o.setId_hotel(chambre);
                
                int prix = Integer.parseInt(obj.get("prix_hotel").toString());
                o.setPrix(prix);
                System.out.println(o);

                listHotel.add(o);

            }

        } catch (IOException ex) {
        }

        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
         */
        System.out.println(listHotel);
        return listHotel;

    }
    ArrayList<HotelDetails> hotel = new ArrayList<>();

    public ArrayList<HotelDetails> getDetailsOffre(int id) {
        System.out.println(1);
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1:8080/Webservice/getDetailsHotel.php?id=" + id);
        //con.setPost(false);
        con.addResponseListener((evt) -> {
            String response = new String(con.getResponseData());
            System.out.println(response);

            hotel = ParseListOffresJason(response);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return hotel;
    }
}
