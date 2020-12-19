package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;

import java.util.ArrayList;
import java.util.List;

class EmptyRepositoryTest {

    private Repository issueRepository = new Repository();

    @Test
    void shouldFindAll() {
        List<Issue> actual = issueRepository.findAll();
        List<Issue> expected = new ArrayList<>();
        Assertions.assertEquals(expected, actual);
    }
}
