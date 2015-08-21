import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for parsing data files used in Budget Liquors Android Application.
 *
 */
public class FileParser {

	/**
	 * Creates an object to be used for parsing relevant files.
	 */
	public FileParser() {
		super();
	}
	
	/**
	 * Parses the sales items files and creates a list of items.
	 * @param filename URL to find the file at "http://budgetapp.no-ip.biz/sales.txt"
	 * @return List of Sales items that has been parsed from the internet.
	 */
	public ArrayList<SaleItem> parseSaleItems(String filename){
		ArrayList<SaleItem> SaleItems = new ArrayList<SaleItem>();
		try {
			   URL url = new URL(filename);
			   Scanner s = new Scanner(url.openStream());
			   while(s.hasNextLine())
			   {
				   String data = s.nextLine();
				   if(data.length() >= 1)
				   {
					   if(data.charAt(0) != '#') {
						   //Parse here
						   String[] dataElements = data.split(", ");
						   SaleItem temp = new SaleItem(dataElements);
						   SaleItems.add(temp);
					   }
				   }
			   }
			   s.close();
			}
			catch(IOException ex) {
			   // there was some connection problem, or the file did not exist on the server.
			   ex.printStackTrace();
			}
		return SaleItems;
	}
	
	public static void main(String[] args) {
		FileParser temp = new FileParser();
		ArrayList<SaleItem> tempList = temp.parseSaleItems("http://budgetapp.no-ip.biz/sales.txt");
		for(int i = 0; i < tempList.size(); i++)
		{
			System.out.println(tempList.get(i).toString());
		}
	}

}
