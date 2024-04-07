package com.aanshik.notesservice.payload;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteDTO {
    private Long id;
    @NotBlank(message = "Please enter a valid title")
    private String title;
    @NotBlank(message = "Please enter a valid description")
    private String description;
    private Date createdDate = new Date(System.currentTimeMillis());
    private Date lastUpdated = new Date(System.currentTimeMillis());
}
