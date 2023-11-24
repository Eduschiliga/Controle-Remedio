package com.example.trabalhocontroleremedio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByMatricula", query = "SELECT u FROM Usuario u WHERE u.matricula = :matricula"),
    @NamedQuery(name = "Usuario.findByLogin", query = "SELECT u FROM Usuario u WHERE u.login = :login"),
    @NamedQuery(name = "Usuario.findBySenha", query = "SELECT u FROM Usuario u WHERE u.senha = :senha"),
    @NamedQuery(name = "Usuario.findByTipo", query = "SELECT u FROM Usuario u WHERE u.tipo = :tipo"),
    @NamedQuery(name = "Usuario.findByNome", query = "SELECT u FROM Usuario u WHERE u.nome = :nome"),
    @NamedQuery(name = "Usuario.findByTelefone", query = "SELECT u FROM Usuario u WHERE u.telefone = :telefone")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "matricula")
    private Integer matricula;
    @Column(name = "login")
    private Serializable login;
    @Column(name = "senha")
    private Serializable senha;
    @Column(name = "tipo")
    private Serializable tipo;
    @Column(name = "nome")
    private Serializable nome;
    @Column(name = "telefone")
    private Serializable telefone;

    public Usuario() {
    }

    public Usuario(Integer matricula) {
        this.matricula = matricula;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Serializable getLogin() {
        return login;
    }

    public void setLogin(Serializable login) {
        this.login = login;
    }

    public Serializable getSenha() {
        return senha;
    }

    public void setSenha(Serializable senha) {
        this.senha = senha;
    }

    public Serializable getTipo() {
        return tipo;
    }

    public void setTipo(Serializable tipo) {
        this.tipo = tipo;
    }

    public Serializable getNome() {
        return nome;
    }

    public void setNome(Serializable nome) {
        this.nome = nome;
    }

    public Serializable getTelefone() {
        return telefone;
    }

    public void setTelefone(Serializable telefone) {
        this.telefone = telefone;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matricula != null ? matricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.matricula == null && other.matricula != null) || (this.matricula != null && !this.matricula.equals(other.matricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject3.Usuario[ matricula=" + matricula + " ]";
    }
    
}
