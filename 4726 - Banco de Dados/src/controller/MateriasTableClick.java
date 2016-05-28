package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import persistence.MateriasDao;
import model.Materias;

public class MateriasTableClick implements MouseListener {

	private JTable tbMaterias;
	private DefaultTableModel model;

	public MateriasTableClick(JTable tbMaterias, DefaultTableModel model) {
		this.tbMaterias = tbMaterias;
		this.model = model;
	}

	@Override
	public void mouseClicked(MouseEvent evento) {
		int linha = tbMaterias.rowAtPoint(evento.getPoint());
		// int coluna = tbMaterias.columnAtPoint(evento.getPoint());
		int coluna = 0;
		Materias mat = new Materias();
		int id = (int) model.getValueAt(linha, coluna);
		mat.setId(id);
		MateriasDao mDao = new MateriasDao();
		try {
			mat = mDao.consultaMateria(mat);
			StringBuffer buffer = new StringBuffer();
			buffer.append("ID: ");
			buffer.append(mat.getId());
			buffer.append("\n");
			buffer.append("Nome: ");
			buffer.append(mat.getNome());
			buffer.append("\n");
			buffer.append("Carga Horaria: ");
			buffer.append(mat.getCargaHoraria());
			JOptionPane.showMessageDialog(null, buffer.toString(),
					mat.getNome(), JOptionPane.INFORMATION_MESSAGE);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
