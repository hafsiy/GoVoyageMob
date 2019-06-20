/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entity.Agence;
import Entity.VolReservation;
import Service.ServiceAgence;
import Service.ServiceReservation;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.mycompany.marwa.MyApplication;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Lenovo
 */
public class AddVolReservationScreen {

    Label departDate;
    Label arriveDate;
    Label departTemp;
    Label arriveTemp;
    Button reserver;
    ImageViewer planeLogo;
    private Resources theme;

    public AddVolReservationScreen(int idVol) {

        departDate = new Label("Date de départ");
        arriveDate = new Label("Date d'arrivée");
        departTemp = new Label("Temp  de départ");
        arriveTemp = new Label("Temp  d'arrivée");
        reserver = new Button("Confirmer");
        theme = UIManager.initFirstTheme("/theme");
        planeLogo = new ImageViewer(theme.getImage("plane.png").scaled(400, 400));

        Form reservationVol = new Form("Réservation Vol", BoxLayout.yLast());

        Toolbar toolbar = new Toolbar();
        reservationVol.setToolBar(toolbar);
        toolbar.addCommandToLeftBar("back", theme.getImage("back.png"), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                DetailsOffresInterface item = new DetailsOffresInterface(DetailsOffresInterface.offer.get(0).getId_offre_hotel());

            }
        });

        Picker datePickerDepart = new Picker();
        datePickerDepart.setType(Display.PICKER_TYPE_DATE);

        Picker datePickerArrive = new Picker();
        datePickerArrive.setType(Display.PICKER_TYPE_DATE);

        Picker timePickerDepart = new Picker();
        timePickerDepart.setType(Display.PICKER_TYPE_TIME);

        Picker timePickerArrive = new Picker();
        timePickerArrive.setType(Display.PICKER_TYPE_TIME);

        datePickerDepart.setDate(new Date());
        datePickerArrive.setDate(new Date());

        timePickerDepart.setTime(10 * 60); // 10:00AM = Minutes since midnight
        timePickerArrive.setTime(10 * 60); // 10:00AM = Minutes since midnight

        reservationVol
                .add(planeLogo)
                .add(departDate)
                .add(datePickerDepart)
                .add(arriveDate)
                .add(datePickerArrive)
                .add(departTemp)
                .add(timePickerDepart)
                .add(arriveTemp)
                .add(timePickerArrive)
                .add(reserver);
        reserver.addActionListener(l -> {

            ServiceReservation service = new ServiceReservation();
            VolReservation reservation = new VolReservation(0,
                    MyApplication.listuser.get(0).getId_user(),
                    DetailsVolInterface.offer.get(0).getId_vol(),
                    datePickerDepart.getValue().toString(),
                    datePickerArrive.getValue().toString(),
                    timePickerDepart.getValue().toString(),
                    timePickerArrive.getValue().toString());
            System.out.println("id vol:" + reservation.getId_vol());
            System.out.println("id user:" + reservation.getId_user());
            System.out.println("id user:" + datePickerDepart.getValue().toString());
            System.out.println("id user:" + datePickerArrive.getValue().toString());
            System.out.println("id user:" + timePickerDepart.getValue().toString());
            System.out.println("id user:" + timePickerArrive.getValue().toString());
            boolean isAdded = service.addVolReservation(reservation);

            if (isAdded) {
                Dialog.show("succès de l'opération", "votre réservation est bien enregistrée", "OK", "Cancel");
            }

        });

        reservationVol.show();
    }

}
