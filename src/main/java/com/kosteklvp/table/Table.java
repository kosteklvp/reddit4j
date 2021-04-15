package com.kosteklvp.table;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Table {

  private List<TableHeading> headings;

  private List<TableRow> rows;

  public String generate() {
    if (CollectionUtils.isEmpty(headings)) {
      throw new HeadingsNotSetException();
    }

    final StringBuilder tableText = new StringBuilder();

    addBeginning(tableText);

    addHeadings(tableText);

    addColumnsAlign(tableText);

    if (CollectionUtils.isNotEmpty(rows)) {
      addRows(tableText);
    }

    addEnding(tableText);

    return tableText.toString();

  }

  private void addBeginning(StringBuilder tableText) {
    tableText.append("&#x200B;").append("\n").append("\n");
  }

  private void addHeadings(StringBuilder tableText) {
    tableText.append("|");
    headings.forEach(heading -> tableText.append(heading.getName()).append("|"));
    tableText.append("\n");
  }

  private void addColumnsAlign(StringBuilder tableText) {
    tableText.append("|");
    headings.forEach(heading -> tableText.append(heading.getAlign().get()).append("|"));
    tableText.append("\n");
  }

  private void addRows(StringBuilder tableText) {
    rows.forEach(row -> {
      tableText.append("|");
      row.getValues().forEach(value -> tableText.append(value).append("|"));
      tableText.append("\n");
    });
  }

  private void addEnding(StringBuilder tableText) {
    tableText.append("\n").append("\n").append("&#x200B;");
  }

}
