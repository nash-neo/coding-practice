package airbnb;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import airbnb.MeetingRoom.Meeting;

public class MeetingRoomTest {

    private MeetingRoom meetingRoom = new MeetingRoom();

    @Test
    public void test() {
        List<List<Meeting>> meetings = new ArrayList<>();
        meetings.add(Arrays.asList(new Meeting(1,3), new Meeting(4,6)));
        meetings.add(Arrays.asList(new Meeting(2,5), new Meeting(7,8)));
        System.out.println(meetingRoom.find(meetings));
        System.out.println(meetingRoom.find2(meetings));
        System.out.println(meetingRoom.find3(meetings));
    }
}
