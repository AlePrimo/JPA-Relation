package com.jpa.entities;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "competitions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder

public class FootballCompetition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(columnDefinition = "VARCHAR(150)")
    String name;
    Integer prize;
    @Column(name = "start_date" ,columnDefinition = "DATE")
    LocalDate startDate;
    @Column(name = "end_date", columnDefinition = "DATE")
    LocalDate endDate;






}
