package com.assessment.notes.repository;

import com.assessment.notes.domain.Note;
import org.springframework.data.repository.CrudRepository;

public interface NoteRepository extends CrudRepository<Note, Long> {
}
