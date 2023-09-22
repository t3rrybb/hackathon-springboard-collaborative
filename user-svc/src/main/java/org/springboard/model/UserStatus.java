package org.springboard.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserStatus {
    QUEUED("QUEUED"),
    APPROVED("APPROVED"),
    REJECTED("REJECTED"),
    RESIDENT("RESIDENT");

    private final String state;
}