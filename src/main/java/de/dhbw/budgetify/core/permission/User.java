package de.dhbw.budgetify.core.permission;

public interface User {

    int getId();

    String getFirstName();

    String getLastName();

    String getUsername();

    String getPassword();

    Group getGroup();

    boolean hasPermission(String permission);

    long getCreatedAt();

    void save();
}
