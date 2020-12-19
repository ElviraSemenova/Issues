package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Assignee;
import ru.netology.domain.Issue;
import ru.netology.domain.Label;
import ru.netology.domain.Status;
import ru.netology.exception.NotFoundException;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    private Repository issueRepository = new Repository();

    private Issue issue1 = new Issue(1, "name1", Status.Open, "author1", EnumSet.of(Label.Bug), Arrays.asList("project1", "project2"), "5.7 M2", new Assignee(4, "Name4", "Surname4"), LocalDate.of(2020, 3, 1), 3, 4);
    private Issue issue2 = new Issue(2, "name2", Status.Closed, "author2", EnumSet.of(Label.Featurerequest), Collections.singletonList("project3"), "5.7 Backlog", new Assignee(3, "Name3", "Surname3"), LocalDate.of(2020, 2, 14), 11, 1);
    private Issue issue3 = new Issue(3, "name3", Status.Open, "author3", EnumSet.of(Label.Question), Arrays.asList("project1", "project2"), null, new Assignee(2, "name2", "Surname2"), LocalDate.of(2019, 1, 16), 15, 0);
    private Issue issue4 = new Issue(4, "name4", Status.Closed, "author4", EnumSet.of(Label.Bug), Collections.emptyList(), null, null, LocalDate.of(2019, 4,9), 3, 2);
    private Issue issue5 = new Issue(5, "name5", Status.Open, "author5", EnumSet.of(Label.Question), Collections.singletonList("project2"), "5.7 M2", null, LocalDate.of(2020, 5,6), 0, 0);
    private Issue issue6 = new Issue(6, "name6", Status.Closed, "author2", EnumSet.of(Label.Featurerequest), Collections.emptyList(), null, new Assignee(1, "Name1", "Surname1"), LocalDate.of(2020, 4, 11), 70, 7);

    @BeforeEach()
    void setUp() {
        issueRepository.save(issue1);
        issueRepository.save(issue2);
        issueRepository.save(issue3);
        issueRepository.save(issue4);
        issueRepository.save(issue5);
        issueRepository.save(issue6);
    }

    @Test
    void shouldFindAll() {
        List<Issue> actual = issueRepository.findAll();
        List<Issue> expected = Arrays.asList(issue1, issue2, issue3, issue4, issue5, issue6);
        assertEquals(expected, actual);
    }

    @Test
    void shouldFindById() {
        Issue actual = issueRepository.findById(3);
        assertEquals(issue3, actual);
    }

    @Test
    void shouldThrowException() {
        assertThrows(NotFoundException.class, () -> issueRepository.findById(8));
    }

    @Test
    void shouldOpenById() {
        issueRepository.openById(1);
        Issue byId = issueRepository.findById(1);
        assertSame(byId.getStatus(), Status.Open);
    }

    @Test
    void shouldCloseById() {
        issueRepository.closeById(2);
        Issue byId = issueRepository.findById(2);
        assertSame(byId.getStatus(), Status.Closed);
    }
}