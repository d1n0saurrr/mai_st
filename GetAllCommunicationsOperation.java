@Component
@slf4j

public class GetAllCommunicationsLogic {
    State initState;
    Map<String, State> states;

    @Autowired
    public GetAllCommunications Logic (@Qualifier ("GetAllCommunications") State initState,
            @Qualifier("GetAllCommunications") Map<String, State> states) {
        this.initState = initState;
        this.states states;
    }
    
    public GetAllCommunicationsApiResponse process (GetAllCommunicationsApiRequest getAllCommunicationsApiRequest) {
        var stateMachine = new StateMachine (initState, states);
        var entity = new Entity();
        entity.add(getAllCommunicationsApiRequest);
        long startTime, endTime;
        startTime = System.currentTimeMillis();
        while (stateMachine.step(entity)) {}
        endTime = System.currentTimeMillis();
        Metrics.globalRegistry.timer ("GetAllCommunications").record(endTime - startTime, TimeUnit.MILLISECONDS);
        return (GetAllCommunicationsApiResponse) entity.get(GetAllCommunicationsApiResponse.class);
    }
}