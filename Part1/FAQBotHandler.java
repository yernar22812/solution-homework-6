package Part1;

public class FAQBotHandler implements SupportHandler{
    private SupportHandler next;
    @Override
    public SupportHandler setNext(SupportHandler handler) {
        this.next = handler;
        return handler;
    } @Override
    public void handle(String issue) {
        Logger.log("FAQ", issue, "Trying to handle");
        if(issue.equals("password_reset")) {
            Logger.log("FAQBot", issue, "Handled");
        } else if (next != null ) {
            Logger.log("FAQBot", issue, "Passing ti next");
            next.handle(issue);
        } else {
            throw new UnsupportedOperationException("Issue not handled. " + issue);
        }
    }
}
