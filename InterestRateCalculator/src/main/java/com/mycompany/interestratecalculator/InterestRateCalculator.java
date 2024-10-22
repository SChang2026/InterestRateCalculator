/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.interestratecalculator;

/**
 *
 * @author SChang2026
 */
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class InterestRateCalculator {
    // Public constant for interest rate
    public static final double RATE = 0.035; // 3.5% interest rate
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt user for financial amount
        System.out.print("Enter the financial amount: ");
        double amount = scanner.nextDouble();
        
        // Create an instance of InterestRateCalculator
        InterestRateCalculator calculator = new InterestRateCalculator();
        
        // Calculate the total amount with interest
        double totalAmountWithInterest = calculator.calculateTotalAmountWithInterest(amount);
        
        // Prompt user for number of months
        System.out.print("Enter the number of months for repayment: ");
        int months = scanner.nextInt();
        
        // Calculate monthly payments and display results
        calculator.calculateMonthlyPayments(totalAmountWithInterest, months);
        
        scanner.close();
    }


    // Private variables for total amount and monthly payments
    private double remainingAmount;
    private double monthlyPayment;

    // Method to calculate total amount with interest
    public double calculateTotalAmountWithInterest(double amount) {
        double interestAmount = amount * RATE;
        return amount + interestAmount;
    }

    // Method to calculate and display monthly payments
    public void calculateMonthlyPayments(double totalAmount, int months) {
        remainingAmount = totalAmount;

        System.out.println("Monthly Payments:");
        double totalPaid = 0;

        for (int i = 1; i <= months; i++) {
            // Calculate interest for the remaining amount
            double interestForMonth = remainingAmount * RATE;
            
            // Calculate monthly payment
            monthlyPayment = remainingAmount / (months - (i - 1));
            double totalMonthlyPayment = monthlyPayment + interestForMonth;
            
            // Update remaining amount
            remainingAmount -= monthlyPayment;

            // Output the payment for the month
            System.out.println("Month " + i + ": " + formatCurrency(totalMonthlyPayment));
            totalPaid += totalMonthlyPayment;
        }

        // Show total paid and compare with original amount
        System.out.println("\nTotal Amount Paid: " + formatCurrency(totalPaid));
        System.out.println("Original Amount Borrowed: " + formatCurrency(totalAmount));
    }

    // Helper method to format currency
    private String formatCurrency(double amount) {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
        return currencyFormat.format(amount);
    }
}
