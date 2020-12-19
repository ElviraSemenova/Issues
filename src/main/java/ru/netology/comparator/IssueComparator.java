package ru.netology.comparator;

import ru.netology.domain.Issue;

import java.util.Comparator;

public class IssueComparator implements Comparator<Issue> {

    public int compare(Issue o1, Issue o2) {
        return Integer.compare(o2.getId(), o1.getId());
    }
}
