class Piece {
  int? idPiece; // ID unique de la pièce
  String nomPiece; // Nom de la pièce
  String model; // Modèle de la pièce
  double prixPiece; // Prix de la pièce
  DateTime dateCreation; // Date de création de la pièce

  // Constructeur
  Piece({
    this.idPiece,
    required this.nomPiece,
    required this.model,
    required this.prixPiece,
    required this.dateCreation,
  });

  // Méthode pour convertir un objet JSON en instance de Piece
  factory Piece.fromJson(Map<String, dynamic> json) {
    return Piece(
      idPiece: json['idPiece'] != null ? json['idPiece']?.toInt() : null,
      nomPiece: json['nomPiece'] ?? '',
      model: json['model'] ?? '',
      prixPiece: (json['prixPiece'] ?? 0).toDouble(),
      dateCreation: json['dateCreation'] != null
          ? DateTime.tryParse(json['dateCreation']) ?? DateTime.now()
          : DateTime.now(), // Utilisation de la date actuelle si la date est invalide ou manquante
    );
  }

  // Méthode pour convertir une instance de Piece en JSON
  Map<String, dynamic> toJson() {
    return {
      'idPiece': idPiece,
      'nomPiece': nomPiece,
      'model': model,
      'prixPiece': prixPiece,
      'dateCreation': dateCreation.toIso8601String(),
    };
  }
}
