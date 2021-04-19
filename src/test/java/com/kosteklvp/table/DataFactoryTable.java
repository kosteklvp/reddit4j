package com.kosteklvp.table;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

public class DataFactoryTable {

  @AllArgsConstructor
  enum PersonTableHeading implements TableHeading {
    FIRST_NAME("First name", Align.LEFT),
    LAST_NAME("Last name", Align.LEFT),
    CITY("City", Align.RIGHT),
    EMAIL("Email", Align.RIGHT),
    BIRTH_DATE("Birth date", Align.CENTER);

    private final String name;

    private final Align align;

    @Override
    public String getName() {
      return name;
    }

    @Override
    public Align getAlign() {
      return align;
    }

    public static List<TableHeading> getAll() {
      return List.of(values());
    }

  }

  static String getEmptyPersonTableText() {
    return "&#x200B;\n"
        + "\n"
        + "|First name|Last name|City|Email|Birth date|\n"
        + "|:--|:--|--:|--:|:-:|\n"
        + "\n"
        + "\n"
        + "&#x200B;";
  }

  static String getPersonTableText() {
    return "&#x200B;\n"
        + "\n"
        + "|First name|Last name|City|Email|Birth date|\n"
        + "|:--|:--|--:|--:|:-:|\n"
        + "|Lindsey|Craft|Lenox|csuarez@b1zmail.org|08/25/1955|\n"
        + "|Jackie|Dawson|Omega|eo'neill27@ma1l2u.org|03/06/1970|\n"
        + "|Joyce|Hester|Chester|theyare@yah00.biz|02/13/1979|\n"
        + "|George|Suarez|Coverdale|ithatch@ma1l2u.com|04/06/1965|\n"
        + "|Brad|Ramsey|Toccoa|suspensediscovered@ma1lbox.co.uk|02/05/1974|\n"
        + "|Leslie|Reilly|Ellenton|smcguire@ma1l2u.co.uk|05/25/1969|\n"
        + "|Jody|Hughes|Locust Grove|roomcame@everyma1l.com|04/11/1966|\n"
        + "|Margaret|Kane|Braselton|sfletcher@ma1l2u.us|06/24/1979|\n"
        + "|Dale|Fowler|Phillipsburg|sothis@b1zmail.us|08/15/1957|\n"
        + "|Erin|Stafford|Watkinsville|cramsey@ma1lbox.us|07/04/1963|\n"
        + "|Alyssa|William|Cuthbert|tois@b1zmail.net|12/08/1980|\n"
        + "|Vernon|Lloyd|Cox|codom72@gma1l.biz|07/22/1979|\n"
        + "|Floyd|Sharp|Chula|hadwhat68@ma1l2u.us|03/31/1982|\n"
        + "|Barb|Maddox|Stilson|lotssecretly@somema1l.biz|01/06/1977|\n"
        + "|Rod|Parsons|Montgomery|brichards@gma1l.us|08/09/1969|\n"
        + "|Charlie|York|Bronwood|whopull@somema1l.biz|10/06/1972|\n"
        + "|Glenn|Barr|Springfield|jcollins@hotma1l.net|05/04/1981|\n"
        + "|Dixie|Avery|Byromville|islandroom@ma1lbox.com|09/26/1960|\n"
        + "|Tia|Fuentes|Albany|rruiz@b1zmail.org|11/10/1969|\n"
        + "|Mother|Johnston|Moniac|lluna@yah00.co.uk|02/15/1979|\n"
        + "|Matt|Clarke|Barney|nbuckner@yah00.biz|04/11/1962|\n"
        + "|Rachel|Melton|Osterfield|tdickinson@ma1lbox.com|03/03/1962|\n"
        + "|Christian|Marquez|Waverly|isno@yah00.org|09/25/1971|\n"
        + "|Abigail|Orr|Hartwell|generatedenter88@hotma1l.net|09/20/1966|\n"
        + "|Shane|Hess|Richmond Hill|gwooten@b1zmail.com|10/10/1964|\n"
        + "\n"
        + "\n"
        + "&#x200B;";
  }

  @Builder
  @NoArgsConstructor
  @AllArgsConstructor
  public static class PersonRow implements TableRow {

    private String firstName;
    private String lastName;
    private String city;
    private String email;
    private String birthDate;

    @Override
    public List<String> getValues() {
      return List.of(
          firstName,
          lastName,
          city,
          email,
          birthDate);
    }

  }
}
