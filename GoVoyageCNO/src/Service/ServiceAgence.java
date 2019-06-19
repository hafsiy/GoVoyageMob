/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.Agence;
import Entity.HotelDetails;
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
public class ServiceAgence {

    public ArrayList<Agence> ParseListOffresJason(String json) {

        ArrayList<Agence> listAgence = new ArrayList<>();

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
            Map<String, Object> agence = j.parseJSON(new CharArrayReader(json.toCharArray()));

            /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche                
             */
            List<Map<String, Object>> list = (List<Map<String, Object>>) agence.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                Agence o = new Agence();

                float id = Float.parseFloat(obj.get("id_agence").toString());
                o.setId_agence((int) id);
                o.setNom_agence(obj.get("nom_agence").toString());
                o.setId_user(Integer.parseInt(obj.get("id_user").toString()));

                String adresse_agence = obj.get("adresse_agence").toString();
                o.setAdresse_agence(adresse_agence);
                System.out.println(o);

                listAgence.add(o);

            }

        } catch (IOException ex) {
        }

        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
         */
        System.out.println(listAgence);
        return listAgence;

    }
    ArrayList<Agence> agence = new ArrayList<>();

    public ArrayList<Agence> getDetailsAgence(int id) {
        System.out.println(1);
        ConnectionRequest con = new ConnectionRequest();
        // con.setUrl("http://127.0.0.1:8080/Webservice/getDetailsHotel.php?id=" + id);
        //bouraoui
        con.setUrl("http://127.0.0.1/Webservice/getDetailsAgence.php?id=" + id);
        //con.setPost(false);
        con.addResponseListener((evt) -> {
            String response = new String(con.getResponseData());
            System.out.println(response);
            agence = ParseListOffresJason(response);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return agence;
    }

}
