package Model;

public class Ramp implements Platform{
    private State state = State.UP;
    private boolean locked = false;

    public void raiseRamp() {
        state = State.UP;
    }

    public void lowerRamp() {
        if (locked) {throw new IllegalCallerException("Can not lower ramp while transport is moving");}
        state = State.DOWN;
    }

    public void lock() {
        if (state != State.UP) {throw new IllegalCallerException("Can not lock platform while ramp is down");}
        locked = true;
    }

    public void unlock() {
        locked = false;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
