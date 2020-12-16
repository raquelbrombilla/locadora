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

import model.bean.Cliente;
import model.bean.Filme;
import model.dao.ClienteDAO;
import model.dao.FilmeDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFListarClientes extends JFrame {

	private JPanel contentPane;
	private JTable jtClientes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFListarClientes frame = new JFListarClientes();
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
	public JFListarClientes() {
		setTitle("Listar Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listar Clientes");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(10, 24, 151, 21);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 75, 549, 227);
		contentPane.add(scrollPane);
		
		jtClientes = new JTable();
		jtClientes.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"idCliente", "Nome", "CPF", "Telefone"
			}
		));
		scrollPane.setViewportView(jtClientes);
		
		JButton btnCadastrar = new JButton("Cadastrar Cliente");
		btnCadastrar.setBounds(10, 335, 137, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnAlterar = new JButton("Alterar Cliente");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//verificar se há cliente selecionado
				
				if(jtClientes.getSelectedRow() != -1) {
					JFAtualizarCliente ac = new JFAtualizarCliente((int)jtClientes.getValueAt(jtClientes.getSelectedRow(), 0));
					ac.setVisible(true);
						
				} else{
					JOptionPane.showMessageDialog(null, "Selecione um cliente!");
				}
				readJTable();
			}
		});
		btnAlterar.setBounds(157, 335, 136, 23);
		contentPane.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir Cliente");
		btnExcluir.setBounds(303, 335, 137, 23);
		contentPane.add(btnExcluir);
		
		readJTable();
	}

	public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) jtClientes.getModel();
		modelo.setNumRows(0);
		ClienteDAO cdao = new ClienteDAO();
		
		for(Cliente c : cdao.read()) {
			modelo.addRow(new Object[] {
					c.getIdCliente(),
					c.getNome(),
					c.getCpf(),
					c.getTelefone()
					
			});	
				
		}
	}

	
}
