package com.example.producer.model.dto;

import java.util.Objects;

public class TaskDTO {
    private Integer id;
    private String description;
    private boolean completed;
    private Integer completionPercentage;
    private UserDTO user;

    public TaskDTO() {
    }

    public TaskDTO(Integer id, String description, boolean completed, Integer completionPercentage, UserDTO user) {
        this.id = id;
        this.description = description;
        this.completed = completed;
        this.completionPercentage = completionPercentage;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public Integer getCompletionPercentage() {
        return completionPercentage;
    }

    public void setCompletionPercentage(Integer completionPercentage) {
        this.completionPercentage = completionPercentage;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskDTO taskDTO = (TaskDTO) o;
        return completed == taskDTO.completed &&
                Objects.equals(id, taskDTO.id) &&
                Objects.equals(description, taskDTO.description) &&
                Objects.equals(completionPercentage, taskDTO.completionPercentage) &&
                Objects.equals(user, taskDTO.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, completed, completionPercentage, user);
    }
}
