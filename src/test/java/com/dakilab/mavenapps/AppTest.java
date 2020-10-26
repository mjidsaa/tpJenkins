package com.dakilab.mavenapps;


import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    @Test
    public void testCalculator(){
        // Arrange
        int a = 2;
        int b = 3;
        Calculator calculator = new Calculator();

        // Act
        int somme = calculator.calculerSomme(a, b);

        // Assert
        Assert.assertEquals(5, somme);
    }

}
