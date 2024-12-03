package org.isetn.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ClassMat")
public class ClassMat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "codClass")
	private Classe classe;

	public ClassMat(Classe classe, Matiere matiere) {
		super();
		this.classe = classe;
		this.matiere = matiere;
	}
	@ManyToOne
	@JoinColumn(name = "codMat")
	private Matiere matiere;

	private Float coefMat;
	private Float nbrHS;
	public ClassMat( Classe classe, Matiere matiere, Float coefMat, Float nbrHS) {
		super();
		
		this.classe = classe;
		this.matiere = matiere;
		this.coefMat = coefMat;
		this.nbrHS = nbrHS;
	}
	public ClassMat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Classe getClasse() {
		return classe;
	}
	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	public Matiere getMatiere() {
		return matiere;
	}
	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}
	public Float getCoefMat() {
		return coefMat;
	}
	public void setCoefMat(Float coefMat) {
		this.coefMat = coefMat;
	}
	public Float getNbrHS() {
		return nbrHS;
	}
	public void setNbrHS(Float nbrHS) {
		this.nbrHS = nbrHS;
	}
	
	
	
}

