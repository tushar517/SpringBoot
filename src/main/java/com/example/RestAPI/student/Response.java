package com.example.RestAPI.student;

public class Response {
    private String name;
    private String statusMessage;

    public Response(String name) {
        this.name = name;
        this.statusMessage = "Student Created Successfully";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    @Override
    public String toString() {
        return "Response{" +
                "name='" + name + '\'' +
                ", statusMessage='" + statusMessage + '\'' +
                '}';
    }
}
