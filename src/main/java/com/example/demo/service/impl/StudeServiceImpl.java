package com.exmaple.demo.service.Impl;
import java.util.*;
import org.springframework.sterotype.Service;
import com.example.demo.entity.Student;
@Service
public class StudenteServiceImpl implements StudentService {
    private final Map<long,Student> store = new HasMap<>();
    private long counter =1;
    @Override
    public Student insertStudent(Student st){
        st.setld(counter++);
        store.put(st.getld(),st);
        return st;
    }
    @Override
    public List<Student>
    getAllStudents(){
        return new ArrayList<>(store.v)
    }
}