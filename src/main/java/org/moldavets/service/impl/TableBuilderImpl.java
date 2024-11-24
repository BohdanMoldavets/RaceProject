package org.moldavets.service.impl;

import org.moldavets.model.table.TableData;
import org.moldavets.model.table.TableOptions;
import org.moldavets.model.table.TableField;
import org.moldavets.service.TableBuilder;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TableBuilderImpl implements TableBuilder {

    @Override
    public <T> String build(Collection<T> racers, TableOptions<T> tableOptions) {
        TableData tableData = buildTableData(racers, tableOptions);
        return buildTable(tableData, tableOptions);
    }

    private static <T>TableData buildTableData(Collection<T> racers, TableOptions<T> tableOptions) {
        int[] columnWidths = IntStream.range(0, tableOptions.fields().size()).map(any -> Integer.MIN_VALUE).toArray();

        List<List<String>> cells = Stream.concat(
                        Stream.of(tableOptions.fields().stream().map(TableField::title).toList()),
                        racers.stream()
                                .sorted(tableOptions.sorting())
                                .map(racer -> tableOptions.fields().stream().map(field -> field.accessor().apply(racer)).toList())
                ).peek(row -> {
                    for (int i = 0; i < row.size(); i++) {
                        int width = row.get(i).length();
                        if(columnWidths[i] < width) {
                            columnWidths[i] = width;
                        }
                    }
                })
                .toList();
        return new TableData(cells, columnWidths);
    }

    private static <T> String buildTable(TableData tableData, TableOptions<T> tableOptions) {
        String rowTemplate = Arrays.stream(tableData.columnWidths())
                .mapToObj(value -> "%-" + value + "s")
                .collect(Collectors.joining("|","|","|"));
        AtomicInteger counter = new AtomicInteger();
        return tableData.cells().stream()
                .map(row -> String.format(rowTemplate, row.toArray()))
                .map(row -> {
                    if(counter.incrementAndGet() == tableOptions.separatorAfter() + 1) {
                        return row + "\n" + "-".repeat(row.length());
                    } else {
                        return row;
                    }
                })
                .collect(Collectors.joining("\n"));
    }


}
