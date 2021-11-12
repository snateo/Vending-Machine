package com.techelevator;

import org.junit.*;

public class ItemsTest {

    @Test
    public void getSaying_returns_notvalid_given_null() {
        // Arrange
        Items sut = new Items("", "", 0, "", 0);

        // Act
        String result = sut.getSaying(null);

        // Assert
        Assert.assertEquals("Slot was not valid.", result);
    }

    @Test
    public void getSaying_returns_notvalid_given_empty() {
        // Arrange
        Items sut = new Items("", "", 0, "", 0);

        // Act
        String result = sut.getSaying("");

        // Assert
        Assert.assertEquals("Slot was not valid.", result);
    }

    @Test
    public void getSaying_returns_notvalid_given_nonexistant_slot() {
        // Arrange
        Items sut = new Items("", "", 0, "", 0);

        // Act
        String result = sut.getSaying("F");

        // Assert
        Assert.assertEquals("Slot was not valid.", result);
    }

    @Test
    public void getSaying_returns_crunch_given_slot_A() {
        // Arrange
        Items sut = new Items("", "", 0, "", 0);

        // Act
        String result = sut.getSaying("A");

        // Assert
        Assert.assertEquals("Crunch Crunch, Yum!", result);
    }

    @Test
    public void getSaying_returns_crunch_given_slot_B() {
        // Arrange
        Items sut = new Items("", "", 0, "", 0);

        // Act
        String result = sut.getSaying("B");

        // Assert
        Assert.assertEquals("Munch Munch, Yum!", result);
    }

    @Test
    public void getSaying_returns_crunch_given_slot_C() {
        // Arrange
        Items sut = new Items("", "", 0, "", 0);

        // Act
        String result = sut.getSaying("C");

        // Assert
        Assert.assertEquals("Glug Glug, Yum!", result);
    }

    @Test
    public void getSaying_returns_crunch_given_slot_D() {
        // Arrange
        Items sut = new Items("", "", 0, "", 0);

        // Act
        String result = sut.getSaying("D");

        // Assert
        Assert.assertEquals("Chew Chew, Yum!", result);
    }

}