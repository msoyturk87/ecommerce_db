package com.cybertek.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "unit_of_measures")
public class Uom extends BaseEntity<Integer>{

    private String name;

    private String description;
}
