package com.splitaccounts.split.test.android;

import android.test.ActivityInstrumentationTestCase2;

import com.splitaccounts.split.ProjectListActivity;

/**
 * Created by gaellecoz on 11.11.2015.
 */
public class TestProjectListActivity extends ActivityInstrumentationTestCase2<ProjectListActivity> {
    public TestProjectListActivity() {
        super(ProjectListActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
    }

    @Override
    protected void runTest() throws Throwable {
        super.runTest();
        getActivity().finish();
    }

    public void testDefaults() {
        // My test stuff
    }

    public void testAddProject() {
        // My test stuff
    }

}
