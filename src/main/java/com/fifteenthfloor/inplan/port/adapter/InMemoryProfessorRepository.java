package com.fifteenthfloor.inplan.port.adapter;

import com.fifteenthfloor.inplan.domain.model.Professor;
import com.fifteenthfloor.inplan.domain.model.ProfessorRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Valeriy Knyazhev
 */
@Repository
public class InMemoryProfessorRepository implements ProfessorRepository {

    private Set<Professor> professors = new HashSet<> ();

    public InMemoryProfessorRepository() {
        loadProfessors();
    }

    private void loadProfessors() {
        this.professors.add(new Professor());
    }

    @Override
    public ArrayList<Professor> getAllProfessors() {
        return new ArrayList<>(this.professors);
    }

    @Override
    public ArrayList<Professor> getProfessorsByLastName(String lastname) {
        ArrayList<Professor> professors = new ArrayList<>();
        for (Professor professor : this.professors) {
            if (professor.getLastname().equals(lastname)) {
                professors.add(professor);
            }
        }
        return professors;
    }

    @Override
    public Professor getProfessor(long id) {
        return this.professors.stream().filter(pr -> id == pr.getId()).findFirst().orElse(null);
    }

}
