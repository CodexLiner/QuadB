package com.example.quadb.MyModels;

import java.util.List;

public class schedule {
    String time;
    List<String> days;

    public schedule(String time, List<String> days) {
        this.time = time;
        this.days = days;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<String> getDays() {
        return days;
    }

    public void setDays(List<String> days) {
        this.days = days;
    }
}
