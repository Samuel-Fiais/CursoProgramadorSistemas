package DAO;

import DTO.LoginDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import view.MainMenuScreen;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author seemg
 */
public class LoginDAO {
    
    Connection conn;
    
    public boolean verificatiuonLogin(LoginDTO objLoginDTO) {
        conn = new ConnectionDAO().connectBD();
        
        try {
            String sql = "select * from Login where login = ? and senha = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objLoginDTO.getLogin());
            pstm.setString(2, objLoginDTO.getSenha());
            Boolean res = pstm.executeQuery().next();
            return res;
            
        } catch (SQLException e) {
            System.out.println("Login Erro " + e.getMessage());
            return false;
        }
    }
    
}
