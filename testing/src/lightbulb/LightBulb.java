package lightbulb;

public class LightBulb {
    private IState state;

    public LightBulb(IState state) {
        this.state = state;
    }

    public void setState(IState state) {
        this.state = state;
    }

    public boolean isEnabled() {
        return state instanceof On;
    }

    public boolean isDisabled() {
        return state instanceof Off;
    }

    public float getCP() {
        return state.getCP();
    }
}




