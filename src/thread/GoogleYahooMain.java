package thread;

public class GoogleYahooMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
			System.out.println("_@_@_@_@_@_@_@_@_WELCOME MAIN _@_@_@_@__@_@_");
	    	Gmail gmail=new Gmail();
	    	GoogleAccount googleAccount=new GoogleAccount(gmail,"GoogleAccount");
	    	YahooAccount yahooAccount=new YahooAccount(gmail,"YahooAccount");
	    	yahooAccount.setPriority(Thread.MAX_PRIORITY);
	    	googleAccount.setPriority(Thread.MIN_PRIORITY);
	    	
	    	googleAccount.start();
	    	yahooAccount.start();
	    	System.out.println("_@_@_@_@_@_@_@_@_WELCOME MAIN _@_@_@_@__@_@_");
	}

}
