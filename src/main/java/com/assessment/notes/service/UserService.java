package com.assessment.notes.service;

import com.assessment.notes.domain.Note;
import com.assessment.notes.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User findByEmail(String email);

    User findById(Long id);

    User createUser(User user);

    User save(User user);

    void updateUserNote(Note note, User user);

    void addUserNote(Note note, User user);

    List<Note> findAllUserNote(User user);

    void deleteUserNote(Note note, User user);
}
