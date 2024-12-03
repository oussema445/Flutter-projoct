import 'package:flutter/material.dart';
import 'package:mini_projet_flutter/entities/Pieces.dart';
import 'package:mini_projet_flutter/services/piecesService.dart';
import 'package:mini_projet_flutter/template/dialog/PieceDialog.dart';
import 'package:intl/intl.dart';  // Pour formater la date

class PiecesScreen extends StatefulWidget {
  const PiecesScreen({super.key});

  @override
  _PiecesScreenState createState() => _PiecesScreenState();
}

class _PiecesScreenState extends State<PiecesScreen> {
  List<Piece> pieces = [];
  bool isLoading = false;
  TextEditingController searchController = TextEditingController();

  @override
  void initState() {
    super.initState();
    _loadPieces();
  }

  // Charger la liste des pièces depuis le backend
  void _loadPieces() async {
    setState(() {
      isLoading = true;
    });

    try {
      pieces = await PieceService.getAllPieces();
    } catch (e) {
      // Gérer les erreurs
      print('Erreur lors du chargement des pièces: $e');
    }

    setState(() {
      isLoading = false;
    });
  }

  // Afficher un dialog pour ajouter ou modifier une pièce
  void _showPieceDialog([Piece? piece]) {
    showDialog(
      context: context,
      builder: (context) {
        return PieceDialog(
          notifyParent: _loadPieces,
          piece: piece,
        );
      },
    );
  }

  // Supprimer une pièce
  void _deletePiece(int pieceId) async {
    try {
      await PieceService.deletePieceFromService(pieceId);  // Passer l'ID de la pièce
      ScaffoldMessenger.of(context).showSnackBar(
        const SnackBar(content: Text('Pièce supprimée')),
      );
      _loadPieces(); // Recharge les pièces après la suppression
    } catch (e) {
      // Gérer les erreurs
      print('Erreur lors de la suppression de la pièce: $e');
    }
  }

  // Recherche des pièces par nom
  void _searchPieces() async {
    if (searchController.text.isEmpty) {
      // Si le champ est vide, recharger toutes les pièces
      _loadPieces();
    } else {
      setState(() {
        isLoading = true;
      });

      try {
        pieces = await PieceService.searchPiecesByName(searchController.text);
      } catch (e) {
        print('Erreur lors de la recherche de pièces: $e');
      }

      setState(() {
        isLoading = false;
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        backgroundColor: Colors.blue,
        title: const Text('Liste des Pièces'),
        actions: [
          IconButton(
            icon: Row(
              children: const [
                Icon(
                  Icons.add,
                  color: Colors.white, // Icône en blanc
                ),
                SizedBox(width: 8), // Un petit espace entre l'icône et le texte
                Text(
                  'Ajouter Pièce', // Texte qui s'affiche à côté de l'icône
                  style: TextStyle(
                    color: Colors.white,
                  ),
                ),
              ],
            ),
            onPressed: () => _showPieceDialog(),  // Affichage du dialog pour ajouter une pièce
          ),
        ],
      ),
      body: Column(
        children: [
          Padding(
            padding: const EdgeInsets.all(8.0),
            child: TextField(
              controller: searchController,
              decoration: const InputDecoration(
                labelText: "Rechercher par nom",
                prefixIcon: Icon(Icons.search),
                border: OutlineInputBorder(),
              ),
              onChanged: (value) {
                _searchPieces();  // Recherche en temps réel pendant que l'utilisateur tape
              },
            ),
          ),
          Expanded(
            child: isLoading
                ? const Center(child: CircularProgressIndicator())
                : SingleChildScrollView(
              scrollDirection: Axis.horizontal,
              child: DataTable(
                columnSpacing: 16.0,
                columns: const [
                  DataColumn(label: Text('Nom de la Pièce')),
                  DataColumn(label: Text('Modèle')),
                  DataColumn(label: Text('Prix')),
                  DataColumn(label: Text('Date de Création')),
                  DataColumn(label: Text('Actions')),
                ],
                rows: pieces.map<DataRow>((piece) {
                  String formattedDate =
                  DateFormat('yyyy-MM-dd').format(piece.dateCreation);

                  return DataRow(cells: [
                    DataCell(Text(piece.nomPiece)),
                    DataCell(Text(piece.model)),
                    DataCell(Text('\$${piece.prixPiece.toString()}')),
                    DataCell(Text(formattedDate)),
                    DataCell(Row(
                      mainAxisSize: MainAxisSize.min,
                      children: [
                        IconButton(
                          icon: const Icon(Icons.edit),
                          onPressed: () => _showPieceDialog(piece),
                        ),
                        IconButton(
                          icon: const Icon(Icons.delete),
                          onPressed: () => _deletePiece(piece.idPiece!),
                        ),
                      ],
                    )),
                  ]);
                }).toList(),
              ),
            ),
          ),
        ],
      ),
    );
  }
}
