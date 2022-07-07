/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.LoginDTO;
import DTO.RemoveDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class RemoveDAO {
    Connection conn = new ConnectionDAO().connectBD();
    public boolean remove(RemoveDTO objRemoveDTO) {
        try {
            LoginDTO objTester = new LoginDTO();
            objTester.setLogin(objRemoveDTO.getLogin());
            objTester.setSenha(objRemoveDTO.getSenha());
            boolean permission = new LoginDAO().verificatiuonLogin(objTester);
            if (permission == true) {
                String sql = "delete from Login where login = ?";
                PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.setString(1, objRemoveDTO.getLogin());
                pstm.executeUpdate();
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não encontrado");
                return false;
            }
            
        } catch (SQLException e) {
            return false;
        }
    }
}
