package workshop;

import org.junit.Test;
import workshop.texttoHtml.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HtmlPagesConverterTest {
    private patternmatcher matcher1 = new greaterthan();
    private patternmatcher matcher2 = new lessthan();
    private patternmatcher matcher3 = new ampersand();
    private patternmatcher matcher4 = new newline();
    private patternmatcher matcher5 = new defaultsameChar();
    List<patternmatcher> matcherList = new ArrayList<>();

    private void addtolist(){
            matcherList.add(matcher1);
            matcherList.add(matcher2);
            matcherList.add(matcher3);
            matcherList.add(matcher4);
            matcherList.add(matcher5);
    }
    PlaintextToHtmlConverterFake converter = new PlaintextToHtmlConverterFake(matcherList);

    @Test
    public void charConversion() throws Exception {
        converter.setRead("<");
        assertEquals("&lt;", converter.toHtml());

        converter.setRead(">");
        assertEquals("&gt;", converter.toHtml());

        converter.setRead("&");
        assertEquals("&amp;", converter.toHtml());

        converter.setRead("\n");
        assertEquals("<br />", converter.toHtml());
    }

    @Test
    public void noConversion() throws Exception {
        converter.setRead("simple");
        assertEquals("simple", converter.toHtml());
    }

    @Test
    public void mixedCharConversion() throws Exception {
        converter.setRead("<small>\n&space");
        assertEquals("&lt;small&gt;<br />&amp;space", converter.toHtml());
    }

    class PlaintextToHtmlConverterFake extends PlaintextToHtmlConverter {
        String text;

        public PlaintextToHtmlConverterFake(List<patternmatcher> patternmatcherList) {
            super(patternmatcherList);
        }

        protected void setRead(String text) {
            this.text = text;
        }

        protected String read() throws IOException {
            return text;
        }
    }
}
