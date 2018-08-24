package view;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.CursoJdbcDAO;
import controller.JdbUtil;
import controller.ProfessorJdbcDAO;

public class DeletarCurso extends JFrame{
	JTextField txtID = new JTextField();
	JLabel ID = new JLabel("ID: ");
	
	JButton btnSalvar = new JButton("Salvar");
	JButton btnVoltar = new JButton("Voltar");
	
	public DeletarCurso() {
		super("Delete um curso");
		Container paine = this.getContentPane();

		paine.add(ID);
		paine.add(txtID);	
		ID.setBounds(10, 15, 45, 30);
		txtID.setBounds(90, 15, 225, 30);
		
		paine.add(btnSalvar);
		btnSalvar.setBounds(20, 60, 130, 30);
		btnSalvar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
				int idApagar = Integer.parseInt(txtID.getText());
				Connection connection = JdbUtil.getConnection();
				CursoJdbcDAO cursoJdbcDao = new CursoJdbcDAO(connection);
				
				cursoJdbcDao.deletar(idApagar);
				JOptionPane.showMessageDialog(new JFrame(), "Cadastro Removido com Sucesso!");
								
				for (int i=0; i < getContentPane().getComponentCount(); i++) {
					Component c = getContentPane().getComponent(i);
					
					if(c instanceof JTextField) {
						JTextField field = (JTextField) c;
						field.setText("");
					}	
				}
				
				}catch(Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(new JFrame(), "ERRO! Exclusão não realizada");
				}
				
			}
		});
		
		paine.add(btnVoltar);
		btnVoltar.setBounds(170, 60, 130, 30);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				App voltarApp = new App();
				dispose();
			}
		});
		
		
		
		
		
		
		
		
		
		
		
		

		this.setResizable(false);
		this.setLayout(null);
		this.setVisible(true);
		this.setSize(340, 130);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	
	public static void main(String args[]) {
		DeletarProfessor delProf = new DeletarProfessor();
	}

}
