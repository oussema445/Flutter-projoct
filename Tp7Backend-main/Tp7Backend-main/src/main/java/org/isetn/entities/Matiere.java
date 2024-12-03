package org.isetn.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Matiere {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codMat;
	private String intMat;
    private String description;
	
    @JsonIgnore
	@ManyToMany(mappedBy = "matieres")
	    private List<Classe> classes;

	public Long getCodMat() {
		return codMat;
	}

	public void setCodMat(Long codMat) {
		this.codMat = codMat;
	}

	public String getIntMat() {
		return intMat;
	}

	public void setIntMat(String intMat) {
		this.intMat = intMat;
	}

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Classe> getClasses() {
		return classes;
	}

	public void setClasses(List<Classe> classes) {
		this.classes = classes;
	}

	public Matiere(Long codMat, String intMat, String description, List<Classe> classes) {
		super();
		this.codMat = codMat;
		this.intMat = intMat;
		this.description = description;
		this.classes = classes;
	}

	public Matiere() {
		super();
		// TODO Auto-generated constructor stub
	}

	   
}
