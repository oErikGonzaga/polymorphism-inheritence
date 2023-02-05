package com.gonzaga.polymorphismInheritance.entities;

public class Individual extends TaxPayer{

    private double healthExpenditures;

    public Individual(String name, double annualIncome, double healthExpenditures) {
        super(name, annualIncome);
        this.healthExpenditures = healthExpenditures;
    }
    public double getHealthExpenditures() {
        return healthExpenditures;
    }
    public void setHealthExpenditures(double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public double tax() {

        double basicTax;

        basicTax = getAnnualIncome() < 20000 ? getAnnualIncome() * 0.15 : getAnnualIncome() * 0.25;
        basicTax -= getHealthExpenditures() * 0.5;

        if (basicTax < 0)
            basicTax = 0;

        return basicTax;
    }

}
