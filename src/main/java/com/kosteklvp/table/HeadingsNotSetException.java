package com.kosteklvp.table;

public class HeadingsNotSetException extends RuntimeException {

  public HeadingsNotSetException() {
    super("Headings are not set.");
  }

}
