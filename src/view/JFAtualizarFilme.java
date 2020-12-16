package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.bean.Filme;
import model.dao.FilmeDAO;

public class JFAtualizarFilme extends JFrame {

	private JPanel contentPane;	
	private JTextField txtTitulo;
	private JTextField txtCategoria;
	
	private static int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFAtualizarFilme frame = new JFAtualizarFilme(id);
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
	public JFAtualizarFilme(int id) {
		setTitle("Alterar Filme");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel labelCadastrarFilme = new JLabel("Alterar Filme ");
		labelCadastrarFilme.setFont(new Font("Tahoma", Font.BOLD, 17));
		labelCadastrarFilme.setBounds(28, 23, 149, 22);
		contentPane.add(labelCadastrarFilme);
		
		JLabel lblNewLabel = new JLabel("ID do Filme");
		lblNewLabel.setBounds(169, 60, 79, 14);
		contentPane.add(lblNewLabel);
		
		FilmeDAO fdao = new FilmeDAO();
		Filme f = fdao.read(id);
		
		JLabel lblId = new JLabel("New label");
		lblId.setBounds(247, 60, 46, 14);
		contentPane.add(lblId);
		
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
		
		lblId.setText(String.valueOf(f.getIdFilme()));
		txtTitulo.setText(f.getTitulo());
		txtSinopse.setText(f.getSinopse());
		txtCategoria.setText(f.getCategoria());
		spTempo.setValue(f.getTempo());
		
		if(f.isImagem3d() == true) {
			rdbtn3d.setSelected(true);
		} else if(f.isImagem3d() == false) {
			rdbtn2d.setSelected(true);
		}
		
		if(f.isDublado() == true) {
			rdbtnDublado.setSelected(true);
		} else if(f.isDublado() == false) {
			rdbtnLegendado.setSelected(true);
		}
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Filme f = new Filme();
				FilmeDAO dao = new FilmeDAO();
				
				f.setIdFilme(Integer.parseInt(lblId.getText()));
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
				
				dao.update(f);
				
			}
		});
		btnAlterar.setBounds(28, 387, 100, 23);
		contentPane.add(btnAlterar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(148, 387, 100, 23);
		contentPane.add(btnLimpar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(268, 387, 100, 23);
		contentPane.add(btnCancelar);
		
		
	}
}
