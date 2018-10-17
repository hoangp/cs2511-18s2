package tut12.smells.example2;

public class PostCode {
	private String postcode;
	
	public PostCode(String postcode) {
		this.postcode = postcode;
	}

	public String getPostcode() { return postcode; }
	public String getPostcodeArea(){ return postcode.split("")[0]; }	
	
  // What's Code Smell here ?
}
