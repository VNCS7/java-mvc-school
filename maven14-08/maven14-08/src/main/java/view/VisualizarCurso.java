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
import controller.CursoJdbcDAO;
import controller.JdbUtil;

public class VisualizarCurso extends JFrame {
	JTable tabelaCurso = new JTable();
	JButton btnVoltar = new JButton("Voltar");
	
	public VisualizarCurso() {
		super("Visualizar Curso");
		
		try {
			Connection conn = JdbUtil.getConnection();
			CursoJdbcDAO cursosJDBC = new CursoJdbcDAO(conn);
			DefaultTableModel tableVisualizar = new DefaultTableModel();
			tabelaCurso.setModel(cursosJDBC.visualizar());		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		Container paine = this.getContentPane();
		paine.setLayout(null);	
		
		tabelaCurso.setBounds(0, 0, 1000, 530);
		paine.add(tabelaCurso);
		
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
		VisualizarCurso vmC = new VisualizarCurso();
	}

}
