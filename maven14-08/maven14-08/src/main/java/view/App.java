package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class App extends JFrame {
	JLabel selecione = new JLabel("Selecione qual cadastro irá realizar");
	JButton btnAluno = new JButton("Aluno");
	JButton btnCurso = new JButton("Curso");
	JButton btnDisciplina = new JButton ("Disciplina");
	JButton btnProfessor = new JButton ("Professor");

public App() {
	super("Cadastro");
	Container paine = this.getContentPane();
	
	paine.add(selecione);
	selecione.setBounds(120, 10, 300, 30);
	
	paine.add(btnAluno);
	btnAluno.setBounds(5, 45, 100, 40);
	btnAluno.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			cadAluno JanelaAluno = new cadAluno();
			dispose();
		}
	});
	
	paine.add(btnCurso);
	btnCurso.setBounds(115, 45, 100, 40);
	btnCurso.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			cadCurso JanelaCurso = new cadCurso();
			dispose();
		}
	});
	paine.add(btnDisciplina);
	btnDisciplina.setBounds(225, 45, 100, 40);
	btnDisciplina.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			cadDisciplina JanelaDisciplina = new cadDisciplina();
			dispose();
		}
	});
	paine.add(btnProfessor);
	btnProfessor.setBounds(335, 45, 100, 40);
	btnProfessor.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			cadProfessor JanelaProfessor = new cadProfessor();
			dispose();
		}
	});
	
	this.setLayout(null);
	this.setResizable(false);
	this.setVisible(true);
	this.setSize(455, 130);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setLocationRelativeTo(null);
}
	public static void main(String args[]) {
		App janelaApp = new App();
	}

}
