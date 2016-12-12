package com.oriansolution.dwt.model;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.*;

/**
 * Created by madhawa on 12/10/16.
 */
@Entity(name="CONTACT_DETAILS")
public class ContactDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="CONTACT_ID",unique = true,nullable = false)
    private long id;
    @Column(name="CONTACT")
    private String contact;
    @Column(name="CONTACT_TYPE")
    private String contactType;
    @ManyToOne(cascade=CascadeType.ALL)
    private WorkRequest workRequest;

    public WorkRequest getWorkRequest() {
        return workRequest;
    }

    public void setWorkRequest(WorkRequest workRequest) {
        this.workRequest = workRequest;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


}
