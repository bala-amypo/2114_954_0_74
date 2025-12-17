package com.example.demo.services;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Studentity;
@Service
public class StudeService {
    private Map<Integer, Studentity> details = new HashMap<>();
    public Studentity saveData(Studentity st) {
        details.put(st.getId(), st);
        return st;
    }
    public Studentity getById(int id) {
        return details.get(id);
    }
    public Collection<Studentity> getAll() {
        return details.values();
    }
    public Studentity updateStudent(int id, Studentity st) {
        if(details.containsKey(id)) {
            st.setId(id);
            details.put(id, st);
            return st;
        }
        return null;
    }
}