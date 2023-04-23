package javatestlpsoultions;

/**
 * @author --G--
 */
public class JavaTestLPSoultions {

    public static void main(String[] args) {
        String name = args[0] + " " + args[1];
        String email = args[2];
        String repositoryUrl
                = "https://github.com/szmarton94/JavaTestLPSoultions.git";

        HtmlBuilder builder = new HtmlBuilder();
        builder.addDoctype("html").
                openTag("html").
                openTag("head").
                addElement("title", name + " - Teszt Feladat").
                closeTag("head").
                openTag("body").
                addElement("h1", "Teszt Feladat").
                addLinkWithParagraph(repositoryUrl, "Megoldás").
                addElement("p", "A feladat elkészítőjének adatai").
                openTagWithAttribute("table", "border", "1px solid black").
                openTag("tr").
                addElement("td", "Név").
                addElement("td", name).
                closeTag("tr").
                openTag("tr").
                addElement("td", "Elérhetőség").
                addElement("td", email).
                closeTag("tr").
                closeTag("table").
                addLink("http://lpsolutions.hu", "L&P Solutions").
                closeTag("body").
                closeTag("html");
        String htmt = builder.build();
        System.out.println(htmt);
        String newhtml3 = builder.removeElements("h1", "p", "p", "a", "table",
                "tr", "td").
                toString();
        String html = builder.build();

        System.out.println(html);
    }
}
