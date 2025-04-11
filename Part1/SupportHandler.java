package Part1;

public interface SupportHandler {
    SupportHandler setNext(SupportHandler handler);
    void handle(String issue);
}
