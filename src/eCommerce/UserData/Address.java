package eCommerce.UserData;

public class Address {
	
	private String addressEn;
	private String address;
	private String addressLine;
	private String city;
	private String state;
	private String country;
	private String zipcode;
	
	public Address(String line, String _City, String _State, String _Country, String _ZipCode)
	{
		addressLine = line;
		city = _City;
		state = _State;
		country = _Country;
		zipcode = _ZipCode;
		address = addressLine + " " + city + ", " + state + " " + zipcode + ", " + country;
		addressEn = addressLine + "#" + city + "#" + state + "#" + zipcode + "#" + country;
	}
	public Address(String addressEnc)
	{
		String[] arr = {" ", " ", " ", " ", " "};

		System.out.println("Address " + addressEnc);
		if(addressEnc != "" && addressEnc != null)
		{
			arr = addressEnc.split("#");
		}
		if(arr.length == 5)
		{
			addressLine = arr[0];
			city = arr[1];
			state = arr[2];
			zipcode = arr[3];
			country = arr[4];
			address = addressLine + " " + city + ", " + state + " " + zipcode + ", " + country;
		}else
		{
			addressLine = "";
			city = "";
			state = "";
			zipcode = "";
			country = "";
			address = "";
		}
	}
	
	public String getAddressEnc()
	{
		return addressEn;
	}
	
	public String getAddressLine()
	{
		return addressLine;
	}
	
	public String getCity()
	{
		return city;
	}
	
	public String getState()
	{
		return state;
	}
	
	public String getCountry()
	{
		return country;
	}
	
	public String getZipCode()
	{
		return zipcode;
	}
	
	public String toString()
	{
		return address;
	}
}
