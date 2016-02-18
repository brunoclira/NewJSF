package br.edu.ifpb.DAO;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import br.edu.ifpb.entidades.Usuario;

public class UsuarioDAO {

	public static Connection con;
	public static ResultSet rs;

	public UsuarioDAO() {
		// TODO Auto-generated constructor stub
	}

	// CONEXÃO COM O BD
	public void abrirConexao() {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			this.con = (Connection) DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/NewJSF", "root", "root1234");

		} catch (ClassNotFoundException cnfe) {
			System.out.println("Nao foi possivel encontrar o Driver apropriado");
		} catch (SQLException sqle) {
			System.out.println("Nao foi possivel conectar ao SGBD");
			sqle.printStackTrace(System.err);
		}
		System.out.println("Conexão aberta");

	}

	public void fecharConexao() {
		try {
			this.con.close();
		} catch (SQLException e) {
			System.out.println("Nao foi possivel fechar conexão");
			e.printStackTrace();
		} catch (NullPointerException npe) {
			System.out.println("Nao foi possivel realizar inserção");
			npe.printStackTrace(System.err);
		}
		System.out.println("Conexão fechada");
	}

	public Usuario mostraUsuario() {
		System.out.println("Conexão aberta");

		UsuarioDAO bd = new UsuarioDAO();
		Usuario user = new Usuario();

		try {

			bd.abrirConexao();
			Statement st = (Statement) con.createStatement();

			String sql = "SELECT * FROM usuario";

			rs = st.executeQuery(sql);
			rs.next();

			user.setMatricula(rs.getInt("matricula"));
			user.setData(rs.getString("data_nasc"));
			user.setNome(rs.getString("nome"));

			st.close();
			rs.close();
			bd.fecharConexao();
		} catch (SQLException sqle) {
			System.out.println("Nao foi possivel realizar inserção");
			sqle.printStackTrace(System.err);
		} catch (NullPointerException npe) {
			System.out.println("Nao foi possivel realizar inserção");
			npe.printStackTrace(System.err);
		}

		return user;
	}

}
