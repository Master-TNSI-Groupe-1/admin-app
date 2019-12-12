package com.application.entity;

import java.util.ArrayList;
import java.util.List;

public class TestList {
    private List<Test> testList;

    public TestList() {
        testList = new ArrayList<>();
    }

    public List<Test> getTestList() {
        return testList;
    }

    public void setTestList(List<Test> testList) {
        this.testList = testList;
    }
}
