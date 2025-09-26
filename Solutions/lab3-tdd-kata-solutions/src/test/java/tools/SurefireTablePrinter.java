package tools;

import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import java.nio.file.*;
import java.util.*;

public class SurefireTablePrinter {
  static class Row {
    String name; int tests, failures, errors, skipped; double time;
  }

  public static void main(String[] args) throws Exception {
    Path dir = Paths.get("target", "surefire-reports");
    if (!Files.isDirectory(dir)) {
      System.err.println("No surefire-reports found (run `mvn test` first).");
      System.exit(1);
    }
    List<Row> rows = new ArrayList<>();
    var dbf = DocumentBuilderFactory.newInstance();

    try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "TEST-*.xml")) {
      for (Path p : stream) {
        Document d = dbf.newDocumentBuilder().parse(p.toFile());
        Element root = (Element) d.getElementsByTagName("testsuite").item(0);
        Row r = new Row();
        r.name     = root.getAttribute("name");
        r.tests    = parseInt(root.getAttribute("tests"));
        r.failures = parseInt(root.getAttribute("failures"));
        r.errors   = parseInt(root.getAttribute("errors"));
        r.skipped  = parseInt(root.getAttribute("skipped"));
        r.time     = parseDouble(root.getAttribute("time"));
        rows.add(r);
      }
    }

    System.out.printf("%-50s %6s %8s %7s %8s %8s%n",
        "Test Suite", "Tests", "Failures", "Errors", "Skipped", "Time");
    System.out.println("-".repeat(95));
    int t=0,f=0,e=0,s=0; double tt=0;
    for (Row r : rows) {
      System.out.printf("%-50s %6d %8d %7d %8d %8.2f%n",
          r.name, r.tests, r.failures, r.errors, r.skipped, r.time);
      t+=r.tests; f+=r.failures; e+=r.errors; s+=r.skipped; tt+=r.time;
    }
    System.out.println("-".repeat(95));
    System.out.printf("%-50s %6d %8d %7d %8d %8.2f%n", "TOTAL", t,f,e,s,tt);
  }

  private static int parseInt(String s){ try { return Integer.parseInt(s); } catch(Exception e){ return 0; } }
  private static double parseDouble(String s){ try { return Double.parseDouble(s); } catch(Exception e){ return 0; } }
}
