package com.oussema.pieces.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oussema.pieces.entities.Pieces;
import com.oussema.pieces.repos.PieceRepository;



@Service 
public class PieceServiceimpl implements PieceService {

	@Autowired
	PieceRepository pieceRepository ;
	
	@Override
	public Pieces savePiece(Pieces p) {
		return pieceRepository.save(p);
	}

	@Override
	public Pieces updatePiece(Pieces p) {
		return pieceRepository.save(p);
	}

	@Override
	public void deletePiece(Pieces p) {
		 pieceRepository.delete(p);
		
	}

	@Override
	public void deletePieceById(Long id) {
		pieceRepository.deleteById(id);
	}

	@Override
	public Pieces getPiece(Long id) {
		return pieceRepository.findById(id).get();
	}

	@Override
	public List<Pieces> getAllPieces() {
		return pieceRepository.findAll();
	}

	@Override
	public List<Pieces> findByNomPiece(String nom) {
		return pieceRepository.findByNomPiece(nom);
	}

	@Override
	public List<Pieces> findByNomPieceContains(String nom) {
		return pieceRepository.findByNomPieceContains(nom);
	}

	@Override
	public List<Pieces> findByNomPrix(String nom, Double prix) {
		return null;
	}
	


	@Override
	public List<Pieces> findByOrderByNomPieceAsc() {
		return pieceRepository.findByOrderByNomPieceAsc();
	}

	@Override
	public List<Pieces> trierPiecesNomsPrix() {
		return pieceRepository.trierPiecesNomsPrix();

	}

	

}
