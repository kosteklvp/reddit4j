package com.kosteklvp;

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
      throw new RuntimeException("Headings are not set.");
    }

    final StringBuilder tableText = new StringBuilder();
    tableText.append("&#x200B;").append("\n").append("\n");

    addHeadings(tableText);
    tableText.append("\n");

    addColumnsAlign(tableText);
    tableText.append("\n");

    addRows(tableText);

    return tableText.toString();

  }

  private void addHeadings(StringBuilder tableText) {
    tableText.append("|");
    headings.forEach(heading -> tableText.append(heading.getName()).append("|"));
  }

  private void addColumnsAlign(StringBuilder tableText) {
    tableText.append("|");
    headings.forEach(heading -> tableText.append(heading.getAlign().get()).append("|"));
  }

  private void addRows(StringBuilder tableText) {
    for (TableRow row : rows) {
      tableText.append("|");

    }
  }

}
