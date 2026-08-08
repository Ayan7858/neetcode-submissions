/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, Comparator.comparingInt(i -> i.start));

        for(int i = 1; i < intervals.size(); i++){
            int l1 = intervals.get(i-1).end;
            int l2 = intervals.get(i).start;

            if(l1 > l2) return false;
        }
        return true;
    }
}
