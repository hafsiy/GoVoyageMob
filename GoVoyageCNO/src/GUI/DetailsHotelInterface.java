/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.HotelDetails;
import Entity.HotelOffer;
import Service.ServiceHotel;
import Service.ServiceOffre;
import com.codename1.components.ImageViewer;
import com.codename1.components.InteractionDialog;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.marwa.MyApplication;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class DetailsHotelInterface {

    private Resources theme;
    private Form DetailsHotelForm;
    private Button retournerBtn;
    private SpanLabel AdresseSP;
    private ImageViewer ImageHotelIV;
    private Label starsLB;
    private Label nomLB;
    private Label prixLB;
    private Label chambrelLB;

    private Container ImgHC;
    private Container DetailsC;
    private Container RetournerC;
    public Container dialogContainer;

    public DetailsHotelInterface(int idHotel) {

        theme = UIManager.initFirstTheme("/theme");

        Form DetailsHotelForm = new Form("Détails Hotel", BoxLayout.yLast());

        ImgHC = new Container(new FlowLayout());
        starsLB = new Label();
        chambrelLB = new Label();
        nomLB = new Label();
        prixLB = new Label();
        AdresseSP = new SpanLabel();

        EncodedImage localimg = EncodedImage.createFromImage(MyApplication.theme.getImage("doghmene_marwa.jpg"), false);

        URLImage imgHotel = URLImage.createToStorage(localimg, "LesJasmins1.png", "http://127.0.0.1:8080/LesJasmins1.jpg");
        ImageViewer ImageHotelIV;
        ImageHotelIV = new ImageViewer();
        ImageHotelIV.setImage(imgHotel);
        ServiceHotel service = new ServiceHotel();
        System.out.println(idHotel);
        ArrayList<HotelDetails> hotel = service.getDetailsOffre(idHotel);

        if (hotel.size() > 0) {
            System.out.println(hotel.size());
            AdresseSP.setText("Adresse : " + hotel.get(0).getAdresse_hotel());
            nomLB.setText((hotel.get(0).getNom_hotel()));
            chambrelLB.setText("Nombre de chambre : " + (hotel.get(0).getChambre()) + "");
            starsLB.setText("Catégorie : " + (hotel.get(0).getStars_hotel()) + "");
            prixLB.setText("Prix moyen(hors la haute saison) : " + (hotel.get(0).getPrix()) + "");

        }
        DetailsC = new Container(BoxLayout.y());
        DetailsC.addAll(ImageHotelIV, AdresseSP, chambrelLB, prixLB, starsLB);
        RetournerC = new Container(BoxLayout.y());
        retournerBtn = new Button("Retourner");
        RetournerC.add(retournerBtn);
        DetailsHotelForm.addAll(ImgHC, RetournerC);
        retournerBtn.addPointerPressedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                DetailsHotelForm.show();

            }
        });

//        DetailsHotelForm.show();
        dialogContainer = DetailsC;

    }

    public Container getDialogContainer() {
        return dialogContainer;
    }

    public void setDialogContainer(Container dialogContainer) {
        this.dialogContainer = dialogContainer;
    }

}
