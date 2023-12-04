package client;

import objet.Operation;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            // Définition de l'adresse IP et du port du serveur
            InetAddress serverAddress = InetAddress.getByName("192.168.147.20");
            InetSocketAddress serverSocketAddress = new InetSocketAddress(serverAddress, 1234);

            // Création d'une socket pour se connecter au serveur
            Socket clientSocket = new Socket();

            // Connexion au serveur
            clientSocket.connect(serverSocketAddress);

            // Configuration du flux de sortie pour envoyer un objet Operation au serveur
            OutputStream output = clientSocket.getOutputStream();
            ObjectOutputStream os = new ObjectOutputStream(output);

            // Création d'un objet Operation (par exemple, 40 * 20)
            Operation op = new Operation(40, 20, '*');

            // Envoi de l'objet Operation au serveur
            os.writeObject(op);

            // Configuration du flux d'entrée pour recevoir un objet Operation modifié du serveur
            InputStream input = clientSocket.getInputStream();
            ObjectInputStream is = new ObjectInputStream(input);

            // Réception et lecture de l'objet Operation modifié
            op = (Operation) is.readObject();

            // Affichage du résultat
            System.out.println("Résultat reçu du serveur : " + op.getRes());
        } catch (Exception e) {
            // Gestion des exceptions en cas d'erreur
            System.out.println("Client : Une erreur s'est produite - " + e.getMessage());
            e.printStackTrace();
        }
    }
}