package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
public class Issue {
    private int id;
    private String name;
    private Status status;
    private String author;
    private EnumSet<Label> labels;
    private Set<String> projects = new HashSet<>();
    private String milestone;
    private Assignee assignee;
    private LocalDate date;
    private int commentsCount;
    private int pullRequestCount;

    public Issue(int id, String name, Status status, String author, EnumSet<Label> labels, Collection<String> projects, String milestone, Assignee assignee, LocalDate date, int commentsCount, int pullRequestCount) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.author = author;
        this.labels = labels;
        this.milestone = milestone;
        this.assignee = assignee;
        this.date = date;
        this.commentsCount = commentsCount;
        this.pullRequestCount = pullRequestCount;
        this.projects.addAll(projects);
    }
}