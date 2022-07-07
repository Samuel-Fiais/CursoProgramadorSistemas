package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectionDAO {
    public Connection connectBD() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/app", "root", "20012006");
            return conn;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Deu erro " + e.getMessage());
            return null;
        }
    }
    
}
