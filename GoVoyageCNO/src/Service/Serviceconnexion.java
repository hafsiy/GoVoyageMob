package Service;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.codename1.components.InfiniteProgress;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Dialog;
import com.mycompany.Entite.User;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author karoui
 */
public class Serviceconnexion {

    public void ajoutUser(User u) {
        ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        //String Url = "http://127.0.0.1/govoyage/inscription.php?nom=" + u.getNom() + "&prenom=" + u.getPrenom() + "&username=\"" + u.getUsername() + "\"&password=\"" + u.getPassword() + "\"&email=\"" + u.getEmail() + "\"&tel=\"" + u.getPhone() + "\"&sexe=\"" + u.getSexe() + "\"&pays=\"" + u.getPays() + "\"&adresse=\"" + u.getAdresse() + "\""; // création de l'URL
       // con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());//Récupération de la réponse du serveur
            System.out.println(str);//Affichage de la réponse serveur sur la console

        });
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
    }

    public ArrayList<User> ParseListOffresJason(String json) {

        ArrayList<User> listUsers = new ArrayList<>();

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
            Map<String, Object> user = j.parseJSON(new CharArrayReader(json.toCharArray()));

            /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche                
             */
            List<Map<String, Object>> list = (List<Map<String, Object>>) user.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                User u = new User();

                float id = Float.parseFloat(obj.get("id_user").toString());
                u.setId_user((int) id);
                u.setPassword_user(obj.get("password_user").toString());
                u.setLogin_user(obj.get("login_user").toString());
                /*
                u.setNom(obj.get("nom").toString());
                u.setPrenom(obj.get("prenom").toString());
                u.setEmail(obj.get("email").toString());
                u.setPhone(obj.get("telephone").toString());
                u.setDate_naissance(obj.get("date_naissance").toString());
                u.setSexe(obj.get("sexe").toString());
                u.setPays(obj.get("pays").toString());
                u.setAdresse(obj.get("adresse").toString());
                System.out.println(u);
*/
                listUsers.add(u);

            }

        } catch (IOException ex) {
        }

        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
         */
        System.out.println(listUsers);
        return listUsers;

    }
    ArrayList<User> user;

    public ArrayList<User> getUser(String userName, String passWord) {
        //System.out.println(1);
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1/Webservice/login.php?username=" + userName + "&password=" + passWord);
        //con.setPost(false);
        con.addResponseListener((evt) -> {
            String response = new String(con.getResponseData());
            System.out.println(response);

            user = ParseListOffresJason(response);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return user;
    }

}