package week5.spies;

import java.util.ArrayList;
import java.util.List;

public class Spy implements Observer {

    private final String name;

    private Agency employer;

    private List<Message> agenda = new ArrayList<>(3);

    public Spy(String name, Agency employer) {
        this.name = name;
        this.employer = employer;
    }

    public void informMember(Message discussion) {
        if (agenda.size() < 3) agenda.add(discussion);
        if (agenda.size() == 3) report(agenda);
    }

    private void report(List<Message> agenda) {
        employer.makePublic(agenda, this);
    }

    @Override
    public String toString() {
        return name;
    }
}
