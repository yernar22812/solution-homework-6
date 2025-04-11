package Part1;

public class JuniorSupportHandler implements SupportHandler {
    private SupportHandler next;
    @Override
    public SupportHandler setNext(SupportHandler handler) {
        this.next = handler;
        return handler;
    } @Override
    public void handle(String issue) {
        Logger.log("JuniorSupport", issue, "Trying to handle");
        if (issue.equals("refund_request") || issue.equals("billing_issue")) {
            Logger.log("JuniorSupport", issue, "Handled");
        } else if (next != null) {
            Logger.log("JuniorSupport", issue, "Passing to next");
            next.handle(issue);
        } else {
            throw new UnsupportedOperationException("Issue unresolved: " + issue);
        }
    }
    }

