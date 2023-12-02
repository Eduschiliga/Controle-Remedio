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
@Table(name = "Remedio")
@NamedQueries({
    @NamedQuery(name = "Remedio.findAll", query = "SELECT r FROM Remedio r"),
    @NamedQuery(name = "Remedio.findByIdRemedio", query = "SELECT r FROM Remedio r WHERE r.idRemedio = :idRemedio"),
    @NamedQuery(name = "Remedio.findByNome", query = "SELECT r FROM Remedio r WHERE r.nome = :nome"),
    @NamedQuery(name = "Remedio.findByNomeGenerico", query = "SELECT r FROM Remedio r WHERE r.nomeGenerico = :nomeGenerico"),
    @NamedQuery(name = "Remedio.findByCategoria", query = "SELECT r FROM Remedio r WHERE r.categoria = :categoria")})
public class Remedio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idRemedio")
    private Integer idRemedio;
    @Column(name = "nome")
    private String nome;
    @Column(name = "nome_generico")
    private String nomeGenerico;
    @Column(name = "categoria")
    private String categoria;
    @Column(name = "forma_dosagem")
    private String formaDosagem;
    @OneToMany(mappedBy = "fkRemedio")
    private Collection<RemedioIdoso> remedioIdosoCollection;

    public Remedio() {
    }

    public Remedio(Integer idRemedio) {
        this.idRemedio = idRemedio;
    }

    public Integer getIdRemedio() {
        return idRemedio;
    }

    public void setIdRemedio(Integer idRemedio) {
        this.idRemedio = idRemedio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeGenerico() {
        return nomeGenerico;
    }

    public void setNomeGenerico(String nomeGenerico) {
        this.nomeGenerico = nomeGenerico;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setFormaDosagem(String formaDosagem){
        this.formaDosagem = formaDosagem;
    }

    public String getFormaDosagem(){
        return formaDosagem;
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
        hash += (idRemedio != null ? idRemedio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Remedio)) {
            return false;
        }
        Remedio other = (Remedio) object;
        if ((this.idRemedio == null && other.idRemedio != null) || (this.idRemedio != null && !this.idRemedio.equals(other.idRemedio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ idRemedio=" + idRemedio + " ]";
    }
    
}