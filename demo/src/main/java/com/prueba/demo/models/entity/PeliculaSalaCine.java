package com.prueba.demo.models.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="pelicula_sala_cine")
public class PeliculaSalaCine implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idpeliculasalacine;

	@ManyToOne
	@JoinColumn(name = "idpelicula")
	private Pelicula pelicula;
	
	@ManyToOne
	@JoinColumn(name = "idsalacine")
	private SalaCine salaCine;
	
	@Column(name = "fecha_publicacion")
	@Temporal(TemporalType.DATE)
	private Date fechaPublicacion;
	
	@Column(name = "fecha_fin")
	@Temporal(TemporalType.DATE)
	private Date fechaFin;

	public Integer getIdpeliculasalacine() {
		return idpeliculasalacine;
	}

	public void setIdpeliculasalacine(Integer idpeliculasalacine) {
		this.idpeliculasalacine = idpeliculasalacine;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public SalaCine getSalaCine() {
		return salaCine;
	}

	public void setSalaCine(SalaCine salaCine) {
		this.salaCine = salaCine;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public void setFechaFin(Timestamp fechaFin) {
		this.fechaFin = fechaFin;
	}

}