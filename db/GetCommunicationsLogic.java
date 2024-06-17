@Slf4j
@Component
@RequiredArgsConstructor
public class GetCommunicationsLogic {
    private static final RowMapper<GetCommunicationsOutputRows> mapper = new RwMapper();
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplateCommunication;

    public GetCommunicationsOutput logic(GetCommunicationsInput input) {
        var parameters = new MapSqlParameterSource();
        parameters.addValue("user_id", input.getUserId());
        var list = new ArrayList<GetCommunicationsOutputRows>(
            namedParameterJdbcTemplateCommunication.query(
                "SELECT * FROM communication WHERE user_id = :user_id ", 
                parameters, mapper
            )
        );
        var response_json = new Gson().toJson(list);
        log.debug("GetCommunications response: " + response_json);
        var output = new GetCommunicationsOutput();
        output.setRows(list);
        return output;
    }
}