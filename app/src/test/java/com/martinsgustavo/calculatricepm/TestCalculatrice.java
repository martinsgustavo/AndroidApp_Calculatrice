// Travail Pratique II
// POO II
//
// Luiz Gustavo Martins de Farias

package com.martinsgustavo.calculatricepm;

import org.junit.Test;

import java.util.EmptyStackException;

import static org.junit.Assert.*;

public class TestCalculatrice {
    //Test de la classe Addition
    @Test
    public void testAdditionNombrePositif() throws Exception {
        Scalaire n1 = new Scalaire(2.0);
        Scalaire n2 = new Scalaire(2.0);

        Addition resultat = new Addition(n1, n2);

        assertEquals(4.0, resultat.evaluer(), 0.001);
        assertEquals("(2.0 + 2.0)", resultat.toInfix());
        assertEquals("2.0 2.0 +", resultat.toPolonaise());
    }

    @Test
    public void testAdditionNombreAvecDecimal() throws Exception {
        Scalaire n1 = new Scalaire(203.05);
        Scalaire n2 = new Scalaire(203.0);

        Addition resultat = new Addition(n1, n2);

        assertEquals(406.05, resultat.evaluer(), 0.001);
        assertEquals("(203.05 + 203.0)", resultat.toInfix());
        assertEquals("203.05 203.0 +", resultat.toPolonaise());
    }

    @Test
    public void testAdditionTresGrandNombre() throws Exception {
        Expression n1 = new Scalaire(208399.0);
        Expression n2 = new Scalaire(400203.0);

        Expression resultat = new Addition(n1, n2);

        assertEquals(608602.0, resultat.evaluer(), 0.001);
        assertEquals("(208399.0 + 400203.0)", resultat.toInfix());
        assertEquals("208399.0 400203.0 +", resultat.toPolonaise());
    }

    //Test de la classe Soustraction
    @Test
    public void testSoustractionNombrePositif() throws Exception {
        Expression n1 = new Scalaire(25.0);
        Expression n2 = new Scalaire(10.0);

        Expression resultat = new Soustraction(n1, n2);

        assertEquals(15.0, resultat.evaluer(), 0.001);
        assertEquals("(25.0 - 10.0)", resultat.toInfix());
        assertEquals("25.0 10.0 -", resultat.toPolonaise());
    }

    @Test
    public void testSoustractionNombreAvecDecimal() throws Exception {
        Expression n1 = new Scalaire(300.5);
        Expression n2 = new Scalaire(2.1);

        Expression resultat = new Soustraction(n1, n2);

        assertEquals(298.4, resultat.evaluer(), 0.001);
        assertEquals("(300.5 - 2.1)", resultat.toInfix());
        assertEquals("300.5 2.1 -", resultat.toPolonaise());
    }

    @Test
    public void testSoustractionTresGrandNombre() throws Exception {
        Expression n1 = new Scalaire(9999.0);
        Expression n2 = new Scalaire(1111.0);

        Expression resultat = new Soustraction(n1, n2);

        assertEquals(8888.0, resultat.evaluer(), 0.001);
        assertEquals("(9999.0 - 1111.0)", resultat.toInfix());
        assertEquals("9999.0 1111.0 -", resultat.toPolonaise());
    }

    //Test de la classe Multiplication
    @Test
    public void testMultiplicationNombrePositif() throws Exception {
        Expression n1 = new Scalaire(25.0);
        Expression n2 = new Scalaire(10.0);

        Expression resultat = new Multiplication(n1, n2);

        assertEquals(250.0, resultat.evaluer(), 0.001);
        assertEquals("(25.0 * 10.0)", resultat.toInfix());
        assertEquals("25.0 10.0 *", resultat.toPolonaise());
    }

    @Test
    public void testMultiplicationNombreAvecDecimal() throws Exception {
        Expression n1 = new Scalaire(2.5);
        Expression n2 = new Scalaire(5.0);

        Expression resultat = new Multiplication(n1, n2);

        assertEquals(12.5, resultat.evaluer(), 0.001);
        assertEquals("(2.5 * 5.0)", resultat.toInfix());
        assertEquals("2.5 5.0 *", resultat.toPolonaise());
    }

    @Test
    public void testMultiplicationTresGrandNombre() throws Exception {
        Expression n1 = new Scalaire(5500.0);
        Expression n2 = new Scalaire(3.0);

        Expression resultat = new Multiplication(n1, n2);

        assertEquals(16500.0, resultat.evaluer(), 0.001);
        assertEquals("(5500.0 * 3.0)", resultat.toInfix());
        assertEquals("5500.0 3.0 *", resultat.toPolonaise());
    }

    //Test de la classe Division
    @Test
    public void testDivisionNombrePositif() throws Exception {
        Expression n1 = new Scalaire(25.0);
        Expression n2 = new Scalaire(10.0);

        Expression resultat = new Division(n1, n2);

        assertEquals(2.5, resultat.evaluer(), 0.001);
        assertEquals("(25.0 / 10.0)", resultat.toInfix());
        assertEquals("25.0 10.0 /", resultat.toPolonaise());
    }

    @Test
    public void testDivisionNombreAvecDecimal() throws Exception {
        Expression n1 = new Scalaire(15.9);
        Expression n2 = new Scalaire(3.0);

        Expression resultat = new Division(n1, n2);

        assertEquals(5.3, resultat.evaluer(), 0.001);
        assertEquals("(15.9 / 3.0)", resultat.toInfix());
        assertEquals("15.9 3.0 /", resultat.toPolonaise());
    }

    @Test
    public void testDivisionTresGrandNombre() throws Exception {
        Expression n1 = new Scalaire(8844.0);
        Expression n2 = new Scalaire(4.0);

        Expression resultat = new Division(n1, n2);

        assertEquals(2211.0, resultat.evaluer(), 0.001);
        assertEquals("(8844.0 / 4.0)", resultat.toInfix());
        assertEquals("8844.0 4.0 /", resultat.toPolonaise());
    }

    //Test de la classe FabriqueExpression
    @Test
    public void testFabriqueExpressionPolonaise01() throws Exception {
        String expression = "5 6 + 4 1 / *";
        FabriqueExpression fE = new FabriqueExpression();
        Expression resultat = fE.batirFromPolonaise(expression);

        assertEquals(44.0, resultat.evaluer(), 0.001);
        assertEquals("((5.0 + 6.0) * (4.0 / 1.0))", resultat.toInfix());
        assertEquals("5.0 6.0 + 4.0 1.0 / *", resultat.toPolonaise());

    }

    @Test
    public void testFabriqueExpressionPolonaise02() throws Exception {
        String expression = "1 2 + 30 - 4 * 5 /";
        FabriqueExpression fE = new FabriqueExpression();
        Expression resultat = fE.batirFromPolonaise(expression);

        assertEquals(-21.6, resultat.evaluer(), 0.001);
        assertEquals("((((1.0 + 2.0) - 30.0) * 4.0) / 5.0)", resultat.toInfix());
        assertEquals("1.0 2.0 + 30.0 - 4.0 * 5.0 /", resultat.toPolonaise());
    }

    //Bonus
    @Test
    public void testFabriqueExpressionToInfix01() throws Exception {
        String expression = "(((2 + 2) * (5 - 2)) / 2)";
        FabriqueExpression fE = new FabriqueExpression();
        Expression resultat = fE.batirFromToInfix(expression);

        assertEquals(6.0, resultat.evaluer(), 0.001);
        assertEquals("(((2.0 + 2.0) * (5.0 - 2.0)) / 2.0)", resultat.toInfix());
        assertEquals("2.0 2.0 + 5.0 2.0 - * 2.0 /", resultat.toPolonaise());
    }

    @Test
    public void testFabriqueExpressionToInfix02() throws Exception {
        String expression = "(((10 * 2.5) + (5 / 2)) / 10)";
        FabriqueExpression fE = new FabriqueExpression();
        Expression resultat = fE.batirFromToInfix(expression);

        assertEquals(2.75, resultat.evaluer(), 0.001);
        assertEquals("(((10.0 * 2.5) + (5.0 / 2.0)) / 10.0)", resultat.toInfix());
        assertEquals("10.0 2.5 * 5.0 2.0 / + 10.0 /", resultat.toPolonaise());
    }

    @Test
    public void testFabriqueExpressionMalForme() throws Exception {

        try {
            String expression = "1 + 2 - 3 * 4 / 5";
            FabriqueExpression fE = new FabriqueExpression();
            Expression resultat = fE.batirFromPolonaise(expression);

            assertEquals("Expression mal formée.", resultat.evaluer());

        } catch (EmptyStackException e) {
            System.out.print("Expression mal formée.");
        }

    }

    @Test
    public void testFabriqueExpressionDivisePar0() throws Exception {

        try {
            String expression = "2 0 /";
            FabriqueExpression fE = new FabriqueExpression();
            Expression resultat = fE.batirFromPolonaise(expression);

            assertEquals("Pas possible de divisé par 0.", resultat.evaluer());

        } catch (UnsupportedOperationException e) {
            System.out.print("Pas possible de divisé par 0.");
        }

    }
}