package com.assessment.notes.controller;

import com.assessment.notes.domain.Note;
import com.assessment.notes.domain.User;
import com.assessment.notes.service.UserNoteService;
import com.assessment.notes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.Calendar;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    UserService userService;
    @Autowired
    UserNoteService userNoteService;

    @RequestMapping("/")
    public String index() {return "index";}

    @RequestMapping("/login")
    public String login() {
        return "myAccount";
    }

    @RequestMapping("/listNotes")
    public String listNotes(Model model, Principal principal) {
        User user = userService.findByEmail(principal.getName());
        model.addAttribute(user);
        List<Note> noteList = userService.findAllUserNote(user);
        model.addAttribute(noteList);

        return "userNotes";
    }

    @RequestMapping("/updateNotes")
    public String updateNotes(@ModelAttribute("id") Long noteId, Model model, @ModelAttribute("newNote")String newNote, Principal principal) {
        User user = userService.findByEmail(principal.getName());
        Note note = userNoteService.findById(noteId);
        note.setNote(newNote);
        note.setLastUpdateTime(Calendar.getInstance().getTime());
        userService.updateUserNote(note,user);
        List<Note> noteList = user.getNoteList();
        model.addAttribute(noteList);

        return "userNotes";
    }

    @RequestMapping("/createNotes", method = RequestMethod.POST)
    public String createNotes(Model model, @ModelAttribute("newNote")String newNote, @ModelAttribute("newNote")String title, Principal principal) {
        User user = userService.findByEmail(principal.getName());
        Note note = new Note();
        note.setCreateTime(Calendar.getInstance().getTime());
        note.setUser(user);
        note.setLastUpdateTime(Calendar.getInstance().getTime());
        note.setTitle(title);
        note.setNote(newNote);
        userService.addUserNote(note, user);
        List<Note> noteList = user.getNoteList();
        model.addAttribute(noteList);

        return "userNotes";
    }




}
