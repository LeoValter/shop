package ru.leovalter.shop.util;

import lombok.SneakyThrows;
import ru.leovalter.shop.model.Product;
import ru.leovalter.shop.util.exception.NotFoundException;

public class ValidationUtil {
    public static <T> T checkNotFoundWithId(T object, int id) {
        checkNotFoundWithId(object != null, id);
        return object;
    }

    public static void checkNotFoundWithId(boolean found, int id) {
        checkNotFound(found, "id: " + id);
    }

    @SneakyThrows
    private static void checkNotFound(boolean found, String arg) {
        if (!found) {
            throw new NotFoundException(arg);
        }
    }
}
