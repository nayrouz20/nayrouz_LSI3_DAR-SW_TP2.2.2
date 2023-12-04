package server;

import objet.Operation; // Importation de la classe Operation

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket ss = new ServerSocket(1234)) {
            // Attendre qu'un client se connecte
            Socket clientSocket = ss.accept();

            // Configuration du flux d'entrée pour recevoir un objet
            InputStream input = clientSocket.getInputStream();
            ObjectInputStream oi = new ObjectInputStream(input);

            // Lire l'objet reçu (Operation)
            Operation op = (Operation) oi.readObject();

            // Extraire les données nécessaires de l'objet Operation
            int nb1 = op.getNb1();
            int nb2 = op.getNb2();
            char ops = op.getOp();

            int res = 0;

            // Effectuer l'opération demandée
            switch (ops) {
                case '+':
                    res = nb1 + nb2;
                    break;
                case '-':
                    res = nb1 - nb2;
                    break;
                case '*':
                    res = nb1 * nb2;
                    break;
                case '/':
                    res = nb1 / nb2;
                    break;
            }

            // Stocker le résultat dans l'objet Operation
            op.setRes(res);

            // Configuration du flux de sortie pour envoyer l'objet Operation modifié
            OutputStream output = clientSocket.getOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(output);

            // Envoyer l'objet Operation modifié de retour au client
            oo.writeObject(op);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Une erreur s'est produite : " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

