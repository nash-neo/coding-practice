package airbnb;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoom {

    //Time: O(nlogk), k = meetings.size(), n is the total number of meetings
    //Space: O(k)
    public List<Meeting> find(List<List<Meeting>> meetings) {
        List<Meeting> result = new ArrayList<>();
        Queue<MeetingWithIndex> queue = new PriorityQueue<>((a,b) ->  a.start-b.start);
        for (int i = 0; i < meetings.size(); ++i) { //O(klogk)
            if (!meetings.get(i).isEmpty()) {
                Meeting m = meetings.get(i).get(0);
                queue.offer(new MeetingWithIndex(m.start, m.end, i, 0));
            }
        }
        Meeting tmp = null;
        while (!queue.isEmpty()) { //O(nlogk)
            MeetingWithIndex top = queue.poll();
            if (top.j < meetings.get(top.i).size()-1) { //not the last, add next
                Meeting next = meetings.get(top.i).get(top.j+1);
                queue.offer(new MeetingWithIndex(next.start, next.end, top.i, top.j+1));
            }
            if (tmp == null) {
                tmp = new Meeting(top.start, top.end);
            }
            else {
                if (tmp.end < top.start) {
                    result.add(tmp);
                    tmp = new Meeting(top.start, top.end);
                }
                else {
                    tmp.end = Math.max(tmp.end, top.end);
                }
            }
        }
        if (tmp != null) {
            result.add(tmp);
        }
        List<Meeting> breaks = new ArrayList<>();
        if (result.isEmpty()) {
            return breaks;
        }
        int end = result.get(0).end;
        for (int i = 1; i < result.size(); ++i) {
            breaks.add(new Meeting(end, result.get(i).start));
            end = result.get(i).end;
        }
        return breaks;
    }

    static class Meeting {
        int start;
        int end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return start + ":" + end;
        }

    }

    static class MeetingWithIndex extends Meeting {
        int i; //ith list
        int j; //jth element of ith list
        MeetingWithIndex(int start, int end, int i, int j) {
            super(start, end);
            this.i = i;
            this.j = j;
        }
    }

    //merge Time: O(n^2), Space: O(1) excluding output
    public List<Meeting> find2(List<List<Meeting>> meetings) {
        List<Meeting> merged = new ArrayList<>();
        for (List<Meeting> meeting : meetings) {
            //merge with result
            merged = merge(merged, meeting);
        }
        List<Meeting> result = new ArrayList<>();
        if (merged.size() <= 1) {
            return result;
        }
        int end = merged.get(0).end;
        for (int i = 1; i < merged.size(); ++i) {
            result.add(new Meeting(end, merged.get(i).start));
            end = merged.get(i).end;
        }
        return result;
    }

    private List<Meeting> merge(List<Meeting> a, List<Meeting> b) {
        List<Meeting> result = new ArrayList<>();
        Meeting tmp = null;
        int i = 0;
        int j = 0;
        while (i < a.size() || j < b.size()) {
            if (tmp == null) {
                if (i < a.size() && j < b.size()) {
                    if (a.get(i).start < b.get(j).start) {
                        tmp = new Meeting(a.get(i).start, a.get(i).end);
                    }
                    else {
                        tmp = new Meeting(b.get(j).start, b.get(j).end);
                    }
                }
                else if (i < a.size()) {
                    tmp = new Meeting(a.get(i).start, a.get(i).end);
                }
                else if (j < b.size()) {
                    tmp = new Meeting(b.get(j).start, b.get(j).end);
                }
            }
            else {
                if (i <a.size() && j < b.size()) {
                    if (tmp.end < a.get(i).start && tmp.end < b.get(j).start) {
                        result.add(tmp);
                        tmp = a.get(i).start < b.get(j).start ? new Meeting(a.get(i).start, a.get(i).end) :
                                new Meeting(b.get(j).start, b.get(i).end);
                    }
                    else if (a.get(i).start < b.get(j).start) {
                        tmp.end = Math.max(tmp.end, a.get(i).end);
                        ++i;
                    }
                    else {
                        tmp.end = Math.max(tmp.end, b.get(j).end);
                        ++j;
                    }
                }
                else if (i < a.size()) {
                    if (tmp.end < a.get(i).start) {
                        result.add(tmp);
                        tmp = a.get(i);
                        ++i;
                    }
                    else {
                        tmp.end = Math.max(tmp.end, a.get(i).end);
                        ++i;
                    }
                }
                else { //j < b.size()
                    if (tmp.end < b.get(j).start) {
                        result.add(tmp);
                        tmp = b.get(j);
                        ++j;
                    }
                    else {
                        tmp.end = Math.max(tmp.end, b.get(j).end);
                        ++j;
                    }
                }
            }
        }
        if (tmp != null) {
            result.add(tmp); //don't forget
        }
        return result;
    }

    //Time: O(nlogn), Space: O(n)
    public List<Meeting> find3(List<List<Meeting>> meetings) {
        List<Meeting> result = new ArrayList<>();
        Queue<TimeNode> queue = new PriorityQueue<>((a,b) -> { //start first if time equals
            if (a.time == b.time) {
                if (!a.isStart && b.isStart) {
                    return +1;
                }
                else if(a.isStart && !b.isStart) {
                    return -1;
                }
                else {
                    return 0;
                }
            }
            else {
                return a.time - b.time;
            }
        });
        for (List<Meeting> ms : meetings) {
            for (Meeting m : ms) {
                queue.offer(new TimeNode(m.start, true));
                queue.offer(new TimeNode(m.end, false));
            }
        }
        if(queue.isEmpty()) {
            return result;
        }
        int count = 0;
        int time = queue.peek().time;
        while (!queue.isEmpty()) {
            TimeNode curr = queue.poll();
            if (curr.isStart) {
                ++count;
                if (count == 1 && time != curr.time) {
                    result.add(new Meeting(time, curr.time));
                }
            }
            else {
                --count;
                if (count == 0) {
                    time = curr.time;
                }
            }
        }
        return result;
    }

    static class TimeNode {
        int time;
        boolean isStart;
        TimeNode(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }
    }
}
