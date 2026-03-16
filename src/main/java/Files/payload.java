package Files;

public class payload {

	public static String AddData()
	
	{
		
		return "{\r\n"
				+ "  \"name\": \"Apple MacBook Pro 16\",\r\n"
				+ "  \"data\": {\r\n"
				+ "    \"year\": 2019,\r\n"
				+ "    \"price\": 1849.99,\r\n"
				+ "    \"CPU model\": \"Intel Core i9\",\r\n"
				+ "    \"Hard disk size\": \"1 TB\"\r\n"
				+ "  }\r\n"
				+ "}";
	}
	
public static String UpdateData()
	
	{
		
		return "{\r\n"
				+ "  \"name\": \"Ashish MacBook Pro 20\",\r\n"
				+ "  \"data\": {\r\n"
				+ "    \"year\": 2023,\r\n"
				+ "    \"price\": 1200.45,\r\n"
				+ "    \"CPU model\": \"Intel Core i9\",\r\n"
				+ "    \"Hard disk size\": \"1 TB\",\r\n"
				+ "    \"color\": \"silver\"\r\n"
				+ "  }\r\n"
				+ "}";
	}

public static String Course()

{
	
	return "{\r\n"
			+ "  \"dashboard\": {\r\n"
			+ "\r\n"
			+ "      \"totalPurchaseAmount\": 370,\r\n"
			+ "      \"WebSite\": \"Udemy.com\"\r\n"
			+ "    },\r\n"
			+ "    \"courses\": [\r\n"
			+ "      {\r\n"
			+ "        \"title\": \"Data Science Fundamentals\",\r\n"
			+ "        \"price\": 100,\r\n"
			+ "        \"copies\": 2\r\n"
			+ "      },\r\n"
			+ "      {\r\n"
			+ "        \"title\": \"Web Development Bootcamp\",\r\n"
			+ "        \"price\": 120,\r\n"
			+ "        \"copies\": 1\r\n"
			+ "      },\r\n"
			+ "      {\r\n"
			+ "        \"title\": \"Machine Learning Advanced\",\r\n"
			+ "        \"price\": 150,\r\n"
			+ "        \"copies\": 1\r\n"
			+ "      }\r\n"
			+ "    ]\r\n"
			+ "  }\r\n"
			+ "";
}

public static String AddPlcae()

{
	return "{\r\n"
			+ "  \"location\": {\r\n"
			+ "    \"latitude\": 30.7046,\r\n"
			+ "    \"longitude\": 76.7179\r\n"
			+ "  },\r\n"
			+ "  \"accuracy\": 15,\r\n"
			+ "  \"addname\": \"Example Cafe\",\r\n"
			+ "  \"phone_number\": \"+91-9876543210\",\r\n"
			+ "  \"address\": \"123 Main Street, Sahibzada Ajit Singh Nagar, Punjab, India\",\r\n"
			+ "  \"types\": [\"restaurant\", \"cafe\"],\r\n"
			+ "  \"website\": \"https://www.examplecafe.com\",\r\n"
			+ "  \"language\": \"en\"\r\n"
			+ "}\r\n"
			+ "";
}


public static String lib(String auth, String ibsn)
{
	return "{\r\n"
			+ "  \"name\": \"The Art of Coding\",\r\n"
			+ "  \"isbn\": \""+ibsn+"\",\r\n"
			+ "  \"aisle\": \"A12\",\r\n"
			+ "  \"author\": \""+auth+"\"\r\n"
			+ "}\r\n"
			+ "";
}

}
