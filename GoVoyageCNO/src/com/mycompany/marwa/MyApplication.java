package com.mycompany.marwa;

import Entity.Vol;
import GUI.AddVolReservationScreen;
import GUI.Affichage;
import GUI.AffichageListeHotel;
import GUI.DetailsOffresInterface;
import GUI.DetailsVolInterface;
import Service.ServiceVol;
import Service.Serviceconnexion;
import com.codename1.components.ImageViewer;
import com.codename1.io.Log;
import com.codename1.ui.Form;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.io.NetworkEvent;
import com.codename1.ui.Button;
import static com.codename1.ui.CN.addNetworkErrorListener;
import static com.codename1.ui.CN.updateNetworkThreadCount;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.spinner.Picker;
import com.mycompany.Entite.User;
import com.mycompany.myapp.Chaine;
import java.util.ArrayList;

public class MyApplication {

    private Form current;
    private DetailsOffresInterface DetailsForm;
    public static ArrayList<User> listuser;
    Serviceconnexion sc = new Serviceconnexion();
    User user;
    public static Form hi1;
    public static Resources theme;

    public void init(Object context) {
//         use two network threads instead of one
        updateNetworkThreadCount(2);

        theme = UIManager.initFirstTheme("/theme");

//         Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true);

//         Pro only feature
        Log.bindCrashProtection(true);

        addNetworkErrorListener(err -> {
//             prevent the event from propagating
            err.consume();
            if (err.getError() != null) {
                Log.e(err.getError());
            }
            Log.sendLogAsync();
            Dialog.show("Connection Error", "There was a networking error in the connection to " + err.getConnectionRequest().getUrl(), "OK", null);
        });
    }

    public void start() {
//        DetailsForm = new cla
//        if(current != null){
//           current.show();
//            return;

        //DetailsForm = new DetailsOffresInterface();
        // DetailsVolInterface  detail = new DetailsVolInterface();
        // AddVolReservationScreen form = new AddVolReservationScreen(0);
        Form hi = new Form("GoVoyage", new FlowLayout(CENTER, CENTER));
        hi1 = new Form("Programmes", new FlowLayout(CENTER, CENTER));

        Container ver = new Container(BoxLayout.y());
        Container c = new Container(new FlowLayout(CENTER));
        ImageViewer a = new ImageViewer(theme.getImage("logo.png").scaled(512, 314));
        Container c1 = new Container(new FlowLayout(CENTER));
        Container c2 = new Container(new FlowLayout(CENTER));

        Form hi2 = new Form("Liste des Offres VOLS", new FlowLayout(CENTER, CENTER));
        TextField username = new TextField("", "login");
        TextField password = new TextField("", "password", 20, TextField.PASSWORD);
        Label signup = new Label("inscrivez vous");
        signup.getAllStyles().setFgColor(0x5C5CFF);
        hi1.getToolbar().addCommandToRightBar("Back", null, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                hi.show();
            }
        });
        hi.show();

        Button b = new Button("Sign In");
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {

                String login = username.getText();
                String passwod = password.getText();
                listuser = sc.getUser(login, passwod);
                System.err.println(listuser);
                if (listuser.size() > 0) {
                    username.setText("");
                    password.setText("");
                    user = listuser.get(0);

                    Container ver = new Container(BoxLayout.y());
                    Button hotel = new Button("Hotels");
                    Button vol = new Button("Vols");

                    Button detailHotelOffer = new Button("Détail offre hotel");
                    Button detailVolOffer = new Button("Détail vol offre");

                    vol.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            hi2.refreshTheme();
                            hi2.show();

                        }

                    });
                    hotel.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            AffichageListeHotel h = new AffichageListeHotel();
                            h.getF().show();
                        }
                    });

                    detailHotelOffer.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                           
                        }
                    });

                    detailVolOffer.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            //DetailsVolInterface detail = new DetailsVolInterface();
                        }
                    });

                    hi2.getToolbar().addCommandToRightBar("Back", null, new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent evt) {

                            username.setText("");
                            password.setText("");
                            hi1.refreshTheme();
                            hi1.show();
                        }
                    });

                    ver.addAll(hotel, vol);
                    hi1.add(ver);
                    hi1.show();

                }else {
                     Dialog.show("Login ou Mot de passe invalide", "S'il vous plait veuillez vérifier votre Login et Mot de passe", "OK", "Cancel");
                }
            }

        });

        c.addAll(a);
        c1.addAll(username, password, b, signup);
        hi.addAll(c, c1);

        signup.addPointerPressedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Form inscription = new Form("Créer un nouveau compte", new FlowLayout(CENTER));
                Label def = new Label("Remlissez le formulaire");
                Label vide = new Label();
                TextField Nom = new TextField("", "Nom");
                TextField prenom = new TextField("", "Prenom");
                Picker date_nais = new Picker();
                TextField tel = new TextField("", "Numéro de Téléphone");
                TextField sexe = new TextField("", "Type");
                TextField login = new TextField("", "login");
                TextField pwd = new TextField("", "Mot de passe", 20, TextField.PASSWORD);
                Button inscrire = new Button("Créer mon compte");
                inscription.addAll(def, vide, Nom, prenom, login, pwd, date_nais, tel, sexe, inscrire);
                inscription.show();
            }

        });

        ArrayList<Vol> ListChaine = new ServiceVol().getList2();
        //ImageViewer I = new ImageViewer(theme.getImage("logo.png"));
        Container c30 = new Container(new FlowLayout(CENTER, CENTER));

        for (int i = 0; i < ListChaine.size(); i++) {
            Vol e = ListChaine.get(i);

            /**
             * ***************************************
             */
            Container c20 = new Container(new FlowLayout(CENTER, CENTER));
            Label l = new Label(e.getDepart());
            Label depart = new Label(e.getHeureDepart());
            Label arrivee = new Label(e.getHeureArrive());
            Label placearrive = new Label(e.getArrivee());

            Container c21 = new Container(BoxLayout.y());
            Label ll = new Label(e.getPrix());

            l.addPointerPressedListener((evt) -> {

                System.out.println("id agence :" + e.getId_vol());
                DetailsVolInterface detail = new DetailsVolInterface(e.getId_vol());

            });

            c20.setLeadComponent(l);

            /**
             * ****************************************
             */
            c20.addAll(l, depart, arrivee, placearrive, ll);

            //c21.addAll(ll);
            hi2.add(c20);

        }

        // c30.add(I);
        hi2.add(c30);
        hi.show();

    }

    public void stop() {

    }

    public void destroy() {
    }

}
