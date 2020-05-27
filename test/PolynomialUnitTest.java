/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import polynomial.Polynomial;

/**
 *
 * @author nico_rocca
 */
public class PolynomialUnitTest {
 
    @Test 
    public void emptyConstructorAndtoStringTest() {
            Polynomial polinomio= new Polynomial();
            String res = polinomio.toString();
            assertEquals("0*x^0",res);
        }
    
    @Test 
    public void arrayConstructorAndtoStringTest() {
            int[]coef={4,8,3};
            Polynomial polinomio= new Polynomial(coef);
            String res = polinomio.toString();
            assertEquals("3*x^3+8*x^2+4*x^1",res);
        }
    
     @Test 
    public void addTest() {
            int[]fstCoef={4,8,3};
            int[]sndCoef={9,21,4,3,5};
            Polynomial fstPolinomio= new Polynomial(fstCoef);
            Polynomial sndPolinomio= new Polynomial(sndCoef);
            Polynomial addResult=fstPolinomio.add(sndPolinomio);
            String res = addResult.toString();
            assertEquals("5*x^5+3*x^4+7*x^3+29*x^2+13*x^1",res);
        }
    
    @Test 
    public void addTestSwitched() {
            int[]fstCoef={4,8,3};
            int[]sndCoef={9,21,4,3,5};
            Polynomial fstPolinomio= new Polynomial(fstCoef);
            Polynomial sndPolinomio= new Polynomial(sndCoef);
            Polynomial addResult=sndPolinomio.add(fstPolinomio);
            String res = addResult.toString();
            assertEquals("5*x^5+3*x^4+7*x^3+29*x^2+13*x^1",res);
        }
    
    @Test
    public void getCoefficientTest() {
        int[]fstCoef={9,21,4,3,5};
        Polynomial fstPolinomio= new Polynomial(fstCoef);
        int exp=2;
        int coef=fstPolinomio.getCoefficient(exp);
        assertEquals(21,coef);
    }
    
    @Test
    public void valueOfTest() {
        int[]fstCoef={4,8,3};
        Polynomial fstPolinomio= new Polynomial(fstCoef);
        int point=2;
        int value=fstPolinomio.valueOf(point);
        assertEquals(64,value);
    }
    
    @Test
    public void equalsWithArrayTest() {
        int[]fstCoef={4,8,3};
        Polynomial fstPolinomio= new Polynomial(fstCoef);
        boolean res=fstPolinomio.equals(fstCoef);
        assertEquals(false,res);
    }
    
    @Test
    public void equalsWithDifPolynomialTest() {
        int[]fstCoef={4,8,3};
        Polynomial fstPolinomio= new Polynomial(fstCoef);
        int[]sndCoef={1,8,3};
        Polynomial sndPolinomio= new Polynomial(sndCoef);
        boolean res=fstPolinomio.equals(sndPolinomio);
        assertEquals(false,res);
    }
    
    @Test
    public void equalsWithEqPolynomialTest() {
        int[]fstCoef={4,8,3};
        Polynomial fstPolinomio= new Polynomial(fstCoef);
        Polynomial sndPolinomio= new Polynomial(fstCoef);
        boolean res=fstPolinomio.equals(sndPolinomio);
        assertEquals(true,res);
    }
    
    @Test
    public void equalsWithItselfTest() {
        int[]fstCoef={4,8,3};
        Polynomial fstPolinomio= new Polynomial(fstCoef);
        boolean res=fstPolinomio.equals(fstPolinomio);
        assertEquals(true,res);
    }
}
 

