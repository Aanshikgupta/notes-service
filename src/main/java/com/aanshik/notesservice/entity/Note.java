package com.aanshik.notesservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "notes")
public class Note {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "note_id")
    private Long id;
    @Column(name = "note_title")
    private String title;
    @Column(name = "note_description")
    private String description;
    private Date createdDate;
    private Date lastUpdated;
}
