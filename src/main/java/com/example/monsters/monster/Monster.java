package com.example.monsters.monster;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Monster {
    @Id
    @SequenceGenerator(
            name = "monster_sequence",
            sequenceName = "monster_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "monster_sequence"
    )
    private Long id;
    private String name;
    private String entry;
    private String imageUrl;
    private String occurrence;
    private String susceptibility;
    private String loot;
    private LocalDate dateAdded;
    private Integer classCategory;

    public Monster() {
    }

    public Monster(Long id,
                   String name,
                   String entry,
                   String imageUrl,
                   String occurrence,
                   String susceptibility,
                   String loot,
                   LocalDate dateAdded,
                   Integer classCategory) {
        this.id = id;
        this.name = name;
        this.entry = entry;
        this.imageUrl = imageUrl;
        this.occurrence = occurrence;
        this.susceptibility = susceptibility;
        this.loot = loot;
        this.dateAdded = dateAdded;
        this.classCategory = classCategory;
    }

    public Monster(String name,
                   String entry,
                   String imageUrl,
                   String occurrence,
                   String susceptibility,
                   String loot,
                   LocalDate dateAdded,
                   Integer classCategory) {
        this.name = name;
        this.entry = entry;
        this.imageUrl = imageUrl;
        this.occurrence = occurrence;
        this.susceptibility = susceptibility;
        this.loot = loot;
        this.dateAdded = dateAdded;
        this.classCategory = classCategory;
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

    public String getEntry() {
        return entry;
    }

    public void setEntry(String entry) {
        this.entry = entry;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getOccurrence() {
        return occurrence;
    }

    public void setOccurrence(String occurrence) {
        this.occurrence = occurrence;
    }

    public String getSusceptibility() {
        return susceptibility;
    }

    public void setSusceptibility(String susceptibility) {
        this.susceptibility = susceptibility;
    }

    public String getLoot() {
        return loot;
    }

    public void setLoot(String loot) {
        this.loot = loot;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Integer getClassCategory() {
        return classCategory;
    }

    public void setClassCategory(Integer classCategory) {
        this.classCategory = classCategory;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", entry='" + entry + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", occurrence='" + occurrence + '\'' +
                ", susceptibility='" + susceptibility + '\'' +
                ", loot='" + loot + '\'' +
                ", dateAdded=" + dateAdded +
                ", classCategory=" + classCategory +
                '}';
    }
}
