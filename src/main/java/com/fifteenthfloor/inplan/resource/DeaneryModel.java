package com.fifteenthfloor.inplan.resource;

import com.fifteenthfloor.inplan.domain.model.Deanery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Valeriy Knyazhev
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class DeaneryModel {

    private long id;

    private String label;

    private String login;

    private String email;

    public DeaneryModel(Deanery deanery) {
        setId(deanery.getId());
        setLabel(deanery.getLabel());
        setLogin(deanery.getLogin());
        setEmail(deanery.getEmail());
    }

}
