package softuni.exam.models.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

import static softuni.exam.config.Messages.EXPORT_NON_OBSERVED_STARS;

@Entity
@Table(name = "stars")
public class Star extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String name;

    @Column(name = "light_years",nullable = false)
    private double lightYears;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "star_type", nullable = false)
    private StarType starType;

    @OneToMany(targetEntity = Astronomer.class, mappedBy = "observingStar")
    private Set<Astronomer> observers;

    @ManyToOne
//    @JoinColumn(name = "constellation_id", referencedColumnName = "id")
    private Constellation constellation;

    public Star() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLightYears() {
        return lightYears;
    }

    public void setLightYears(double lightYears) {
        this.lightYears = lightYears;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StarType getStarType() {
        return starType;
    }

    public void setStarType(StarType starType) {
        this.starType = starType;
    }

    public Set<Astronomer> getObservers() {
        return observers;
    }

    public void setObservers(Set<Astronomer> observers) {
        this.observers = observers;
    }

    public Constellation getConstellation() {
        return constellation;
    }

    public void setConstellation(Constellation constellation) {
        this.constellation = constellation;
    }

    @Override
    public String toString() {
        return String.format(EXPORT_NON_OBSERVED_STARS,
                this.name, this.lightYears, this.description,this.constellation.getName());
    }
}
