package app.domain;

import javax.persistence.*;

@Entity
@Table(name = "Medicines")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Name")
    private String name;
    @Column(name = "Health_Resource")
    private double healt_resource;

    public Medicine(String name, double healt_resource) {
        this.name = name;
        this.healt_resource = healt_resource;
    }

    public Medicine() {
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

    public double getHealt_resource() {
        return healt_resource;
    }

    public void setHealt_resource(double healt_resource) {
        this.healt_resource = healt_resource;
    }
}
