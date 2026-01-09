package com.anubhavtyagi28.hibernateadv.dto;

public interface IPatientInfo {

    Long getId();
    String getName();
    String getEmail();
    default String toStringValue() {
        return "Patient{id=" + getId()
                + ", name='" + getName()
                + "', email='" + getEmail() + "'}";
    }
}
