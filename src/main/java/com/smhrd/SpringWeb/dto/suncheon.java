package com.smhrd.SpringWeb.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class suncheon {
    @Id
    private int num;
    @Column(length = 3000)
    private String name;
    private String gender;

}
