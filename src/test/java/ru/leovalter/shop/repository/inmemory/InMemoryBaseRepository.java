package ru.leovalter.shop.repository.inmemory;

import ru.leovalter.shop.model.AbstractBaseEntity;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import static ru.leovalter.shop.model.AbstractBaseEntity.START_SEQUENCE;

public class InMemoryBaseRepository<T extends AbstractBaseEntity> {

    private static AtomicInteger counter = new AtomicInteger(START_SEQUENCE);

    Map<Integer, T> map = new ConcurrentHashMap<>();

    public T save(T entry) {
        Objects.requireNonNull(entry, "Entry must be not null");
        if (entry.isNew()) {
            entry.setId(counter.incrementAndGet());
            map.put(entry.getId(), entry);
        }
        return entry;
    }

    public T get(int id) {
        return map.get(id);
    }

    public Collection<T> getCollections() {
        return map.values();
    }

    public boolean delete(int id) {
        return map.remove(id) != null;
    }
}
