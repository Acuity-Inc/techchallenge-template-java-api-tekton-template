package com.acuity.templates.springboottemplate.controller;

import com.acuity.templates.springboottemplate.domain.dto.CreateParentDTO;
import com.acuity.templates.springboottemplate.domain.dto.ParentDTO;
import com.acuity.templates.springboottemplate.domain.entity.Parent;
import com.acuity.templates.springboottemplate.domain.mapper.ParentMapper;
import com.acuity.templates.springboottemplate.service.ParentService;
import lombok.val;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class ParentControllerTest {

    private static final UUID PARENT_ID = UUID.fromString("7e7e7e7e-7e7e-7e7e-7e7e-7e7e7e7e7e7e");
    private static Parent parent;
    private static ParentDTO parentDTO;

    @InjectMocks
    final ParentController parentController = new ParentController();

    @Mock
    ParentService parentService;

    @Mock
    ParentMapper parentMapper;

    @BeforeAll
    static void setUp() {
        parent = new Parent(null, "MommaBear", 1, 2.0, Date.valueOf("2005-03-13"), "Mother", true);
        parentDTO = new ParentDTO(PARENT_ID, "MommaBear", 1, 2.0, Date.valueOf("2005-03-13"), "Mother", true);
    }

    @Test
    void givenValidInput_whenGetParentIsCalled_thenReturnParent() {
        // given
        when(parentService.getParent(PARENT_ID)).thenReturn(parent);
        when(parentMapper.toDTO(parent)).thenReturn(parentDTO);

        // when
        val result = parentController.getParent(PARENT_ID);

        // then
        assertEquals(parentDTO, result);
    }

    @Test
    void givenValidRequest_whenGetAllParentsIsCalled_thenReturnAllParents() {
        // given
        val allParents = List.of(parent);
        val allParentsDTO = List.of(parentDTO);
        when(parentService.getAllParents()).thenReturn(allParents);
        when(parentMapper.toDTOList(allParents)).thenReturn(allParentsDTO);

        // when
        val result = parentController.getAllParents();

        // then
        assertEquals(allParentsDTO, result);
    }

    @Test
    void givenValidInput_whenCreateParentIsCalled_thenReturnCreatedParent() {
        // given
        val createParentDTO = new CreateParentDTO("MommaBear", 1, 2.0, Date.valueOf("2005-03-13"), "Mother", true);
        when(parentMapper.createParentDTO(createParentDTO)).thenReturn(parent);
        when(parentService.createParent(parent)).thenReturn(parent);
        when(parentMapper.toDTO(parent)).thenReturn(parentDTO);

        // when
        val result = parentController.createParent(createParentDTO);

        // then
        assertEquals(parentDTO, result);
    }


    @Test
    void givenValidInput_whenUpdateParentIsCalled_thenReturnUpdatedParent() {
        // given
        val updateParentDTO = new ParentDTO(PARENT_ID, "MommaBear", 1, 2.0, Date.valueOf("2005-03-13"), "Mother", true);
        when(parentMapper.toEntity(updateParentDTO)).thenReturn(parent);
        when(parentService.updateParent(parent)).thenReturn(parent);
        when(parentMapper.toDTO(parent)).thenReturn(parentDTO);

        // when
        val result = parentController.updateParent(updateParentDTO);

        // then
        assertEquals(parentDTO, result);
    }

    @Test
    void givenValidRequest_whenDeleteParentIsCalled_thenReturnWithoutException() {
        // when & then
        assertDoesNotThrow(() -> parentController.deleteParent(PARENT_ID));
    }
}
