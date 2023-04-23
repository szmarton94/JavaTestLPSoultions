package javatestlpsoultions;

import java.util.List;

/**
 * @author G
 */
public class HtmlBuilder {

    private final StringBuilder html = new StringBuilder();
    private int indentcount = 0;

    public HtmlBuilder addDoctype(String type) {
        html.append("<!DOCTYPE ").
                append(type).
                append(">\n");
        return this;
    }

    public HtmlBuilder openTag(String tag) {
        indent();
        html.append("<").
                append(tag).
                append(">").
                append(System.lineSeparator());
        indentcount++;
        return this;
    }

    public HtmlBuilder openTagWithAttribute(String tag, String attribute,
            String value) {
        indent();
        html.append("<").
                append(tag).
                append(" ").
                append(attribute).
                append("=\"").
                append(value).
                append("\">\n");
        indentcount++;
        return this;

    }

    public HtmlBuilder closeTag(String tag) {
        indentcount--;
        indent();
        html.append("</").
                append(tag).
                append(">\n");
        return this;
    }

    public HtmlBuilder addElement(String tag, String content) {
        indent();
        html.append("<").
                append(tag).
                append(">").
                append(content).
                append("</").
                append(tag).
                append(">\n");
        return this;
    }

    public HtmlBuilder addLinkWithParagraph(
            String attribute,
            String value) {
        indent();
        html.append("<p><a href=\"").
                append(attribute).
                append("\">").
                append(value).
                append("</a></p>\n");

        return this;
    }

    public HtmlBuilder addLink(
            String attribute,
            String value) {
        indent();
        html.append("<a href=\"").
                append(attribute).
                append("\">").
                append(value).
                append("</a>\n");

        return this;
    }

    public String build() {
        return html.toString();
    }

    private void indent() {
        for (int i = 0; i < indentcount; i++) {
            html.append("   ");
        }
    }

    public HtmlBuilder removeElements(String... tags) {
        for (String tag : tags) {
            int startIndex = html.lastIndexOf("<" + tag);
            int endIndex = html.indexOf("</" + tag + ">", startIndex) + 3 + tag.
                    length();
            if (startIndex >= 0 && endIndex >= 0) {
                html.delete(startIndex, endIndex);
            }
        }
        return this;
    }

}
