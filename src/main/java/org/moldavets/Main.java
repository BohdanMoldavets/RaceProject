package org.moldavets;

import org.moldavets.model.Racer;
import org.moldavets.model.input.InputData;
import org.moldavets.model.table.TableOptions;
import org.moldavets.service.InputDataReader;
import org.moldavets.service.ModelBuilder;
import org.moldavets.service.TableBuilder;
import org.moldavets.service.impl.InputDataReaderImpl;
import org.moldavets.service.impl.ModelBuilderImpl;
import org.moldavets.service.impl.TableBuilderImpl;

import java.util.Collection;

public class Main {
    public static void main(String[] args) {

        InputDataReader inputDataReader = new InputDataReaderImpl();
        ModelBuilder modelBuilder = new ModelBuilderImpl();
        TableBuilder tableBuilder = new TableBuilderImpl();

        InputData inputData = inputDataReader.readInputData(
                "data/abbreviations.txt",
                "data/start.log",
                "data/end.log"
        );

        Collection<Racer> racers = modelBuilder.build(inputData);
        String output = tableBuilder.build(racers, TableOptions.racerOptions());
        System.out.println(output);


    }
}