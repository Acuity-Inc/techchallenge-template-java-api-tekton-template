package com.acuity.templates.springboottemplate.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class CreateParentDTO {

    private String parentName;

    private Integer intField;

    private Double doubleField;

    private Date dateField;

    private String stringField;

    private Boolean booleanField;
}
