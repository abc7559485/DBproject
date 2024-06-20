package DB_folder;

import java.awt.*;

public class Start {
    public static Connector conn;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    ConnectorGui gui = new ConnectorGui();
                    conn = new Connector(gui);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

    }
}
