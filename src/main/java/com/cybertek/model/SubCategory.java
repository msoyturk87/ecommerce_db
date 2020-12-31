package com.cybertek.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "sub_categories")
public class SubCategory extends BaseEntity<Integer>{

    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
