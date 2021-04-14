package com.kosteklvp;

import lombok.AllArgsConstructor;

public interface TableHeading {

  public String getName();

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

  public Align getAlign();

}
