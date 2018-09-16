package controller;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Alunos;
import model.Curso;

public class CursoJdbcDAO {
	private Connection conn;

	public CursoJdbcDAO(Connection conn){
		this.conn = conn;
	}
	
	public void salvar(Curso curso) throws SQLException{
	String sql = "insert into curso (nome,cargaHoraria) values ('"+curso.getNome()+"','"+curso.getCargaHoraria()+"')";
	System.out.println(sql);
	PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
	prepareStatement.executeUpdate();
	prepareStatement.close();
}
	public void deletar(int idSelect) throws SQLException {
	String sql = "delete from curso where idCurso='"+idSelect+"'";		
	System.out.println(sql);
	PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
	prepareStatement.executeUpdate();
	prepareStatement.close();
}
	public void atualizar(int idSelect, Curso curso) throws SQLException {
	String sql = "update curso set nome='"+curso.getNome()+"',cargaHoraria='"+curso.getCargaHoraria()+"'where idCurso = '"+idSelect+"'";
	System.out.println(sql);
	PreparedStatement prepareStatement;
	try {
		prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
        prepareStatement.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}		
}
	public DefaultTableModel visualizar() throws Exception{
		
		DefaultTableModel modeloTable = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
	};
	
	String query = "select * from curso";
	
	try {
		PreparedStatement prepareStatement = this.conn.prepareStatement(query);
		ResultSet rs = prepareStatement.executeQuery();
		
			modeloTable.addColumn("ID");
			modeloTable.addColumn("NOME");
			modeloTable.addColumn("CARGA HORARIA");
			
			while(rs.next()) {
				modeloTable.addRow(new String[] {rs.getString("idCurso"),rs.getString("nome"),rs.getString("cargaHoraria")});
			}
			prepareStatement.close();
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	return modeloTable;
	}

}
