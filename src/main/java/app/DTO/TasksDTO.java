package app.DTO;

import app.domain.Task;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class TasksDTO {
    @NotNull
    private String name;
    @NotNull
    @Min(value = 0)
    private double reward;
    @NotNull
    private String description;
    @NotNull
    @Min(value = 1)
    @Max(value = 4)
    private int trust_level;

    public TasksDTO() {
    }

    public TasksDTO(Task task) {
        this.name = task.getName();
        this.reward = task.getReward();
        this.description = task.getDescription();
        this.trust_level = task.getTrust_level();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getReward() {
        return reward;
    }

    public void setReward(double reward) {
        this.reward = reward;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTrust_level() {
        return trust_level;
    }

    public void setTrust_level(int trust_level) {
        this.trust_level = trust_level;
    }
}
