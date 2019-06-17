package com.mycompany.marwa;

import GUI.AddVolReservationScreen;
import GUI.DetailsOffresInterface;
import com.codename1.io.Log;
import com.codename1.ui.Form;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.io.NetworkEvent;
import static com.codename1.ui.CN.addNetworkErrorListener;
import static com.codename1.ui.CN.updateNetworkThreadCount;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Toolbar;
import com.codename1.ui.plaf.UIManager;

public class MyApplication {

    private Form current;
    private DetailsOffresInterface DetailsForm;
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

        // DetailsForm = new DetailsOffresInterface();
        AddVolReservationScreen form = new AddVolReservationScreen(0);

    }

//        Form detailOffre = new Form("Détails Offre", BoxLayout.y());
//        Form F1 = new Form("Details", BoxLayout.y());
//        for(int i=0 ; i<teams.size(); i++){
//          Team t = teams.get(i);
//       Container c = new Container(BoxLayout.x());
//           ImageViewer teamImg = new ImageViewer(theme.getImage(teams.get(i).getImg()));
//           Label nomTeam = new Label(teams.get(i).getNom());
//           c.addAll(teamImg, nomTeam);
//           c.setLeadComponent(nomTeam);
//           hi.add(c);
//           nomTeam.addPointerPressedListener(new ActionListener() {
//           @Override
//           public void actionPerformed(ActionEvent evt) {
//               F1.getToolbar().addCommandToLeftBar("Back", null, new ActionListener() {
//                   @Override
//                   public void actionPerformed(ActionEvent evt) {
//                       F1.removeAll();
//                       hi.show();
//                   }
//               });
//               
//               ImageViewer Img1 = new ImageViewer(theme.getImage(t.getImg()));
//               SpanLabel Sl = new SpanLabel(t.getDetail());
//               F1.add(Img1);
//               F1.add(Sl);
//               
//         
//               F1.show();
//           }
//           
//       });
////       }
//                detailOffre.show();
    public void stop() {
//        current = getCurrentForm();
//        if (current instanceof Dialog) {
//            ((Dialog) current).dispose();
//            current = getCurrentForm();
//        }
    }

    public void destroy() {
    }

}
