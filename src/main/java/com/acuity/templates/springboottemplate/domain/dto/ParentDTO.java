package com.acuity.templates.springboottemplate.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParentDTO {
    private UUID id;

    private String parentName;

    private Integer intField;

    private Double doubleField;

    private Date dateField;

    private String stringField;

    private Boolean booleanField;
}
