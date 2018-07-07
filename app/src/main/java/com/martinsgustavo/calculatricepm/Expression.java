// Travail Pratique II
// POO II
//
// Luiz Gustavo Martins de Farias

package com.martinsgustavo.calculatricepm;

public interface Expression {

    //Méthode pour retourner le calcul
    public double evaluer();

    //Méthode pour retourner l'expression régulière
    public String toInfix();

    //Méthode pour retourne l'expression polonaise
    public String toPolonaise();

}
