package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import model.Materias;

public class RadioMateriasController implements ActionListener {

	JTextField tfCodigo, tfNome, tfCargaHoraria;
	JLabel lblCodigo, lblNome, lblCargaHoraria, lblMaterias;
	JRadioButton rdbtnCadastrar, rdbtnEditar, rdbtnExcluir;
	JButton btnEnviar;
	JComboBox<Materias> cbMaterias;

	public RadioMateriasController(JTextField tfCodigo, JTextField tfNome, JTextField tfCargaHoraria, JLabel lblCodigo,
			JLabel lblNome, JLabel lblCargaHoraria, JLabel lblMaterias, JRadioButton rdbtnCadastrar,
			JRadioButton rdbtnEditar, JRadioButton rdbtnExcluir, JButton btnEnviar, JComboBox<Materias> cbMaterias) {
		this.tfCodigo = tfCodigo;
		this.tfCargaHoraria = tfCargaHoraria;
		this.tfNome = tfNome;
		this.lblCargaHoraria = lblCargaHoraria;
		this.lblCodigo = lblCodigo;
		this.lblNome = lblNome;
		this.lblMaterias = lblMaterias;
		this.rdbtnCadastrar = rdbtnCadastrar;
		this.rdbtnEditar = rdbtnEditar;
		this.rdbtnExcluir = rdbtnExcluir;
		this.btnEnviar = btnEnviar;
		this.cbMaterias = cbMaterias;
	}

	public void actionPerformed(ActionEvent e) {
		if (rdbtnCadastrar.isSelected()) {
			montaTelaCadastro();
		} else {
			IMateriasController matCont = new MateriasController(cbMaterias);
			try {
				matCont.ListaMaterias();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(null, e1.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}
			if (rdbtnEditar.isSelected()) {
				montaTelaEditar();
			} else {
				if (rdbtnExcluir.isSelected()) {
					montaTelaExcluir();
				}
			}
		}
	}

	private void limpaCampos() {
		tfCodigo.setText("");
		tfCargaHoraria.setText("");
		tfNome.setText("");
	}

	private void montaTelaCadastro() {
		limpaCampos();
		lblCodigo.setVisible(false);
		tfCodigo.setVisible(false);
		lblNome.setVisible(true);
		tfNome.setVisible(true);
		lblCargaHoraria.setVisible(true);
		tfCargaHoraria.setVisible(true);
		btnEnviar.setVisible(true);
		lblMaterias.setVisible(false);
		cbMaterias.setVisible(false);
	}

	private void montaTelaEditar() {
		limpaCampos();
		lblCodigo.setVisible(true);
		tfCodigo.setVisible(true);
		lblNome.setVisible(true);
		tfNome.setVisible(true);
		lblCargaHoraria.setVisible(true);
		tfCargaHoraria.setVisible(true);
		btnEnviar.setVisible(true);
		lblMaterias.setVisible(true);
		cbMaterias.setVisible(true);
	}

	private void montaTelaExcluir() {
		limpaCampos();
		lblCodigo.setVisible(false);
		tfCodigo.setVisible(false);
		lblNome.setVisible(false);
		tfNome.setVisible(false);
		lblCargaHoraria.setVisible(false);
		tfCargaHoraria.setVisible(false);
		btnEnviar.setVisible(true);
		lblMaterias.setVisible(true);
		cbMaterias.setVisible(true);
	}

}
