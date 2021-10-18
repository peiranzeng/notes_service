package com.assessment.notes.service.impl;

import com.assessment.notes.domain.Note;
import com.assessment.notes.domain.User;
import com.assessment.notes.repository.NoteRepository;
import com.assessment.notes.repository.UserRepository;
import com.assessment.notes.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
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
        User localUser = userRepository.findByEmail(user.getEmail());
        if(localUser != null) {
            LOG.info("user {} already exists. Nothing will be done.", user.getEmail());
        }else {
            user.setNoteList(new ArrayList<Note>());
            user.setCreateTime(Calendar.getInstance().getTime());
            user.setLastUpdateTime(Calendar.getInstance().getTime());
            localUser = userRepository.save(user);
        }

        return localUser;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void updateUserNote(Note note, User user) {
        List<Note> noteList = user.getNoteList();
        for(Note n : noteList) {
            if(n.getId() == note.getId()){
                noteRepository.save(n);
            }
        }
        save(user);
    }

    @Override
    public void addUserNote(Note note, User user) {
        note.setUser(user);
        user.getNoteList().add(note);
        save(user);
    }

    @Override
    public List<Note> findAllUserNote(User user) {
        return user.getNoteList();
    }

    @Override
    public void deleteUserNote(Note note, User user) {
        List<Note> noteList = user.getNoteList();
        for(Note n : noteList) {
            if(n.getId() == note.getId()){
                noteList.remove(n);
                noteRepository.delete(n);
            }
        }
        save(user);
    }


}
