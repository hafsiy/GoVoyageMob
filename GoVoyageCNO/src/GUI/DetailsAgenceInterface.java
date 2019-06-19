/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Agence;
import Entity.HotelDetails;
import Entity.HotelOffer;
import Service.ServiceAgence;
import Service.ServiceHotel;
import Service.ServiceOffre;
import com.codename1.components.ImageViewer;
import com.codename1.components.InteractionDialog;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
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
public class DetailsAgenceInterface {

    private Resources theme;
    private Form DetailsHotelForm;
    private Button retournerBtn;
    private Label AdresseSP;
    private ImageViewer ImageHotelIV;
    private Label starsLB;
    private Label nomLB;
    private Label prixLB;
    private Label chambrelLB;

    private Container ImgHC;
    private Container DetailsC;
    private Container RetournerC;
    public Container dialogContainer;

    public DetailsAgenceInterface(int idAgence) {

        theme = UIManager.initFirstTheme("/theme");

        Form DetailsHotelForm = new Form("Détails Hotel", BoxLayout.yLast());

        ImgHC = new Container(new FlowLayout());
        nomLB = new Label();

        AdresseSP = new Label();

        nomLB.getStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE));
        AdresseSP.getStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE));

        EncodedImage localimg = EncodedImage.createFromImage(MyApplication.theme.getImage("vol.png").scaled(400, 400), false);

        URLImage imgHotel = URLImage.createToStorage(localimg, "LesJasmins1.png", "http://127.0.0.1:8080/LesJasmins1.jpg");
        ImageViewer ImageHotelIV;
        ImageHotelIV = new ImageViewer();
        ImageHotelIV.setImage(imgHotel);
        ServiceAgence service = new ServiceAgence();
        System.out.println(idAgence);
        ArrayList<Agence> agence = service.getDetailsAgence(idAgence);

        if (agence.size() > 0) {
            System.out.println(agence.size());
            nomLB.setText("Nom Agence  : " + agence.get(0).getNom_agence());
            AdresseSP.setText("Adresse Agence  :" + agence.get(0).getAdresse_agence());

        }
        DetailsC = new Container(BoxLayout.y());
        DetailsC.addAll(ImageHotelIV, nomLB, AdresseSP);
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
