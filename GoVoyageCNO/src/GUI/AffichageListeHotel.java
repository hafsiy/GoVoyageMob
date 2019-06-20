/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.HotelOffer;
import Service.ServiceRenseigtHotel;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;

import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;

import com.codename1.ui.Image;

import com.codename1.ui.Label;
import com.codename1.ui.URLImage;

import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
//import com.codename1.ui.util.ImageIO;

import com.codename1.ui.util.Resources;
import com.mycompany.marwa.MyApplication;

import java.util.ArrayList;

/**
 *
 * @author bhk
 */
public class AffichageListeHotel {

    Form f;
    private Form current;
    private Resources theme;
    Container c1;
    ImageViewer img;
    DetailsOffresInterface detailsForm;

    public AffichageListeHotel() {

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
               MyApplication.hi1.show();
            }
        });
        f.getToolbar().addCommandToRightSideMenu("Home", null, new ActionListener() {

            public void actionPerformed(ActionEvent evt) {

            }

        });
//             f.getToolbar().addCommandToRightSideMenu("About", null, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//               
//            }
//        });
//            f.getToolbar().addCommandToRightSideMenu("Show On Map", null, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//               
//            }
//        });

    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

    private void addItem(HotelOffer c) {

        Container C2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container C1 = new Container(new BorderLayout());

        Label nom = new Label("Hotel " + c.getTitre_offre_hotel());
        Label adr = new Label(" " + c.getDescription_offre_hotel());
        Button detail = new Button("Details");
        System.out.println("c.getPhoto_offre_hotel()aaaaaa: " + c.getPhoto_offre_hotel());
        detail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println(c.getId_offre_hotel());
                detailsForm = new DetailsOffresInterface(c.getId_offre_hotel());
            }
        });
        Label prix = new Label(" Price: " + c.getPrix());
        System.out.println(" " + c.getDate_debut_dispo());
        Form hi = new Form("Toolbar", new BoxLayout(BoxLayout.Y_AXIS));
        EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(hi.getWidth(), hi.getWidth() / 5, 0xffff0000), true);
        URLImage background = URLImage.createToStorage(placeholder, "400px-AGameOfThrones.jpg", "http://127.0.0.1/" + c.getPhoto_offre_hotel());

        int deviceWidth = Display.getInstance().getDisplayWidth();
        EncodedImage encImage = EncodedImage.createFromImage(placeholder, false);

        C2.add(background);
        C2.add(nom);
        C2.add(adr);
        //C2.setLeadComponent(detail);
        C2.add(prix);
        C2.add(detail);

        f.add(C2);
        f.refreshTheme();
    }

    public Resources getTheme() {
        return theme;
    }

    public void setTheme(Resources theme) {
        this.theme = theme;
    }

}
