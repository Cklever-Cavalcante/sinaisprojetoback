package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empresas")
public class Empresas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_empresa;

    @Column(name = "nome_empresa")
    private String nomeEmpresa;

    @Column(name = "nome_respo")
    private String nomeRespo;

    @Column(name = "telefone")
    private String telefone;
    
    @Column(name = "email")
    private String email;

    @Column(name = "comentarios")
    private String comentarios;


	public Empresas() {
		
	}
	
	public Empresas(String nomeEmpresa, String nomeRespo, String telefone, String email, String comentarios) {
		super();
		this.nomeEmpresa = nomeEmpresa;
		this.nomeRespo = nomeRespo;
		this.telefone = telefone;
		this.email = email;
		this.comentarios = comentarios;
	}
	public long getId_empresa() {
		return id_empresa;
	}
	public void setId_empresa(long id_empresa) {
		this.id_empresa = id_empresa;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getNomeRespo() {
		return nomeRespo;
	}

	public void setNomeRespo(String nomeRespo) {
		this.nomeRespo = nomeRespo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
	
}
