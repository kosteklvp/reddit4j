package com.kosteklvp.table;

import lombok.AllArgsConstructor;

public interface TableHeading {

  public String getName();

  public Align getAlign();

  @AllArgsConstructor
  public enum Align {
    LEFT(":--"),
    CENTER(":-:"),
    RIGHT("--:");

    private final String code;

    public String get() {
      return code;
    }
  }

}
