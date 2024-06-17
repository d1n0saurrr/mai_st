@Slf4j
@RestController
@RequiredArgsConstructor
@Crossorigin("")
public class GetAllCommunicationsController implements GetAllCommunicationsApiDelegate {
    private final GetAllCommunicationsLogic getAllCommunicationsOperation;
    
    @Override
    public ResponseEntity<GetAllCommunicationsApiResponse>
            getAllCommunications(GetAllCommunicationsAptRequest param) {
        MDC.put("operationName", "GetAllCommunications");
        MDC.put("LoggerHelp", "start");
        log.info("getAllCommunications start");
        var response getAllCommunicationsoperation.process(paran);
        MDC.put("operationName", "GetAllCommunications");
        MDC.put("loggerHelp", "success");
        log.info("getAllCommunications success");
        return Optional.of(response).map(content -> ResponseEntity
                        .status(HttpStatus.OK)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(content))
                .orElseThrow(()->
                        new NoSuchElementException("No data found for getAllCommunications request"));
    }
}