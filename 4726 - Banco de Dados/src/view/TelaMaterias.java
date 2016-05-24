package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JComboBox;

import controller.ComboMateriasController;
import controller.RadioMateriasController;

public class TelaMaterias extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfCodigo;
	private JTextField tfNome;
	private JTextField tfCargaHoraria;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaMaterias frame = new TelaMaterias();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TelaMaterias() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCodigo = new JLabel("C\u00F3digo: ");
		lblCodigo.setBounds(10, 94, 46, 14);
		contentPane.add(lblCodigo);
		lblCodigo.setVisible(false);

		tfCodigo = new JTextField();
		tfCodigo.setBounds(105, 91, 86, 20);
		contentPane.add(tfCodigo);
		tfCodigo.setColumns(10);
		tfCodigo.setVisible(false);
		tfCodigo.setEditable(false);

		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setBounds(10, 134, 46, 14);
		contentPane.add(lblNome);
		lblNome.setVisible(false);

		tfNome = new JTextField();
		tfNome.setBounds(105, 130, 319, 20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		tfNome.setVisible(false);

		JLabel lblCargaHoraria = new JLabel("Carga Horária: ");
		lblCargaHoraria.setBounds(10, 174, 86, 14);
		contentPane.add(lblCargaHoraria);
		lblCargaHoraria.setVisible(false);

		tfCargaHoraria = new JTextField();
		tfCargaHoraria.setBounds(105, 170, 51, 20);
		contentPane.add(tfCargaHoraria);
		tfCargaHoraria.setColumns(10);
		tfCargaHoraria.setVisible(false);

		JRadioButton rdbtnCadastrar = new JRadioButton("Cadastrar");
		rdbtnCadastrar.setBounds(10, 7, 109, 23);
		contentPane.add(rdbtnCadastrar);

		JRadioButton rdbtnEditar = new JRadioButton("Editar");
		rdbtnEditar.setBounds(166, 7, 109, 23);
		contentPane.add(rdbtnEditar);

		JRadioButton rdbtnExcluir = new JRadioButton("Excluir");
		rdbtnExcluir.setBounds(319, 7, 109, 23);
		contentPane.add(rdbtnExcluir);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnExcluir);
		bg.add(rdbtnEditar);
		bg.add(rdbtnCadastrar);

		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.setBounds(10, 227, 414, 23);
		contentPane.add(btnEnviar);
		btnEnviar.setVisible(false);

		JLabel lblMaterias = new JLabel("Mat\u00E9rias: ");
		lblMaterias.setBounds(10, 48, 86, 14);
		contentPane.add(lblMaterias);
		lblMaterias.setVisible(false);

		JComboBox cbMaterias = new JComboBox();
		cbMaterias.setBounds(105, 45, 319, 20);
		contentPane.add(cbMaterias);
		cbMaterias.setVisible(false);

		RadioMateriasController radioController = new RadioMateriasController(
				tfCodigo, tfNome, tfCargaHoraria, lblCodigo, lblNome,
				lblCargaHoraria, lblMaterias, rdbtnCadastrar, rdbtnEditar,
				rdbtnExcluir, btnEnviar, cbMaterias);
		rdbtnCadastrar.addActionListener(radioController);
		rdbtnEditar.addActionListener(radioController);
		rdbtnExcluir.addActionListener(radioController);

		//carrega combo e campos
		ComboMateriasController comboController = new ComboMateriasController(
				tfCodigo, tfNome, tfCargaHoraria, cbMaterias, rdbtnExcluir);
		
		cbMaterias.addActionListener(comboController);
	}
}
