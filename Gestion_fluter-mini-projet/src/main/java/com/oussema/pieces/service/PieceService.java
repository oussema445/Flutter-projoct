package com.oussema.pieces.service;

import java.util.List;

import com.oussema.pieces.entities.Pieces;

public interface PieceService {

	Pieces savePiece(Pieces p);
	Pieces updatePiece(Pieces p);
	void deletePiece(Pieces p);
	void deletePieceById(Long id);
	Pieces getPiece(Long id);
	List<Pieces> getAllPieces();
	List<Pieces> findByNomPiece(String nom);
	List<Pieces> findByNomPieceContains(String nom);
	List<Pieces> findByNomPrix (String nom, Double prix);
	List<Pieces> findByOrderByNomPieceAsc();
	List<Pieces> trierPiecesNomsPrix();
	
}
