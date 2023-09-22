package org.springboard.model;

public enum UserStatus {
    QUEUED("QUEUED"),
    APPROVED("APPROVED"),
    REJECTED("REJECTED");

    private final String state;

    public String getState() {
        return state;
    }

    UserStatus(String state) {
        this.state = state;

    }
}
