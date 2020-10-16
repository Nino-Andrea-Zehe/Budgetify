package de.dhbw.budgetify.core.permission.impl;

import de.dhbw.budgetify.core.permission.Group;
import de.dhbw.budgetify.core.permission.User;

public class BudgetifyUser implements User {

    //Eigenschaften von User
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private long createdAt;
    private Group group;

    public BudgetifyUser(int id, String firstName, String lastName, String username, String password, long createdAt, Group group) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.createdAt = createdAt;
        this.group = group;
    }

    //Public Getter-Methoden für Eigenschaften
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Group getGroup() {
        return group;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public boolean hasPermission(String permission) {
        return group.hasPermission(permission);
    }

    public void save() {

    }
}
