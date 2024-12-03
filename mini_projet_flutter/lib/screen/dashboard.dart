import 'package:animated_text_kit/animated_text_kit.dart';
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:mini_projet_flutter/template/navbar.dart';
import 'package:mini_projet_flutter/screen/Pieces.dart';  // Importer PiecesScreen ici

class Dashboard extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: NavBar('Dashboard'),  // Utilisation de la NavBar
      backgroundColor: Colors.blue,
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            SizedBox(
              child: DefaultTextStyle(
                style: const TextStyle(
                  fontSize: 30.0,
                  fontFamily: 'Agne',
                ),
                child: AnimatedTextKit(
                  animatedTexts: [
                    TypewriterAnimatedText('Welcome Back'),
                    TypewriterAnimatedText('Dashboard to our App Pieces'),
                  ],
                ),
              ),
            ),
            // Ajout d'un bouton pour accéder à PiecesScreen
            ElevatedButton(
              onPressed: () {
                // Navigation vers l'écran des pièces
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => PiecesScreen()),
                );
              },
              child: const Text('Voir les Pièces'),
            ),
            SizedBox(height: 20),  // Espace entre le bouton et le GIF
            Container(
              width: 200,  // Largeur du container pour ajuster le GIF
              height: 200,  // Hauteur du container
              child: Image.asset('/images/200000.gif'),  // Affichage du GIF
            ),
          ],
        ),
      ),
    );
  }
}
