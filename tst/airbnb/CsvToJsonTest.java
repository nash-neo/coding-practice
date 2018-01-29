package airbnb;

import org.junit.Test;

public class CsvToJsonTest {

    private CsvToJson csvToJson = new CsvToJson();

    @Test
    public void test() {
        String csv = "A,B,C\na,b,c";
        System.out.println(csvToJson.toJson(csv));
    }

    @Test
    public void test1() {
        String csv = "A,B,C\na,b,c\n\"aa\",\"bb\",\"cc\"";
        System.out.println(csvToJson.toJson(csv));
    }
}
