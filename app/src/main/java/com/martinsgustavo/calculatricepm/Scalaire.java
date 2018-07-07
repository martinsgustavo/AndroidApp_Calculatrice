// Travail Pratique II
// POO II
//
// Luiz Gustavo Martins de Farias

package com.martinsgustavo.calculatricepm;

public class Scalaire implements Expression{

    private double scalaire;

    //Construteur pour la classe Scalaire
    public Scalaire(double scalaire) {
        this.scalaire = scalaire;
    }

    @Override
    public double evaluer() {
        return scalaire;
    }

    @Override
    public String toInfix() {
        return Double.toString(scalaire);
    }

    @Override
    public String toPolonaise() {
        return Double.toString(scalaire);
    }
}
