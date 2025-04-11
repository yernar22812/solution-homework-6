package Part1;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Map<String, SupportHandler> availableHandlers = new HashMap<>();
        availableHandlers.put("faq", new FAQBotHandler());
        availableHandlers.put("junior", new JuniorSupportHandler());
        availableHandlers.put("senior", new SeniorSupportHandler());
        List<String> handlerOrder = Arrays.asList("faq", "junior", "senior");

        SupportHandler first = availableHandlers.get(handlerOrder.get(0));
        SupportHandler current = first;
        for (int i = 1; i < handlerOrder.size(); i++) {
            current = current.setNext(availableHandlers.get(handlerOrder.get(i)));
        }
        String[] issues = {
                "password_reset",
                "refund_request",
                "account_ban",
                "unknown_bug"
        };

        for (String issue : issues) {
            System.out.println("== Handling issue: " + issue + " ==");
            try {
                first.handle(issue);
            } catch (UnsupportedOperationException e) {
                System.out.println("[System] " + e.getMessage());
            }
            System.out.println();
        }
    }
}

