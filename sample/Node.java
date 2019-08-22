package sample;

public class Node {
    private String websiteName;
    private String webSiteUserName;
    private String websitePassword;
    private String webSiteEmail;
    private String websiteURL;
    private String websiteInformation;


    /**
     * Constructor.
     * @param name
     * @param pass
     * @param url
     * @param info
     */
    Node(String name, String userName, String pass, String email, String url, String info) {
        this.websiteName = name;
        this.webSiteUserName = userName;
        this.websitePassword = pass;
        this.webSiteEmail = email;
        this.websiteURL = url;
        this.websiteInformation = info;

    }


    Node(String name, String userName, String pass, String email, String url) {
        this.websiteName = name;
        this.webSiteUserName = userName;
        this.websitePassword = pass;
        this.webSiteEmail = email;
        this.websiteURL = url;
    }


    public String GetWebsiteName() {
        return this.websiteName;
    }

    public String GetWebsitePassword() {
        return this.websitePassword;
    }

    public String GetWebsiteURL() {
        return this.websiteURL;
    }

    public String GetWebsiteInformation() {
        return this.websiteInformation;
    }

    public String GetWebsiteUsername() {
        return this.webSiteUserName;
    }

    public String GetWebsiteEmail() {
        return this.webSiteEmail;
    }

}
