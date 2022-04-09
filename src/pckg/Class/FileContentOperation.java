package pckg.Class;

import java.nio.charset.StandardCharsets;

public class FileContentOperation {
    public String getUncommentedContent(String fileContent) {
        String unCommentedContent = fileContent.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)","");
        return unCommentedContent;
    }
    public byte[] getContentByteByByte(String fileContent) {
        byte[] bytes = fileContent.getBytes(StandardCharsets.UTF_8);
        return bytes;
    }

}
