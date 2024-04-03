package com.sud.fsbd.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="students_tb")
public record Students(@Id int rollNo, String name, String email) {

}
