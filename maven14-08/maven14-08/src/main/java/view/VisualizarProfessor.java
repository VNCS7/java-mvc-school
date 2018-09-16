package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.DisciplinaJdbcDAO;
import controller.JdbUtil;
import controller.ProfessorJdbcDAO;

public class VisualizarProfessor extends JFrame {
	JTable tabelaDisciplina = new JTable();
	JButton btnVoltar = new JButton("Voltar");
	
	public VisualizarProfessor() {
		super("Visualizar Professor");
		
		try {
			Connection conn = JdbUtil.getConnection();
			ProfessorJdbcDAO professoressJDBC = new ProfessorJdbcDAO(conn);
			DefaultTableModel tableVisualizar = new DefaultTableModel();
			tabelaDisciplina.setModel(professoressJDBC.visualizar());		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Container paine = this.getContentPane();
		paine.setLayout(null);	
		
		tabelaDisciplina.setBounds(0, 0, 1000, 530);
		paine.add(tabelaDisciplina);
		
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
		VisualizarProfessor vmP = new VisualizarProfessor();
	}

}
