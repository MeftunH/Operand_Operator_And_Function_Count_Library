package pckg.Class;

public class FileContentOperation {

    protected String uncommentedContent;

    public String getUncommentedContent() {
        return uncommentedContent;
    }

    public void setUncommentedContent(String uncommentedContent) {
        this.uncommentedContent = uncommentedContent;
    }

    public FileContentOperation(String uncommentedContent) {
        this.uncommentedContent = uncommentedContent;
    }

    public String getUncommentedContent(String fileContent) {
        String unCommentedContent = fileContent.replaceAll("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)","");
        return unCommentedContent;
    }

}
