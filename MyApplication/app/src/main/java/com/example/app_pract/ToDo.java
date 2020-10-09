package com.example.app_pract;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToDo {

    private String[] id = null;

    public String[] getId() {
        return id;
    }

    public void setId(String[] id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + Arrays.toString(id) +
                '}';
    }

}
