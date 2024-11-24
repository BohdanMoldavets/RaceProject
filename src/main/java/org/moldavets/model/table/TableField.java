package org.moldavets.model.table;

import java.util.function.Function;

public record TableField<T>(
        String title,
        Function<T,String> accessor
) {
}
