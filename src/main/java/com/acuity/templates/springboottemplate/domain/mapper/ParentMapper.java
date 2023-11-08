package com.acuity.templates.springboottemplate.domain.mapper;

import com.acuity.templates.springboottemplate.domain.dto.CreateParentDTO;
import com.acuity.templates.springboottemplate.domain.dto.ParentDTO;
import com.acuity.templates.springboottemplate.domain.entity.Parent;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ParentMapper {

    ParentDTO toDTO(Parent parent);

    List<ParentDTO> toDTOList(List<Parent> parent);

    Parent createParentDTO(CreateParentDTO createParentDTO);

    Parent toEntity(ParentDTO parentDTO);
}
