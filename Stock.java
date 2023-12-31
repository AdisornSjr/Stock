package hw4;

public class Stock {
    private List list;
    private int totalShares;

    public Stock(String costBasis) {
        switch (costBasis) {
            case "FIFO":
                list = new Queue();
                break;
            case "LIFO":
                list = new Stack();
                break;
            default:
                System.out.println("Invalid cost basis. Choose FIFO or LIFO");
                break;
        }
    }

    public void buy(int boughtShares, double boughtPrice) {
        // Complete this code
        // Something is missing here
        list.push(new Node(boughtShares, boughtPrice));
        totalShares += boughtShares;
    }

    public void sell(int soldShares, double soldPrice) {
        if (soldShares <= totalShares) {
            double realizedGain = 0.0;
            double unrealizedGain = 0.0;

            // คิด profit/loss ที่เกิดจริง
            while (list.top() != null && soldShares > 0) { // ตามที่ จารให้มา
                if (soldShares >= list.top().shares) {
                    realizedGain += (soldPrice - list.top().price) * list.top().shares; // ตามสูตรเลย
                    soldShares -= list.top().shares;
                    list.pop();
                    // check เมื่อขายหมดตั้งแต่ตัวแรก ก็คิด unrealized เลย
                    if (soldShares == 0) {
                        Node currentNode = list.top(); // set first to list.top()
                        while (currentNode != null) { // loop to last
                            unrealizedGain += (soldPrice - currentNode.price) * currentNode.shares;
                            currentNode = currentNode.next;
                        }

                    }
                } else {
                    realizedGain += (soldPrice - list.top().price) * soldShares; // หา realized กรณีที่เหลือ soldShare <
                                                                                 // list.top()
                    list.top().shares -= soldShares;
                    soldShares = 0;

                    // หา unrealized

                    Node currentNode = list.top(); // set first to list.top()
                    while (currentNode != null) { // loop to last
                        unrealizedGain += (soldPrice - currentNode.price) * currentNode.shares; // คิด unrealized
                        currentNode = currentNode.next;
                    }

                }

            }

            totalShares -= soldShares;
            System.out.println("Realized P/L = " + realizedGain + " Unrealized P/L = " + unrealizedGain);
        } else {
            System.out.println("Sell command rejected");
        }
    }

    public void showList() {
        Node currentNode = list.top();
        System.out.print("head -> ");
        while (currentNode != null) {
            System.out.print("[" + currentNode.shares + "@" + currentNode.price + "B] -> ");
            currentNode = currentNode.next;
        }
        System.out.println("tail");
    }
}