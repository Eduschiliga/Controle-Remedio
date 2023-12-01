/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.trabalhocontroleremedio.modelo;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author marco
 */
@Entity
@Table(name = "Idoso")
@NamedQueries({
    @NamedQuery(name = "Idoso.findAll", query = "SELECT i FROM Idoso i"),
    @NamedQuery(name = "Idoso.findByIdIdoso", query = "SELECT i FROM Idoso i WHERE i.idIdoso = :idIdoso"),
    @NamedQuery(name = "Idoso.findByNome", query = "SELECT i FROM Idoso i WHERE i.nome = :nome"),
    @NamedQuery(name = "Idoso.findByNascimento", query = "SELECT i FROM Idoso i WHERE i.nascimento = :nascimento"),
    @NamedQuery(name = "Idoso.findBySexo", query = "SELECT i FROM Idoso i WHERE i.sexo = :sexo")})
public class Idoso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idIdoso")
    private Integer idIdoso;
    @Column(name = "nome")
    private String nome;
    @Column(name = "nascimento")
    private String nascimento;
    @Column(name = "sexo")
    private String sexo;
    @OneToMany(mappedBy = "fkIdoso")
    private Collection<RemedioIdoso> remedioIdosoCollection;

    public Idoso() {
    }

    public Idoso(Integer idIdoso) {
        this.idIdoso = idIdoso;
    }

    public Integer getIdIdoso() {
        return idIdoso;
    }

    public void setIdIdoso(Integer idIdoso) {
        this.idIdoso = idIdoso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Collection<RemedioIdoso> getRemedioIdosoCollection() {
        return remedioIdosoCollection;
    }

    public void setRemedioIdosoCollection(Collection<RemedioIdoso> remedioIdosoCollection) {
        this.remedioIdosoCollection = remedioIdosoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idIdoso != null ? idIdoso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Idoso)) {
            return false;
        }
        Idoso other = (Idoso) object;
        if ((this.idIdoso == null && other.idIdoso != null) || (this.idIdoso != null && !this.idIdoso.equals(other.idIdoso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject3.Idoso[ idIdoso=" + idIdoso + " ]";
    }
    
}