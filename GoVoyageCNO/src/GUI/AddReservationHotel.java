/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.ui.Button;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import java.util.Date;
/**
 *
 * @author Yosr Hafsi
 */
public class AddReservationHotel {
    Label departDate;
    Label arriveDate;
    Label nbChambre;
    Label nbAdulte;
    Label nbEnfant;
    Label nbNuit;
    Button reserver;
    
    public AddReservationHotel(int idHotel) {
        
        
        arriveDate = new Label("Date d'arrivée");
        departDate = new Label("Date de départ");
        nbChambre = new Label("Nombre de chmabre");
        nbAdulte = new Label("Nombre adulte");
        nbEnfant = new Label("Nombre enfant");
        nbNuit = new Label("Nuitées");
        reserver = new Button("Reserver");
        
        Form reservationHotel = new Form("Réservation Hoetl", BoxLayout.yLast());
        Picker datePickerDepart = new Picker();
        datePickerDepart.setType(Display.PICKER_TYPE_DATE);
        
        Picker datePickerArrive = new Picker();
        datePickerArrive.setType(Display.PICKER_TYPE_DATE);
        
        datePickerDepart.setDate(new Date());
        datePickerArrive.setDate(new Date());
        

        reservationHotel.add(departDate)
                .add(datePickerDepart)
                .add(arriveDate)
                .add(nbChambre)
                .add(nbAdulte)
                .add(nbEnfant)
                .add(nbNuit)
                .add(reserver);
        
        reservationHotel.show();
    }
}
