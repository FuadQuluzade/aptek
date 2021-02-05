package az.orient.aptek.main;

import az.orient.aptek.gui.LoginFrame;
import az.orient.aptek.gui.MainFrame;
import az.orient.aptek.pojo.Login;
import com.github.weisj.darklaf.LafManager;
import com.github.weisj.darklaf.theme.SolarizedDarkTheme;

public class Main {

    public static void main(String[] args) {
        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Windows".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }

            LafManager.setDecorationsEnabled(true);
            LafManager.installTheme(new SolarizedDarkTheme());

            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

}
