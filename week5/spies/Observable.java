package week5.spies;

public interface Observable {

    void register(Observer observer);

    void leave();

    void informAll(Message discussion);

}
