package com.fifteenthfloor.inplan.resource;

import com.fifteenthfloor.inplan.domain.model.Professor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Valeriy Knyazhev
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class ProfessorModel {

    private long id;

    private String firstname;

    private String middlename;

    private String lastname;

    public ProfessorModel(Professor professor) {
        setId(professor.getId());
        setFirstname(professor.getFirstname());
        setMiddlename(professor.getMiddlename());
        setLastname(professor.getLastname());
    }

}
