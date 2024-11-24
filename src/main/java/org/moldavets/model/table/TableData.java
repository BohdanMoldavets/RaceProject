package org.moldavets.model.table;

import java.util.List;

public record TableData(
        List<List<String>> cells,
        int[] columnWidths
) {
}
