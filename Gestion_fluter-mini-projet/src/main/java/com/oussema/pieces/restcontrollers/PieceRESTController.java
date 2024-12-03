package com.oussema.pieces.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oussema.pieces.entities.Pieces;
import com.oussema.pieces.service.PieceService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PieceRESTController {

	@Autowired
	PieceService pieceService ;
	
	@RequestMapping(method = RequestMethod.GET)
	List<Pieces> getAllPieces(){
		return pieceService.getAllPieces();
	}
	
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Pieces getPieceById(@PathVariable("id") Long id) {
	return pieceService.getPiece(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Pieces createPiece(@RequestBody Pieces pieces) {
	return pieceService.savePiece(pieces);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Pieces updatePiece(@RequestBody Pieces pieces) {
	return pieceService.savePiece(pieces);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deletePiece(@PathVariable("id") Long id)
	{
	pieceService.deletePieceById(id);
	}
	
	
	
	@RequestMapping(value="/piecsByName/{nom}",method = RequestMethod.GET)
	public List<Pieces> findByNomPieceContains(@PathVariable("nom") String nom) {
	return pieceService.findByNomPieceContains(nom);
	}
	
}
