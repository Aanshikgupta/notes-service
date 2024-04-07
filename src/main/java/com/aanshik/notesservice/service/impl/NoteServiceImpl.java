package com.aanshik.notesservice.service.impl;

import com.aanshik.notesservice.entity.Note;
import com.aanshik.notesservice.exception.ResourceNotFoundException;
import com.aanshik.notesservice.mapper.ObjectMapper;
import com.aanshik.notesservice.payload.NoteDTO;
import com.aanshik.notesservice.repository.NoteRepository;
import com.aanshik.notesservice.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    private final ObjectMapper objectMapper;

    @Autowired
    public NoteServiceImpl(NoteRepository noteRepository, ObjectMapper objectMapper) {
        this.noteRepository = noteRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public NoteDTO createNote(NoteDTO noteDTO) {
        return objectMapper.getDTOFromEntity(noteRepository.save(objectMapper.getEntityFromDTO(noteDTO)));
    }

    @Override
    public NoteDTO updateNote(NoteDTO noteDTO) {
        noteDTO.setLastUpdated(new Date(System.currentTimeMillis()));
        return objectMapper.getDTOFromEntity(noteRepository.save(objectMapper.getEntityFromDTO(noteDTO)));
    }

    @Override
    public boolean deleteNote(NoteDTO noteDTO) {
        try {
            noteRepository.delete(objectMapper.getEntityFromDTO(noteDTO));
            return true;
        } catch (Exception e) {
            throw new ResourceNotFoundException(noteDTO.getId(), "Note");
        }
    }

    @Override
    public NoteDTO getNoteById(Long id) {
        Optional<Note> note = noteRepository.findById(id);
        if (note.isPresent()) {
            return objectMapper.getDTOFromEntity(note.get());
        } else {
            throw new ResourceNotFoundException(id, "Note");
        }
    }

    @Override
    public List<NoteDTO> getAllNotes() {
        return noteRepository.findAll().stream().map(objectMapper::getDTOFromEntity).collect(Collectors.toList());
    }
}
