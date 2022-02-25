import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void originalFile() throws IOException {
        Path fileName = Path.of("test-file.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);

        assertEquals(List.of("https://something.com", "some-page.html"), links);
    }

    @Test
    public void inccorectFile() throws IOException {
        Path fileName = Path.of("incorrect.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);

        assertEquals(List.of(), links);
    }

    @Test
    public void imageFile() throws IOException {
        Path fileName = Path.of("image.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);

        assertEquals(List.of("google.com"), links);
    }
    @Test
    public void newFile() throws IOException {
        Path fileName = Path.of("newfile.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);

        assertEquals(List.of("https://docs.google.com/document/d/1enL_jhAcSdQ1lHbUpXYqPfW6yy4eBnv5T9iod1aKQoE/edit#heading=h.6htt4v2f3w9w", "google.com/12345()"), links);
    }

    @Test
    public void Snippet1() throws IOException {
        Path fileName = Path.of("Snippet1.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);

        assertEquals(List.of("google.com", "google.com","ucsd.edu"), links);
    }
    
    @Test
    public void Snippet2() throws IOException {
        Path fileName = Path.of("Snippet2.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);

        assertEquals(List.of("a.com","a.com(())", "example.com"), links);
    }

 
    @Test
    public void Snippet3() throws IOException {
        Path fileName = Path.of("Snippet3.md");
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);

        assertEquals(List.of("https://ucsd-cse15l-w22.github.io/"), links);
    }
    

}
