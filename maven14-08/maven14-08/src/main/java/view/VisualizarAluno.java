package view;

import java.awt.Container;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.AlunosJdbcDAO;
import controller.JdbUtil;

public class VisualizarAluno extends JFrame {
	JTable tabelaAluno = new JTable();
	public VisualizarAluno() {
		super("Visualizar Aluno");
		
		try {
			Connection conn = JdbUtil.getConnection();
			AlunosJdbcDAO alunosJDBC = new AlunosJdbcDAO(conn);
			
			DefaultTableModel tableVisualizar = new DefaultTableModel();
			//tableVisualizar = alunosJDBC.visualizar();
		//	tabelaAluno.setModel(tableVisualizar);
			tabelaAluno.setModel(alunosJDBC.visualizar());

			
			
			
		}catch(Exception e) {
			e.printStackTrace();
			


			
			
		}
		
		Container paine = this.getContentPane();
		paine.setLayout(null);
		
		
		
		tabelaAluno.setBounds(0, 0, 1000, 600);
		paine.add(tabelaAluno);
		
		
		
		
		this.setResizable(false);
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(1000, 600);	
		this.setLocationRelativeTo(null);
	}
	
	public static void main(String args[]) {
		VisualizarAluno vmA = new VisualizarAluno();
	}

}
