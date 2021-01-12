package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.bean.Filme;
import model.dao.FilmeDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFListarFilmes extends JFrame {

	private JPanel contentPane;
	private JTable jtFilmes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFListarFilmes frame = new JFListarFilmes();
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
	public JFListarFilmes() {
		setTitle("Listar Filmes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblListarFilmes = new JLabel("Listar Filmes");
		lblListarFilmes.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblListarFilmes.setBounds(10, 24, 158, 21);
		contentPane.add(lblListarFilmes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 589, 242);
		contentPane.add(scrollPane);
		
		jtFilmes = new JTable();
		jtFilmes.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"idFilme", "T\u00EDtulo", "Categoria", "Tempo"
			}
		));
		scrollPane.setViewportView(jtFilmes);
		
		JButton btnCadastrar = new JButton("Cadastrar Filme");
		btnCadastrar.setBounds(10, 338, 130, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnAlterar = new JButton("Alterar Filme");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//verificar se há filme selecionado
				
				if(jtFilmes.getSelectedRow() != -1) {
					JFAtualizarFilme af = new JFAtualizarFilme((int)jtFilmes.getValueAt(jtFilmes.getSelectedRow(), 0));
					af.setVisible(true);
						
				} else{
					JOptionPane.showMessageDialog(null, "Selecione um filme!");
				}
				readJTable();
			}
		});
		btnAlterar.setBounds(163, 338, 118, 23);
		contentPane.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir Filme");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(jtFilmes.getSelectedColumn() != -1) {
					int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o filme selecionado?","Exclusão", JOptionPane.YES_NO_OPTION);
					
					if(opcao == 0) {
						FilmeDAO dao = new FilmeDAO();
						Filme f = new Filme();
						f.setIdFilme((int) jtFilmes.getValueAt(jtFilmes.getSelectedRow(), 0));
						dao.delete(f);
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um filme!");					
				}
				readJTable();	
			}
		});
		btnExcluir.setBounds(301, 338, 130, 23);
		contentPane.add(btnExcluir);
		
		readJTable();
	}
	
	public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) jtFilmes.getModel();
		modelo.setNumRows(0);
		FilmeDAO fdao = new FilmeDAO();
		
		for(Filme f : fdao.read()) {
			modelo.addRow(new Object[] {
					f.getIdFilme(),
					f.getTitulo(),
					f.getCategoria(),
					f.getTempo()
					
			});	
				
		}
	}

}
