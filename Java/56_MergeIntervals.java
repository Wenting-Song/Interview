/*
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
*/
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() < 1){
            return intervals;
        }
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        List<Interval> result = new LinkedList<>();
        for(Interval inter: intervals){
            if(inter.start <= end){
                end = Math.max(end, inter.end);
            } else {
                result.add(new Interval(start, end));
                start = inter.start;
                end = inter.end;
            }
        }
        result.add(new Interval(start, end));
        return result;
    }
}
