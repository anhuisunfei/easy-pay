package com.payment.module.sys.es.pojo;

import java.util.Date;

/**
 * TODO
 *
 * @author sunf
 * @version 1.0
 * @date 2020/12/11 17:37
 */
public class Post {
    private String user;
    private  String message;
    private Date postDate;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    @Override
    public String toString() {
        return "Post{" +
                "user='" + user + '\'' +
                ", message='" + message + '\'' +
                ", postDate=" + postDate +
                '}';
    }
}
