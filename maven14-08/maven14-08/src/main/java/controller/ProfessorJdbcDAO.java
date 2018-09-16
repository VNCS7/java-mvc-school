package controller;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Alunos;
import model.Professor;

public class ProfessorJdbcDAO {
	
	private Connection conn;

	public ProfessorJdbcDAO(Connection conn){
		this.conn = conn;
	}
	
	public void salvar(Professor c) throws SQLException {
		String sql = "insert into professor (nome,rg,cpf,endereco,bairro,cep,idCurso,idDisciplina) values ('"+c.getNome()+"','"+c.getRg()+"','"+c.getCpf()+"','"+c.getEndereco()+"','"+c.getBairro()+"','"+c.getCep()+"','"+c.getIdCurso()+"','"+c.getIdDisciplina()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
}
	public void deletar(int idSelect) throws SQLException {
		String sql = "delete from professor where idProfessor='"+idSelect+"'";		
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
}

	public void atualizar(int idSelect, Professor c) throws SQLException {
		String sql = "update professor set nome='"+c.getNome()+"',endereco='"+c.getEndereco()+"',bairro='"+c.getBairro()+"',idCurso='"+c.getIdCurso()+"',idDisciplina='"+c.getIdDisciplina()+"'where idProfessor = '"+idSelect+"'";
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
	
	String query = "select * from professor";
	
	try {
		PreparedStatement prepareStatement = this.conn.prepareStatement(query);
		ResultSet rs = prepareStatement.executeQuery();
		
			modeloTable.addColumn("ID");
			modeloTable.addColumn("NOME");
			modeloTable.addColumn("RG");
			modeloTable.addColumn("CPF");
			modeloTable.addColumn("ENDEREÇO");
			modeloTable.addColumn("BAIRRO");
			modeloTable.addColumn("CEP");
			modeloTable.addColumn("ID CURSO");
			modeloTable.addColumn("ID DISCIPLINA");
			
			while(rs.next()) {
				modeloTable.addRow(new String[] {rs.getString("idProfessor"),rs.getString("nome"),rs.getString("rg"),rs.getString("cpf"),rs.getString("endereco"),rs.getString("bairro"),rs.getString("cep"),rs.getString("idCurso"),rs.getString("idDisciplina")});
			}
			prepareStatement.close();
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	return modeloTable;
	}
}

