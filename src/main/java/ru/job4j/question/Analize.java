package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        Info info = new Info(0, 0, 0);
        Map<Integer, String> map = new HashMap<>();
        for (User user : previous) {
            map.put(user.getId(), user.getName());
        }
        for (User idCur : current) {
            if (map.containsKey(idCur.getId())) {
                if (!map.containsValue(idCur.getName())) {
                    info.setChanged(info.getChanged() + 1);
                }
            } else {
                info.setAdded(info.getAdded() + 1);
            }
        }
        info.setDeleted(previous.size() + info.getAdded() - current.size());
        return info;
    }
}
