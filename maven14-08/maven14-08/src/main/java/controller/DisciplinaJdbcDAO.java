package controller;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.*;

public class DisciplinaJdbcDAO {
	private Connection conn;
	
	public DisciplinaJdbcDAO(Connection conn){
		this.conn = conn;
	}
	
	public void salvar(Disciplina disciplina) throws SQLException{
		String sql = "insert into disciplina (nomeDisciplina,idCurso,cargaHoraria) values ('"+disciplina.getNomeDisciplina()+"','"+disciplina.getIdCurso()+"','"+disciplina.getCargaHoraria()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	public void deletar(int idSelect) throws SQLException {
		String sql = "delete from disciplina where idDisciplina='"+idSelect+"'";		
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
	}
	//NECESSITA DE ALTERAÇÕES (FALTANDO COLUNAS NA QUERY)
	public void atualizar(int idSelect, Disciplina disciplina) throws SQLException {
		String sql = "update disciplina set nomeDisciplina='"+disciplina.getNomeDisciplina()+"',cargaHoraria='"+disciplina.getCargaHoraria()+"'where idDisciplina = '"+idSelect+"'";
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
	
	String query = "select * from disciplina";
	
	try {
		PreparedStatement prepareStatement = this.conn.prepareStatement(query);
		ResultSet rs = prepareStatement.executeQuery();
		
			modeloTable.addColumn("ID");
			modeloTable.addColumn("ID CURSO");
			modeloTable.addColumn("NOME");
			modeloTable.addColumn("CARGA HORARIA");
			
			while(rs.next()) {
				modeloTable.addRow(new String[] {rs.getString("idDisciplina"),rs.getString("idCurso"),rs.getString("nomeDisciplina"),rs.getString("cargaHoraria")});
			}
			prepareStatement.close();
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	return modeloTable;
	}
}
