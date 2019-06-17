/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.HotelOffer;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Lenovo
 */
public class ServiceVol {
   
    
        public ArrayList<HotelOffer> ParseListOffresJason(String json) {

        ArrayList<HotelOffer> listOffre = new ArrayList<>();

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
            Map<String, Object> offre = j.parseJSON(new CharArrayReader(json.toCharArray()));

            /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche                
             */
            List<Map<String, Object>> list = (List<Map<String, Object>>) offre.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                HotelOffer o = new HotelOffer();

                float id = Float.parseFloat(obj.get("id_offre_hotel").toString());
                o.setId_offre_hotel((int) id);
                o.setPhoto_offre_hotel(obj.get("photo_offre_hotel").toString());
                o.setTitre_offre_hotel(obj.get("titre_offre_hotel").toString());
//                o.setId_offre_hotel((int) obj.get("id_offre_hotel"));
                o.setDescription_offre_hotel(obj.get("description_offre_hotel").toString());
                o.setDate_debut_dispo(obj.get("date_debut_dispo").toString());
                o.setDate_fin_dispo(obj.get("date_fin_dispo").toString());
                o.setPrix(obj.get("prix").toString());
//                o.setId_hotel(Integer.parseInt(obj.get("id_hotel").toString()));


                int idHotel = Integer.parseInt(obj.get("id_hotel").toString());
                o.setId_hotel(idHotel);
                System.out.println(o);

                listOffre.add(o);

            }

        } catch (IOException ex) {
        }

        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
         */
        System.out.println(listOffre);
        return listOffre;

    }
    ArrayList<HotelOffer> offres = new ArrayList<>();

    public ArrayList<HotelOffer> getDetailsOffre(int id) {
        System.out.println(1);
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1:8080/Webservice/getDetailsOffre.php?id=" + id);
        //con.setPost(false);
        con.addResponseListener((evt) -> {
            String response = new String(con.getResponseData());
            System.out.println(response);

            offres = ParseListOffresJason(response);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return offres;
    }
    
}
