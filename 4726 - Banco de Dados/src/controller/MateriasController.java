package controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import model.Materias;
import persistence.IMateriasDao;
import persistence.MateriasDao;

public class MateriasController implements IMateriasController {

	private JComboBox<Materias> cbMaterias;

	public MateriasController() {
		super();
	}

	public MateriasController(JComboBox<Materias> cbMaterias) {
		this.cbMaterias = cbMaterias;
	}

	public void ListaMaterias() throws SQLException {
		List<Materias> listaMaterias = new ArrayList<Materias>();
		IMateriasDao mDao = new MateriasDao();
		listaMaterias = mDao.consultaMaterias();
		if (cbMaterias.getItemCount() > 0) {
			cbMaterias.removeAllItems();
		}
		if (listaMaterias != null) {
			for (Materias mat : listaMaterias) {
				cbMaterias.addItem(mat);
			}
		}
	}

}
