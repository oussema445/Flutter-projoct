import 'package:flutter/material.dart';
import 'package:mini_projet_flutter/entities/Pieces.dart';
import 'package:mini_projet_flutter/services/piecesService.dart';

class PieceDialog extends StatefulWidget {
  final Function() notifyParent;
  final Piece? piece;

  const PieceDialog({super.key, required this.notifyParent, this.piece});

  @override
  _PieceDialogState createState() => _PieceDialogState();
}

class _PieceDialogState extends State<PieceDialog> {
  final TextEditingController nomCtrl = TextEditingController();
  final TextEditingController modelCtrl = TextEditingController();
  final TextEditingController prixCtrl = TextEditingController();

  String title = "Ajouter Pièce";
  bool isEditMode = false;

  @override
  void initState() {
    super.initState();
    if (widget.piece != null) {
      isEditMode = true;
      title = "Modifier Pièce";
      nomCtrl.text = widget.piece!.nomPiece;
      modelCtrl.text = widget.piece!.model;
      prixCtrl.text = widget.piece!.prixPiece.toString();
    }
  }

  // Fonction pour ajouter ou modifier la pièce
  void _savePiece() async {
    final piece = Piece(
      nomPiece: nomCtrl.text,
      model: modelCtrl.text,
      prixPiece: double.parse(prixCtrl.text),
      dateCreation: DateTime.now(),
    );

    try {
      if (isEditMode) {
        piece.idPiece = widget.piece!.idPiece;  // Conserver l'ID si c'est une modification
        await PieceService.updatePiece(piece);
      } else {
        await PieceService.addPiece(piece);
      }
      widget.notifyParent();
      Navigator.of(context).pop();
    } catch (e) {
      // Gérer les erreurs
      print('Erreur lors de la sauvegarde de la pièce: $e');
    }
  }

  @override
  Widget build(BuildContext context) {
    return AlertDialog(
      title: Text(title),
      content: SingleChildScrollView(
        child: Column(
          children: [
            TextField(
              controller: nomCtrl,
              decoration: const InputDecoration(labelText: "Nom de la pièce"),
            ),
            TextField(
              controller: modelCtrl,
              decoration: const InputDecoration(labelText: "Modèle"),
            ),
            TextField(
              controller: prixCtrl,
              decoration: const InputDecoration(labelText: "Prix"),
              keyboardType: TextInputType.number,
            ),
            const SizedBox(height: 20),
            ElevatedButton(
              onPressed: _savePiece,
              child: Text(isEditMode ? 'Mettre à jour' : 'Ajouter'),
            ),
          ],
        ),
      ),
    );
  }
}
