package de.dhbw.budgetify.core.impl;

import de.dhbw.budgetify.core.Cost;
import de.dhbw.budgetify.core.permission.User;

public class BudgetifyCost implements Cost {

    private int id;
    private double value;
    private String description;
    private long date;
    private long lastUpdatedAt;
    private boolean occurred;
    private User creator;
    private User lastUpdatedBy;

    public BudgetifyCost(int id, double value, String description, long date, long lastUpdatedAt, boolean occurred, User creator, User lastUpdatedBy) {
        this.id = id;
        this.value = value;
        this.description = description;
        this.date = date;
        this.lastUpdatedAt = lastUpdatedAt;
        this.occurred = occurred;
        this.creator = creator;
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public int getId() {
        return this.id;
    }

    public double getValue() {
        return this.value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getDescription() {
        return this.description;
    }

    public long getDate() {
        return this.date;
    }

    public long getLastUpdatedAt() {
        return this.lastUpdatedAt;
    }

    public boolean occurred() {
        return System.currentTimeMillis() >= getDate();
    }

    public User getCreator() {
        return this.creator;
    }

    public User getLastUpdatedBy() {
        return this.lastUpdatedBy;
    }

    public void setLastUpdatedBy(User user) {
        this.lastUpdatedBy = user;
    }

    public void setLastUpdatedAt(long lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }
}
