package DB_folder;

import java.sql.SQLException;

public class DBThread extends Thread {
    private final String sql;
    private final boolean isQuery;

    public DBThread(String sql, boolean isQuery) {
        this.sql = sql;
        this.isQuery = isQuery;
    }

    public void run() {
        try{
            if(!Connector.connected){
                ConnectLogin cl = new ConnectLogin();
            }
            if(isQuery){
                Connector.query(sql);
            }

        }
        catch(SQLException e){
            e.printStackTrace();
            Connector.gui.textArea_1.append("Error: Database operation failed!\n");
        }
//        finally {
//            try{
//                if(!isQuery && DB_folder.Connector.connected){
//                    DB_folder.Connector.disconnect();
//                }
//            }
//            catch(SQLException e){
//                e.printStackTrace();
//            }
//        }

    }
}
