package tclisp.tests;

@RunWith(Parameterized.class)
public class BasicTests {
	
	@Parameters
	public static Iterable<Object[]> data() {
	    return Arrays.asList(new Object[][] {
	        {"MethodCall",     "test",  42, Long.class }
	    });
	}
	
	public BasicTests(final String testClass,
		      final String testSelector,
		      final Object expectedResult,
		      final Class<?> resultType) {
		    this.testClass      = testClass;
		    this.testSelector   = testSelector;
		    this.expectedResult = expectedResult;
		    this.resultType     = resultType;
	}
	
	protected void assertEqualsSOMValue(final Object expectedResult, final Object actualResult) {
	    if (resultType == Long.class) {
	      long expected = (int) expectedResult;
	      long actual   = (long) actualResult;
	      assertEquals(expected, actual);
	      return;
	    }

	    /*if (resultType == SClass.class) {
	      String expected = (String) expectedResult;
	      String actual   = ((SClass) actualResult).getName().getString();
	      assertEquals(expected, actual);
	      return;
	    }

	    if (resultType == SSymbol.class) {
	      String expected = (String) expectedResult;
	      String actual   = ((SSymbol) actualResult).getString();
	      assertEquals(expected, actual);
	      return;
	    }*/
	    fail("SOM Value handler missing");
	}
	
	protected String getClasspath(){
	    return "Smalltalk:TestSuite/BasicInterpreterTests";
	}

	protected static Universe u = Universe.current();
	  
	@Test
	public void testBasicInterpreterBehavior() {
	    u.setAvoidExit(true);
	    u.setupClassPath(this.getClasspath());

	    Object actualResult = u.interpret(testClass, testSelector);

	    assertEqualsSOMValue(expectedResult, actualResult);
	}
}
