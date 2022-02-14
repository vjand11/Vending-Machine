package com.techelevator.view;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class BalanceTests {

    @Test
    public void calculated_correct_change() {
        //Arrange
        BigDecimal testValue = BigDecimal.valueOf(1.00);
        Balance testBalance = new Balance(testValue);
        //Act
        BigDecimal result = testBalance.calculateChange(testValue);
        //Assert
        Assert.assertEquals(BigDecimal.valueOf(1.0), result);
    }

    @Test
    public void calculated_correct_change_from_zero() {
        //Arrange
        BigDecimal testValue = BigDecimal.valueOf(0.00);
        Balance testBalance = new Balance(testValue);
        //Act
        BigDecimal result = testBalance.calculateChange(testValue);
        //Assert
        Assert.assertEquals(BigDecimal.valueOf(0.0), result);
    }

    @Test
    public void calculated_correct_change_from_negative() {
        //Arrange
        BigDecimal testValue = BigDecimal.valueOf(-1.00);
        Balance testBalance = new Balance(testValue);
        //Act
        BigDecimal result = testBalance.calculateChange(testValue);
        //Assert
        Assert.assertEquals(BigDecimal.valueOf(-1.0), result);
    }

    @Test
    public void returned_correct_change_to_user() {
        //Arrange
        BigDecimal testValue = BigDecimal.valueOf(1.00);
        Balance testBalance = new Balance(testValue);
        //Act
        BigDecimal result = testBalance.returnChange(testValue);
        //Assert
        Assert.assertEquals(BigDecimal.valueOf(0.0),result);
    }

    @Test
    public void returned_correct_amount_with_zero_balance() {
        //Arrange
        BigDecimal testValue = BigDecimal.valueOf(0.0);
        Balance testBalance = new Balance(testValue);
        //Act
        BigDecimal result = testBalance.returnChange(testValue);
        //Assert
        Assert.assertEquals(BigDecimal.valueOf(0.0),result);
    }

    @Test
    public void returned_correct_change_from_negative() {
        //Arrange
        BigDecimal testValue = BigDecimal.valueOf(-1.00);
        Balance testBalance = new Balance(testValue);
        //Act
        BigDecimal result = testBalance.returnChange(testValue);
        //Assert
        Assert.assertEquals(BigDecimal.valueOf(0.0),result);
    }




}
