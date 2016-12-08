package com.oriansolution.dwt.model;

import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by madhawa on 11/30/16.
 */
// this should extends from Hiarrchy
/*@Entity
@Table(name="REQUESTOR_DETAIL")*/
@Embeddable
public class RequestorDetail implements Serializable {
   /* @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long requestorDetailID;*/
    @Column(name="UPFSERRVICE_ID")
    private String upfServiceId;
    @Column(name="FIRST_NAME")
    private String firstName;
    @Column(name="LAST_NAME")
    private String lastName;
    @Column(name="DESIGNATION")
    private String designation;

    /*@Column(name="WORKREQUEST_ID")
    private String workRequestId;*/

   /* public String getWorkRequestId() {
        return workRequestId;
    }

    public void setWorkRequestId(String workRequestId) {
        this.workRequestId = workRequestId;
    }*/

    public String getUpFServiceId() {
        return upfServiceId;
    }

    public void setUpFServiceId(String upFServiceId) {
        this.upfServiceId = upFServiceId;
    }

    public String getUpFServiceid() {
        return upfServiceId;
    }

    public void setUpFServiceid(String upFServiceId) {
        this.upfServiceId = upFServiceId;
    }

    /*   public long getRequestorDetailID() {
        return requestorDetailID;
    }

    public void setRequestorDetailID(long requestorDetailID) {
        this.requestorDetailID = requestorDetailID;
    }*/

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
