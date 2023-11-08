package com.acuity.templates.springboottemplate.controller;

import com.acuity.templates.springboottemplate.domain.dto.CreateParentDTO;
import com.acuity.templates.springboottemplate.domain.dto.ParentDTO;
import com.acuity.templates.springboottemplate.domain.entity.Parent;
import com.acuity.templates.springboottemplate.domain.mapper.ParentMapper;
import com.acuity.templates.springboottemplate.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class ParentController {

    @Autowired
    ParentService parentService;

    @Autowired
    ParentMapper parentMapper;

    @GetMapping("/parents/{id}")
    public ParentDTO getParent(@PathVariable UUID id) {
        return parentMapper.toDTO(parentService.getParent(id));
    }

    @GetMapping("/parents")
    public List<ParentDTO> getAllParents() {
        return parentMapper.toDTOList(parentService.getAllParents());
    }

    @PostMapping("/parents")
    public ParentDTO createParent(@RequestBody CreateParentDTO createParentDTO) {
        Parent parent = parentMapper.createParentDTO(createParentDTO);
        return parentMapper.toDTO(parentService.createParent(parent));
    }

    @PutMapping("/parents")
    public ParentDTO updateParent(@RequestBody ParentDTO parentDTO) {
        Parent parent = parentMapper.toEntity(parentDTO);
        return parentMapper.toDTO(parentService.updateParent(parent));
    }

    @DeleteMapping("/parents/{id}")
    public void deleteParent(@PathVariable UUID id) {
        parentService.deleteParent(id);
    }
}
