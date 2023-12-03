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
@Table(name = "horario")
@NamedQueries({
    @NamedQuery(name = "Horario.findAll", query = "SELECT h FROM Horario h"),
    @NamedQuery(name = "Horario.findByIdHorario", query = "SELECT h FROM Horario h WHERE h.idhorario = :idhorario"),
    @NamedQuery(name = "Horario.findByH1", query = "SELECT h FROM Horario h WHERE h.h1 = :h1"),
    @NamedQuery(name = "Horario.findByH2", query = "SELECT h FROM Horario h WHERE h.h2 = :h2"),
    @NamedQuery(name = "Horario.findByH3", query = "SELECT h FROM Horario h WHERE h.h3 = :h3"),
    @NamedQuery(name = "Horario.findByH4", query = "SELECT h FROM Horario h WHERE h.h4 = :h4"),
    @NamedQuery(name = "Horario.findByH5", query = "SELECT h FROM Horario h WHERE h.h5 = :h5"),
    @NamedQuery(name = "Horario.findByH6", query = "SELECT h FROM Horario h WHERE h.h6 = :h6"),
    @NamedQuery(name = "Horario.findByH7", query = "SELECT h FROM Horario h WHERE h.h7 = :h7"),
    @NamedQuery(name = "Horario.findByH8", query = "SELECT h FROM Horario h WHERE h.h8 = :h8"),
    @NamedQuery(name = "Horario.findByH9", query = "SELECT h FROM Horario h WHERE h.h9 = :h9"),
    @NamedQuery(name = "Horario.findByH10", query = "SELECT h FROM Horario h WHERE h.h10 = :h10"),
    @NamedQuery(name = "Horario.findByH11", query = "SELECT h FROM Horario h WHERE h.h11 = :h11"),
    @NamedQuery(name = "Horario.findByH12", query = "SELECT h FROM Horario h WHERE h.h12 = :h12"),
    @NamedQuery(name = "Horario.findByH13", query = "SELECT h FROM Horario h WHERE h.h13 = :h13"),
    @NamedQuery(name = "Horario.findByH14", query = "SELECT h FROM Horario h WHERE h.h14 = :h14"),
    @NamedQuery(name = "Horario.findByH15", query = "SELECT h FROM Horario h WHERE h.h15 = :h15"),
    @NamedQuery(name = "Horario.findByH16", query = "SELECT h FROM Horario h WHERE h.h16 = :h16"),
    @NamedQuery(name = "Horario.findByH17", query = "SELECT h FROM Horario h WHERE h.h17 = :h17"),
    @NamedQuery(name = "Horario.findByH18", query = "SELECT h FROM Horario h WHERE h.h18 = :h18"),
    @NamedQuery(name = "Horario.findByH19", query = "SELECT h FROM Horario h WHERE h.h19 = :h19"),
    @NamedQuery(name = "Horario.findByH20", query = "SELECT h FROM Horario h WHERE h.h20 = :h20"),
    @NamedQuery(name = "Horario.findByH21", query = "SELECT h FROM Horario h WHERE h.h21 = :h21"),
    @NamedQuery(name = "Horario.findByH22", query = "SELECT h FROM Horario h WHERE h.h22 = :h22"),
    @NamedQuery(name = "Horario.findByH23", query = "SELECT h FROM Horario h WHERE h.h23 = :h23"),
    @NamedQuery(name = "Horario.findByH24", query = "SELECT h FROM Horario h WHERE h.h24 = :h24")})
public class Horario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idhorario")
    private Integer idhorario;
    @Column(name = "h1")
    private Boolean h1;
    @Column(name = "h2")
    private Boolean h2;
    @Column(name = "h3")
    private Boolean h3;
    @Column(name = "h4")
    private Boolean h4;
    @Column(name = "h5")
    private Boolean h5;
    @Column(name = "h6")
    private Boolean h6;
    @Column(name = "h7")
    private Boolean h7;
    @Column(name = "h8")
    private Boolean h8;
    @Column(name = "h9")
    private Boolean h9;
    @Column(name = "h10")
    private Boolean h10;
    @Column(name = "h11")
    private Boolean h11;
    @Column(name = "h12")
    private Boolean h12;
    @Column(name = "h13")
    private Boolean h13;
    @Column(name = "h14")
    private Boolean h14;
    @Column(name = "h15")
    private Boolean h15;
    @Column(name = "h16")
    private Boolean h16;
    @Column(name = "h17")
    private Boolean h17;
    @Column(name = "h18")
    private Boolean h18;
    @Column(name = "h19")
    private Boolean h19;
    @Column(name = "h20")
    private Boolean h20;
    @Column(name = "h21")
    private Boolean h21;
    @Column(name = "h22")
    private Boolean h22;
    @Column(name = "h23")
    private Boolean h23;
    @Column(name = "h24")
    private Boolean h24;
    @OneToMany(mappedBy = "fkHorario")
    private Collection<RemedioIdoso> remedioIdosoCollection;

    public Horario() {
    }

    public Horario(Integer idHorario) {
        this.idhorario = idHorario;
    }

    public Integer getIdhorario() {
        return idhorario;
    }

    public void setIdHorario(Integer idHorario) {
        this.idhorario = idHorario;
    }

    public Boolean getH1() {
        return h1;
    }

    public void setH1(Boolean h1) {
        this.h1 = h1;
    }

    public Boolean getH2() {
        return h2;
    }

    public void setH2(Boolean h2) {
        this.h2 = h2;
    }

    public Boolean getH3() {
        return h3;
    }

    public void setH3(Boolean h3) {
        this.h3 = h3;
    }

    public Boolean getH4() {
        return h4;
    }

    public void setH4(Boolean h4) {
        this.h4 = h4;
    }

    public Boolean getH5() {
        return h5;
    }

    public void setH5(Boolean h5) {
        this.h5 = h5;
    }

    public Boolean getH6() {
        return h6;
    }

    public void setH6(Boolean h6) {
        this.h6 = h6;
    }

    public Boolean getH7() {
        return h7;
    }

    public void setH7(Boolean h7) {
        this.h7 = h7;
    }

    public Boolean getH8() {
        return h8;
    }

    public void setH8(Boolean h8) {
        this.h8 = h8;
    }

    public Boolean getH9() {
        return h9;
    }

    public void setH9(Boolean h9) {
        this.h9 = h9;
    }

    public Boolean getH10() {
        return h10;
    }

    public void setH10(Boolean h10) {
        this.h10 = h10;
    }

    public Boolean getH11() {
        return h11;
    }

    public void setH11(Boolean h11) {
        this.h11 = h11;
    }

    public Boolean getH12() {
        return h12;
    }

    public void setH12(Boolean h12) {
        this.h12 = h12;
    }

    public Boolean getH13() {
        return h13;
    }

    public void setH13(Boolean h13) {
        this.h13 = h13;
    }

    public Boolean getH14() {
        return h14;
    }

    public void setH14(Boolean h14) {
        this.h14 = h14;
    }

    public Boolean getH15() {
        return h15;
    }

    public void setH15(Boolean h15) {
        this.h15 = h15;
    }

    public Boolean getH16() {
        return h16;
    }

    public void setH16(Boolean h16) {
        this.h16 = h16;
    }

    public Boolean getH17() {
        return h17;
    }

    public void setH17(Boolean h17) {
        this.h17 = h17;
    }

    public Boolean getH18() {
        return h18;
    }

    public void setH18(Boolean h18) {
        this.h18 = h18;
    }

    public Boolean getH19() {
        return h19;
    }

    public void setH19(Boolean h19) {
        this.h19 = h19;
    }

    public Boolean getH20() {
        return h20;
    }

    public void setH20(Boolean h20) {
        this.h20 = h20;
    }

    public Boolean getH21() {
        return h21;
    }

    public void setH21(Boolean h21) {
        this.h21 = h21;
    }

    public Boolean getH22() {
        return h22;
    }

    public void setH22(Boolean h22) {
        this.h22 = h22;
    }

    public Boolean getH23() {
        return h23;
    }

    public void setH23(Boolean h23) {
        this.h23 = h23;
    }

    public Boolean getH24() {
        return h24;
    }

    public void setH24(Boolean h24) {
        this.h24 = h24;
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
        hash += (idhorario != null ? idhorario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horario)) {
            return false;
        }
        Horario other = (Horario) object;
        if ((this.idhorario == null && other.idhorario != null) || (this.idhorario != null && !this.idhorario.equals(other.idhorario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ idHorario=" + idhorario + " ]";
    }
    
}