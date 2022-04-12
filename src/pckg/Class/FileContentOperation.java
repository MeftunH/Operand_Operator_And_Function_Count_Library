package pckg.Class;

import java.nio.charset.StandardCharsets;

public class FileContentOperation {
    public String getUncommentedContent(String fileContent) {
        String unCommentedContent = fileContent.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)","");
        return unCommentedContent;
    }

}
