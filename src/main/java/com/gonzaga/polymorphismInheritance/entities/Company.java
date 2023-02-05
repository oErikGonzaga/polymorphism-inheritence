package com.gonzaga.polymorphismInheritance.entities;

public class Company extends TaxPayer{

    private int numberOfEmployees;

    public Company(String name, double annualIncome, int numberOfEmployees) {
        super(name, annualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }
    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public double tax() {
        return getNumberOfEmployees() > 10 ? getAnnualIncome() * 0.14 : getAnnualIncome() * 0.16;
    }
}
