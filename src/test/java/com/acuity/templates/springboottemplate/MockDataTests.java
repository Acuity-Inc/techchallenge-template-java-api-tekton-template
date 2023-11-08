package com.acuity.templates.springboottemplate;

import com.acuity.templates.springboottemplate.domain.entity.Parent;
import com.acuity.templates.springboottemplate.repository.ParentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class MockDataTests {

    @Autowired
    MockData mockData;

    @MockBean
    ParentRepository parentRepository;

    @Test
    void givenStartup_whenMockDataRuns_thenExpectTwoParentSaves() {
        verify(parentRepository, times(2)).save(any(Parent.class));
    }
}