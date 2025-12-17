package com.exmaple.demo.service.Impl;
import java.util.*;
import org.springframework.sterotype.Service;
import com.example.demo.entity.Studentity;
@Service
public class StudentServiceImpl implements StudentService {
    private final Map<long,Studentity> store = new HasMap<>();
    private long counter =1;
    @Override
    public Studentity insertStudent(Studentity st){
        st.setld(counter++);
        store.put(st.getld(),st);
        return st;
    }
    @Override
    public List<Studentity>
    getAllStudent(){
        return new ArrayList<>(store.values());

    }
    @Override
    public Optional<Studentity>
    getOneStudent(Long id){
        return Optional.ofNullable(store.get(id));

    }
    @Override
    public void deleteStudent(Long id){
        store.remove(id);
    }
}