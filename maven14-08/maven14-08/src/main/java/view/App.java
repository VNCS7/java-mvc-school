package view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class App extends JFrame {

	JButton btnAluno = new JButton("Aluno");
	JButton btnCurso = new JButton("Curso");
	JButton btnDisciplina = new JButton ("Disciplina");
	JButton btnProfessor = new JButton ("Professor");
	
	JButton btnAltAluno = new JButton("Aluno");
	JButton btnAltCurso = new JButton("Curso");
	JButton btnAltDisciplina = new JButton ("Disciplina");
	JButton btnAltProfessor = new JButton ("Professor");
	
	JButton btnDelAluno = new JButton("Aluno");
	JButton btnDelCurso = new JButton("Curso");
	JButton btnDelDisciplina = new JButton ("Disciplina");
	JButton btnDelProfessor = new JButton ("Professor");
	
	JButton btnVerAluno = new JButton("Aluno");
	JButton btnVerCurso = new JButton("Curso");
	JButton btnVerDisciplina = new JButton ("Disciplina");
	JButton btnVerProfessor = new JButton ("Professor");
	
	JPanel cadPainel = new JPanel();
	JPanel altPainel = new JPanel();
	JPanel delPainel = new JPanel();
	JPanel verPainel = new JPanel();

public App() {
	super("Manipular Banco Escolar");
	Container paine = this.getContentPane();
	
	cadPainel.setLayout(null);
	paine.add(cadPainel);
	cadPainel.setBorder(javax.swing.BorderFactory.createTitledBorder("Cadastrar"));
	cadPainel.setBounds(5, 10, 300, 80);
	
	cadPainel.add(btnAluno);
	btnAluno.setBounds(new java.awt.Rectangle(45,20,100,20));
	btnAluno.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			CadAluno JanelaAluno = new CadAluno();
			dispose();
		}
	});

	cadPainel.add(btnCurso);
	btnCurso.setBounds(155, 20, 100, 20);
	btnCurso.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			CadCurso JanelaCurso = new CadCurso();
			dispose();
		}
	});
	
	cadPainel.add(btnDisciplina);
	btnDisciplina.setBounds(45, 50, 100, 20);
	btnDisciplina.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			CadDisciplina JanelaDisciplina = new CadDisciplina();
			dispose();
		}
	});
	
	cadPainel.add(btnProfessor);
	btnProfessor.setBounds(155, 50, 100, 20);
	btnProfessor.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			CadProfessor JanelaProfessor = new CadProfessor();
			dispose();
		}
	});
	
	paine.add(altPainel);
	altPainel.setLayout(null);
	altPainel.setBorder(javax.swing.BorderFactory.createTitledBorder("Alterar Cadastro"));
	altPainel.setBounds(350, 10, 300, 80);
	
	altPainel.add(btnAltAluno);
	btnAltAluno.setBounds(new java.awt.Rectangle(45,20,100,20));
	btnAltAluno.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			AtualizarAluno AtualizarAluno = new AtualizarAluno();
			dispose();
		}
	});
	
	altPainel.add(btnAltCurso);
	btnAltCurso.setBounds(new java.awt.Rectangle(155,20,100,20));
	btnAltCurso.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			AtualizarCurso AtualizarCurso = new AtualizarCurso();
			dispose();
		}
	});
	
	altPainel.add(btnAltDisciplina);
	btnAltDisciplina.setBounds(new java.awt.Rectangle(45,50,100,20));
	btnAltDisciplina.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			AtualizarDisciplina AtualizarDisciplina= new AtualizarDisciplina();
			dispose();
		}
	});
	
	altPainel.add(btnAltProfessor);
	btnAltProfessor.setBounds(new java.awt.Rectangle(155,50,100,20));
	btnAltProfessor.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			AtualizarProfessor AtualizarProfessor = new AtualizarProfessor();
			dispose();
		}
	});

	paine.add(delPainel);
	delPainel.setLayout(null);
	delPainel.setBorder(javax.swing.BorderFactory.createTitledBorder("Deletar cadastro"));
	delPainel.setBounds(5, 130, 300, 80);
	
	delPainel.add(btnDelAluno);
	btnDelAluno.setBounds(new java.awt.Rectangle(45,20,100,20));
	btnDelAluno.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			DeletarAluno DeletarAluno = new DeletarAluno();
			dispose();
		}
	});
	
	delPainel.add(btnDelCurso);
	btnDelCurso.setBounds(new java.awt.Rectangle(155,20,100,20));
	btnDelCurso.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			DeletarCurso DeletarCurso = new DeletarCurso();
			dispose();
		}
	});
	
	delPainel.add(btnDelDisciplina);
	btnDelDisciplina.setBounds(new java.awt.Rectangle(45,50,100,20));
	btnDelDisciplina.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			DeletarDisciplina DeletarDisciplina = new DeletarDisciplina();
			dispose();
		}
	});
	
	delPainel.add(btnDelProfessor);
	btnDelProfessor.setBounds(new java.awt.Rectangle(155,50,100,20));
	btnDelProfessor.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			DeletarProfessor DeletarProfessor = new DeletarProfessor();
			dispose();
		}
	});
	
	paine.add(verPainel);
	verPainel.setLayout(null);
	verPainel.setBorder(javax.swing.BorderFactory.createTitledBorder("Visualizar Cadastro"));
	verPainel.setBounds(350, 130, 300, 80);
	
	
	this.setLayout(null);
	this.setResizable(false);
	this.setVisible(true);
	this.setSize(660, 245);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setLocationRelativeTo(null);
}
	public static void main(String args[]) {
		App janelaApp = new App();
	}

}
