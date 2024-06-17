@Qualifier("GetAllCommunications")
@Configuration("GetAllCommunicationsApiRequest2DBSelectInput")

public class GetAllCommunicationsApiRequest2DBSelectInput implements State {
    @RequiredArgsConstructor
    public static class GetAllCommunicationsApiRequest2DBSelectInputLogicWrapper {
        private final GetAllCommunicationsApiRequest2DBSelectInputLogic getAllCommunicationsApiRequest2DBSelectInputLogic;

        @Mdc(fields = {
            @MdcFieldMapping (fieldPath = "queryParams.user_id", fieldName = "userId")
        },
            constants = {
            @MdcConstantMapping (constantName = "operationName", constantValue = "GetAllCommunications")
        })
        @Log(masks = {},
            logLevel = LogLevel.DEBUG
        )

        public GetCommunicationsInput wrapLogic (GetAllCommunicationsApiRequest input) {
            return getAllCommunicationsApiRequest2DBSelectInputLogic.logic(input);
        }
    }

    @Bean
    public GetAllCommunicationsApiRequest2DBSelectInputLogicWrapper getAllCommunicationsApiRequest2DBSelectInputLogicWrapper(GetAllCommunicationsApiRequest2DBSelectInputLogic getAllCommunicationsApiRequest2DBSelectInputLogic) {
        return new GetAllCommunicationsApiRequest2DBSelectInputLogicWrapper (getAllCommunicationsApiRequest2DBSelectInputLogic);
    }

    @Autowired
    private GetAllCommunicationsApiRequest2DBSelectInputLogicWrapper getAllCommunicationsApiRequest2DBSelectInputLogicWrapper;
    
    @Override
    public string process (Entity entity) {
        var input = (GetAllCommunicationsApiRequest) entity.get(GetAllCommunicationsApiRequest.class);
        var getCommunications Input = getAllCommunicationsApiRequest2DBSelectInputLogicWrapper.wrapLogic(input);
        entity.add(getCommunicationsInput);
        return "GetCommunications";
    }
}