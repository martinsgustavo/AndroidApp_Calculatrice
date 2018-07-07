// Travail Pratique II
// POO II
//
// Luiz Gustavo Martins de Farias

package com.martinsgustavo.calculatricepm;

public class Soustraction implements Expression {

    private Expression operandeA;
    private Expression operandeB;

    //Construteur pour le Soustraction
    public Soustraction(Expression operandeA, Expression operandeB) {
        super();
        this.operandeA = operandeA;
        this.operandeB = operandeB;
    }
    @Override
    public double evaluer() {
        return operandeA.evaluer() - operandeB.evaluer();
    }
    @Override
    public String toInfix() {
        return "(" + operandeA.toInfix() + " - " + operandeB.toInfix() + ")";
    }
    @Override
    public String toPolonaise() {
        return operandeA.toPolonaise() + " " + operandeB.toPolonaise() + " -";
    }
}