package org.test.dectestapp.functions;

import lombok.Data;
import java.util.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.*;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.dectestapp.dto.*;
import ru.dectestapp.logic.*;

@Component
public class TimestampToString {
    public static TimestampToStringOutput timestampToString(TimestampToStringInput input) {
        TimestampToStringOutput output = new TimestampToStringOutput(input.getTime().toString());
        return output;
    }
}