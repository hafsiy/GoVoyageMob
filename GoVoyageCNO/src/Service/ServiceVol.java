/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entity.HotelOffer;
import Entity.Vol;
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
 * @author Lenovo
 */
public class ServiceVol {

    
    public ArrayList<Vol> parseListVolJson(String json) {

       ArrayList<Vol> listVol = new ArrayList<>();

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
            Map<String, Object> professionnels = j.parseJSON(new CharArrayReader(json.toCharArray()));
                       
            
            /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche                
            */
            List<Map<String, Object>> list = (List<Map<String, Object>>) professionnels.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                Vol V = new Vol();

                float id = Float.parseFloat(obj.get("id_vol").toString());
                float nbescal = Float.parseFloat(obj.get("nb_escale").toString());

                V.setId_vol((int) id);
                V.setNb_escale((int)nbescal);
                V.setPrix(obj.get("prix").toString());
                V.setOrigine(obj.get("origine").toString());
                V.setDestination(obj.get("destination").toString());
                V.setHeureDepart(obj.get("heureDepart").toString());
                V.setHeureArrive(obj.get("heureArrive").toString());
                V.setDepart(obj.get("depart").toString());
                V.setArrivee(obj.get("arrivee").toString());
                

                System.out.println(V);
                
                listVol.add(V);

            }

        } catch (IOException ex) {
        }
        
        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        System.out.println(listVol);
        return listVol;

    }
    
    public ArrayList<Vol> ParseListOffresJason(String json) {

        ArrayList<Vol> listOffre = new ArrayList<>();

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
                Vol o = new Vol();

                float id = Float.parseFloat(obj.get("id_vol").toString());
                o.setId_vol((int) id);
                o.setNb_escale(Integer.parseInt(obj.get("nb_escale").toString()));
                o.setPrix(obj.get("prix").toString());
//                o.setId_offre_hotel((int) obj.get("id_offre_hotel"));
                o.setOrigine(obj.get("origine").toString());
                o.setDestination(obj.get("destination").toString());
                o.setHeureDepart(obj.get("heureDepart").toString());
                o.setHeureArrive(obj.get("heureArrive").toString());

                o.setDepart(obj.get("depart").toString());
                o.setArrivee(obj.get("arrivee").toString());
                o.setHeureArrive(obj.get("heureArrive").toString());
//                o.setId_hotel(Integer.parseInt(obj.get("id_hotel").toString()));
                int id_agence = Integer.parseInt(obj.get("id_agence").toString());
                o.setId_agence(id_agence);
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
    ArrayList<Vol> offres = new ArrayList<>();

    public ArrayList<Vol> getDetailsVol(int id) {
        System.out.println(1);
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1/Webservice/getDetailsVol.php?id=" + id);
        //con.setPost(false);
        con.addResponseListener((evt) -> {
            String response = new String(con.getResponseData());
            System.out.println(response);

            offres = ParseListOffresJason(response);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return offres;
    }

    ArrayList<Vol> listVol = new ArrayList<>();

    public ArrayList<Vol> getList2() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1/Webservice/selectVol.php");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceVol ser = new ServiceVol();
                listVol = ser.parseListVolJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listVol;
    }

}
