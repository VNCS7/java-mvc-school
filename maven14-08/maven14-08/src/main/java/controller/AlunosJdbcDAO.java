package controller;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

import model.Alunos;

public class AlunosJdbcDAO {
	private Connection conn;

	public AlunosJdbcDAO(Connection conn){
		this.conn = conn;
	}

	public void salvar(Alunos c) throws SQLException {
		String sql = "insert into aluno (nome,rg,cpf,endereco,bairro,cep,idCurso) values ('"+c.getNome()+"','"+c.getRg()+"','"+c.getCpf()+"','"+c.getEndereco()+"','"+c.getBairro()+"','"+c.getCep()+"','"+c.getIdCurso()+"')";
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
}
	public void deletar(int idSelect) throws SQLException {
		String sql = "delete from aluno where idAluno='"+idSelect+"'";		
		System.out.println(sql);
		PreparedStatement prepareStatement = this.conn.prepareStatement(sql);
		prepareStatement.executeUpdate();
		prepareStatement.close();
}

	public void atualizar(int idSelect, Alunos c) throws SQLException {
		String sql = "update aluno set nome='"+c.getNome()+"',rg='"+c.getRg()+"',cpf='"+c.getCpf()+"',endereco='"+c.getEndereco()+"',bairro='"+c.getBairro()+"',cep='"+c.getCep()+"',idCurso='"+c.getIdCurso()+"'where idAluno = '"+idSelect+"'";
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
	
	String query = "select * from aluno";
	
	try {
		PreparedStatement prepareStatement = this.conn.prepareStatement(query);
		ResultSet rs = prepareStatement.executeQuery();
		
			modeloTable.addColumn("ID");
			modeloTable.addColumn("NOME");
			modeloTable.addColumn("RG");
			modeloTable.addColumn("CPF");
			modeloTable.addColumn("ENDEREÇO");
			modeloTable.addColumn("CEP");
			modeloTable.addColumn("ID CURSO");
			
			while(rs.next()) {
				modeloTable.addRow(new String[] {rs.getString("idAluno"),rs.getString("nome"),rs.getString("rg"),rs.getString("cpf"),rs.getString("endereco"),rs.getString("cep"),rs.getString("idCurso")});
			}
			prepareStatement.close();
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	return modeloTable;
	}

}
