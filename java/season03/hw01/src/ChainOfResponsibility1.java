/**
 * Created by xqy on 17/8/13.
 */
interface Handler<T> {
    boolean handle(T t);
}
interface Chain<T> {
    void handle(T t);
}
class ChainBuilder<T> {
    public static <T> ChainBuilder<T> chainBuilder() {
        return new ChainBuilder<>();
    }

    private HandlerImpl<T> first;

    private ChainBuilder() {
    }

    public SuccessorBuilder first(Handler<T> handler) {
        first = new HandlerImpl<>(handler);
        return new SuccessorBuilder(first);
    }

    public class SuccessorBuilder {
        private HandlerImpl<T> current;

        private SuccessorBuilder(HandlerImpl<T> current) {
            this.current = current;
        }

        public SuccessorBuilder successor(Handler<T> successor) {
            HandlerImpl<T> successorWrapper = new HandlerImpl<>(successor);
            current.setSuccessor(successorWrapper);
            current = successorWrapper;
            return this;
        }

        public Chain<T> build() {
            return new ChainImpl<T>(first);
        }
    }

    private static class ChainImpl<T> implements Chain<T> {
        private final Handler<T> first;

        public ChainImpl(Handler<T> first) {
            this.first = first;
        }

        @Override
        public void handle(T t) {
            first.handle(t);
        }
    }

    private static class HandlerImpl<T> implements Handler<T> {
        private final Handler<T> delegate;
        private Handler<T> successor;

        public HandlerImpl(Handler<T> delegate) {
            this.delegate = delegate;
        }

        private void setSuccessor(HandlerImpl<T> successor) {
            this.successor = successor;
        }

        @Override
        public boolean handle(T t) {
            if (delegate.handle(t)) {
                return true;
            }
            else if (successor != null) {
                return successor.handle(t);
            }
            return false;
        }
    }
}
public class ChainOfResponsibility1 {
    public static void main(String[] args) {
        final double base = 500;
        ChainBuilder<PurchaseRequest> chainBuilder = ChainBuilder.chainBuilder();
        Chain<PurchaseRequest> chain = chainBuilder
                .first(request -> {
                    if (request.getAmount() < base * 10) {
                        System.out.println("Manager will approve $" + request.getAmount());
                        return true;
                    }
                    return false;
                })
                .successor(request -> {
                    if (request.getAmount() < base * 20) {
                        System.out.println("Director will approve $" + request.getAmount());
                        return true;
                    }
                    return false;
                })
                .successor(request -> {
                    if (request.getAmount() < base * 50) {
                        System.out.println("President will approve $" + request.getAmount());
                    } else {
                        System.out.println("Your request for $" + request.getAmount() + " needs a board meeting!");
                    }
                    return true;
                }).build();

        chain.handle(new PurchaseRequest(1000)); // manager
        chain.handle(new PurchaseRequest(9000)); // director
        chain.handle(new PurchaseRequest(23000)); // president
        chain.handle(new PurchaseRequest(100000)); // board
    }

    private static class PurchaseRequest {
        private final double amount;

        private PurchaseRequest(double amount) {
            this.amount = amount;
        }

        public double getAmount() {
            return amount;
        }
    }
}
