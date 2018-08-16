package com.example.xback.tes;

public class ListItem {

    private String head;
    private String auth;
    private String imageUrl;

    public ListItem (String head, String auth, String imageUrl){
        this.head = head;
        this.auth = auth;
        this.imageUrl = imageUrl;
    }

    public String getHead() {
        return head;
    }

    public String getAuth() {
        return auth;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
