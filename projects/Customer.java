public class Customer implements Cloneable {

    private String name;
    private String email;
    private String mobile;
    private Address address;

    // Constructor
    public Customer(String name, String email, String mobile, Address address) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
    }

    // Nested Address class
    public static class Address {

        private String line;
        private String city;
        private String pincode;

        // Constructor
        public Address(String line, String city, String pincode) {
            this.line = line;
            this.city = city;
            this.pincode = pincode;
        }

        // Getters
        public String getLine() {
            return line;
        }

        public String getCity() {
            return city;
        }

        public String getPincode() {
            return pincode;
        }
    }

    // getAddress()
    public Address getAddress() {
        return address;
    }

    // clone()
    @Override
    public Customer clone() {

        try {
            return (Customer) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}