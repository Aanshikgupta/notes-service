package com.aanshik.notesservice.mapper;

import com.aanshik.notesservice.entity.Note;
import com.aanshik.notesservice.payload.NoteDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObjectMapper {
    @Autowired
    private ModelMapper modelMapper;

    public NoteDTO getDTOFromEntity(Note note) {
        return modelMapper.map(note, NoteDTO.class);
    }

    public Note getEntityFromDTO(NoteDTO noteDTO) {
        return modelMapper.map(noteDTO, Note.class);
    }
}
