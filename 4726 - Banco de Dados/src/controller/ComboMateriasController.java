package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import model.Materias;

public class ComboMateriasController implements ActionListener {

	private JTextField tfCodigo;
	private JTextField tfNome;
	private JTextField tfCargaHoraria;
	private JComboBox<Materias> cbMaterias;
	private JRadioButton rdbtnExcluir;

	public ComboMateriasController(JTextField tfCodigo, JTextField tfNome,
			JTextField tfCargaHoraria, JComboBox<Materias> cbMaterias,
			JRadioButton rdbtnExcluir) {
		this.tfCodigo = tfCodigo;
		this.tfNome = tfNome;
		this.tfCargaHoraria = tfCargaHoraria;
		this.cbMaterias = cbMaterias;
		this.rdbtnExcluir = rdbtnExcluir;
	}

	public void actionPerformed(ActionEvent e) {
		if (cbMaterias.getItemCount() > 0) {
			if (!rdbtnExcluir.isSelected()) {
				Materias m = (Materias) cbMaterias.getSelectedItem();
				tfCodigo.setText(String.valueOf(m.getId()));
				tfNome.setText(m.getNome());
				tfCargaHoraria.setText(String.valueOf(m.getCargaHoraria()));
			}
		}
	}

}
