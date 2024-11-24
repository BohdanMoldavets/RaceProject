package org.moldavets.service;

import org.moldavets.model.input.InputData;
import org.moldavets.model.Racer;

import java.util.Collection;

public interface ModelBuilder {
    Collection<Racer> build(InputData inputData);
}
