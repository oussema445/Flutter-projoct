package com.oussema.pieces.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.oussema.pieces.entities.Pieces;

@RepositoryRestResource(path = "rest")
public interface PieceRepository extends JpaRepository<Pieces, Long> {
	
	List<Pieces> findByNomPiece(String nom);
	List<Pieces> findByNomPieceContains(String nom);
	
	
	@Query("select p from Pieces p where p.nomPiece like %:nom and p.prixPiece > :prix")
	List<Pieces> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
	

	
	
	List<Pieces> findByOrderByNomPieceAsc();
	
	
	@Query("select p from Pieces p order by p.nomPiece ASC, p.prixPiece DESC")
	List<Pieces> trierPiecesNomsPrix ();
	
	
}








