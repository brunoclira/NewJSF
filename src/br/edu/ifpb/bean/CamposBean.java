package br.edu.ifpb.bean;

import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.edu.ifpb.entidades.Campos;

@RequestScoped
@ManagedBean
public class CamposBean {

	private Campos campo;

	public CamposBean(){
		this.campo = new Campos();
	}
	
	public Campos getCampo() {
		return campo;
	}

	public void setCampo(Campos campo) {
		this.campo = campo;
	}
	
	public String inverte(){
		
		String aux = campo.getCampo1();
		campo.setCampo1(campo.getCampo2()); 
		campo.setCampo2(aux);
		
		return null;
	}
	
	
	
}
