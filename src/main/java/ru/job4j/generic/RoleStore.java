package ru.job4j.generic;

public class RoleStore implements Store<Role> {

    private final Store<Role> ruleStore = new MemStore<>();

    @Override
    public void add(Role model) {
        ruleStore.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
        return ruleStore.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return ruleStore.delete(id);
    }

    @Override
    public Role findById(String id) {
        return ruleStore.findById(id);
    }
}
