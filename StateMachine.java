public class StateMachine {
    private State currState;
    private final Map<String, State> states;
    
    public StateMachine (State initialstate, Map<String, State> states) {
        this.currState = initialState;
        this.states = states;
    }

    public boolean step (Entity entity) {
        var newStateName = currState.process(entity);
        if (newStateName == null) {
            return false;
        } else {
            this.currState = this.states.get(newStateName);
            return true;
        }
    }
}