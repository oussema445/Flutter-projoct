package com.oussema.pieces;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.oussema.pieces.entities.Pieces;
import com.oussema.pieces.repos.PieceRepository;

@SpringBootTest
class PiecesApplicationTests {

	@Autowired
	private PieceRepository pieceRepository;
	@Test
	public void testCreatePiece() {
	Pieces piec = new Pieces();
	pieceRepository.save(piec);
	}
	@Test
	public void testFindPiece()
	{
	Pieces p = pieceRepository.findById(4L).get();
	System.out.println(p);
	}
	@Test
	public void testUpdatePiece()
	{
	Pieces p = pieceRepository.findById(1L).get();
	p.setPrixPiece(400.0);
	pieceRepository.save(p);
	}
	@Test
	public void testDeletePiece()
	{
	pieceRepository.deleteById(3L);;
	}
	@Test
	public void testListerTousPieces()
	{
	List<Pieces> piecs = pieceRepository.findAll();
	for (Pieces p : piecs)
	{
	System.out.println(p);
	}
	}
	
	@Test
	public void testFindPieceByNom()
	{
	List<Pieces> piecs = pieceRepository.findByNomPiece("roue");
	for (Pieces p : piecs)
	{
	System.out.println(p);
	}
	}
	
	@Test
	public void testFindPieceByNomContains()
	{
	List<Pieces> piecs = pieceRepository.findByNomPieceContains("r");
	for (Pieces p : piecs)
	{
	System.out.println(p);
	}
	}
	
	@Test
	public void testfindByNomPrix()
	{
	List<Pieces> piecs = pieceRepository.findByNomPrix("DISQUE DE FREIN", 150.0);
	for (Pieces p : piecs)
	{
	System.out.println(p);
	}
	}
	
	
	
	
	

	
	@Test
	public void testfindByOrderByNomPieceAsc()
	{
	List<Pieces> prods = pieceRepository.findByOrderByNomPieceAsc();
	for (Pieces p : prods)
	{
	System.out.println(p);
	}
	}
	
	@Test
	public void testTrierPiecesNomsPrix()
	{
	List<Pieces> piecs = pieceRepository.trierPiecesNomsPrix();
	for (Pieces p : piecs)
	{
	System.out.println(p);
	}
	}
	

	}
	
	

