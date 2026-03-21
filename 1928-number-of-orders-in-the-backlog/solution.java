class Solution {
    public int getNumberOfBacklogOrders(int[][] orders) {
        TreeMap<Integer, Integer> buyPriceToAmount = new TreeMap<>();
        TreeMap<Integer, Integer> sellPriceToAmount = new TreeMap<>();

        for (int[] order : orders) {
            int price = order[0];
            int amount = order[1];
            int type = order[2];
            
            if (type == 0) {
                while (amount > 0 && !sellPriceToAmount.isEmpty()) {
                    Integer lowestSellPrice = sellPriceToAmount.firstKey();
                    if (lowestSellPrice <= price) {
                        Integer sellAmount = sellPriceToAmount.get(lowestSellPrice);
                        if (sellAmount > amount) {
                            sellPriceToAmount.put(lowestSellPrice, sellAmount - amount);
                        } else {
                            sellPriceToAmount.remove(lowestSellPrice);
                        }
                        amount -= sellAmount;
                    } else {
                        break;
                    }
                }

                if (amount > 0) {
                    buyPriceToAmount.put(price, buyPriceToAmount.getOrDefault(price, 0) + amount);
                }
            } else {
                while (amount > 0 && !buyPriceToAmount.isEmpty()) {
                    Integer lowestSellPrice = buyPriceToAmount.lastKey();
                    if (lowestSellPrice >= price) {
                        Integer sellAmount = buyPriceToAmount.get(lowestSellPrice);
                        if (sellAmount > amount) {
                            buyPriceToAmount.put(lowestSellPrice, sellAmount - amount);
                        } else {
                            buyPriceToAmount.remove(lowestSellPrice);
                        }
                        amount -= sellAmount;
                    } else {
                        break;
                    }
                }
                if (amount > 0) {
                    sellPriceToAmount.put(price, sellPriceToAmount.getOrDefault(price, 0) + amount);
                }
            }
        }

        int totalBacklog = 0;

        for (Integer amount : sellPriceToAmount.values()) {
            totalBacklog += amount;
            totalBacklog %= Math.pow(10, 9) + 7;
        }

        for (Integer amount : buyPriceToAmount.values()) {
            totalBacklog += amount;
            totalBacklog %= Math.pow(10, 9) + 7;
        }

        return totalBacklog;
    }
}