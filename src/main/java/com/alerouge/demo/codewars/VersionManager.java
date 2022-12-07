package com.alerouge.demo.codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class VersionManager {

    private List<Integer> version;
    private final List<List<Integer>> versionHistory;

    public VersionManager(String defaultVersion) {
        if (defaultVersion != null && !defaultVersion.isEmpty()) {
            this.version = initializeVersion(defaultVersion);
        } else {
            this.version = Arrays.asList(0, 0, 1);
        }
        this.versionHistory = new ArrayList<>();
    }
    public VersionManager() {
        this("");
    }

    private List<Integer> initializeVersion(String defaultVersion) {
        Pattern pattern = Pattern.compile("\\w+\\.?");
        Matcher matcher = pattern.matcher(defaultVersion);
        List<Integer> resultList = null;
        try {
            resultList = matcher.results()
                    .limit(3)
                    .map(MatchResult::group)
                    .map(s -> s.replace(".", ""))
                    .mapToInt(Integer::parseInt)
                    .boxed()
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException("Error occured while parsing version!");
        }
        if (resultList.isEmpty()) throw new IllegalArgumentException("Error occured while parsing version!");
        for (int i = resultList.size(); i < 3; i++) {
            resultList.add(0);
        }
        return resultList;
    }

    public VersionManager major() {
        this.handleNewVersion(0);
        return this;
    }

    public VersionManager minor() {
        this.handleNewVersion(1);
        return this;
    }

    public VersionManager patch() {
        this.handleNewVersion(2);
        return this;
    }

    private void handleNewVersion(int index) {
        this.versionHistory.add(new ArrayList<>(this.version));
        for (int i = 0; i < this.version.size(); i++) {
            if (i == index) {
                this.version.set(i, this.version.get(i) + 1);
            } else if (i > index) {
                this.version.set(i, 0);
            }
        }
    }

    public VersionManager rollback() {
        if (this.versionHistory.isEmpty()) throw new IllegalArgumentException("Cannot rollback!");
        this.version = this.versionHistory.remove(this.versionHistory.size() - 1);
        return this;
    }

    public String release() {
        return this.version.stream()
                .map(String::valueOf)
                .collect(Collectors.joining("."));
    }

}
