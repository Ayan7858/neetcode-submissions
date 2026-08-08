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

//  sort
//  start time ke saath mai stack ka top check karunga
//  stack peek > start --> new room 
//  else pop and assign

// [start]
// [end]
// [0, 5, 15]
// [40, 10, 20]

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a, b) -> a.start - b.start);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(Interval interval : intervals) {
            if(!minHeap.isEmpty() && minHeap.peek() <= interval.start) {
                minHeap.poll();
            }
            minHeap.offer(interval.end);
        }

        return minHeap.size();
    }
}
