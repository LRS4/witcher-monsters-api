package com.example.monsters.model;

import javax.persistence.*;

@Entity
@Table
public class Category {

    //region Properties

    @Id
    @SequenceGenerator(
            name = "monster_category_sequence",
            sequenceName = "monster_category_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "monster_category_sequence"
    )
    private Long id;
    private String name;
    private String displayName;

    //endregion

    //region Constructors

    public Category() {

    }

    public Category(String name,
                    String displayName) {
        this.name = name;
        this.displayName = displayName;
    }

    //endregion

    //region Accessors

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

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", displayName='" + displayName + '\'' +
                '}';
    }

    //endregion
}
