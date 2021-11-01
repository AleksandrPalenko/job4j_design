package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        Info info = new Info();
        for (User tmp : previous) {
            if (!current.contains(tmp)) {
                info.getDeleted();
            } else if (!current.contains(tmp.getName())) {
                info.getChanged();
            } else if (!previous.contains(tmp.getName())
                    && !previous.contains(tmp.getId())
                    && current.contains(tmp.getName()) && current.contains(tmp.getId())) {
                info.getAdded();
            }
        }
        return info;
    }

}
/*
алгоритмически удачнее использовать HashMap:
положить туда первую коллекцию (элемент:колво_дубликатов),
а затем вытаскивать и удалять (при value=1) по элементу, идя по второй:
всё, что не нашлось в мапе — updated, всё, что осталось — deleted
 */