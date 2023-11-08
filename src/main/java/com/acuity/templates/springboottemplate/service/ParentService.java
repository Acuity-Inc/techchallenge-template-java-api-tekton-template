package com.acuity.templates.springboottemplate.service;

import com.acuity.templates.springboottemplate.domain.entity.Parent;

import java.util.List;
import java.util.UUID;

public interface ParentService {
    Parent getParent(UUID id);

    Parent createParent(Parent parent);

    Parent updateParent(Parent parent);

    void deleteParent(UUID id);

    List<Parent> getAllParents();
}
