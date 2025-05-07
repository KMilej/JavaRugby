package models;

public class Player {

	/* PROPERTIES */
	private String name;
	private String surname;
	private String fieldPosition;
	private String address;
	private String postcode;
	private int sruNumber;
	private String dateOfBirth;
	private int phoneNumber;
	private String email;
	private String doctor;
	private String doctorPhoneNumber;

	/* METHODS */

	public Player(String name, String surname, String fieldPosition, String address, String postcode, int sruNumber, String dateOfBirth,
			int phoneNumber, String email) {
		this.name = name;
		this.surname = surname;
		this.fieldPosition = fieldPosition;
		this.address = address;
		this.postcode = postcode;
		this.sruNumber = sruNumber;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public Player(String name, String surname, String fieldPosition, String address, String postcode, int sruNumber, String dateOfBirth,
			int phoneNumber, String email, String doctor, String doctorPhoneNumber) {
		this.name = name;
		this.surname = surname;
		this.fieldPosition = fieldPosition;
		this.address = address;
		this.postcode = postcode;
		this.sruNumber = sruNumber;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.doctor = doctor;
		this.doctorPhoneNumber = doctorPhoneNumber;
	}

	public String getDoctorPhoneNumber() {
		return doctorPhoneNumber;
	}

	public void setDoctorPhoneNumber(String doctorPhoneNumber) {
		this.doctorPhoneNumber = doctorPhoneNumber;
	}

	public String getDoctor() {
		return doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getSruNumber() {
		return sruNumber;
	}

	public void setSruNumber(int sruNumber) {
		this.sruNumber = sruNumber;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	@Override
	public String toString() {
	    return "Player{" +
	            "name='" + name + '\'' +
	            ", surname='" + surname + '\'' +
	            ", address='" + address + '\'' +
	            ", Position='" + fieldPosition + '\'' +
	            ", postcode='" + postcode + '\'' +
	            ", sruNumber=" + sruNumber +
	            ", dateOfBirth='" + dateOfBirth + '\'' +
	            ", phoneNumber=" + phoneNumber +
	            ", email='" + email + '\'' +
	            ", doctor='" + doctor + '\'' +
	            ", doctorPhoneNumber='" + doctorPhoneNumber + '\'' +
	            '}';
	}

}
