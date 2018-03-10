package homeworks;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;


@RunWith(JUnitParamsRunner.class)
public class WordReferenceTest extends WordReferenceParent{
	
	@Test
	@FileParameters("./data/dtWordReference.csv")
	public void testNumber1(String browser, String urlToOpen,
			String searchTerm1, String numberOfElementToSearch1,
			String searchTerm2, String numberOfElementToSearch2){
		
		setUp(urlToOpen,browser);
		
		search(searchTerm1);
		
		wrreverse();
		
		seeAlso(Integer.parseInt(numberOfElementToSearch1));
		
		searchInternal(searchTerm2);
		
		wrreverse();
		
		seeAlso(Integer.parseInt(numberOfElementToSearch2));
		
	}
}
