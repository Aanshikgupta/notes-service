package com.aanshik.notesservice.service;

import com.aanshik.notesservice.payload.NoteDTO;

import java.util.List;

public interface NoteService {
    NoteDTO createNote(NoteDTO noteDTO);
    NoteDTO updateNote(NoteDTO noteDTO);
    boolean deleteNote(NoteDTO noteDTO);
    NoteDTO getNoteById(Long id);
    List<NoteDTO> getAllNotes();

}
