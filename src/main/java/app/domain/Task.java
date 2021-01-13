package app.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Name")
    private String name;
    @Column(name = "Reward")
    private double reward;
    @Column(name = "Description")
    private String description;
    @Column(name = "Trust_Level")
    private int trust_level;

    @OneToMany(mappedBy = "trader_id")
    private Set<TraderTasks> traderstasks = new HashSet<>();

    public Task(String name, double reward, String description, int trust_level) {
        this.name = name;
        this.reward = reward;
        this.description = description;
        this.trust_level = trust_level;
    }

    public Task() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Set<TraderTasks> getTradersTasks() {
        return traderstasks;
    }

    public void setTradersTasks(Set<TraderTasks> traders) {
        this.traderstasks = traders;
    }
}
