package workshop;

import org.junit.Test;
import workshop.fizzbuzz.*;
import workshop.texttoHtml.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HtmlPagesConverterIntegrationTest {
    @Test
    public void convertFromActualFile() throws Exception {
        patternmatcher matcher1 = new greaterthan();
        patternmatcher matcher2 = new lessthan();
        patternmatcher matcher3 = new ampersand();
        patternmatcher matcher4 = new newline();
        patternmatcher matcher5 = new defaultsameChar();
        List<patternmatcher> matcherList = new ArrayList<>();
            matcherList.add(matcher1);
            matcherList.add(matcher2);
            matcherList.add(matcher3);
            matcherList.add(matcher4);
            matcherList.add(matcher5);

        PlaintextToHtmlConverter converter = new PlaintextToHtmlConverter(matcherList);
        assertEquals("abc<br />&lt;hello&gt;", converter.toHtml());
    }
}
