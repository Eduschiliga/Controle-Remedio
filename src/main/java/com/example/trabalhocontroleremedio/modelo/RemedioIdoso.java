/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.trabalhocontroleremedio.modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author marco
 */
@Entity
@Table(name = "Remedio_Idoso")
@NamedQueries({
    @NamedQuery(name = "RemedioIdoso.findAll", query = "SELECT r FROM RemedioIdoso r"),
    @NamedQuery(name = "RemedioIdoso.findByIdRemedioIdoso", query = "SELECT r FROM RemedioIdoso r WHERE r.idRemedioIdoso = :idRemedioIdoso"),
    @NamedQuery(name = "RemedioIdoso.findByDosagem", query = "SELECT r FROM RemedioIdoso r WHERE r.dosagem = :dosagem"),
    @NamedQuery(name = "RemedioIdoso.findByQuantidadeDias", query = "SELECT r FROM RemedioIdoso r WHERE r.quantidadeDias = :quantidadeDias")})
public class RemedioIdoso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idRemedio_Idoso")
    private Integer idRemedioIdoso;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "dosagem")
    private Float dosagem;
    @Column(name = "quantidade_dias")
    private Integer quantidadeDias;
    @JoinColumn(name = "fk_idoso", referencedColumnName = "idIdoso")
    @ManyToOne
    private Idoso fkIdoso;
    @JoinColumn(name = "fk_remedio", referencedColumnName = "idRemedio")
    @ManyToOne
    private Remedio fkRemedio;
    @JoinColumn(name = "fk_horario", referencedColumnName = "idHorario")
    @ManyToOne
    private Horario fkHorario;

    public RemedioIdoso() {
    }

    public RemedioIdoso(Integer idRemedioIdoso) {
        this.idRemedioIdoso = idRemedioIdoso;
    }

    public Integer getIdRemedioIdoso() {
        return idRemedioIdoso;
    }

    public void setIdRemedioIdoso(Integer idRemedioIdoso) {
        this.idRemedioIdoso = idRemedioIdoso;
    }

    public Float getDosagem() {
        return dosagem;
    }

    public void setDosagem(Float dosagem) {
        this.dosagem = dosagem;
    }

    public Integer getQuantidadeDias() {
        return quantidadeDias;
    }

    public void setQuantidadeDias(Integer quantidadeDias) {
        this.quantidadeDias = quantidadeDias;
    }

    public Idoso getFkIdoso() {
        return fkIdoso;
    }

    public void setFkIdoso(Idoso fkIdoso) {
        this.fkIdoso = fkIdoso;
    }

    public Remedio getFkRemedio() {
        return fkRemedio;
    }

    public void setFkRemedio(Remedio fkRemedio) {
        this.fkRemedio = fkRemedio;
    }

    public Horario getFkHorario() {
        return fkHorario;
    }

    public void setFkHorario(Horario fkHorario) {
        this.fkHorario = fkHorario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRemedioIdoso != null ? idRemedioIdoso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RemedioIdoso)) {
            return false;
        }
        RemedioIdoso other = (RemedioIdoso) object;
        if ((this.idRemedioIdoso == null && other.idRemedioIdoso != null) || (this.idRemedioIdoso != null && !this.idRemedioIdoso.equals(other.idRemedioIdoso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ idRemedioIdoso=" + idRemedioIdoso + " ]";
    }
    
}