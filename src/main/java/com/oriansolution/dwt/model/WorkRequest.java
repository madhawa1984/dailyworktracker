package com.oriansolution.dwt.model;



import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by madhawa on 11/15/16.
 */
@Entity
@Table(name="WORKREQUEST")
public class WorkRequest implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="WORKREQUEST_SEQ")
    @SequenceGenerator(
            name="WORKREQUEST_SEQ",
            sequenceName="WORKREQUEST_SEQ_MYSQL",
            allocationSize=10
    )*/
    // need to considere about the custom id generation
    @Column(name = "ID", unique = true, nullable = false)
    private long id;
    @Column(name = "REQUEST_ID")
    private String requestID;
    @Column(name = "DELIEVERY_FORMAT")
    private String delieveryFormat;
    @Column(name = "FREQUENCY")
    private String frequency;


    // comment relationship<onre request is having many comments .comment will have only one request id >
    @OneToMany(cascade=CascadeType.ALL,mappedBy = "workRequest")
    //@JoinTable(name="WORK_REQUEST_COMMENTS",@JoinColumns=@JoinColumn("ID"))
    private List<Comment> listOfComments;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="BRANCH_ID_OF_REQUEST")
    private Branch branch;
    @Embedded
    private RequestorDetail requestor;

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public RequestorDetail getRequestor() {
        return requestor;
    }

    public void setRequestor(RequestorDetail requestor) {
        this.requestor = requestor;
    }

   /* private Date createdDate;
    private Date dueDate;
    private Date modifiedDate;
    private Date closedDate;*/

    public List<Comment> getListOfComments() {
        return listOfComments;
    }

    public void setListOfComments(List<Comment> listOfComments) {
        this.listOfComments = listOfComments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public String getDelieveryFormat() {
        return delieveryFormat;
    }

    public void setDelieveryFormat(String delieveryFormat) {
        this.delieveryFormat = delieveryFormat;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }


    /*public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Date getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(Date closedDate) {
        this.closedDate = closedDate;
    }

    public ArrayList<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(ArrayList<Comment> commentList) {
        this.commentList = commentList;
    }

    private ArrayList<Comment> commentList; // hibernate relationship mappings comes here*/
}
