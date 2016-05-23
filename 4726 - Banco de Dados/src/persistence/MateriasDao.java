package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Materias;

public class MateriasDao implements IMateriasDao{

	private Connection c;

	public MateriasDao() {
		GenericDao gDao = new GenericDao();
		c = gDao.getConnection();
	}

	public void insereMateria(Materias materia) throws SQLException {
		String sql = "INSERT INTO materias (nome, carga_horaria) VALUES (?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, materia.getNome());
		ps.setInt(2, materia.getCargaHoraria());
		ps.execute();
		ps.close();

	}

	public void atualizaMateria(Materias materia) throws SQLException {
		String sql = "UPDATE materias SET nome = ?, carga_horaria = ? WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, materia.getNome());
		ps.setInt(2, materia.getCargaHoraria());
		ps.setInt(3, materia.getId());
		ps.execute();
		ps.close();
	}

	public void excluiMateria(Materias materia) throws SQLException {
		String sql = "DELETE materias WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, materia.getId());
		ps.execute();
		ps.close();
	}

	public List<Materias> consultaMaterias() throws SQLException {
		String sql = "SELECT id, nome, carga_horaria FROM materias";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<Materias> ListaMaterias = new ArrayList<Materias>();
		while (rs.next()) {
			Materias mat = new Materias();
			mat.setId(rs.getInt("id"));
			mat.setNome(rs.getString("nome"));
			mat.setCargaHoraria(rs.getInt("carga_horaria"));
			ListaMaterias.add(mat);
		}
		rs.close();
		ps.close();
		return ListaMaterias;
	}

	public Materias consultaMateria(Materias materia) throws SQLException {
		String sql = "SELECT id, nome, carga_horaria FROM materias WHERE id = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, materia.getId());
		ResultSet rs = ps.executeQuery();
		Materias mat = new Materias();
		if (rs.next()) {
			mat.setId(rs.getInt("id"));
			mat.setNome(rs.getString("nome"));
			mat.setCargaHoraria(rs.getInt("carga_horaria"));
		}
		rs.close();
		ps.close();
		return mat;
	}
	

}
