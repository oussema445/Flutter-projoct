package org.isetn.RestControllers;

import java.util.List;

import org.isetn.entities.ClassMat;
import org.isetn.entities.Classe;
import org.isetn.entities.Matiere;
import org.isetn.repository.ClassMatRepository;
import org.isetn.repository.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("class")
public class ClassController {
	@Autowired
	private ClasseRepository classeRepository;
	@Autowired
	private ClassMatRepository classMatRepository;

	/*
	 * @PostMapping("/add") public Classe add(@RequestBody Classe classe) {
	 * System.out.println(classe.toString()); return classeRepository.save(classe);
	 * }
	 */

	@PostMapping("/add")
	public ResponseEntity<?> addClass(@RequestBody Classe classe) {
		// Étape 1: Ajouter la classe dans la table `classe`
		Classe savedClasse = classeRepository.save(classe);

		// Étape 2: Ajouter les relations dans la table `classMat`
		// (relationmany-to-many)
		if (classe.getMatieres() != null) {
			for (Matiere matiere : classe.getMatieres()) { // Créer et sauvegarder la relation ClassMat entreClasse et
															// Matiere
				ClassMat existingClassMat = classMatRepository.findByClasseCodClassAndMatiereCodMat(savedClasse.getCodClass(), matiere.getCodMat());
			        if (existingClassMat != null) {
			            // Mettez à jour les valeurs
			            existingClassMat.setCoefMat(2f);
			            existingClassMat.setNbrHS(22.5f);
			            // Utilisez save pour mettre à jour l'enregistrement
			            classMatRepository.save(existingClassMat);
			        }
			}
		}

		return ResponseEntity.ok(savedClasse); // Retourner l'objet Classe enregistré
	}

	@GetMapping("/all")
	public List<Classe> getAll() {
		return classeRepository.findAll();
	}

	@DeleteMapping("/delete")
	public void delete(@Param("id") Long id) {
		Classe c = classeRepository.findById(id).get();
		classeRepository.delete(c);
	}

	@PutMapping("/update")
	public Classe update(@RequestBody Classe classe) {
		return classeRepository.save(classe);
	}
}
