package DB_folder;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ResultSetTableModel extends DefaultTableModel {
    public ResultSetTableModel(ResultSet rs) throws SQLException {
        super();
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        for(int i = 1; i <= columnCount; i++) {
            addColumn(metaData.getColumnName(i));
        }

        while(rs.next()) {
            Object[] rowData = new Object[columnCount];
            for(int i = 1; i <= columnCount; i++) {
                rowData[i - 1] = rs.getObject(i);
            }
            addRow(rowData);
        }
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
