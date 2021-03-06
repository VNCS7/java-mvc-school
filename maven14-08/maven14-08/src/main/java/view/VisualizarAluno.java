package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.AlunosJdbcDAO;
import controller.JdbUtil;

public class VisualizarAluno extends JFrame {
	JTable tabelaAluno = new JTable();
	JButton btnVoltar = new JButton("Voltar");
	
	public VisualizarAluno() {
		super("Visualizar Aluno");
		
		try {
			Connection conn = JdbUtil.getConnection();
			AlunosJdbcDAO alunosJDBC = new AlunosJdbcDAO(conn);
			DefaultTableModel tableVisualizar = new DefaultTableModel();
			tabelaAluno.setModel(alunosJDBC.visualizar());		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Container paine = this.getContentPane();
		paine.setLayout(null);	
		
		tabelaAluno.setBounds(0, 0, 1000, 530);
		paine.add(tabelaAluno);
		
		paine.add(btnVoltar);
		btnVoltar.setBounds(10, 535, 70, 30);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				App voltarApp = new App();
				dispose();
			}
		});
			
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
