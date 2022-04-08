package com.leo.example.commonutils.enums;

import java.io.Serializable;
import java.util.stream.Stream;

public interface IValueEnum<T extends Serializable> {
    static <B extends IValueEnum<?>> Object[] getValues(B[] arr) {
        return Stream.of(arr).map(IValueEnum::getValue).toArray();
    }

    T getValue();
}
