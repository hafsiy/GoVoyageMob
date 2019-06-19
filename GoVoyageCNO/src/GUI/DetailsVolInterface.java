/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Agence;
import Entity.HotelOffer;
import Entity.Vol;
import Service.ServiceOffre;
import Service.ServiceVol;
import com.codename1.components.ImageViewer;
import com.codename1.components.InteractionDialog;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import static com.codename1.ui.layouts.BorderLayout.center;
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
public class DetailsVolInterface {
    //Attributs 

    private Resources theme;
    private Form DetailsOffreForm;
    private Button reserverBtn;
    private SpanLabel descriptionSP;
    private ImageViewer ImageOffreIV;
    private Label titreOffreLB;
    private Button idHotelLB;

    private SpanLabel dateDebutOffre, dateFinOffre;
    private Label prix;
    private Container ImgC;
    private Container TitreC;
    private Container DetailsC;
    private Container DateC;
    private Container PrixC;
    private Container StarsC;
    private Container ReserverC;
    public static ArrayList<Vol> offer;

    public DetailsVolInterface(int volOfferId) {

        theme = UIManager.initFirstTheme("/theme");

        Form DetailsOffreForm = new Form("Détails Offres", BoxLayout.yLast());
        Form DetailsHotel = new Form("Détails Hotel", BoxLayout.yLast());

        DetailsOffreForm.getStyle().setBackgroundGradientStartColor(0xFFBCCA);
        DetailsOffreForm.getStyle().setBackgroundGradientEndColor(0xFFBCCA);

        ImgC = new Container(new FlowLayout());
        titreOffreLB = new Label("Titre offre");
        idHotelLB = new Button();
        prix = new Label();
        descriptionSP = new SpanLabel();
        dateDebutOffre = new SpanLabel();
        dateFinOffre = new SpanLabel();

        EncodedImage localimg = EncodedImage.createFromImage(MyApplication.theme.getImage("vol.png").scaled(400, 400), false);

        URLImage imgOffre = URLImage.createToStorage(localimg, "HotelLesJasmins.png", "http://127.0.0.1:8080/HotelLesJasmins.jpg");
        ImageViewer ImaggeOffreIV;
        ImageOffreIV = new ImageViewer();
        ImageOffreIV.setImage(imgOffre);
        descriptionSP.getTextAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE));
        titreOffreLB.getStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE));
        prix.getStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE));

        idHotelLB.getStyle().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE));

        dateDebutOffre.getTextAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE));
        dateFinOffre.getTextAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE));

        TitreC = new Container(BoxLayout.x());
        DetailsC = new Container(BoxLayout.yLast());
        TitreC.addAll(titreOffreLB);
        DateC = new Container(BoxLayout.y());
        PrixC = new Container(BoxLayout.x());
        PrixC.add(prix);
        DateC.addAll(dateDebutOffre, dateFinOffre);
        StarsC = new Container(BoxLayout.x());
        DetailsC.addAll(ImageOffreIV, idHotelLB, TitreC, descriptionSP, DateC, PrixC, StarsC);
        ReserverC = new Container(BoxLayout.y());
        reserverBtn = new Button("Réserver");
        reserverBtn.addActionListener(l -> {
            AddVolReservationScreen form = new AddVolReservationScreen(0);

        });

        ReserverC.add(reserverBtn);
        DetailsOffreForm.addAll(ImgC, DetailsC, ReserverC);
        ServiceVol service = new ServiceVol();
        offer = service.getDetailsVol(volOfferId);
        idHotelLB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                InteractionDialog id = new InteractionDialog("Détails Agence");
                id.setLayout(new BorderLayout());
                id.add(BorderLayout.CENTER, new Label("Hello Dialog"));
                Button close = new Button("Close");
                close.addActionListener((ee) -> id.dispose());
                DetailsAgenceInterface interfarce = new DetailsAgenceInterface(offer.get(0).getId_agence());
                id.addComponent(BorderLayout.SOUTH, close);
                id.add(BorderLayout.CENTER, interfarce.getDialogContainer());
                Dimension pre = id.getContentPane().getPreferredSize();
                //id.show(0, 0, Display.getInstance().getDisplayWidth() - (pre.getWidth() + pre.getWidth() / 6), 0);
                id.show(0, 0, 0, 0);
            }
        });

        if (offer.size() > 0) {

            titreOffreLB.setText("Départ : " + offer.get(0).getDepart());
            idHotelLB.setText("Voir détail Agence");
            descriptionSP.setText("Arrivée : " + offer.get(0).getArrivee());
            dateDebutOffre.setText("Heure début : " + offer.get(0).getHeureDepart());
            dateFinOffre.setText("Heure Fin : " + offer.get(0).getHeureArrive());
            //prix.setText("Prix : " + offer.get(0).getPrix());

        }

        Toolbar toolbar = new Toolbar();
        DetailsOffreForm.setToolBar(toolbar);
        toolbar.addCommandToLeftBar("back", theme.getImage("back.png"), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                MyApplication.hi1.show();
            }
        });

        DetailsOffreForm.show();

    }
    
    
    
}
