package com.abidsaifeddin.vehiculesgraphql.Models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@EqualsAndHashCode
@Entity
public class Vehicle implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String modelCode;

    private String brandName;

    private LocalDate launchDate;

    private transient String formattedDate;

    public String getFormattedDate() {
        return getLaunchDate().toString();
    }
}
