package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bean.Cliente;

public class ClienteDAO {
	
	public static void create(Cliente c) {
		
		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		
		try {
			stmt = con.prepareStatement("INSERT INTO CLIENTE(nome, cpf, telefone, endereco) VALUES (?, ?, ?, ?)");
			stmt.setString(1, c.getNome());
			stmt.setString(2, c.getCpf());
			stmt.setString(3, c.getTelefone());
			stmt.setString(4, c.getEndereco());
			
			stmt.executeUpdate(); 
			JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");
			
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar: " + e);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
			
		}
	}
}
