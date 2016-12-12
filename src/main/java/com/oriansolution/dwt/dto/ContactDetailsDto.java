package com.oriansolution.dwt.dto;

/**
 * Created by madhawa on 12/10/16.
 */
public class ContactDetailsDto {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    private long id;
    private String contact;
    private String contactType;
}
