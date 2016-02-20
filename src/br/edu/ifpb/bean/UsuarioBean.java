package br.edu.ifpb.bean;

import java.sql.ResultSet;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.mysql.jdbc.Connection;

import br.edu.ifpb.DAO.UsuarioDAO;
import br.edu.ifpb.entidades.Usuario;

@RequestScoped
@ManagedBean(name = "UsuarioBean")
public class UsuarioBean {

	ArrayList<Usuario> usuario;

	public UsuarioBean() {
		this.usuario = new ArrayList<Usuario>();
	}

	public ArrayList<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(ArrayList<Usuario> usuario) {
		this.usuario = usuario;
	}

	public void exibeUsuario() throws ClassNotFoundException {
		int i = 0;
		UsuarioDAO bd = new UsuarioDAO();
		Usuario user = new Usuario();

		for (i = 0; i < 2; i++) {
			user = bd.mostraUsuario();
			usuario.add(i, user);
			//System.out.println(usuario.getNome);
		}
		
		

	}

}
