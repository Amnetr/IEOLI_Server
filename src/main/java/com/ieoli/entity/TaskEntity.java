package com.ieoli.entity;

public class TaskEntity {
    private Integer taskid;

    private String taskdescription;

    public Integer getTaskid() {
        return taskid;
    }

    public void setTaskid(Integer taskid) {
        this.taskid = taskid;
    }

    public String getTaskdescription() {
        return taskdescription;
    }

    public void setTaskdescription(String taskdescription) {
        this.taskdescription = taskdescription == null ? null : taskdescription.trim();
    }
}