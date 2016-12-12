package com.oriansolution.dwt.model;

import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by madhawa on 11/30/16.
 */

@Embeddable
public class RequestorDetail implements Serializable {

    @Column(name="REQUESTOR_UPM_ID")
    private String requestorUpmServiceId;
    @Column(name="REQUESTOR_FIRST_NAME")
    private String firstName;
    @Column(name="REQUESTOR_LAST_NAME")
    private String lastName;
    @Column(name="REQUESTOR_DESIGNATION")
    private String designation;


    public String getRequestorUpmServiceId() {
        return requestorUpmServiceId;
    }

    public void setRequestorUpmServiceId(String requestorUpmServiceId) {
        this.requestorUpmServiceId = requestorUpmServiceId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }


}
