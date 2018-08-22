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

import controller.AlunosJdbcDAO;
import controller.JdbUtil;
import model.Alunos;

public class DeletarAluno extends JFrame {
	
	JTextField txtID = new JTextField();
	JLabel ID = new JLabel("ID: ");
	
	JButton btnSalvar = new JButton("Salvar");
	JButton btnVoltar = new JButton("Voltar");
	
	 public DeletarAluno() {
		 super("Deletar um Aluno");
		 
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
					AlunosJdbcDAO alunosJdbcDao = new AlunosJdbcDAO(connection);
					
					alunosJdbcDao.deletar(idApagar);
					JOptionPane.showMessageDialog(new JFrame(), "Cadastro Efetuado com Sucesso!");
									
					for (int i=0; i < getContentPane().getComponentCount(); i++) {
						Component c = getContentPane().getComponent(i);
						
						if(c instanceof JTextField) {
							JTextField field = (JTextField) c;
							field.setText("");
						}	
					}
					
					}catch(Exception ex) {
						ex.printStackTrace();
						JOptionPane.showMessageDialog(new JFrame(), "ERRO! Cadastro não realizado");
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
		 DeletarAluno delAluno = new DeletarAluno();
	 }
	
}
