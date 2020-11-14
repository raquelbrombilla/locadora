package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.bean.Filme;
import model.dao.FilmeDAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFCadastrarFilme extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtCategoria;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFCadastrarFilme frame = new JFCadastrarFilme();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFCadastrarFilme() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelCadastrarFilme = new JLabel("Cadastrar Filme ");
		labelCadastrarFilme.setFont(new Font("Tahoma", Font.BOLD, 17));
		labelCadastrarFilme.setBounds(28, 23, 149, 22);
		contentPane.add(labelCadastrarFilme);
		
		JLabel labelTitulo = new JLabel("T\u00EDtulo");
		labelTitulo.setBounds(28, 68, 46, 14);
		contentPane.add(labelTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(28, 85, 476, 20);
		contentPane.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		JLabel labelSinopse = new JLabel("Sinopse");
		labelSinopse.setBounds(28, 116, 46, 14);
		contentPane.add(labelSinopse);
		
		JLabel labelCategoria = new JLabel("Categoria");
		labelCategoria.setBounds(28, 257, 72, 14);
		contentPane.add(labelCategoria);
		
		txtCategoria = new JTextField();
		txtCategoria.setColumns(10);
		txtCategoria.setBounds(28, 275, 476, 20);
		contentPane.add(txtCategoria);
		
		JLabel lblTempo = new JLabel("Tempo");
		lblTempo.setBounds(28, 306, 46, 14);
		contentPane.add(lblTempo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 133, 476, 113);
		contentPane.add(scrollPane);
		
		JTextArea txtSinopse = new JTextArea();
		scrollPane.setViewportView(txtSinopse);
		
		JSpinner spTempo = new JSpinner();
		spTempo.setBounds(28, 324, 93, 32);
		contentPane.add(spTempo);
		
		JLabel lblImagem = new JLabel("Imagem");
		lblImagem.setBounds(169, 306, 46, 14);
		contentPane.add(lblImagem);
		
		JRadioButton rdbtn3d = new JRadioButton("3D");
		rdbtn3d.setBounds(225, 329, 63, 23);
		contentPane.add(rdbtn3d);
		
		JRadioButton rdbtn2d = new JRadioButton("2D");
		rdbtn2d.setBounds(169, 329, 53, 23);
		contentPane.add(rdbtn2d);
		
		ButtonGroup imagem = new ButtonGroup();
		imagem.add(rdbtn2d);
		imagem.add(rdbtn3d); 
				
		JLabel lblAudio = new JLabel("\u00C1udio");
		lblAudio.setBounds(322, 306, 46, 14);
		contentPane.add(lblAudio);
		
		JRadioButton rdbtnLegendado = new JRadioButton("Legendado");
		rdbtnLegendado.setBounds(400, 329, 104, 23);
		contentPane.add(rdbtnLegendado);
		
		JRadioButton rdbtnDublado = new JRadioButton("Dublado");
		rdbtnDublado.setBounds(322, 329, 72, 23);
		contentPane.add(rdbtnDublado);
		
		ButtonGroup dublado = new ButtonGroup();
		dublado.add(rdbtnLegendado);
		dublado.add(rdbtnDublado);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Filme f = new Filme();
				FilmeDAO dao = new FilmeDAO();
				
				f.setTitulo(txtTitulo.getText());
				f.setCategoria(txtCategoria.getText());
				f.setSinopse(txtSinopse.getText());
				f.setTempo(Integer.parseInt(spTempo.getValue().toString()));
				if(rdbtn2d.isSelected()){
					f.setImagem3d(false);
				} else if(rdbtn3d.isSelected()){
					f.setImagem3d(true);
				}
				
				if(rdbtnDublado.isSelected()){
					f.setDublado(true);
				} else if(rdbtnLegendado.isSelected()) {
					f.setDublado(false);
				}
				
				dao.create(f);
				
			}
		});
		btnCadastrar.setBounds(28, 387, 100, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(148, 387, 100, 23);
		contentPane.add(btnLimpar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(268, 387, 100, 23);
		contentPane.add(btnCancelar);
	}
}
