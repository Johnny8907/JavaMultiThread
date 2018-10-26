package GuardedSuspension;

public class Request {
    private final String name;

    Request(String name) {
        this.name = name;
    }

    public String toString() {
        return "[ Request " + name + " ]";
    }
}
