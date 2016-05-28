package controller;

import java.sql.SQLException;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.Materias;
import persistence.IMateriasDao;
import persistence.MateriasDao;

public class MateriasTableController {

	private DefaultTableModel model;

	public MateriasTableController(DefaultTableModel model) {
		this.model = model;
	}

	public void preencheTable() throws SQLException {
		IMateriasDao mDao = new MateriasDao();
		List<Materias> listaMaterias = mDao.consultaMaterias();
		model.setRowCount(0);
		
		for (Materias m : listaMaterias) {
			Object[] linha = new Object[3];
			linha[0] = m.getId();
			linha[1] = m.getNome();
			linha[2] = m.getCargaHoraria();
			model.addRow(linha);
		}
	}
}
