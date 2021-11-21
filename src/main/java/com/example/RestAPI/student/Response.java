package com.example.RestAPI.student;

public class Response {
    private String name;
    private String statusMessage;

    public Response(String name) {
        this.name = name;
        this.statusMessage = "Student Created Successfully";
    }

    @Override
    public String toString() {
        return "Response{" +
                "name='" + name + '\'' +
                ", statusMessage='" + statusMessage + '\'' +
                '}';
    }
}
