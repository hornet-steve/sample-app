package com.hornetdevelopment.sample.domain;

/**
 * Created by steve on 4/21/17.
 */
public class ApplicationStatus {

    public enum STATUS {
        OK,
        NOTOK
    }

    private final String description;
    private final STATUS status;

    public ApplicationStatus(String description, STATUS status) {
        this.description = description;
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public STATUS getStatus() {
        return status;
    }
}
