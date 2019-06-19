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
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;


import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 *
 * @author ASUS
 */
public class ServiceRenseigtHotel {
    
        
    ArrayList<HotelOffer> listHot = new ArrayList<>();
    

    public ArrayList<HotelOffer> parseListHJson(String json) {
  
        try {
            
            
            JSONParser j = new JSONParser();
            Map<String, Object> hot = j.parseJSON(new CharArrayReader(json.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) hot.get("root");

            for (Map<String, Object> obj : list) {

            HotelOffer e = new HotelOffer();
                
            float id = Float.parseFloat(obj.get("id_offre_hotel").toString());
             System.out.println("id_offre_hotel "+obj.get("id_offre_hotel"));
            e.setId_hotel((int) id);
            e.setTitre_offre_hotel(obj.get("titre_offre_hotel").toString());
            //e.setTitre_offre_hotel(obj.get("titre_offre_hotel").toString());
            e.setDescription_offre_hotel(obj.get("description_offre_hotel").toString());
            e.setPhoto_offre_hotel(obj.get("photo_offre_hotel").toString());
            System.out.println("photo_offre_hotel " +obj.get("photo_offre_hotel").toString());
            e.setDate_debut_dispo(obj.get("date_debut_dispo").toString());
            e.setDate_fin_dispo(obj.get("date_fin_dispo").toString());
            e.setPrix(obj.get("prix").toString());
  
            System.out.println("objet "+obj);
  
            listHot.add(e);

            }
            
            System.out.println("listHotel " +listHot);
          
        } catch (IOException ex) {
       
        }
         return listHot;
    }
    

    
    public ArrayList<HotelOffer> getList2(){       
    
        
        ConnectionRequest con= new ConnectionRequest();
        con.setUrl("http://127.0.0.1/Webservice/getListeHotel.php"); 

        con.addResponseListener(new ActionListener<NetworkEvent>() {
            public void actionPerformed(NetworkEvent evt) {
                ServiceRenseigtHotel ser = new ServiceRenseigtHotel();
                 String str = new String(con.getResponseData());//Récupération de la réponse du serveur
                System.out.println("connectionData: "+str);
                listHot = ser.parseListHJson(new String(con.getResponseData()));
                
                System.out.println("connectionDatalistHot: "+listHot);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listHot;
    }
    
}
