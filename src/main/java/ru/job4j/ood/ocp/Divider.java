package ru.job4j.ood.ocp;


import java.util.ArrayList;
import java.util.List;

public class Divider {
    public void isValid(ArrayList<Integer> num) {
/*
Здесь в параметрах нарушение OCP, нужно принимать абстракцию List<Integer> num
 */
    }

   public ArrayList<Integer> isNotValid(List<Integer> num) {
        return null;
        /*
Здесь нарушение OCP в возращаемомо типе,
нужно написать абстракцию,например List<I> isNotValid(List<Integer> num)
 */
   }
}
