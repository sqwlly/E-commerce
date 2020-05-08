package log.model;

public class ClickLog{
    private String pageCode;
    private String url;
    private String clickPosition;
    private String pageContent;

    public String getPageCode(){
    return pageCode;
    }
    public void setPageCode(String pageCode) {
        this.pageCode = pageCode;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getClickPosition() {
        return clickPosition;
    }
    public void setClickPosition(String clickPosition) {
        this.clickPosition = clickPosition;
    }
    public String getPageContent() {
        return pageContent;
    }
    public void setPageContent(String pageContent) {
        this.pageContent = pageContent;
    }
}


