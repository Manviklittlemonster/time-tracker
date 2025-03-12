package training.taylor.timetracker.core;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import training.taylor.timetracker.core.dao.TimeEntry;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TrackerCoreConfig.class)
public class TrackerTest {
    @Autowired
    private Tracker tracker;

    @Before
    public void setUp() {
        // Clear the tracker before each test
        while (tracker.size() > 0) {
            tracker.remove(tracker.get(0));
        }
    }

    @Test
    public void testMe() {
        assertNotNull(tracker);
    }

    @Test
    public void testAdd() {
        TimeEntry entry = new TimeEntry();
        entry.setDescription("Entry Test");
        entry.setRate(80.0f);
        entry.setTime(3);
        tracker.add(entry);
        assertTrue(tracker.size() > 0);
    }

    @Test
    public void testRemove() {
        TimeEntry entry = new TimeEntry();
        entry.setDescription("Entry Test");
        tracker.add(entry);
        tracker.remove(entry);
        assertEquals(0, tracker.size());
    }

    @Test
    public void testGet() {
        TimeEntry entry = new TimeEntry();
        entry.setDescription("Entry Test");
        tracker.add(entry);
        assertEquals(entry, tracker.get(0));
    }

    @Test
    public void testEmptyTracker() {
        assertEquals(0, tracker.size());
    }
}

