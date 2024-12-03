package com.oussema.pieces.entities;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Pieces {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
private Long idPiece ;
private String nomPiece;
private String model ;
private Double prixPiece;
private Date dateCreation;




public Pieces() {
	super();
	// TODO Auto-generated constructor stub
}
public Long getIdPiece() {
	return idPiece;
}
public void setIdPiece(Long idPiece) {
	this.idPiece = idPiece;
}
public String getNomPiece() {
	return nomPiece;
}
public void setNomPiece(String nomPiece) {
	this.nomPiece = nomPiece;
}
public Double getPrixPiece() {
	return prixPiece;
}
public void setPrixPiece(Double prixPiece) {
	this.prixPiece = prixPiece;
}
public Date getDateCreation() {
	return dateCreation;
}
public void setDateCreation(Date dateCreation) {
	this.dateCreation = dateCreation;
}
public Pieces(String nomPiece, Double prixPiece, Date dateCreation,String model) {
	super();
	this.nomPiece = nomPiece;
	this.prixPiece = prixPiece;
	this.dateCreation = dateCreation;
	this.model=model;
}
@Override
public String toString() {
	return "Pieces [idPiece=" + idPiece + ", nomPiece=" + nomPiece +", model"+ model + ", prixPiece=" + prixPiece + ", dateCreation="
			+ dateCreation + "]";
}

public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}





}
