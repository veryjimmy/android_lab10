package com.example.user.lab2;

import android.app.Application;
import android.app.Fragment;
import android.test.ApplicationTestCase;
import com.robotium.solo.Solo;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ActivityInstrumentationTestCase2<MainActivity>
{

    private Solo solo;
    public ApplicationTest()
    {
        super(MainActivity.class);
    }

    @Override
    public void setUp() throws Exception
    {
        solo = new Solo(getInstrumentation(), getActivity());
    }
    @Override
    public void tearDown() throws Exception
    {
        solo.finishOpenedActivities();
    }

    public void testMantall() throws Exception
    {
        solo.enterText((EditText)solo.getView(R.id.et_knee),"50");
        solo.enterText((EditText)solo.getView(R.id.et_age),"20");
        boolean notesFound = solo.searchText("169.4") ;
        assertTrue("Note 1 and/or Note 2 are not found", notesFound);
    }

    public void testWomantall() throws Exception
    {
        solo.clickOnButton("男性");
        solo.enterText((EditText)solo.getView(R.id.et_knee),"40");
        solo.enterText((EditText)solo.getView(R.id.et_age),"18");
        boolean notesFound = solo.searchText("149.77") ;
        assertTrue("Note 1 and/or Note 2 are not found", notesFound);
    }

    public void testEstBmi() throws Exception
    {
        solo.clickOnButton("自行輸入");
        solo.enterText((EditText)solo.getView(R.id.et_knee),"50");
        solo.enterText((EditText)solo.getView(R.id.et_age),"20");
        solo.enterText((EditText)solo.getView(R.id.et_weight),"80");
        boolean notesFound = solo.searchText("27.87810021898248") ;
        assertTrue("Note 1 and/or Note 2 are not found", notesFound);
    }

    public void testNomBmi() throws Exception
    {
        solo.clickOnButton("估計值");
        solo.enterText((EditText)solo.getView(R.id.et_knee),"50");
        solo.enterText((EditText)solo.getView(R.id.et_age),"20");
        solo.enterText((EditText)solo.getView(R.id.et_height),"180");
        solo.enterText((EditText)solo.getView(R.id.et_weight),"140");
        boolean notesFound = solo.searchText("43.20987654320987") ;
        assertTrue("Note 1 and/or Note 2 are not found", notesFound);
    }


}

