package DAO;

import DTO.RegistrationDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class RegistrationDAO {
    
    Connection conn;
    
    public boolean register(RegistrationDTO objRegisterDTO) {
        conn = new ConnectionDAO().connectBD();
        
        try {
 
            String sql = "insert into Login(Id, Login, senha) values (null, ?, ?)";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objRegisterDTO.getLogin());
            pstm.setString(2, objRegisterDTO.getSenha());
            
            pstm.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            System.out.println("Cadastro Erro " + e.getMessage());
            return false;
        }
    }
    
}
