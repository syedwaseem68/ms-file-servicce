package com.nokia.ms.file.service.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.UUID;

@Component
public class SystemHelper {

    private String ZONE_ID = "Asia/Kolkata";

    public String getRandomUUID() {
        return UUID.randomUUID().toString();
    }

    public String toJSON(Object parm) {
        Gson gson = this.getGSonBuilder();
        return gson.toJson(parm);
    }

    private Gson getGSonBuilder() {
        return (new GsonBuilder()).setDateFormat("yyyy-MM-dd HH:mm:ss").setLongSerializationPolicy(LongSerializationPolicy.STRING).create();
    }

    public String getCurrentTimeString() {
        return this.convertTimeToString(this.getCurrentTime());
    }

    public String convertTimeToString(LocalDateTime dt) {
        return dt == null ? null : this.getDateTimeFormatter().format(dt);
    }

    public DateTimeFormatter getDateTimeFormatter() {
        return (new DateTimeFormatterBuilder()).appendOptional(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).parseDefaulting(ChronoField.HOUR_OF_DAY, 0L).parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0L).parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0L).toFormatter();
    }

    public LocalDateTime getCurrentTime() {
        ZonedDateTime zdt = ZonedDateTime.now(this.getZoneId());
        return zdt.toLocalDateTime();
    }

    public ZoneId getZoneId() {
        return ZoneId.of(this.ZONE_ID);
    }
}
