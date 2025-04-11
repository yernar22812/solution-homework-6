package Part1;

public class SeniorSupportHandler implements SupportHandler {
    private SupportHandler next;

    @Override
    public SupportHandler setNext(SupportHandler handler) {
        this.next = handler;
        return handler;
    }

    @Override
    public void handle(String issue) {
        Logger.log("SeniorSupport", issue, "Trying to handle");
        if (issue.equals("account_ban") || issue.equals("data_loss")) {
            Logger.log("SeniorSupport", issue, "Handled");
        } else {
            throw new UnsupportedOperationException("Issue unresolved: " + issue);
        }
    }
}