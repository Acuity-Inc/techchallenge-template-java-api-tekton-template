package com.acuity.templates.springboottemplate.service;

import com.acuity.templates.springboottemplate.domain.entity.Parent;
import com.acuity.templates.springboottemplate.domain.exception.ParentNotFoundException;
import com.acuity.templates.springboottemplate.repository.ParentRepository;
import com.acuity.templates.springboottemplate.service.implementation.ParentServiceImpl;
import lombok.val;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class ParentServiceImplTest {

    private static final UUID PARENT_ID = UUID.fromString("7e7e7e7e-7e7e-7e7e-7e7e-7e7e7e7e7e7e");
    private static Parent parent;

    @InjectMocks
    private final ParentService parentService = new ParentServiceImpl();

    @Mock
    private ParentRepository parentRepository;

    @BeforeAll
    static void setUp() {
        parent = new Parent(PARENT_ID, "MommaBear", 1, 2.0, Date.valueOf("2005-03-13"), "Mother", true);
    }

    @Test
    void givenValidInput_whenGetParentIsCalled_thenReturnParent() {
        //given
        when(parentRepository.findById(PARENT_ID)).thenReturn(Optional.of(parent));

        // when
        val result = parentService.getParent(PARENT_ID);

        // then
        assertNotNull(result);
        assertEquals(parent, result);
    }

    @Test
    void givenNonExistentId_whenGetParentIsCalled_thenThrowException() {
        //given
        when(parentRepository.findById(PARENT_ID)).thenReturn(Optional.empty());

        // when & then
        assertThrows(ParentNotFoundException.class, () -> parentService.getParent(PARENT_ID));
    }

    @Test
    void givenValidRequest_whenGetAllParentsIsCalled_thenReturnAllParents() {
        // given
        val parents = List.of(parent);
        when(parentRepository.findAll()).thenReturn(parents);

        // when
        val result = parentService.getAllParents();

        // then
        assertEquals(parents, result);
    }

    @Test
    void givenValidInput_whenCreateParentIsCalled_thenReturnParent() {
        // given
        when(parentRepository.save(parent)).thenReturn(parent);

        // when
        val result = parentService.createParent(parent);

        // then
        assertNotNull(result);
        assertEquals(parent, result);
    }

    @Test
    void givenValidInput_whenUpdateParentIsCalled_thenReturnParent() {
        // given
        when(parentRepository.findById(PARENT_ID)).thenReturn(Optional.of(parent));
        when(parentRepository.save(parent)).thenReturn(parent);

        // when
        val result = parentService.updateParent(parent);

        // then
        assertNotNull(result);
        assertEquals(parent, result);
    }

    @Test
    void givenNonExistentId_whenUpdateParentIsCalled_thenThrowException() {
        // given
        when(parentRepository.findById(PARENT_ID)).thenReturn(Optional.empty());

        // when & then
        assertThrows(ParentNotFoundException.class, () -> parentService.updateParent(parent));
    }

    @Test
    void givenValidInput_whenDeleteParentIsCalled_thenDoNotThrowException() {
        // given
        when(parentRepository.findById(PARENT_ID)).thenReturn(Optional.of(parent));

        // when & then
        assertDoesNotThrow(() -> parentService.deleteParent(PARENT_ID));
    }

    @Test
    void givenNonExistentId_whenDeleteParentIsCalled_thenThrowException() {
        // given
        when(parentRepository.findById(PARENT_ID)).thenReturn(Optional.empty());

        // when & then
        assertThrows(ParentNotFoundException.class, () -> parentService.deleteParent(PARENT_ID));
    }
}
