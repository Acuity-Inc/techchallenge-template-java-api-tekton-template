package com.acuity.templates.springboottemplate.service.implementation;

import com.acuity.templates.springboottemplate.domain.entity.Parent;
import com.acuity.templates.springboottemplate.domain.exception.ParentNotFoundException;
import com.acuity.templates.springboottemplate.repository.ParentRepository;
import com.acuity.templates.springboottemplate.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParentServiceImpl implements ParentService {

    @Autowired
    ParentRepository parentRepository;

    @Override
    public Parent getParent(UUID id) {
        return parentRepository.findById(id).orElseThrow(() -> new ParentNotFoundException(id));
    }

    @Override
    public Parent createParent(Parent parent) {
        return parentRepository.save(parent);
    }

    @Override
    public Parent updateParent(Parent parent) {
        Optional<Parent> foundParent = parentRepository.findById(parent.getId());
        if (foundParent.isPresent()) {
            return parentRepository.save(parent);
        } else {
            throw new ParentNotFoundException(parent.getId());
        }
    }

    @Override
    public void deleteParent(UUID id) {
        Optional<Parent> foundParent = parentRepository.findById(id);
        if (foundParent.isPresent()) {
            parentRepository.deleteById(id);
        } else {
            throw new ParentNotFoundException(id);
        }
    }

    @Override
    public List<Parent> getAllParents() {
        return parentRepository.findAll();
    }
}
