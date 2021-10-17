package com.assessment.notes.service;

import com.assessment.notes.domain.Note;

public interface UserNoteService {
    Note findById(Long id);
    void removeById(Long id);
}
