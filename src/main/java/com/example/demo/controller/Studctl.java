package com.example.demo.controller;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Studentity;
import com.example.demo.services.StudeService;

@RestController
@RequestMapping("/student")

public class Studctl {
    @Autowired
    StudeService ser;
    @PostMapping("/add")
    public Studentity addStudent(@RequestBody Studentity st) {
        return ser.saveData(st);
    }
    @GetMapping("/{id}")
    public Studentity getStudent(@PathVariable int id) {
        return ser.getById(id);
    }
    @GetMapping("/all")
    public Collection<Studentity> getAllStudents() {
        return ser.getAll();
    }
    @PutMapping("/update/{id}")
    public Studentity updateStudent(@PathVariable int id, @RequestBody Studentity st) {
        Studentity updated = ser.updateStudent(id, st);
        if(updated != null) {
            return updated;
        } else {
            throw new RuntimeException("Student with ID " + id + " not found");
        }
    }
}
