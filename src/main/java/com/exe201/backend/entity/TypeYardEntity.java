package com.exe201.backend.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "type_yards")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TypeYardEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "type_name")
    private String typeName;
}

