package com.hornetdevelopment.sample.util;

import com.hornetdevelopment.sample.controller.validation.InvalidUUIDException;

import java.util.UUID;

/**
 * Mocked up to add some trivial validation functionality in the controller
 */
public class UUIDUtil {

    public static UUID uuidFromString(String uuid) {
        UUID result = null;
        try {
            result = UUID.fromString(uuid);
        } catch (IllegalArgumentException e) {
            throw new InvalidUUIDException(e);
        }

        return result;
    }

}


