package de.dhbw.budgetify.core.impl;

import de.dhbw.budgetify.core.Budget;
import de.dhbw.budgetify.core.Cost;
import de.dhbw.budgetify.core.permission.User;

import java.util.HashSet;
import java.util.Set;

public class BudgetifyBudget implements Budget {

    private int id;
    private double maxValue;
    private Set<Cost> setOfCosts;
    private long expiry;
    private long createdAt;
    private User owner;
    private User creator;

    public BudgetifyBudget(int id, double maxValue, Set<Cost> setOfCosts, long expiry, long createdAt, User owner, User creator) {
        this.id = id;
        this.maxValue = maxValue;
        this.setOfCosts = setOfCosts;
        this.expiry = expiry;
        this.createdAt = createdAt;
        this.owner = owner;
        this.creator = creator;
    }

    public int getId() {
        return this.id;
    }

    public double getMaxValue() {
        return this.maxValue;
    }

    public Set<Cost> getCost() {
        return new HashSet<Cost>(setOfCosts);
    }

    public void addCost(Cost cost) {
        setOfCosts.add(cost);
    }

    public void removeCost(Cost cost) {
        setOfCosts.remove(cost);
    }

    public double getUsedValue() {
        double usedValue = 0;
        for (Cost temp : setOfCosts) {
            usedValue += temp.getValue();
        }
        return usedValue;
    }

    public double getUsedValueAsOfToday() {
        double usedValue = 0;
        for (Cost temp : setOfCosts) {
            if (temp.occurred()) {
                usedValue += temp.getValue();
            }
        }
        return usedValue;
    }

    public double getForecast(long until) {
        double foreCast = 0;
        for (Cost temp : setOfCosts) {
            if (temp.getDate() <= until) {
                foreCast += temp.getValue();
            }
        }
        return foreCast;
    }

    public double getAvailableBudget() {
        return maxValue - getUsedValue();
    }

    public double getAvailableBudgetAsOfToday() {
        return maxValue - getUsedValueAsOfToday();
    }

    public long getExpiry() {
        return this.expiry;
    }

    public long getCreatedAt() {
        return this.createdAt;
    }

    public User getOwner() {
        return this.owner;
    }

    public User getCreator() {
        return this.creator;
    }

    public void save() {

    }
}
