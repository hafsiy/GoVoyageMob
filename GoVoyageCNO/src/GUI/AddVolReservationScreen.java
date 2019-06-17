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
 * @author Lenovo
 */
public class AddVolReservationScreen {
    
    Label departDate;
    Label arriveDate;
    Label departTemp;
    Label arriveTemp;
    Button reserver;
    
    public AddVolReservationScreen(int idVol) {
        
        departDate = new Label("Date de départ");
        arriveDate = new Label("Date d'arrivée");
        departTemp = new Label("Temp  de départ");
        arriveTemp = new Label("Temp  d'arrivée");
        reserver = new Button("Reserver");
        
        Form reservationVol = new Form("Réservation Vol", BoxLayout.yLast());
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

        reservationVol.add(departDate)
                .add(datePickerDepart)
                .add(arriveDate)
                .add(datePickerArrive)
                .add(departTemp)
                .add(timePickerDepart)
                .add(arriveTemp)
                .add(timePickerArrive)
                .add(reserver);
        
        reservationVol.show();
    }
    
    
    
}
