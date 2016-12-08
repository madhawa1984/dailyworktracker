package com.oriansolution.dwt.dto;

import java.util.Date;
import java.util.List;

/**
 * Created by madhawa on 11/27/16.
 */
public class CommentsDto {
    private long id;
    private String createdDate;
    private String modifieddDate;
    private String comment;// check how to support lenghty comment// this shoulbe an array List

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifieddDate() {
        return modifieddDate;
    }

    public void setModifieddDate(String modifieddDate) {
        this.modifieddDate = modifieddDate;
    }


    //private List<String> history;
}
