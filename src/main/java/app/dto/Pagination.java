package app.dto;

/**
 * Created with Android Studio.
 * User: Sasha Shcherbinin
 * Date: 7/26/17
 * Time: 12:15 AM
 */
public class Pagination {

    /**
     * TotalPages : 1
     * PageNo : 1
     * PerPage : 25
     * WebURL : http://timesofindia.indiatimes.com/
     */

    private String TotalPages;
    private String PageNo;
    private String PerPage;
    private String WebURL;

    public String getTotalPages() {
        return TotalPages;
    }

    public void setTotalPages(String TotalPages) {
        this.TotalPages = TotalPages;
    }

    public String getPageNo() {
        return PageNo;
    }

    public void setPageNo(String PageNo) {
        this.PageNo = PageNo;
    }

    public String getPerPage() {
        return PerPage;
    }

    public void setPerPage(String PerPage) {
        this.PerPage = PerPage;
    }

    public String getWebURL() {
        return WebURL;
    }

    public void setWebURL(String WebURL) {
        this.WebURL = WebURL;
    }
}
