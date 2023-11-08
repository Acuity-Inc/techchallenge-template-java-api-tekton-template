package com.acuity.templates.springboottemplate;

import com.acuity.templates.springboottemplate.domain.entity.Parent;
import com.acuity.templates.springboottemplate.repository.ParentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class MockData implements CommandLineRunner {

    private final ParentRepository parentRepository;

    public MockData(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @Override
    public void run(String... strings) {
        Parent parent1 = new Parent(null, "MommaBear", 1, 2.0, Date.valueOf("2005-03-13"), "Mother", true);
        parentRepository.save(parent1);
        Parent parent2 = new Parent(null, "PoppaBear", 2, 3.0, Date.valueOf("2023-09-21"), "Father", false);
        parentRepository.save(parent2);
    }
}