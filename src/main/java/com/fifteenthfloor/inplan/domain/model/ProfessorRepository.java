package com.fifteenthfloor.inplan.domain.model;

import java.util.ArrayList;

/**
 * @author Valeriy Knyazhev
 */
public interface ProfessorRepository {

    ArrayList<Professor> getAllProfessors();

    ArrayList<Professor> getProfessorsByLastName(String lastname);

    Professor getProfessor(long id);

}
