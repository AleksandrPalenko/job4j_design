package ru.job4j.ood.lsp;

public class CountTicket {
    public int getSum(int num, int cost) {
        if (num < 100) {
            return -1;
        }
        return num * cost;
    }

    public static void main(String[] args) {
        CountTicket countTicket = new CountTicket();
        System.out.println(countTicket.getSum(150, 50));
    }
/*
1. Предусловия (Preconditions) не могут быть усилены в подклассе
 */
    public class CountRZDTicket extends CountTicket {
        public int getSum(int num, int cost) {
            if (num < 1000) {
                return -1;
            }
            return num * cost;
        }
    }
    /*
2. Постусловия (Postconditions) не могут быть ослаблены в подклассе.
 */
    public class CountKinoTicket extends CountTicket {
        public int getSum(int num, int cost) {
            return num * cost;
        }
    }
    /*
3. Инварианты (Invariants) — все условия базового класса также должны быть сохранены и в подклассе
*/
    public class CountTranslationTicket extends CountTicket {
        public int getSum(int num, int cost) {
            if (num < 100) {
                throw new IllegalArgumentException("invalid counter");
            }
            return num * cost;
        }
    }

}
