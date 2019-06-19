/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.HotelOffer;
import Service.ServiceRenseigtHotel;
import com.codename1.components.ImageViewer;

import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;

import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;

import com.codename1.ui.util.Resources;

import java.util.ArrayList;

/**
 *
 * @author bhk
 */
public class Affichage {

    Form f;
    private Form current;
    private Resources theme;
    Container c1;

    public Affichage() {

        f = new Form("Go Voyage", BoxLayout.y());
        ServiceRenseigtHotel service = new ServiceRenseigtHotel();
        ArrayList<HotelOffer> list = service.getList2();
        System.out.println("list " + list);
        for (HotelOffer r : list) {
            addItem(r);
            f.refreshTheme();
        }
        f.show();
        f.getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                // f.show();
            }
        });
        f.getToolbar().addCommandToRightSideMenu("Home", null, new ActionListener() {

            public void actionPerformed(ActionEvent evt) {

            }

        });
        f.getToolbar().addCommandToRightSideMenu("About", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

            }
        });
        f.getToolbar().addCommandToRightSideMenu("Show On Map", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

            }
        });

    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    private void addItem(HotelOffer c) {

        //Container C1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container C2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container C1 = new Container(new BoxLayout(BoxLayout.X_AXIS));

        Label nom = new Label(" " + c.getTitre_offre_hotel());
        //Label detail = new Label(" " + c.getTitre_offre_hotel());
        Label adr = new Label(" " + c.getDescription_offre_hotel());
        System.out.println("c.getPhoto_offre_hotel()aaaaaa: " + c.getPhoto_offre_hotel());

        ImageViewer img = new ImageViewer(theme.getImage("hotel.png"));
//                    ImageViewer img = new ImageViewer();
//        
//        EncodedImage placeholder = EncodedImage.createFromImage(theme.getImage("offrehot.jpg"), true);
//        URLImage uRLImage = URLImage.createToStorage(placeholder,
//                "image from server", "http://127.0.0.1/image/offrehot");        
//        img.setImage(uRLImage);
//                            EncodedImage encImg
//                        = EncodedImage.createFromImage(theme.getImage("offrehot.jpg"), false);
//                URLImage imgUrl
//                        = URLImage.createToStorage(encImg, "cache", "http://127.0.0.1/image/" + c.getPhoto_offre_hotel());
//                imgUrl.fetch();
//                ImageViewer a = new ImageViewer(theme.getImage("offrehot.png").scaled(512, 314));
//                ImageViewer img1 = new ImageViewer(imgUrl);
//        ImageViewer img = new ImageViewer();
//        
//        EncodedImage placeholder = EncodedImage.createFromImage(theme.getImage("maxresdefault.jpg"), true);
//        URLImage uRLImage = URLImage.createToStorage(placeholder,
//                "image from server", "http://127.0.0.1/image/c.getPhoto_offre_hotel()");        
//        img.setImage(uRLImage);
//                EncodedImage encImg
//                        = EncodedImage.createFromImage(theme.getImage("maxresdefault.jpg"), false);
//                URLImage imgUrl
//                        = URLImage.createToStorage(encImg, "cache", "http://127.0.0.1/image/" + c.getPhoto_offre_hotel());
//                imgUrl.fetch();
//                ImageViewer img = new ImageViewer(imgUrl);
        Label prix = new Label(" Prix: " + c.getPrix());
        System.out.println(" " + c.getDate_debut_dispo());

        nom.addPointerPressedListener(l -> {

             //DetailsVolInterface  detail = new DetailsVolInterface();
            
        });

        C2.add(img);
        C2.add(nom);
        C2.add(adr);
//               C2.add(datedeb);
//              C2.add(dateFin);
        C2.add(prix);

        C2.setLeadComponent(nom);
        f.add(C2);
        f.refreshTheme();
    }

}
