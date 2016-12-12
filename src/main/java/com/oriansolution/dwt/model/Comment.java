package com.oriansolution.dwt.model;

import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by madhawa on 11/15/16.
 */
@Entity
@Table(name="COMMENT")
public class Comment implements Serializable {
    @Id
    // @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="COMMENT_ID",unique = true,nullable = false)
    private long commentId;
    @Column(name="CREATED_DATE")
    private Date createdDate;
    @Column(name="MODIFIED_DATE")
    private Date modifieddDate;
    @Column(name="COMMENT")
    private String comment;// check how to support lenghty comment// this shoulbe an array List
    @Column(name="COMMENTED_USERID")
    private String commentedUsedId;

    public WorkRequest getWorkRequest() {
        return workRequest;
    }

    public void setWorkRequest(WorkRequest workRequest) {
        this.workRequest = workRequest;
    }

    //private List<String> history;
    // this history object goes other way round it is a list of comments whic is beinf ordered
    @ManyToOne(cascade=CascadeType.ALL)
    //@JoinColumn(name="REQUEST_IDFORCOMMENT")
    private WorkRequest workRequest;

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long id) {
        this.commentId = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifieddDate() {
        return modifieddDate;
    }

    public void setModifieddDate(Date modifieddDate) {
        this.modifieddDate = modifieddDate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommentedUsedId() {
        return commentedUsedId;
    }

    public void setCommentedUsedId(String commentedUsedId) {
        this.commentedUsedId = commentedUsedId;
    }

    /*public List<String> getHistory() {
        return history;
    }

    public void setHistory(List<String> history) {
        this.history = history;
    }*/
}
