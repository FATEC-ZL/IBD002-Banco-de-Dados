package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Materias;

public interface IMateriasDao {

	public void insereMateria(Materias materia) throws SQLException;

	public void atualizaMateria(Materias materia) throws SQLException;

	public void excluiMateria(Materias materia) throws SQLException;

	public List<Materias> consultaMaterias() throws SQLException;

	public Materias consultaMateria(Materias materia) throws SQLException;
}
