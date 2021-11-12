package com.techelevator;

import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class VendingMachineCLITest {

    @Test
    public void VendingMachineCLI_is_not_null() throws FileNotFoundException {
        // Arrange
        File file = new File("vendingmachine.csv");
        VendingMachineCLI sut = new VendingMachineCLI(file);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream(); // sout statement will come out to outContent
        System.setOut(new PrintStream(outContent));


        // Act
        System.out.println(sut.getInventoryList());

        // Assert
        Assert.assertNotNull(outContent); // ensures list was added to
    }

    @Test
    public void itemDisplay_returns_description_of_first_item() throws FileNotFoundException {
        // Arrange
        File file = new File("vendingmachine.csv");
        VendingMachineCLI sut = new VendingMachineCLI(file);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Act
        System.out.print(sut.itemDisplay().get(0)); // test first line

        // Assert
        Assert.assertEquals("A1 - Potato Crisps - 3.05 - Stock: 5", outContent.toString());
    }

    @Test
    public void makeAPurchase_changes_current_balance_and_returns_saying() throws FileNotFoundException {
        // Arrange
        File file = new File("vendingmachine.csv");
        VendingMachineCLI sut = new VendingMachineCLI(file);
        Purchases p = new Purchases();
        p.setCurrentBalance(5);

        // Act
        double result = sut.makeAPurchase(p, "A1");
        // Assert
        System.out.println();
        Assert.assertEquals(1.95, result, 0);
    }


    @Test
    public void makeAPurchase_goes_through_with_exact_change() throws FileNotFoundException {
        // Arrange
        File file = new File("vendingmachine.csv");
        VendingMachineCLI sut = new VendingMachineCLI(file);
        Purchases p = new Purchases();
        p.setCurrentBalance(3.05);

        // Act
        double result = sut.makeAPurchase(p, "A1");
        // Assert
        System.out.println();
        Assert.assertEquals(0.0, result, 0);
    }

}
