/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.HotelOffer;
import Service.ServiceOffre;
import com.codename1.components.ImageViewer;
import com.codename1.components.InteractionDialog;
import com.codename1.components.SpanLabel;
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
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BorderLayout;
import static com.codename1.ui.layouts.BorderLayout.center;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.marwa.MyApplication;
import java.util.ArrayList;
import javafx.scene.chart.PieChart;

/**
 *
 * @author lenovo
 */
public class DetailsOffresInterface {
    //Attributs 

    private Resources theme;
    private Form DetailsOffreForm;
    private Button reserverBtn;
    private SpanLabel descriptionSP;
    private ImageViewer ImageOffreIV;
    private Label titreOffreLB;
    private Label idHotelLB;

    private Label dateDebutOffre, dateFinOffre;
    private Label prix;
    private Container ImgC;
    private Container TitreC;
    private Container DetailsC;
    private Container DateC;
    private Container PrixC;
    private Container StarsC;
    private Container ReserverC;
    ArrayList<HotelOffer> offer;

    public DetailsOffresInterface() {

        theme = UIManager.initFirstTheme("/theme");

        Form DetailsOffreForm = new Form("Détails Offres", BoxLayout.yLast());
        Form DetailsHotel = new Form("Détails Hotel", BoxLayout.yLast());

        ImgC = new Container(new FlowLayout());
        titreOffreLB = new Label("Titre offre");
        idHotelLB = new Label();
        prix = new Label();
        dateDebutOffre = new Label();
        dateFinOffre = new Label();

        EncodedImage localimg = EncodedImage.createFromImage(MyApplication.theme.getImage("doghmene_marwa.jpg"), false);

        URLImage imgOffre = URLImage.createToStorage(localimg, "HotelLesJasmins.png", "http://127.0.0.1:8080/HotelLesJasmins.jpg");
        ImageViewer ImaggeOffreIV;
        ImageOffreIV = new ImageViewer();
        ImageOffreIV.setImage(imgOffre);
        descriptionSP = new SpanLabel();

        TitreC = new Container(BoxLayout.x());
        DetailsC = new Container(BoxLayout.yLast());
        TitreC.addAll(titreOffreLB);
        DateC = new Container(BoxLayout.x());
        PrixC = new Container(BoxLayout.x());
        PrixC.add(prix);
        DateC.addAll(dateDebutOffre, dateFinOffre);
        StarsC = new Container(BoxLayout.x());
        DetailsC.addAll(ImageOffreIV, idHotelLB, descriptionSP, DateC, PrixC, StarsC);
        ReserverC = new Container(BoxLayout.y());
        reserverBtn = new Button("Réserver");
        ReserverC.add(reserverBtn);
        DetailsOffreForm.addAll(ImgC, TitreC, DetailsC, ReserverC);
        ServiceOffre service = new ServiceOffre();
        offer = service.getDetailsOffre(1);
        idHotelLB.addPointerPressedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                InteractionDialog id = new InteractionDialog("Détails Hotel");

                id.setLayout(new BorderLayout());
                id.add(BorderLayout.CENTER, new Label("Hello Dialog"));
                Button close = new Button("Close");
                close.addActionListener((ee) -> id.dispose());
                DetailsHotelInterface interfarce = new DetailsHotelInterface(offer.get(0).getId_hotel());
                id.addComponent(BorderLayout.SOUTH, close);
                id.add(BorderLayout.CENTER, interfarce.getDialogContainer());
                Dimension pre = id.getContentPane().getPreferredSize();
                //id.show(0, 0, Display.getInstance().getDisplayWidth() - (pre.getWidth() + pre.getWidth() / 6), 0);
                id.show(0, 0, 0, 0);
            }
        });

        if (offer.size() > 0) {
            titreOffreLB.setText(offer.get(0).getTitre_offre_hotel());
            idHotelLB.setText((offer.get(0).getId_hotel()) + "");
            descriptionSP.setText(offer.get(0).getDescription_offre_hotel());
            dateDebutOffre.setText(offer.get(0).getDate_debut_dispo());
            dateFinOffre.setText(offer.get(0).getDate_fin_dispo());
            prix.setText(offer.get(0).getPrix());

        }
        DetailsOffreForm.show();

    }
}
