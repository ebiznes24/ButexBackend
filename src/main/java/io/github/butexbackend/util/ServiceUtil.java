package io.github.butexbackend.util;

import java.util.Map;

public final class ServiceUtil {

    private static final Map<String, Integer> serviceIdByName = Map.of(
            "INPOST", 10091112,
            "DPD", 10091106
    );

    public static Integer getServiceId(String service) {
        return serviceIdByName.get(service);
    }

    private ServiceUtil() {
    }
}
