import javax.swing.*;

public class LauncherApp{

    public static void main(String[] args){

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                new Gui().setVisible(true);
            }
        });
    }
}
