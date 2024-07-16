package fr.doranco.study_smart.utils;

import org.springframework.stereotype.Component;

@Component
public class DurationUtil {

    public String convertMinutesToHoursAnsMinutes(int minutes) {
        if (minutes > 60) {
            return minutes + "m";
        } else {
            int hours = minutes / 60;
            int remainingMinutes = minutes % 60;
            return hours + "h " + remainingMinutes + "m";
        }
    }
}
