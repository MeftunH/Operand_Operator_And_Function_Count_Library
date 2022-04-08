package pckg.Class;

import pckg.Interface.IFileContentOperation;

public class FileContentOperation implements IFileContentOperation {

    @Override
    public String getUncommentedContent(String fileContent) {
        String unCommentedContent = fileContent.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)","");
        return unCommentedContent;
    }

}
