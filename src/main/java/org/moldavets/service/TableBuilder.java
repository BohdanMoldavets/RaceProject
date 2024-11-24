package org.moldavets.service;

import org.moldavets.model.table.TableOptions;

import java.util.Collection;

public interface TableBuilder {
    <T> String build(Collection<T> racers, TableOptions<T> tableOptions);
}
