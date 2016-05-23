package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import persistence.IMateriasDao;
import persistence.MateriasDao;
import model.Materias;

public class BotaoMateriasController implements ActionListener {

	private JTextField tfCodigo;
	private JTextField tfNome;
	private JTextField tfCargaHoraria;
	private JComboBox<Materias> cbMaterias;
	private JRadioButton rdbtnCadastrar;
	private JRadioButton rdbtnEditar;
	private JRadioButton rdbtnExcluir;

	public BotaoMateriasController(JTextField tfCodigo, JTextField tfNome,
			JTextField tfCargaHoraria, JComboBox<Materias> cbMaterias,
			JRadioButton rdbtnCadastrar, JRadioButton rdbtnEditar,
			JRadioButton rdbtnExcluir) {

		this.tfCodigo = tfCodigo;
		this.tfCargaHoraria = tfCargaHoraria;
		this.tfNome = tfNome;
		this.cbMaterias = cbMaterias;
		this.rdbtnCadastrar = rdbtnCadastrar;
		this.rdbtnEditar = rdbtnEditar;
		this.rdbtnExcluir = rdbtnExcluir;
	}

	public void actionPerformed(ActionEvent e) {
		Materias m = new Materias();
		if (cbMaterias.getSelectedItem() != null) {
			m = (Materias) cbMaterias.getSelectedItem();
		}
		if (rdbtnExcluir.isSelected()) {
			excluir(m);
		} else {
			m.setNome(tfNome.getText());
			m.setCargaHoraria(Integer.parseInt(tfCargaHoraria.getText()));
			if (rdbtnCadastrar.isSelected()) {
				cadastrar(m);
			} else {
				if (rdbtnEditar.isSelected()) {
					editar(m);
				}
			}
		}
		limpaCampos();
	}

	private void limpaCampos() {
		tfCodigo.setText("");
		tfNome.setText("");
		tfCargaHoraria.setText("");
	}

	private void editar(Materias m) {
		IMateriasDao mDao = new MateriasDao();
		IMateriasController matCont = new MateriasController(cbMaterias);

		try {
			mDao.atualizaMateria(m);
			matCont.ListaMaterias();
			JOptionPane.showMessageDialog(null, "Materia atualizada",
					"SUCESSO", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void cadastrar(Materias m) {
		IMateriasDao mDao = new MateriasDao();
		try {
			mDao.insereMateria(m);
			JOptionPane.showMessageDialog(null, "Materia Inserida", "SUCESSO",
					JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO",
					JOptionPane.ERROR_MESSAGE);

		}
	}

	private void excluir(Materias m) {
		IMateriasDao mDao = new MateriasDao();
		IMateriasController matCont = new MateriasController(cbMaterias);
		try {
			mDao.excluiMateria(m);
			matCont.ListaMaterias();
			JOptionPane.showMessageDialog(null, "Materia Excluida", "SUCESSO",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO",
					JOptionPane.ERROR_MESSAGE);
		}

	}

}

