package objet;
// Définition du package pour la classe Operation

import java.io.Serializable;

public class Operation implements Serializable {
    private int nb1; // Premier nombre de l'opération
    private int nb2; // Deuxième nombre de l'opération
    private char op; // Opérateur de l'opération (+, -, *, /)
    private int res; // Résultat de l'opération

    // Constructeur de la classe Operation
    public Operation(int nb1, int nb2, char op){
        this.nb1 = nb1;
        this.nb2 = nb2;
        this.op = op;
    }

    // Méthode pour obtenir le premier nombre
    public int getNb1(){
        return nb1;
    }

    // Méthode pour obtenir le deuxième nombre
    public int getNb2(){
        return nb2;
    }

    // Méthode pour obtenir l'opérateur
    public char getOp(){
        return op;
    }

    // Méthode pour définir le résultat de l'opération
    public void setRes(int res){
        this.res = res;
    }

    // Méthode pour obtenir le résultat de l'opération
    public int getRes(){
        return res;
    }
}