package pckg.Class;

import pckg.Interface.IContentOperation;

public class ContentOperation implements IContentOperation {

    @Override
    public String getUncommentedContent(String fileContent) {
        String unCommentedContent = fileContent.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)","");
        return unCommentedContent;
    }

}
