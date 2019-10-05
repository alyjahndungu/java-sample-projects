package com.turnkeyproject.turnkey.Controller;

import com.turnkeyproject.turnkey.Exception.ResourceNotFoundException;
import com.turnkeyproject.turnkey.Model.Note;
import com.turnkeyproject.turnkey.Repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/diary")
public class NoteController {
    @Autowired
    NoteRepository noteRepository;

    //To get all notes
    @GetMapping("/notes")
    public List<Note> getAllNotes(){
        return noteRepository.findAll();
    }

    //Creating a new note
    @PostMapping("/notes")
        public Note createNote(@Valid @RequestBody Note note){
            return noteRepository.save(note);
        }
 //to get a single note
    @GetMapping("/notes/{id}")
    public Note getNoteById(@PathVariable(value = "id") Long noteId){
 return noteRepository.findById(noteId)
         .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
    }
    //To update a new or existing note
    @PutMapping("/notes/{id}")
    public Note updateNote(@PathVariable(value = "id") Long noteId,
                           @Valid @RequestBody Note noteDetails) {
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());
        Note updatedNote = noteRepository.save(note);
        return updatedNote;
    }

    // Deleting a Note
    @DeleteMapping("/notes/{id}")
    public  ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
        noteRepository.delete(note);
        return ResponseEntity.ok().build();

    }

    }
