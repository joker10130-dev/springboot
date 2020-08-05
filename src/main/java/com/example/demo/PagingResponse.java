package com.example.demo;

import java.util.List;

public class PagingResponse {
    private List<UsersResponse> users;
    private int page;
    private int itemPerPage;

    public PagingResponse(int page, int itemPerPage) {
        this.page = page;
        this.itemPerPage = itemPerPage;
    }

    public List<UsersResponse> getUsers() {
        return users;
    }

    public void setUsers(List<UsersResponse> users) {
        this.users = users;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getItemPerPage() {
        return itemPerPage;
    }

    public void setItemPerPage(int itemPerPage) {
        this.itemPerPage = itemPerPage;
    }
}
