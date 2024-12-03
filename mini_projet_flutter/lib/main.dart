import 'package:flutter/material.dart';

import 'screen/Pieces.dart';
import 'screen/login.dart';


void main() => runApp(const MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Login(),
      routes: {
        '/login': (context) => Login(),
        '/Pieces': (context) => PiecesScreen(),

      },
    );
  }
}