package com.example.RestAPI.student;

public class Response {
    private String name;
    private String statusMessage;

    public Response(String name) {
        this.name = name;
        this.statusMessage = "Student Created Successfully";
    }
}
