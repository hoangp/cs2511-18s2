package tut09.builder;

public class User {
	private String firstName; // required
	private String lastName;  // required
	private int age;          // optional
	private String phone;     // optional
	private String address;   // optional

	private User(UserBuilder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.age = builder.age;
		this.phone = builder.phone;
		this.address = builder.address;
	}
	
	public static class UserBuilder {
		private String firstName; // required
		private String lastName;  // required
		private int age;          // optional
		private String phone;     // optional
		private String address;   // optional

		public UserBuilder(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public UserBuilder age(int age) {
			this.age = age;
			return this;
		}

		public UserBuilder phone(String phone) {
			this.phone = phone;
			return this;
		}

		public UserBuilder address(String address) {
			this.address = address;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}
	
	public String getFirstName() { return firstName; }
  public String getLastName() { return lastName; }
  public int getAge() { return age; }
	public String getPhone() { return phone; }
	public String getAddress() { return address; }
	
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", phone=" + phone
				+ ", address=" + address + "]";
	}
	
	public static void main(String[] args) {
		User user = new User.UserBuilder("John", "Doe")
				.age(30)
				.phone("1234567")
				.address("Fake address")
				.build();
		System.out.println(user.toString());
	}
}
