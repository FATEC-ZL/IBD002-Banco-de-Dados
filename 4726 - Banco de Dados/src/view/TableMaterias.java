package view;

import java.awt.EventQueue;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.MateriasTableClick;
import controller.MateriasTableController;
import controller.MateriasTableModel;

public class TableMaterias extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tbMaterias;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableMaterias frame = new TableMaterias();
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
	public TableMaterias() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 434, 262);
		contentPane.add(scrollPane);

		tbMaterias = new JTable();
		scrollPane.setViewportView(tbMaterias);
		Object[][] dados = new Object[][] {};
		String[] cabecalho = new String[3];

		cabecalho[0] = "ID";
		cabecalho[1] = "Nome";
		cabecalho[2] = "Carga Horaria";

		DefaultTableModel model = new MateriasTableModel(dados, cabecalho);

		tbMaterias.setModel(model);
		tbMaterias.getColumnModel().getColumn(0).setPreferredWidth(62);
		tbMaterias.getColumnModel().getColumn(1).setPreferredWidth(418);
		tbMaterias.getColumnModel().getColumn(2).setPreferredWidth(121);

		MateriasTableController tmController = new MateriasTableController(
				model);
		try {
			tmController.preencheTable();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO",
					JOptionPane.ERROR_MESSAGE);
		}

		MouseListener evento = new MateriasTableClick(tbMaterias, model);
		tbMaterias.addMouseListener(evento);
	}
}
