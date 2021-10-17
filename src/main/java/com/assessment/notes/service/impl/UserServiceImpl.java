package com.assessment.notes.service.impl;

import com.assessment.notes.domain.Note;
import com.assessment.notes.domain.User;
import com.assessment.notes.repository.NoteRepository;
import com.assessment.notes.repository.UserRepository;
import com.assessment.notes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NoteRepository noteRepository;

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }


    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void updateUserNote(Note note, User user) {

    }
}
