package com.aanshik.notesservice.controller;

import com.aanshik.notesservice.payload.NoteDTO;
import com.aanshik.notesservice.service.NoteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/{noteId}")
    public ResponseEntity<NoteDTO> getNoteById(@PathVariable Long noteId) {
        return ResponseEntity.ok(noteService.getNoteById(noteId));
    }

    @PostMapping("/")
    public ResponseEntity<NoteDTO> createNote(@Valid @RequestBody NoteDTO noteDTO) {
        return ResponseEntity.accepted().body(noteService.createNote(noteDTO));
    }

    @PutMapping("/")
    public ResponseEntity<NoteDTO> updateNote(@RequestBody NoteDTO noteDTO) {
        return ResponseEntity.accepted().body(noteService.updateNote(noteDTO));
    }

    @DeleteMapping("/")
    public ResponseEntity<Boolean> deleteNote(@RequestBody NoteDTO noteDTO) {
        return ResponseEntity.ok(noteService.deleteNote(noteDTO));
    }

    @GetMapping("/")
    public ResponseEntity<List<NoteDTO>> getAllNotes() {
        return ResponseEntity.ok(noteService.getAllNotes());
    }

}
