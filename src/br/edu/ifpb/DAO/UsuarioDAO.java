package br.edu.ifpb.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.edu.ifpb.entidades.Usuario;

public class UsuarioDAO {

	public static Connection con;
	public static ResultSet rs;

	public UsuarioDAO() {
		// TODO Auto-generated constructor stub
	}

	// CONEXÃO COM O BD
	public void abrirConexao() throws ClassNotFoundException {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			this.con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/NewJSF", "root", "root1234");
		
		} catch (SQLException error) {
			System.out.println("Nao foi possivel conectar ao BD " + error);
		}
		System.out.println("Conexão aberta");

	}

	public void fecharConexao() {
		
		try {
			this.con.close();
		} catch (SQLException error) {
			System.out.println("Nao foi possivel fechar conexão" + error);
			error.printStackTrace();
		} catch (NullPointerException npe) {
			System.out.println("Nao foi possivel realizar inserção");
			npe.printStackTrace(System.err);
		}
		System.out.println("Conexão fechada");
		
	}

	public Usuario mostraUsuario() throws ClassNotFoundException {
		
		System.out.println("Conexão aberta");

		UsuarioDAO bd = new UsuarioDAO();
		Usuario user = new Usuario();

		try {

			bd.abrirConexao();
			Statement st = con.createStatement();

			String sql = "select * from usuario";

			rs = st.executeQuery(sql);
			rs.next();

			user.setMatricula(rs.getInt("matricula"));
			user.setDt_nasc(rs.getString("dt_nasc"));
			user.setNome(rs.getString("nome"));

			st.close();
			rs.close();
			bd.fecharConexao();
			
		} catch (SQLException error) {
			System.out.println("Nao foi possivel realizar inserção");
			error.printStackTrace(System.err);
		} catch (NullPointerException npe) {
			System.out.println("Nao foi possivel realizar inserção");
			npe.printStackTrace(System.err);
		}

		return user;
	}

}
