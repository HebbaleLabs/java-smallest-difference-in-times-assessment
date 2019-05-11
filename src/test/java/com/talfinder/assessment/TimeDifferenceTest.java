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
        {new String[] {"00:00", "00:01", "00:10", "01:00", "10:00"}, 1},
        {new String[] {"00:00", "00:09", "00:59", "23:00", "23:59"}, 9},
        {new String[] {"22:33", "20:33", "00:33", "00:30"}, 3},
        {new String[] {"18:57", "10:43", "01:56", "00:24"}, 92},
        {new String[] {"01:00", "01:20", "01:15", "01:11", "01:05"}, 4},
        {new String[] {"03:00", "03:30", "03:45", "03:20", "04:30"}, 10}
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
