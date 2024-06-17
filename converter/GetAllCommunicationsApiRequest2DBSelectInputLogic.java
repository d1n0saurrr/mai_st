package org.test.dectestapp.builder.GetAllCommunications;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Primary;
import org.springframework.beans.factory.annotation.Qualifier;
import org.integration.dectestapp.dto.*;
import static org.test.dectestapp.dto.GetAllCommunicationsApi.*;
import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.sql.Timestamp;

@Component
public class GetAllCommunicationsApiRequest2DBSelectInputLogic {
    public GetCommunicationsInput logic(GetAllCommunicationsApiRequest getAllCommunicationsApiRequest) {
        var getCommunicationsInput = new GetCommunicationsInput();
        {
            String getCommunicationsInput_UserId;
            getCommunicationsInput_UserId = getAllCommunicationsApiRequest.getQueryParams().getUserId();
            getCommunicationsInput.setUserId(getCommunicationsInput_UserId);
        }
        return getCommunicationsInput;
    }
}
