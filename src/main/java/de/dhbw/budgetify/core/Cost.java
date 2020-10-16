package de.dhbw.budgetify.core;

import de.dhbw.budgetify.core.permission.User;

public interface Cost {

    int getId();

    double getValue();

    void setValue(double value);

    String getDescription();

    long getDate();

    long getLastUpdatedAt();

    /**
     * returns true if current unix timestamp is greater or equals then getDate()
     *
     * @return true or false
     */
    boolean occurred();

    User getCreator();

    User getLastUpdatedBy();

    void setLastUpdatedBy(User user);

    void setLastUpdatedAt(long lastUpdatedAt);
}
