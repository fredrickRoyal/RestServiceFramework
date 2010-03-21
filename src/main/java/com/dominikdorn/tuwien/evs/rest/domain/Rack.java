package com.dominikdorn.tuwien.evs.rest.domain;

import com.dominikdorn.tuwien.evs.rest.annotations.Restful;

import javax.persistence.*;
import java.util.List;

/**
 * Dominik Dorn
 * 0626165
 * dominik.dorn@tuwien.ac.at
 *
 * A Rack is a defined space with a name that has a
 * certain amount of space available.
 */
@Entity
public class Rack {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "RACK_GEN")
    @SequenceGenerator(name="RACK_GEN", allocationSize=25, sequenceName = "rack_seq")
    private Long id;
    @Basic
    private String name;
    @Basic
    private String description;
    @Basic
    private Integer place;

    @OneToMany(mappedBy = "rack")
    private List<Placement> placements;

    /** generated methods **/
    public Rack() {
    }

    public Rack(Long id, String name, String description, Integer place) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.place = place;
    }

    public Rack(String name, String description, Integer place) {
        this.name = name;
        this.description = description;
        this.place = place;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * place is amount of slots of standardized size that are
     * available in the rack
     * @return
     */
    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public List<Placement> getPlacements() {
        return placements;
    }

    public void setPlacements(List<Placement> placements) {
        this.placements = placements;
    }
}
