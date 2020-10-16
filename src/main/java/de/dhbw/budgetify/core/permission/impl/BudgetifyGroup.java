package de.dhbw.budgetify.core.permission.impl;

import de.dhbw.budgetify.core.permission.Group;

import java.util.HashSet;
import java.util.Set;

public class BudgetifyGroup implements Group {

    //Eigenschaften der Group
    private int id;
    private String name;
    private Set<String> permissionSet;
    private long createdAt;

    public BudgetifyGroup(int id, String name, Set<String> permission, long createdAt) {
        this.id = id;
        this.name = name;
        this.permissionSet = permission;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<String> getPermissionSet() {
        return new HashSet<String>(permissionSet);
    }

    public boolean hasPermission(String permission) {
        return permissionSet.contains(permission.toLowerCase());
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void save() {

    }
}
