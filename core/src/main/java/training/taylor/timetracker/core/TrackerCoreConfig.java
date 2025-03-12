package training.taylor.timetracker.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import training.taylor.timetracker.core.dao.TimeEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * Configuration class for TrackerCore.
 * Scans for components in the "training.taylor.timetracker.core" package.
 */
@Configuration
@ComponentScan("training.taylor.timetracker.core")
public class TrackerCoreConfig {

    /**
     * Defines a bean named "timesheet" that returns a list of TimeEntry objects.
     *
     * @return a new ArrayList of TimeEntry.
     */
    @Bean(name = "timesheet")
    public List<TimeEntry> timeEntries() {
        return new ArrayList<>();
    }
}

