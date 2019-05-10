package com.talfinder.assessment;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Created by shashidhara on 5/10/19.
 */
@RunWith(Parameterized.class)
public class TimeDifferenceTest {

  @Parameters
  public static Collection<Object[]> parameters() {
    return Arrays.asList(new Object[][] {
        {new String[] {"01:00", "01:25"}, 25},
        {new String[] {"01:00", "01:00"}, 0},
        {new String[] {"22:00", "00:30"}, 150},
        {new String[] {"11:00", "12:02", "11:58"}, 4},
        {new String[] {"10:00", "23:59", "00:00"}, 1},
        {new String[] {"11:30", "11:30", "11:30"}, 0},
        {new String[] {"06:30", "00:00", "13:00"}, 60},
        {new String[] {"", "00:00", "11:30"}, 30}
    });
  }

  private final String[] inputTimes;
  private final Integer smallestDifference;

  public TimeDifferenceTest(String[] inputTimes, int smallestDifference) {
    this.inputTimes = inputTimes;
    this.smallestDifference = smallestDifference;
  }

  @Test
  public void findSmallestMinuteDifference() {
    Assert.assertEquals("input:Time inputs as " + Arrays.toString(inputTimes), smallestDifference, TimeDifference.getSmallestMinuteDifference(inputTimes));
  }
}
