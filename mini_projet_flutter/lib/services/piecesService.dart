import 'dart:convert';
import 'package:http/http.dart' as http;
import 'package:mini_projet_flutter/entities/Pieces.dart';

class PieceService {
  // URL de votre backend Spring
  static const String baseUrl = 'http://localhost:8081/pieces/api';

  // Fonction pour ajouter une pièce
  static Future<Piece> addPiece(Piece piece) async {
    final response = await http.post(
      Uri.parse(baseUrl),
      headers: {'Content-Type': 'application/json'},
      body: json.encode(piece.toJson()), // Envoi de la pièce en format JSON
    );

    if (response.statusCode == 201) {
      return Piece.fromJson(json.decode(response.body)); // Retourne la pièce ajoutée
    } else {
      throw Exception('Failed to add piece');
    }
  }

  // Fonction pour mettre à jour une pièce
  static Future<Piece> updatePiece(Piece piece) async {
    final response = await http.put(
      Uri.parse(baseUrl),  
      headers: {'Content-Type': 'application/json'},
      body: json.encode(piece.toJson()), // Envoi de la pièce modifiée en format JSON
    );

    if (response.statusCode == 200) {
      return Piece.fromJson(json.decode(response.body)); // Retourne la pièce mise à jour
    } else {
      throw Exception('Failed to update piece');
    }
  }

  // Fonction pour supprimer une pièce
  static Future<void> deletePieceFromService(int pieceId) async {
    final response = await http.delete(
      Uri.parse('$baseUrl/$pieceId'),
    );

    if (response.statusCode != 200) {
      throw Exception('Failed to delete piece');
    }
  }

  // Fonction pour obtenir une pièce par son ID
  static Future<Piece> getPiece(int pieceId) async {
    final response = await http.get(
      Uri.parse('$baseUrl/$pieceId'),
    );

    if (response.statusCode == 200) {
      return Piece.fromJson(json.decode(response.body)); // Retourne la pièce obtenue
    } else {
      throw Exception('Failed to load piece');
    }
  }

  // Fonction pour obtenir toutes les pièces
  static Future<List<Piece>> getAllPieces() async {
    final response = await http.get(Uri.parse(baseUrl));

    if (response.statusCode == 200) {
      List<dynamic> data = json.decode(response.body);
      return data.map((json) => Piece.fromJson(json)).toList();
    } else {
      throw Exception('Failed to load pieces');
    }
  }

  // Fonction pour rechercher des pièces par nom
  static Future<List<Piece>> searchPiecesByName(String name) async {
    final response = await http.get(
      Uri.parse('$baseUrl/piecsByName/$name'),
    );

    if (response.statusCode == 200) {
      List<dynamic> data = json.decode(response.body);
      return data.map((json) => Piece.fromJson(json)).toList();
    } else {
      throw Exception('Failed to search pieces');
    }
  }
}
