package practice.interval;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/count-days-without-meetings/description/
 */
public class DaysWithoutAnyMeetings {

    static Comparator<int[]> comparator = Comparator.comparingInt(o -> o[0]);
    public static int countDays(int days, int[][] meetings) {
        if (days == 1)
            return 0;

        Arrays.sort(meetings, comparator);

        int nonMeetingDays = 0;
        int leftMostEndingDay = meetings[0][1];
        for (int i = 1; i < meetings.length; i++) {
            if (meetings[i][0] > leftMostEndingDay) {
                nonMeetingDays += (meetings[i][0] - leftMostEndingDay);
            }
            leftMostEndingDay = Math.max(leftMostEndingDay, meetings[i][1]);
        }
        if(leftMostEndingDay < days){
            nonMeetingDays +=  (days - leftMostEndingDay);
        }
        return nonMeetingDays;
    }

}
