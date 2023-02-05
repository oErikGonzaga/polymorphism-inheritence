package com.gonzaga.polymorphismInheritance.applicatiton;

import com.gonzaga.polymorphismInheritance.entities.Company;
import com.gonzaga.polymorphismInheritance.entities.Individual;
import com.gonzaga.polymorphismInheritance.entities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        List<TaxPayer> list = new ArrayList<TaxPayer>();

        System.out.print("Enter the number of tax payers: ");
        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Tax payer #" + i + " data");
            char type = 0;

            while (type != 'i' || type != 'c') {
                System.out.print("Individual or Company (I/C)? : ");
                type = scanner.next().toLowerCase().charAt(0);

                if (type == 'i') {
                    System.out.print("Name: ");
                    String name = scanner.next();
                    System.out.print("Annual Income: ");
                    double annualIncome = scanner.nextDouble();
                    System.out.print("Health Expenditures: ");
                    double healthExpenditures = scanner.nextDouble();
                    list.add(new Individual(name, annualIncome, healthExpenditures));
                }

                if (type == 'c') {
                    System.out.print("Name: ");
                    String name = scanner.next();
                    System.out.print("Annual Income: ");
                    double annualIncome = scanner.nextDouble();
                    System.out.print("Number of Employees: ");
                    int numberOfEmployees = scanner.nextInt();
                    list.add(new Company(name, annualIncome, numberOfEmployees));
                }
            }
        }

        System.out.print("TAXES PAID: ");
        for (TaxPayer tp : list) {
            System.out.println(tp.getName() + ": $" + String.format("%.2f", tp.tax()));
        }

        double sum = 0.0;
        for (TaxPayer tp : list) {
            sum += tp.tax();
        }

        System.out.print("TOTAL TAXES: $" + String.format("%.2f", sum));
        scanner.close();
    }
}
