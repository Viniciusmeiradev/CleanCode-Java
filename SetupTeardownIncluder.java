import fitnesse.responders.run.SuiteResponder;
import fitnesse.wiki.*;

public class SetupTeardownIncluder{
    private PageData PageData;
    private boolean isSuite;  //teste unico ou conjunto de paginas de teste
    private WikiPage testPage;
    private StringBuffer newPageContent;
    private PageCrawler pageCrawler; //rastreador de paginas

    public static String render(PageData pageData)throws Exception{
        return render(pageData, false);
    }

    public static String render(PageData pageData, boolean isSuite) throws Exception{
        return new SetupTeardownIncluder(pageData).render(isSuite);
    }

    public SetupTeardownIncluder(PageData pageData){
        this.pageData = pageData;
        testPage = pageData.getWikiPage();
        pageCrawler = testPage.getPageCrawler();
        newPageContent = new StringBuffer();
    }
}
hhuhgg
