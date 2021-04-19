package com.kosteklvp.table;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.fluttercode.datafactory.impl.DataFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.kosteklvp.table.DataFactoryTable.PersonRow;

class TableGeneratorTest {

  @Test
  void generatesTable() {
    DataFactory dataFactory = new DataFactory();

    List<TableRow> rows = new ArrayList<>();
    for (int i = 0; i < 25; i++) {
      PersonRow personRow = PersonRow.builder()
          .firstName(dataFactory.getFirstName())
          .lastName(dataFactory.getLastName())
          .city(dataFactory.getCity())
          .email(dataFactory.getEmailAddress())
          .birthDate(new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(dataFactory.getBirthDate()))
          .build();

      rows.add(personRow);
    }

    TableGenerator tableGenerator = TableGenerator.builder()
        .headings(DataFactoryTable.PersonTableHeading.getAll())
        .rows(rows)
        .build();

    String generatedTableText = tableGenerator.generate();

    assertThat(generatedTableText, is(DataFactoryTable.getPersonTableText()));
  }

  @Test
  void generatesEmptyTableWhenRowsAreNotSet() {
    TableGenerator tableGenerator = TableGenerator.builder()
        .headings(DataFactoryTable.PersonTableHeading.getAll())
        .build();

    String generatedTableText = tableGenerator.generate();

    assertThat(generatedTableText, is(DataFactoryTable.getEmptyPersonTableText()));
  }

  @Test
  void throwsExceptionWhenHeadingsAreNotSet() {
    TableGenerator tableGenerator = new TableGenerator();

    Assertions.assertThrows(HeadingsNotSetException.class, () -> {
      tableGenerator.generate();
    });
  }

}
