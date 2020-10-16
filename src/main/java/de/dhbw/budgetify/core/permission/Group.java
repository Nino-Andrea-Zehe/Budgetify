package de.dhbw.budgetify.core.permission;

import java.util.Set;

public interface Group {

    int getId();

    String getName();

    /**
     * Get the set of permissions for the group
     *
     * @return a clone of the permission set
     */
    Set<String> getPermissionSet();

    boolean hasPermission(String permission);

    long getCreatedAt();

    void save();
}
