import fitnesse.responders.run.SuiteResponder;
import fitnesse.wiki.*;

public class SetupTeardownIncluder{
    private PageData PageData;
    private boolean isSuite;  //teste unico ou conjunto de paginas de teste
    private WikiPage testPage;
    private StringBuffer newPageContent;
    private PageCrowler pageCrowler;
}
