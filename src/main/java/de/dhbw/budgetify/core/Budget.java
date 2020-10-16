package de.dhbw.budgetify.core;

import de.dhbw.budgetify.core.permission.User;

import java.util.Set;

public interface Budget {

    int getId();

    double getMaxValue();

    /**
     * Get the set of cost for the budget
     *
     * @return a clone of the cost set
     */
    Set<Cost> getCost();

    void addCost(Cost cost);

    void removeCost(Cost cost);

    double getUsedValue();

    double getUsedValueAsOfToday();

    /**
     * get the used value forecast for given timestamp
     *
     * @param until unix timestamp
     * @return forecast for the given timestamp
     */
    double getForecast(long until);

    double getAvailableBudget();

    double getAvailableBudgetAsOfToday();


    /**
     * get the expiry for this budget
     *
     * @return unix timestamp as expiry
     */
    long getExpiry();

    long getCreatedAt();

    User getOwner();

    User getCreator();

    void save();
}
