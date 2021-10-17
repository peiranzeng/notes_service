package com.assessment.notes.service.impl;

import com.assessment.notes.domain.Note;
import com.assessment.notes.repository.NoteRepository;
import com.assessment.notes.service.UserNoteService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserNoteServiceImpl implements UserNoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Note findById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    @Override
    public void removeById(Long id) {
        noteRepository.deleteById(id);
    }
}
