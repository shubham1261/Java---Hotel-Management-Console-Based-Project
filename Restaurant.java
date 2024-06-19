package Driver;

import java.util.*;
public class Restaurant  {
	static {
		System.err.println("**************************************************************");
		System.err.println("||                   || JAI SHREE RAM ||                    ||");
		System.err.println("**************************************************************");
		System.err.println("||                Welcome  to  Khao-Khilao                   ||");
		System.err.println("**************************************************************");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Signup");
		System.out.println("Press 2 for Login");
		System.out.println("Press 3 for Exit");
		int x = sc.nextInt();
		Menu m = new Menu();
		switch (x) {
		case 1:
			m.signup();
			break;
		case 2:
			m.login();
			break;
		case 3:
			System.err.println("Thanks For Visiting...");
			System.exit(0);
			break;
		default:
			System.err.println("Invalid Input!! Please Try Again");
			main(null);
		}

		m.menu();
		m.payment();
        
	}
}

class Menu implements Signup {
	private String name;
	private long contact=9022814766L;
	private String email;
	private int age;
	private String address;
	private String password="123";

	static double totalBill;
	int otp;
	
	static ArrayList a = new ArrayList();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getContact() {
		return contact;
	}

	public void setContact() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Contact Number");
		contact = sc.nextLong();
		if (contact > 999999999 && contact < 10000000000L) {
			System.out.println("Contact number is valid!!");
			System.out.println(" ");
		} else {
			System.err.println("Please enter 10 digit!! Try Again");
			setContact();
		}
		
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void signup() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Name");
		name = sc.nextLine();
		setContact();
		System.out.println("OTP Number:");
		generateOTP();
		System.out.println("Enter your Email");
		email = sc.nextLine();
	    System.out.println("Enter Your Age");
		age=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter your Address");
		address = sc.nextLine();
		System.out.println("Enter Password");
		password = sc.nextLine();
		System.out.println(" ");
		System.out.println("---------------------");
		System.out.println("Signup is Successfull");
		System.out.println("---------------------");
		System.out.println(" ");
		System.out.println("Please Proceed for Login");
		login();
	
	}
	
	public void generateOTP()
	{
		Random r = new Random();
		otp = r.nextInt(1000000);
		if(otp>99999) {
			System.out.println(otp);
			verifyOTP();
		}
		else {
			System.err.println("Try Again");
		    generateOTP();
		}
			
	}
	public void verifyOTP()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter OTP as same as above: ");
		int userOTP = sc.nextInt();
		
		if (userOTP == otp)
		{
			System.out.println("OTP Verified Successfully");
		}
		else
		{
			System.err.println("Incorrect OTP");
			System.out.println(" ");
			System.out.println("Please Try Again");
			generateOTP();
		}
		
	}
	
	public void payment()
	{
		System.out.println("Name: "+name);
		System.out.println("Contact: "+contact);
		System.out.println(a);
		System.out.println("Your Bill: "+totalBill);
	    int a = 18;
		System.out.println("Total Bill with GST: "+(totalBill+a));
		System.out.println(" ");
		System.err.println("Your Order Has Been Placed...");
		System.err.println("- - - Aapka Din Shubh ho - - -");
		System.out.println(" ");
	}

	@Override
	public void login() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 to use Contact for login");
		System.out.println("Press 2 to use Email for login");
		int n = sc.nextInt();
		if (n == 1) {
			System.out.println("Enter the contact");
			long contact = sc.nextLong();
			sc.nextLine();
			System.out.println("Enter the password");
			String pass = sc.nextLine();
			if (this.contact == contact && this.password.equals(pass)){
				System.out.println(" ");
				System.out.println("-------------------");
				System.out.println("Login is Successful");
				System.out.println("-------------------");
				System.out.println(" ");
			} else {
				System.err.println("User Credentials Incorrect");
				login();
			}

		} else if (n == 2) {
			System.out.println("Enter the Email");
			sc.nextLine();
			String email = sc.nextLine();
			System.out.println("Enter the password");
			String pass = sc.nextLine();
			if (this.email.equals(email) && this.password.equals(pass)) {
				System.out.println(" ");
				System.out.println("-------------------");
				System.out.println("Login is Successful");
				System.out.println("-------------------");
				System.out.println(" ");
			} else {
				System.err.println("User Credentials Incorrect");
				login();
			}
		} else {
			System.err.println("Wrong Choice!!! Please try again");
			login();
		}
		
	}

	public void menu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Starters");
		System.out.println("Press 2 for Main Course");
		System.out.println("Press 3 for Desserts");
		System.out.println("Press 4 for Cold Drinks");
		System.out.println("Press 5 for Beverages");
		System.out.println("Press 6 for Continental");
		System.out.println("Press 7 for Thai & Mexican Cuisine");
		System.out.println("Press 8 for Snacks");
		System.out.println("Press 9 for Salads");
		System.out.println("Press 0 for Exit");
		int x = sc.nextInt();
		switch (x) {
		case 1:
			Starters s = new Starters();
			s.startersMenu();
			break;
		case 2:
			Main_Course m = new Main_Course();
			m.mainCourseMenu();
			break;
		case 3:
			Desserts d = new Desserts();
			d.desserts();
			break;
		case 4: 
			Cold_Drinks c = new Cold_Drinks();
			c.coldDrinks();
			break;
		case 5: 
			Beverages b = new Beverages();
			b.beverages();
			break;
		case 6: 
			Continental e = new Continental();
			e.continental();
			break;
		case 7: 
			Thai_Mexican t = new Thai_Mexican();
			t.thaiMexican();
			break;
		case 8: 
			Snacks a = new Snacks();
			a.snacks();
			break;
		case 9:
			Salads g = new Salads();
			g.salads();
		case 0:
			System.out.println("Thank You for visiting");
			System.exit(0);
			break;
		default:
			System.err.println("Try Again!!!");
			menu();
			break;
		}
	
	}

}

class Starters extends Menu {
	public void startersMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Veg Starters");
		System.out.println("Press 2 for Non Veg Starters");
		System.out.println("Press 3 to go back");
		int x = sc.nextInt();
		switch (x) {
		case 1:
			Veg_Starters vs = new Veg_Starters();
			vs.vegStarters();
			break;
		case 2:
			Non_VegStarters nvs = new Non_VegStarters();
			nvs.nonVegStarters();
			break;
		case 3:

			menu();
			break;
		default:
			System.err.println("Please Try Again!!!");
			startersMenu();
			break;

		}
		
	}
}

class Veg_Starters extends Starters {
	public void vegStarters() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Chinese Starters");
		System.out.println("Press 2 for South Indian Staters");
		System.out.println("Press 3 for North Indian Starters");
		System.out.println("Press 4 to go back");
		int n = sc.nextInt();
		switch (n) {
		case 1:
			chineseStarters();
			break;
		case 2:
			southIndianStarters();
			break;
		case 3:
			northIndianStarters();
			break;
		case 4:
			startersMenu();
			break;
		default:
			System.err.println("Please choose correct option");
			vegStarters();
			break;
		}
	
	}

	public void chineseStarters() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Soya Chilly");
		System.out.println("Press 2 for Manchurian");
		System.out.println("Press 3 for Paneer Crispy");
		System.out.println("Press 4 for Paneer Seekh Kebab");
		System.out.println("Press 5 for Hara Bhara Kebab");
		System.out.println("Press 6 for Hariyali Paneer Tikka");
		System.out.println("Press 7 to go back");
		int n = sc.nextInt();
		switch (n) {
		case 1:
			System.out.println("Price of Soya Chilly is Rs 120");
			System.out.println("Choose Y to order or N to go back");
			char ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Soya Chilly,120");
				totalBill = totalBill + 120;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					chineseStarters();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
					
					break;
				}
			} else if (ch == 'n' || ch == 'N') {
				System.out.println("Choose another item");
				chineseStarters();
			} else {
				System.err.println("Please choose correct option");
				vegStarters();
			}
			break;
		case 2:
			System.out.println("Price of Manchurian is Rs 150");
			System.out.println("Choose Y to order or N to go back");
			ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Manchurian,150");
				totalBill = totalBill + 150;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					chineseStarters();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
					break;
				}
			} else if (ch == 'n' || ch == 'N') {
				System.out.println("Choose another item");
				chineseStarters();
			} else {
				System.err.println("Please choose correct option");
				vegStarters();
			}
			break;
		case 3:
			System.out.println("Price of Panner Crispy is Rs 200");
			System.out.println("Choose Y to order or N to go back");
			ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Paneer Crispy,200");
				totalBill = totalBill + 200;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					chineseStarters();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
					break;
				}
			} else if (ch == 'n' || ch == 'N') {
				System.out.println("Choose another item");
				chineseStarters();
			} else {
				System.err.println("Please choose correct option");
				vegStarters();
			}
			break;
		case 4:
			System.out.println("Price of Panner Seekh Kebab is Rs 220");
			System.out.println("Choose Y to order or N to go back");
			char h = sc.next().charAt(0);
			if (h == 'y' || h == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Paneer Seekh Kebab,220");
				totalBill = totalBill + 220;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					chineseStarters();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
					break;
				}
			} else if (h == 'n' || h == 'N') {
				System.out.println("Choose another item");
				chineseStarters();
			} else {
				System.err.println("Please choose correct option");
				vegStarters();
			}
			break;
		case 5:
			System.out.println("Price of Hara Bhara Kebab is Rs 260");
			System.out.println("Choose Y to order or N to go back");
			char c = sc.next().charAt(0);
			if (c == 'y' || c == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Hara Bhara Kebab,260");
				totalBill = totalBill + 260;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					chineseStarters();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
					
					break;
				}
			} else if (c == 'n' || c == 'N') {
				System.out.println("Choose another item");
				chineseStarters();
			} else {
				System.err.println("Please choose correct option");
				vegStarters();
			}
			break;
		case 6:
			System.out.println("Price of Hariyali Paneer Tikka is Rs 200");
			System.out.println("Choose Y to order or N to go back");
			char p = sc.next().charAt(0);
			if (p == 'y' || p == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Hariyali Paneer Tikka,200");
				totalBill = totalBill + 200;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					chineseStarters();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please Pay the Amount");
					
					break;
				}
			} else if (p == 'n' || p == 'N') {
				System.out.println("Choose another item");
				chineseStarters();
			} else {
				System.err.println("Please choose correct option");
				vegStarters();
			}
			break;
		case 7:
			vegStarters();
			break;
		default:
			System.err.println("Please Select Valid Option");
			chineseStarters();
		}

	}

	public void southIndianStarters() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Punugulu");
		System.out.println("Press 2 for Vermicelli Upma");
		System.out.println("Press 3 for Murukku");
		System.out.println("Press 4 for Stuffed Idlis");
		System.out.println("Press 5 for Medu Vada");
		System.out.println("Press 6 for Moong Dal");
		System.out.println("Press 7 to go back");
		int n = sc.nextInt();
		switch (n) {
		case 1:
			System.out.println("Price of Punugulu is Rs 80");
			System.out.println("Choose Y to order or N to go back");
			char ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Punugulu,80");
				totalBill = totalBill + 80;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
 				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					southIndianStarters();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
					
					break;
				}
			} else if (ch == 'n' || ch == 'N') {
				System.out.println("Choose another item");
				southIndianStarters();
			} else {
				System.err.println("Please choose correct option");
				southIndianStarters();
			}
			break;
		case 2:
			System.out.println("Price of Vermicelli Upma is Rs 50");
			System.out.println("Choose Y to order or N to go back");
			ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Vermicelli Upma,50");
				totalBill = totalBill + 50;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					southIndianStarters();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
			
					break;
				}
			} else if (ch == 'n' || ch == 'N') {
				System.out.println("Choose another item");
				southIndianStarters();
			} else {
				System.err.println("Please choose correct option");
				southIndianStarters();
			}
			break;
		case 3:
			System.out.println("Price of Murukku is Rs 100");
			System.out.println("Choose Y to order or N to go back");
			ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Murukku,100");
				totalBill = totalBill + 100;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					southIndianStarters();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
					
					break;
				}
			} else if (ch == 'n' || ch == 'N') {
				System.out.println("Choose another item");
				southIndianStarters();
			} else {
				System.err.println("Please choose correct option");
				southIndianStarters();
			}
			break;
		case 4:
			System.out.println("Price of Stuffed Idlis is Rs 230");
			System.out.println("Choose Y to order or N to go back");
			char h = sc.next().charAt(0);
			if (h == 'y' || h == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Stuffed Idlis,230");
				totalBill = totalBill + 230;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					southIndianStarters();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
			
					break;
				}
			} else if (h == 'n' || h == 'N') {
				System.out.println("Choose another item");
				southIndianStarters();
			} else {
				System.err.println("Please choose correct option");
				southIndianStarters();
			}
			break;
		case 5:
			System.out.println("Price of Medu Vada is Rs 150");
			System.out.println("Choose Y to order or N to go back");
			char c = sc.next().charAt(0);
			if (c == 'y' || c == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Medu vada,150");
				totalBill = totalBill + 150;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					southIndianStarters();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
					
					break;
				}
			} else if (c == 'n' || c == 'N') {
				System.out.println("Choose another item");
				southIndianStarters();
			} else {
				System.err.println("Please choose correct option");
				southIndianStarters();
			}
			break;
		case 6:
			System.out.println("Price of Moong Dal is Rs 200");
			System.out.println("Choose Y to order or N to go back");
			char r = sc.next().charAt(0);
			if (r == 'y' || r == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Moong Dal,200");
				totalBill = totalBill + 200;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					southIndianStarters();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (r == 'n' || r == 'N') {
				System.out.println("Choose another item");
				southIndianStarters();
			} else {
				System.err.println("Please choose correct option");
				southIndianStarters();
			}
			break;
		case 7:
			vegStarters();
			break;
		default:
			System.err.println("Please Select Valid Option");
			southIndianStarters();
		}
	}

	public void northIndianStarters() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Samosa");
		System.out.println("Press 2 for Bhaji Pav");
		System.out.println("Press 3 for Kanda Poha");
		System.out.println("Press 4 for Chole Bhature");
		System.out.println("Press 5 for Vada Pav");
		System.out.println("Press 6 for Dal Pakwan");
		System.out.println("Press 7 to go back");
		int n = sc.nextInt();
		switch (n) {
		case 1:
			System.out.println("Price of Samosa is Rs 40");
			System.out.println("Choose Y to order or N to go back");
			char ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Samosa,40");
				totalBill = totalBill + 40;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					northIndianStarters();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (ch == 'n' || ch == 'N') {
				System.out.println("Choose another item");
				northIndianStarters();
			} else {
				System.err.println("Please choose correct option");
				northIndianStarters();
			}
			break;
		case 2:
			System.out.println("Price of Bhaji Pav is Rs 30");
			System.out.println("Choose Y to order or N to go back");
			ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Bhaji Pav,30");
				totalBill = totalBill + 30;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					northIndianStarters();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
			
					break;
				}
			} else if (ch == 'n' || ch == 'N') {
				System.out.println("Choose another item");
				northIndianStarters();
			} else {
				System.err.println("Please choose correct option");
				northIndianStarters();
			}
			break;
		case 3:
			System.out.println("Price of Kanda Poha is Rs 30");
			System.out.println("Choose Y to order or N to go back");
			ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Kanda Poha,30");
				totalBill = totalBill + 30;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					northIndianStarters();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (ch == 'n' || ch == 'N') {
				System.out.println("Choose another item");
				northIndianStarters();
			} else {
				System.err.println("Please choose correct option");
				northIndianStarters();
			}
			break;
		case 4:
			System.out.println("Price of Chole Bhature is Rs 60");
			System.out.println("Choose Y to order or N to go back");
			char h = sc.next().charAt(0);
			if (h == 'y' || h == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Chole Bhature,60");
				totalBill = totalBill + 60;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					northIndianStarters();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
					
					break;
				}
			} else if (h == 'n' || h == 'N') {
				System.out.println("Choose another item");
				northIndianStarters();
			} else {
				System.err.println("Please choose correct option");
				northIndianStarters();
			}
			break;
		case 5:
			System.out.println("Price of Vada Pav is Rs 100");
			System.out.println("Choose Y to order or N to go back");
			char c = sc.next().charAt(0);
			if (c == 'y' || c == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Vada Pav,100");
				totalBill = totalBill + 100;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					northIndianStarters();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
			
					break;
				}
			} else if (c == 'n' || c == 'N') {
				System.out.println("Choose another item");
				northIndianStarters();
			} else {
				System.err.println("Please choose correct option");
				northIndianStarters();
			}
			break;
		case 6:
			System.out.println("Price of Dal Pakwan is Rs 90");
			System.out.println("Choose Y to order or N to go back");
			char q = sc.next().charAt(0);
			if (q == 'y' || q == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Dal Pakwan,90");
				totalBill = totalBill + 90;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					northIndianStarters();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (q == 'n' || q == 'N') {
				System.out.println("Choose another item");
				northIndianStarters();
			} else {
				System.err.println("Please choose correct option");
				northIndianStarters();
			}
			break;
		case 7:
			vegStarters();
			break;
		default:
			System.err.println("Please Select Valid Option");
			northIndianStarters();
		}
	}
}

class Non_VegStarters extends Starters {
	public void nonVegStarters() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Chinese Non-Veg Starters");
		System.out.println("Press 2 for South Indian Non-Veg Starters");
		System.out.println("Press 3 for North Indian Non-Veg Starters");
		System.out.println("Press 4 to go back");
		int n = sc.nextInt();
		switch (n) {
		case 1:
			chineseNonVegStarters();
			break;
		case 2:
			southIndianNonVegStarters();
			break;
		case 3:
			northIndianNonVegStarters();
			break;
		case 4:
			startersMenu();
			break;
		default:
			System.err.println("Please choose correct option");
			nonVegStarters();
			break;
		}
		sc.close();
}
	public void chineseNonVegStarters() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Achari Egg");
		System.out.println("Press 2 for Chicken 65");
		System.out.println("Press 3 for Chicken Achari");
		System.out.println("Press 4 for Chicken Kathi Roll");
		System.out.println("Press 5 for Chicken Lollipop");
		System.out.println("Press 6 for Chicken Malai");
		System.out.println("Press 7 for Chicken Manchurian");
		System.out.println("Press 8 for Chicken Pakora");
		System.out.println("Press 9 to go back");
		int n = sc.nextInt();
		switch (n) {
		case 1:
			System.out.println("Price of  Achari Egg is Rs 120");
			System.out.println("Choose Y to order or N to go back");
			char ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Achari Egg,120");
				totalBill = totalBill + 120;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					chineseNonVegStarters();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (ch == 'n' || ch == 'N') {
				System.out.println("Choose another item");
				chineseNonVegStarters();
			} else {
				System.err.println("Please choose correct option");
				chineseNonVegStarters();
			}
			break;
		case 2:
			System.out.println("Price of Chicken 65 is Rs 150");
			System.out.println("Choose Y to order or N to go back");
			ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Chicken 65,150");
				totalBill = totalBill + 150;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					chineseNonVegStarters();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (ch == 'n' || ch == 'N') {
				System.out.println("Choose another item");
				chineseNonVegStarters();
			} else {
				System.err.println("Please choose correct option");
				chineseNonVegStarters();
			}
			break;
		case 3:
			System.out.println("Price of Chicken Achari is Rs 200");
			System.out.println("Choose Y to order or N to go back");
			ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Chicken Achari,200");
				totalBill = totalBill + 200;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					chineseNonVegStarters();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (ch == 'n' || ch == 'N') {
				System.out.println("Choose another item");
				chineseNonVegStarters();
			} else {
				System.err.println("Please choose correct option");
				chineseNonVegStarters();
			}
			break;
		case 4:
			System.out.println("Price of Chicken Kathi Roll is Rs 220");
			System.out.println("Choose Y to order or N to go back");
			char h = sc.next().charAt(0);
			if (h == 'y' || h == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Chicken Kathi Roll,220");
				totalBill = totalBill + 220;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					chineseNonVegStarters();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
					
					break;
				}
			} else if (h == 'n' || h == 'N') {
				System.out.println("Choose another item");
				chineseNonVegStarters();
			} else {
				System.err.println("Please choose correct option");
				chineseNonVegStarters();
			}
			break;
		case 5:
			System.out.println("Price of Chicken Lollipop is Rs 260");
			System.out.println("Choose Y to order or N to go back");
			char c = sc.next().charAt(0);
			if (c == 'y' || c == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Chicken Lollipop,260");
				totalBill = totalBill + 260;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					chineseNonVegStarters();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
					
					break;
				}
			} else if (c == 'n' || c == 'N') {
				System.out.println("Choose another item");
				chineseNonVegStarters();
			} else {
				System.err.println("Please choose correct option");
				chineseNonVegStarters();
			}
			break;
		case 6:
			System.out.println("Price of Chicken Malai is Rs 200");
			System.out.println("Choose Y to order or N to go back");
			char p = sc.next().charAt(0);
			if (p == 'y' || p == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Chicken Malai,200");
				totalBill = totalBill + 200;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					chineseNonVegStarters();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (p == 'n' || p == 'N') {
				System.out.println("Choose another item");
				chineseNonVegStarters();
			} else {
				System.err.println("Please choose correct option");
				chineseNonVegStarters();
			}
			break;
		case 7:
			System.out.println("Price of Chicken Manchurian is Rs 130");
			System.out.println("Choose Y to order or N to go back");
			char b = sc.next().charAt(0);
			if (b == 'y' || b == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Chicken Manchurian,130");
				totalBill = totalBill + 130;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					chineseNonVegStarters();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (b == 'n' || b == 'N') {
				System.out.println("Choose another item");
				chineseNonVegStarters();
			} else {
				System.err.println("Please choose correct option");
				chineseNonVegStarters();
			}
			break;
		case 8:
			System.out.println("Price of Chicken Pakora is Rs 160");
			System.out.println("Choose Y to order or N to go back");
			char d = sc.next().charAt(0);
			if (d == 'y' || d == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Chicken Pakora,160");
				totalBill = totalBill + 160;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					chineseNonVegStarters();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (d == 'n' || d == 'N') {
				System.out.println("Choose another item");
				chineseNonVegStarters();
			} else {
				System.err.println("Please choose correct option");
				chineseNonVegStarters();
			}
			break;

		case 9:
			nonVegStarters();
			break;
		default:
			System.err.println("Please Select Valid Option");
			chineseNonVegStarters();
		}

	}
	public void southIndianNonVegStarters() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Chicken Pepper Fry");
		System.out.println("Press 2 for Chicken Sheesh Kebab");
		System.out.println("Press 3 for Chicken Szechwan");
		System.out.println("Press 4 for Chicken Tikka Dry");
		System.out.println("Press 5 for Chilli Chicken");
		System.out.println("Press 6 for Chilli Fish");
		System.out.println("Press 7 for Egg Khema");
		System.out.println("Press 8 for Fish Fry");
		System.out.println("Press 9 to go back");
		int n = sc.nextInt();
		switch (n) {
		case 1:
			System.out.println("Price of  Chicken Pepper Fry is Rs 120");
			System.out.println("Choose Y to order or N to go back");
			char ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Chicken Pepper Fry,120");
				totalBill = totalBill + 120;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					southIndianNonVegStarters();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (ch == 'n' || ch == 'N') {
				System.out.println("Choose another item");
				southIndianNonVegStarters();
			} else {
				System.err.println("Please choose correct option");
				southIndianNonVegStarters();
			}
			break;
		case 2:
			System.out.println("Price of Chicken Sheesh Kebab is Rs 150");
			System.out.println("Choose Y to order or N to go back");
			ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Chicken Sheesh Kebab,150");
				totalBill = totalBill + 150;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					southIndianNonVegStarters();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (ch == 'n' || ch == 'N') {
				System.out.println("Choose another item");
				southIndianNonVegStarters();
			} else {
				System.err.println("Please choose correct option");
				southIndianNonVegStarters();
			}
			break;
		case 3:
			System.out.println("Price of Chicken Szechwan is Rs 200");
			System.out.println("Choose Y to order or N to go back");
			ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Chicken Szechwan,200");
				totalBill = totalBill + 200;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					southIndianNonVegStarters();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (ch == 'n' || ch == 'N') {
				System.out.println("Choose another item");
				southIndianNonVegStarters();
			} else {
				System.err.println("Please choose correct option");
				southIndianNonVegStarters();
			}
			break;
		case 4:
			System.out.println("Price of Chicken Tikka Dry is Rs 220");
			System.out.println("Choose Y to order or N to go back");
			char h = sc.next().charAt(0);
			if (h == 'y' || h == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Chicken Tikka Dry,220");
				totalBill = totalBill + 220;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					southIndianNonVegStarters();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (h == 'n' || h == 'N') {
				System.out.println("Choose another item");
				southIndianNonVegStarters();
			} else {
				System.err.println("Please choose correct option");
				southIndianNonVegStarters();
			}
			break;
		case 5:
			System.out.println("Price of Chilli Chicken is Rs 260");
			System.out.println("Choose Y to order or N to go back");
			char c = sc.next().charAt(0);
			if (c == 'y' || c == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Chilli Chicken,260");
				totalBill = totalBill + 260;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					southIndianNonVegStarters();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
			
					break;
				}
			} else if (c == 'n' || c == 'N') {
				System.out.println("Choose another item");
				southIndianNonVegStarters();
			} else {
				System.err.println("Please choose correct option");
				southIndianNonVegStarters();
			}
			break;
		case 6:
			System.out.println("Price of Chilli Fish is Rs 200");
			System.out.println("Choose Y to order or N to go back");
			char j = sc.next().charAt(0);
			if (j == 'y' || j == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Chilli Fish,200");
				totalBill = totalBill + 200;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					southIndianNonVegStarters();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
		
					break;
				}
			} else if (j == 'n' || j == 'N') {
				System.out.println("Choose another item");
				southIndianNonVegStarters();
			} else {
				System.err.println("Please choose correct option");
				southIndianNonVegStarters();
			}
			break;
		case 7:
			System.out.println("Price of Egg Khema is Rs 130");
			System.out.println("Choose Y to order or N to go back");
			char b = sc.next().charAt(0);
			if (b == 'y' || b == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Egg Khema,130");
				totalBill = totalBill + 130;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					southIndianNonVegStarters();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (b == 'n' || b == 'N') {
				System.out.println("Choose another item");
				southIndianNonVegStarters();
			} else {
				System.err.println("Please choose correct option");
				southIndianNonVegStarters();
			}
			break;
		case 8:
			System.out.println("Price of Fish Fry is Rs 160");
			System.out.println("Choose Y to order or N to go back");
			char d = sc.next().charAt(0);
			if (d == 'y' || d == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Fish Fry,160");
				totalBill = totalBill + 160;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					southIndianNonVegStarters();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (d == 'n' || d == 'N') {
				System.out.println("Choose another item");
				southIndianNonVegStarters();
			} else {
				System.err.println("Please choose correct option");
				southIndianNonVegStarters();
			}
			break;

		case 9:
			nonVegStarters();
			break;
		default:
			System.err.println("Please Select Valid Option");
			southIndianNonVegStarters();
		}
		}
		public void northIndianNonVegStarters()
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Press 1 for Hariyali Chicken");
			System.out.println("Press 2 for Tandoori Chicken");
			System.out.println("Press 3 for Tandoori Fish");
			System.out.println("Press 4 for Tandoori Shrimp");
			System.out.println("Press 5 for Lamb Tikka");
			System.out.println("Press 6 for Lamb Pepper Fry");
			System.out.println("Press 7 for Egg Pepper Fry");
			System.out.println("Press 8 for Fish Tikka");
			System.out.println("Press 9 to go back");
			int n = sc.nextInt();
			switch (n) {
			case 1:
				System.out.println("Price of  Hariyali Chicken is Rs 120");
				System.out.println("Choose Y to order or N to go back");
				char ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					a.add("Hariyali Chicken,120");
					totalBill = totalBill + 120;
					System.out.println(" ");
					System.out.println("Do you want to order more?");
					System.out.println(" ");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						northIndianNonVegStarters();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					northIndianNonVegStarters();
				} else {
					System.err.println("Please choose correct option");
					northIndianNonVegStarters();
				}
				break;
			case 2:
				System.out.println("Price of Tandoori Chicken is Rs 150");
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					a.add("Tandoori Chicken,150");
					totalBill = totalBill + 150;
					System.out.println(" ");
					System.out.println("Do you want to order more?");
					System.out.println(" ");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						northIndianNonVegStarters();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					northIndianNonVegStarters();
				} else {
					System.err.println("Please choose correct option");
					northIndianNonVegStarters();
				}
				break;
			case 3:
				System.out.println("Price of Tandoori Fish is Rs 200");
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					a.add("Tandoori Fish,200");
					totalBill = totalBill + 200;
					System.out.println(" ");
					System.out.println("Do you want to order more?");
					System.out.println(" ");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						northIndianNonVegStarters();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
					
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					northIndianNonVegStarters();
				} else {
					System.err.println("Please choose correct option");
					northIndianNonVegStarters();
				}
				break;
			case 4:
				System.out.println("Price of Tandoori Shrimp is Rs 220");
				System.out.println("Choose Y to order or N to go back");
				char h = sc.next().charAt(0);
				if (h == 'y' || h == 'Y') {
					System.out.println("Order has been confirmed");
					a.add("Tandoori Shrimp,220");
					totalBill = totalBill + 220;
					System.out.println(" ");
					System.out.println("Do you want to order more?");
					System.out.println(" ");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						northIndianNonVegStarters();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
					
						break;
					}
				} else if (h == 'n' || h == 'N') {
					System.out.println("Choose another item");
					northIndianNonVegStarters();
				} else {
					System.err.println("Please choose correct option");
					northIndianNonVegStarters();
				}
				break;
			case 5:
				System.out.println("Price of Lamb Tikka is Rs 260");
				System.out.println("Choose Y to order or N to go back");
				char c = sc.next().charAt(0);
				if (c == 'y' || c == 'Y') {
					System.out.println("Order has been confirmed");
					a.add("Lamb Tikka,260");
					totalBill = totalBill + 260;
					System.out.println(" ");
					System.out.println("Do you want to order more?");
					System.out.println(" ");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						northIndianNonVegStarters();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
					
						break;
					}
				} else if (c == 'n' || c == 'N') {
					System.out.println("Choose another item");
					northIndianNonVegStarters();
				} else {
					System.err.println("Please choose correct option");
					northIndianNonVegStarters();
				}
				break;
			case 6:
				System.out.println("Price of Lamb Pepper Fry is Rs 200");
				System.out.println("Choose Y to order or N to go back");
				char l = sc.next().charAt(0);
				if (l == 'y' || l == 'Y') {
					System.out.println("Order has been confirmed");
					a.add("Lamb Pepper Fry,200");
					totalBill = totalBill + 200;
					System.out.println(" ");
					System.out.println("Do you want to order more?");
					System.out.println(" ");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						northIndianNonVegStarters();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						
						break;
					}
				} else if (l == 'n' || l == 'N') {
					System.out.println("Choose another item");
					northIndianNonVegStarters();
				} else {
					System.err.println("Please choose correct option");
					northIndianNonVegStarters();
				}
				break;
			case 7:
				System.out.println("Price of Egg Pepper Fry is Rs 130");
				System.out.println("Choose Y to order or N to go back");
				char b = sc.next().charAt(0);
				if (b == 'y' || b == 'Y') {
					System.out.println("Order has been confirmed");
					a.add("Egg Pepper Fry,130");
					totalBill = totalBill + 130;
					System.out.println(" ");
					System.out.println("Do you want to order more?");
					System.out.println(" ");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						northIndianNonVegStarters();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						
						break;
					}
				} else if (b == 'n' || b == 'N') {
					System.out.println("Choose another item");
					northIndianNonVegStarters();
				} else {
					System.err.println("Please choose correct option");
					northIndianNonVegStarters();
				}
				break;
			case 8:
				System.out.println("Price of Fish Tikka is Rs 160");
				System.out.println("Choose Y to order or N to go back");
				char d = sc.next().charAt(0);
				if (d == 'y' || d == 'Y') {
					System.out.println("Order has been confirmed");
					a.add("Fish Tikka,160");
					totalBill = totalBill + 160;
					System.out.println(" ");
					System.out.println("Do you want to order more?");
					System.out.println(" ");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						northIndianNonVegStarters();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						
						break;
					}
				} else if (d == 'n' || d == 'N') {
					System.out.println("Choose another item");
					northIndianNonVegStarters();
				} else {
					System.err.println("Please choose correct option");
					northIndianNonVegStarters();
				}
				break;

			case 9:
				nonVegStarters();
				break;
			default:
				System.err.println("Please Select Valid Option");
				northIndianNonVegStarters();
			}
			
		}
}
class Main_Course extends Menu {
	public void mainCourseMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Veg Main Course");
		System.out.println("Press 2 for Non-Veg Main Course");
		System.out.println("Press 3 to go back");
		int x = sc.nextInt();
		switch (x) {
		case 1:
			Veg_mainCourse mc = new Veg_mainCourse();
			mc.vegMainCourse();
			break;
		case 2:
			NonVeg_mainCourse nv = new NonVeg_mainCourse();
			nv.nonVegMainCourse();
			break;
		case 3:
			menu();
			break;
		default:
			System.err.println("Please Try Again!!!");
			mainCourseMenu();
			break;

		}
	}
}
class Veg_mainCourse extends Main_Course
{
	public void vegMainCourse()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Indian Main Course");
		System.out.println("Press 2 for Punjabi Main Course");
		System.out.println("press 3 for North Indian Main Course ");
		System.out.println("Press 4 for South Indian Main Course");
		System.out.println("Press 5 for Go Back");
		int n = sc.nextInt();
		switch (n) 
		{
		case 1:
			indianMainCourse();
			break;
		case 2:
			punjabiMainCourse();
			break;
		case 3:
			northIndianMainCourse();
			break;
		case 4:
			southIndianMainCourse();
			break;
		case 5:
			mainCourseMenu();
			break;
			default:
				System.err.println("Please Try Again");
				vegMainCourse();
				break;
		}
	}
	public void indianMainCourse() 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Paneer Butter Masala");
		System.out.println("Press 2 for Tadka Aloo");
		System.out.println("Press 3 for Subz Miloni");
		System.out.println("Press 4 for Dal Makhani");
		System.out.println("Press 5 for Methi Papad Ki Sabzi");
		System.out.println("Press 6 for Gobi Manchurian");
		System.out.println("Press 7 for Veg Dum Biryani");
		System.out.println("Press 8 for Steamed Rice");
		System.out.println("Press 9 to go back");
		int n = sc.nextInt();
		switch (n) 
		{
		case 1:
			System.out.println("Price of  Paneer Butter Masala is Rs 120");
			System.out.println("Choose Y to order or N to go back");
			char ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') 
			{
				System.out.println("Order has been confirmed");
				a.add("Paneer Butter Masala,120");
				totalBill = totalBill + 120;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n)
				{
				case 1:
					indianMainCourse();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} 
			else if (ch == 'n' || ch == 'N')
			{
				System.out.println("Choose another item");
				indianMainCourse();
			} 
			else 
			{
				System.err.println("Please choose correct option");
				indianMainCourse();
			}
			break;
		case 2:
			System.out.println("Price of Tadka Aloo is Rs 150");
			System.out.println("Choose Y to order or N to go back");
			ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') 
			{
				System.out.println("Order has been confirmed");
				a.add("Tadka Aloo,150");
				totalBill = totalBill + 150;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) 
				{
				case 1:
					indianMainCourse();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} 
			else if (ch == 'n' || ch == 'N')
			{
				System.out.println("Choose another item");
				indianMainCourse();
			} 
			else
			{
				System.err.println("Please choose correct option");
				indianMainCourse();
			}
			break;
		case 3:
			System.out.println("Price of Subz Miloni is Rs 200");
			System.out.println("Choose Y to order or N to go back");
			ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Subz Miloni,200");
				totalBill = totalBill + 200;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					indianMainCourse();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
					
					break;
				}
			} else if (ch == 'n' || ch == 'N') {
				System.out.println("Choose another item");
				indianMainCourse();
			} else {
				System.err.println("Please choose correct option");
				indianMainCourse();
			}
			break;
		case 4:
			System.out.println("Price of Dal Makhani is Rs 220");
			System.out.println("Choose Y to order or N to go back");
			char h = sc.next().charAt(0);
			if (h == 'y' || h == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Dal Makhani,220");
				totalBill = totalBill + 220;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					indianMainCourse();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (h == 'n' || h == 'N') {
				System.out.println("Choose another item");
				indianMainCourse();
			} else {
				System.err.println("Please choose correct option");
				indianMainCourse();
			}
			break;
		case 5:
			System.out.println("Price of Methi Papad Ki Sabzi is Rs 260");
			System.out.println("Choose Y to order or N to go back");
			char c = sc.next().charAt(0);
			if (c == 'y' || c == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Methi Papad Ki Sabzi,260");
				totalBill = totalBill + 260;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					indianMainCourse();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (c == 'n' || c == 'N') {
				System.out.println("Choose another item");
				indianMainCourse();
			} else {
				System.err.println("Please choose correct option");
				indianMainCourse();
			}
			break;
		case 6:
			System.out.println("Price of Gobi Manchurian is Rs 200");
			System.out.println("Choose Y to order or N to go back");
			char k = sc.next().charAt(0);
			if (k == 'y' || k == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Gobi Manchurian,200");
				totalBill = totalBill + 200;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					indianMainCourse();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (k == 'n' || k == 'N') {
				System.out.println("Choose another item");
				indianMainCourse();
			} else {
				System.err.println("Please choose correct option");
				indianMainCourse();
			}
			break;
		case 7:
			System.out.println("Price of Veg Dum Biryani is Rs 130");
			System.out.println("Choose Y to order or N to go back");
			char b = sc.next().charAt(0);
			if (b == 'y' || b == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Veg Dum Biryani,130");
				totalBill = totalBill + 130;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					indianMainCourse();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (b == 'n' || b == 'N') {
				System.out.println("Choose another item");
				indianMainCourse();
			} else {
				System.err.println("Please choose correct option");
				indianMainCourse();
			}
			break;
		case 8:
			System.out.println("Price of Steamed Rice is Rs 160");
			System.out.println("Choose Y to order or N to go back");
			char d = sc.next().charAt(0);
			if (d == 'y' || d == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Steamed Rice,160");
				totalBill = totalBill + 160;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					indianMainCourse();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (d == 'n' || d == 'N') {
				System.out.println("Choose another item");
				indianMainCourse();
			} else {
				System.err.println("Please choose correct option");
				indianMainCourse();
			}
			break;

		case 9:
			vegMainCourse();
			break;
		default:
			System.err.println("Please Select Valid Option");
			indianMainCourse();
		}
	}
	public void punjabiMainCourse( ) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Sarson Da Saag");
		System.out.println("Press 2 for Aloo Jeera");
		System.out.println("Press 3 for Chole Bhature");
		System.out.println("Press 4 for Aloo Gobi");
		System.out.println("Press 5 for Paneer Butter Masala");
		System.out.println("Press 6 for Baingan Bharta");
		System.out.println("Press 7 for Rajma");
		System.out.println("Press 8 for Gobi Masala");
		System.out.println("Press 9 to go back");
		int n = sc.nextInt();
		switch (n) 
		{
		case 1:
			System.out.println("Price of Sarson Da Saag is Rs 120");
			System.out.println(" ");
			System.out.println("Choose Y to order or N to go back");
			char ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') 
			{
				System.out.println("Order has been confirmed");
				a.add("Sarson Da Saag,120");
				totalBill = totalBill + 120;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n)
				{
				case 1:
					punjabiMainCourse();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} 
			else if (ch == 'n' || ch == 'N')
			{
				System.out.println("Choose another item");
				punjabiMainCourse();
			} 
			else 
			{
				System.err.println("Please choose correct option");
				punjabiMainCourse();
			}
			break;
		case 2:
			System.out.println("Price of Aloo Jeera is Rs 150");
			System.out.println(" ");
			System.out.println("Choose Y to order or N to go back");
			ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') 
			{
				System.out.println("Order has been confirmed");
				a.add("Aloo Jeera,150");
				totalBill = totalBill + 150;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) 
				{
				case 1:
					punjabiMainCourse();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} 
			else if (ch == 'n' || ch == 'N')
			{
				System.out.println("Choose another item");
				punjabiMainCourse();
			} 
			else
			{
				System.err.println("Please choose correct option");
				punjabiMainCourse();
			}
			break;
		case 3:
			System.out.println("Price of Chole Bhature is Rs 200");
			System.out.println(" ");
			System.out.println("Choose Y to order or N to go back");
			ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Chole Bhature,200");
				totalBill = totalBill + 200;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					punjabiMainCourse();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (ch == 'n' || ch == 'N') {
				System.out.println("Choose another item");
				punjabiMainCourse();
			} else {
				System.err.println("Please choose correct option");
				punjabiMainCourse();
			}
			break;
		case 4:
			System.out.println("Price of Aloo Gobi is Rs 220");
			System.out.println(" ");
			System.out.println("Choose Y to order or N to go back");
			char h = sc.next().charAt(0);
			if (h == 'y' || h == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Aloo Gobi,220");
				totalBill = totalBill + 220;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					punjabiMainCourse();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (h == 'n' || h == 'N') {
				System.out.println("Choose another item");
				punjabiMainCourse();
			} else {
				System.err.println("Please choose correct option");
				punjabiMainCourse();
			}
			break;
		case 5:
			System.out.println("Price of Paneer Butter Masala is Rs 260");
			System.out.println(" ");
			System.out.println("Choose Y to order or N to go back");
			char c = sc.next().charAt(0);
			if (c == 'y' || c == 'Y') 
			{
				System.out.println("Order has been confirmed");
				a.add("Paneer Butter Masala,260");
				totalBill = totalBill + 260;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) 
				{
				case 1:
					punjabiMainCourse();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} 
			else if (c == 'n' || c == 'N') 
			{
				System.out.println("Choose another item");
				punjabiMainCourse();
			} 
			else 
			{
				System.err.println("Please choose correct option");
				punjabiMainCourse();
			}
			break;
		case 6:
			System.out.println("Price of Baingan Bharta is Rs 200");
			System.out.println(" ");
			System.out.println("Choose Y to order or N to go back");
			char g = sc.next().charAt(0);
			if (g == 'y' || g == 'Y')
			{
				System.out.println("Order has been confirmed");
				a.add("Baingan Bharta,200");
				totalBill = totalBill + 200;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n)
				{
				case 1:
					punjabiMainCourse();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
					
					break;
				}
			} 
			else if (g == 'n' || g == 'N')
			{
				System.out.println("Choose another item");
				punjabiMainCourse();
			} 
			else
			{
				System.err.println("Please choose correct option");
				punjabiMainCourse();
			}
			break;
		case 7:
			System.out.println("Price of Rajma is Rs 130");
			System.out.println(" ");
			System.out.println("Choose Y to order or N to go back");
			char b = sc.next().charAt(0);
			if (b == 'y' || b == 'Y') 
			{
				System.out.println("Order has been confirmed");
				a.add("Rajma,130");
				totalBill = totalBill + 130;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n)
				{
				case 1:
					punjabiMainCourse();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
			
					break;
				}
			} 
			else if (b == 'n' || b == 'N')
			{
				System.out.println("Choose another item");
				punjabiMainCourse();
			} 
			else 
			{
				System.err.println("Please choose correct option");
				punjabiMainCourse();
			}
			break;
		case 8:
			System.out.println("Price of Gobi Masala is Rs 160");
			System.out.println(" ");
			System.out.println("Choose Y to order or N to go back");
			char d = sc.next().charAt(0);
			if (d == 'y' || d == 'Y') 
			{
				System.out.println("Order has been confirmed");
				a.add("Gobi Masala,160");
				totalBill = totalBill + 160;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) 
				{
				case 1:
					punjabiMainCourse();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} 
			else if (d == 'n' || d == 'N')
			{
				System.out.println("Choose another item");
				punjabiMainCourse();
			}
			else 
			{
				System.err.println("Please choose correct option");
				punjabiMainCourse();
			}
			break;

		case 9:
			vegMainCourse();
			break;
		default:
			System.err.println("Please Select Valid Option");
			punjabiMainCourse();
	}
		
	}
	public void northIndianMainCourse()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Chana Masala");
		System.out.println("Press 2 for Vegetable Biryani");
		System.out.println("Press 3 for Dum Aloo");
		System.out.println("Press 4 for Meethi Mutter Malai");
		System.out.println("Press 5 for Tandoori Roti & Naan");
		System.out.println("Press 6 for Malai Kofta");
		System.out.println("Press 7 for Malai Chaap");
		System.out.println("Press 8 for Paneer Makhmali");
		System.out.println("Press 9 to go back");
		int n = sc.nextInt();
		switch (n) 
		{
		case 1:
			System.out.println("Price of Chana Masala is Rs 120");
			System.out.println(" ");
			System.out.println("Choose Y to order or N to go back");
			char ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') 
			{
				System.out.println("Order has been confirmed");
				a.add("Chana Masala,120");
				totalBill = totalBill + 120;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n)
				{
				case 1:
					northIndianMainCourse();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} 
			else if (ch == 'n' || ch == 'N')
			{
				System.out.println("Choose another item");
				northIndianMainCourse();
			} 
			else 
			{
				System.err.println("Please choose correct option");
				northIndianMainCourse();
			}
			break;
		case 2:
			System.out.println("Price of Vegetable Biryani is Rs 150");
			System.out.println(" ");
			System.out.println("Choose Y to order or N to go back");
			ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') 
			{
				System.out.println("Order has been confirmed");
				a.add("Vegetable Biryani,150");
				totalBill = totalBill + 150;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) 
				{
				case 1:
					northIndianMainCourse();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
					
					break;
				}
			} 
			else if (ch == 'n' || ch == 'N')
			{
				System.out.println("Choose another item");
				northIndianMainCourse();
			} 
			else
			{
				System.err.println("Please choose correct option");
				northIndianMainCourse();
			}
			break;
		case 3:
			System.out.println("Price of Dum Aloo is Rs 200");
			System.out.println(" ");
			System.out.println("Choose Y to order or N to go back");
			ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Dum Aloo,200");
				totalBill = totalBill + 200;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					northIndianMainCourse();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
					
					break;
				}
			} else if (ch == 'n' || ch == 'N') {
				System.out.println("Choose another item");
				northIndianMainCourse();
			} else {
				System.err.println("Please choose correct option");
				northIndianMainCourse();
			}
			break;
		case 4:
			System.out.println("Price of Meethi Mutter Malai is Rs 220");
			System.out.println(" ");
			System.out.println("Choose Y to order or N to go back");
			char h = sc.next().charAt(0);
			if (h == 'y' || h == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Meethi Mutter Malai,220");
				totalBill = totalBill + 220;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					northIndianMainCourse();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
					
					break;
				}
			} else if (h == 'n' || h == 'N') {
				System.out.println("Choose another item");
				northIndianMainCourse();
			} else {
				System.err.println("Please choose correct option");
				northIndianMainCourse();
			}
			break;
		case 5:
			System.out.println("Price of Tandoori Roti & Naan is Rs 260");
			System.out.println(" ");
			System.out.println("Choose Y to order or N to go back");
			char c = sc.next().charAt(0);
			if (c == 'y' || c == 'Y') 
			{
				System.out.println("Order has been confirmed");
				a.add("Tandoori Roti & Naan,260");
				totalBill = totalBill + 260;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) 
				{
				case 1:
					northIndianMainCourse();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} 
			else if (c == 'n' || c == 'N') 
			{
				northIndianMainCourse();
			} 
			else 
			{
				System.err.println("Please choose correct option");
				northIndianMainCourse();
			}
			break;
		case 6:
			System.out.println("Price of Malai Kofta is Rs 200");
			System.out.println(" ");
			System.out.println("Choose Y to order or N to go back");
			char p = sc.next().charAt(0);
			if (p == 'y' || p == 'Y')
			{
				System.out.println("Order has been confirmed");
				a.add("Malai Kofta,200");
				totalBill = totalBill + 200;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n)
				{
				case 1:
					northIndianMainCourse();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
					
					break;
				}
			} 
			else if (p == 'n' || p == 'N')
			{
				System.out.println("Choose another item");
				northIndianMainCourse();
			} 
			else
			{
				System.err.println("Please choose correct option");
				northIndianMainCourse();
			}
			break;
		case 7:
			System.out.println("Price of Malai Chaap is Rs 130");
			System.out.println(" ");
			System.out.println("Choose Y to order or N to go back");
			char b = sc.next().charAt(0);
			if (b == 'y' || b == 'Y') 
			{
				System.out.println("Order has been confirmed");
				a.add("Malai Chaap,130");
				totalBill = totalBill + 130;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n)
				{
				case 1:
					northIndianMainCourse();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
			
					break;
				}
			} 
			else if (b == 'n' || b == 'N')
			{
				System.out.println("Choose another item");
				northIndianMainCourse();
			} 
			else 
			{
				System.err.println("Please choose correct option");
				northIndianMainCourse();
			}
			break;
		case 8:
			System.out.println("Price of Paneer Makhmali is Rs 160");
			System.out.println(" ");
			System.out.println("Choose Y to order or N to go back");
			char d = sc.next().charAt(0);
			if (d == 'y' || d == 'Y') 
			{
				System.out.println("Order has been confirmed");
				a.add("Paneer Makhmali,160");
				totalBill = totalBill + 160;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) 
				{
				case 1:
					northIndianMainCourse();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
					
					break;
				}
			} 
			else if (d == 'n' || d == 'N')
			{
				System.out.println("Choose another item");
				northIndianMainCourse();
			}
			else 
			{
				System.err.println("Please choose correct option");
				northIndianMainCourse();
			}
			break;

		case 9:
			vegMainCourse();
			break;
		default:
			System.err.println("Please Select Valid Option");
			northIndianMainCourse();	
	}
	}
		public void southIndianMainCourse()
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Press 1 for Vegetable Korma");
			System.out.println("Press 2 for Avial");
			System.out.println("Press 3 for Cabbage Thoran");
			System.out.println("Press 4 for Puliyodarai");
			System.out.println("Press 5 for Coconut Rice");
			System.out.println("Press 6 for Lemon Rice");
			System.out.println("Press 7 for Karuveppilai Kuzhambu");
			System.out.println("Press 8 for Mor Kuzhambu");
			System.out.println("Press 9 for Vangi Bath");
			System.out.println("Press 0 to go back");
			int n = sc.nextInt();
			switch (n) 
			{
			case 1:
				System.out.println("Price of Vegetable Korma is Rs 120");
				System.out.println(" ");
				System.out.println("Choose Y to order or N to go back");
				char ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') 
				{
					System.out.println("Order has been confirmed");
					a.add("Vegetable Korma,120");
					totalBill = totalBill + 120;
					System.out.println(" ");
					System.out.println("Do you want to order more?");
					System.out.println(" ");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n)
					{
					case 1:
						southIndianMainCourse();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
					
						break;
					}
				} 
				else if (ch == 'n' || ch == 'N')
				{
					System.out.println("Choose another item");
					southIndianMainCourse();
				} 
				else 
				{
					System.err.println("Please choose correct option");
					southIndianMainCourse();
				}
				break;
			case 2:
				System.out.println("Price of Avial is Rs 150");
				System.out.println(" ");
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') 
				{
					System.out.println("Order has been confirmed");
					a.add("Avial,150");
					totalBill = totalBill + 150;
					System.out.println(" ");
					System.out.println("Do you want to order more?");
					System.out.println(" ");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) 
					{
					case 1:
						southIndianMainCourse();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
					
						break;
					}
				} 
				else if (ch == 'n' || ch == 'N')
				{
					System.out.println("Choose another item");
					southIndianMainCourse();
				} 
				else
				{
					System.err.println("Please choose correct option");
					southIndianMainCourse();
				}
				break;
			case 3:
				System.out.println("Price of Cabbage Thoran is Rs 200");
				System.out.println(" ");
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					a.add("Cabbage Thoran,200");
					totalBill = totalBill + 200;
					System.out.println(" ");
					System.out.println("Do you want to order more?");
					System.out.println(" ");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						southIndianMainCourse();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
					
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					southIndianMainCourse();
				} else {
					System.err.println("Please choose correct option");
					southIndianMainCourse();
				}
				break;
			case 4:
				System.out.println("Price of Puliyodarai is Rs 220");
				System.out.println(" ");
				System.out.println("Choose Y to order or N to go back");
				char h = sc.next().charAt(0);
				if (h == 'y' || h == 'Y') {
					System.out.println("Order has been confirmed");
					a.add("Puliyodarai,220");
					totalBill = totalBill + 220;
					System.out.println(" ");
					System.out.println("Do you want to order more?");
					System.out.println(" ");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						southIndianMainCourse();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
					
						break;
					}
				} else if (h == 'n' || h == 'N') {
					System.out.println("Choose another item");
					southIndianMainCourse();
				} else {
					System.err.println("Please choose correct option");
					southIndianMainCourse();
				}
				break;
			case 5:
				System.out.println("Price of Coconut Rice is Rs 260");
				System.out.println(" ");
				System.out.println("Choose Y to order or N to go back");
				char c = sc.next().charAt(0);
				if (c == 'y' || c == 'Y') 
				{
					System.out.println("Order has been confirmed");
					a.add("Coconut Rice,260");
					totalBill = totalBill + 260;
					System.out.println(" ");
					System.out.println("Do you want to order more?");
					System.out.println(" ");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) 
					{
					case 1:
					    southIndianMainCourse();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
					
						break;
					}
				} 
				else if (c == 'n' || c == 'N') 
				{
					southIndianMainCourse();
				} 
				else 
				{
					System.err.println("Please choose correct option");
					southIndianMainCourse();
				}
				break;
			case 6:
				System.out.println("Price of Lemon Rice is Rs 200");
				System.out.println(" ");
				System.out.println("Choose Y to order or N to go back");
				char o = sc.next().charAt(0);
				if (o == 'y' || o == 'Y')
				{
					System.out.println("Order has been confirmed");
					a.add("Lemon Rice,200");
					totalBill = totalBill + 200;
					System.out.println(" ");
					System.out.println("Do you want to order more?");
					System.out.println(" ");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n)
					{
					case 1:
						southIndianMainCourse();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
					
						break;
					}
				} 
				else if (o == 'n' || o == 'N')
				{
					System.out.println("Choose another item");
					southIndianMainCourse();
				} 
				else
				{
					System.err.println("Please choose correct option");
					southIndianMainCourse();
				}
				break;
			case 7:
				System.out.println("Price of Karuveppilai Kuzhambu is Rs 130");
				System.out.println(" ");
				System.out.println("Choose Y to order or N to go back");
				char b = sc.next().charAt(0);
				if (b == 'y' || b == 'Y') 
				{
					System.out.println("Order has been confirmed");
					a.add("Karuveppilai Kuzhambu,130");
					totalBill = totalBill + 130;
					System.out.println(" ");
					System.out.println("Do you want to order more?");
					System.out.println(" ");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n)
					{
					case 1:
						southIndianMainCourse();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
					
						break;
					}
				} 
				else if (b == 'n' || b == 'N')
				{
					System.out.println("Choose another item");
					southIndianMainCourse();
				} 
				else 
				{
					System.err.println("Please choose correct option");
					southIndianMainCourse();
				}
				break;
			case 8:
				System.out.println("Price of Mor Kuzhambu is Rs 160");
				System.out.println(" ");
				System.out.println("Choose Y to order or N to go back");
				char d = sc.next().charAt(0);
				if (d == 'y' || d == 'Y') 
				{
					System.out.println("Order has been confirmed");
					a.add("Mor Kuzhambu,160");
					totalBill = totalBill + 160;
					System.out.println(" ");
					System.out.println("Do you want to order more?");
					System.out.println(" ");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) 
					{
					case 1:
						southIndianMainCourse();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
					
						break;
					}
				} 
				else if (d == 'n' || d == 'N')
				{
					System.out.println("Choose another item");
					southIndianMainCourse();
				}
				else 
				{
					System.err.println("Please choose correct option");
					southIndianMainCourse();
				}
				break;
			case 9:
				System.out.println("Price of Vangi Bath is Rs 160");
				System.out.println(" ");
				System.out.println("Choose Y to order or N to go back");
				char e = sc.next().charAt(0);
				if (e == 'y' || e == 'Y') 
				{
					System.out.println("Order has been confirmed");
					a.add("Vangi Bath,160");
					totalBill = totalBill + 160;
					System.out.println(" ");
					System.out.println("Do you want to order more?");
					System.out.println(" ");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) 
					{
					case 1:
						southIndianMainCourse();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
				
						break;
					}
				} 
				else if (e == 'n' || e == 'N')
				{
					System.out.println("Choose another item");
					southIndianMainCourse();
				}
				else 
				{
					System.err.println("Please choose correct option");
					southIndianMainCourse();
				}
			case 0:
				vegMainCourse();
				break;
			default:
				System.err.println("Please Select Valid Option");
				southIndianMainCourse();	
		}
		
}
}
class NonVeg_mainCourse extends Main_Course
{
	public void nonVegMainCourse()
	{
    	Scanner sc = new Scanner(System.in);
				System.out.println("Press 1 for Indian Non-Veg Main Course");
				System.out.println("Press 2 for Punjabi Non-Veg Main Course");
				System.out.println("press 3 for North Indian Non-Veg Main Course ");
				System.out.println("Press 4 for South Indian Non-Veg Main Course");
				System.out.println("Press 5 for Go Back");
				int n = sc.nextInt();
				switch (n) 
				{
				case 1:
					indianNonVegMainCourse();
					break;
				case 2:
					punjabiNonVegMainCourse();
					break;
				case 3:
					northIndianNonVegMainCourse();
					break;
				case 4:
					southIndianNonVegMainCourse();
					break;
				case 5:
					mainCourseMenu();
					break;
					default:
						System.err.println("Please Try Again");
						nonVegMainCourse();
						break;
				}
			
			}
	 public void indianNonVegMainCourse()
	 {
		 Scanner sc = new Scanner(System.in);
			System.out.println("Press 1 for Shirmp Pakora");
			System.out.println("Press 2 for Chicken Pulao");
			System.out.println("Press 3 for Indian Grill Fish");
			System.out.println("Press 4 for Chicken Nuggets");
			System.out.println("Press 5 for Shami Kabab");
			System.out.println("Press 6 for Reshmi Kabab");
			System.out.println("Press 7 for Mutton Curry");
			System.out.println("Press 8 for Fish Tikka Masala");
			System.out.println("Press 9 to go back");
			int n = sc.nextInt();
			switch (n) 
			{
			case 1:
				System.out.println("Price of Shirmp Pakora is Rs 120");
				System.out.println("Choose Y to order or N to go back");
				char ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') 
				{
					System.out.println("Order has been confirmed");
					a.add("Shirmp Pakora,120");
					totalBill = totalBill + 120;
					System.out.println(" ");
					System.out.println("Do you want to order more?");
					System.out.println(" ");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n)
					{
					case 1:
						indianNonVegMainCourse();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						
						break;
					}
				} 
				else if (ch == 'n' || ch == 'N')
				{
					System.out.println("Choose another item");
					indianNonVegMainCourse();
				} 
				else 
				{
					System.err.println("Please choose correct option");
					indianNonVegMainCourse();
				}
				break;
			case 2:
				System.out.println("Price of Chicken Pulao is Rs 150");
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') 
				{
					System.out.println("Order has been confirmed");
					a.add("Chicken Pulao,150");
					totalBill = totalBill + 150;
					System.out.println(" ");
					System.out.println("Do you want to order more?");
					System.out.println(" ");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) 
					{
					case 1:
						indianNonVegMainCourse();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
					
						break;
					}
				} 
				else if (ch == 'n' || ch == 'N')
				{
					System.out.println("Choose another item");
					indianNonVegMainCourse();
				} 
				else
				{
					System.err.println("Please choose correct option");
					indianNonVegMainCourse();
				}
				break;
			case 3:
				System.out.println("Price of Indian Grill Fish is Rs 200");
				System.out.println("Choose Y to order or N to go back");
				ch = sc.next().charAt(0);
				if (ch == 'y' || ch == 'Y') {
					System.out.println("Order has been confirmed");
					a.add("Indian Grill Fish,200");
					totalBill = totalBill + 200;
					System.out.println(" ");
					System.out.println("Do you want to order more?");
					System.out.println(" ");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						indianNonVegMainCourse();
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						
						break;
					}
				} else if (ch == 'n' || ch == 'N') {
					System.out.println("Choose another item");
					indianNonVegMainCourse();
				} else {
					System.err.println("Please choose correct option");
					indianNonVegMainCourse();
				}
				break;
			case 4:
				System.out.println("Price of Chicken Nuggets is Rs 220");
				System.out.println("Choose Y to order or N to go back");
				char h = sc.next().charAt(0);
				if (h == 'y' || h == 'Y') {
					System.out.println("Order has been confirmed");
					a.add("Chicken Nuggets,220");
					totalBill = totalBill + 220;
					System.out.println(" ");
					System.out.println("Do you want to order more?");
					System.out.println(" ");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						indianNonVegMainCourse();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
					
						break;
					}
				} else if (h == 'n' || h == 'N') {
					System.out.println("Choose another item");
					indianNonVegMainCourse();
				} else {
					System.err.println("Please choose correct option");
					indianNonVegMainCourse();
				}
				break;
			case 5:
				System.out.println("Price of Shami Kabab is Rs 260");
				System.out.println("Choose Y to order or N to go back");
				char c = sc.next().charAt(0);
				if (c == 'y' || c == 'Y') {
					System.out.println("Order has been confirmed");
					a.add("Shami Kabab,260");
					totalBill = totalBill + 260;
					System.out.println(" ");
					System.out.println("Do you want to order more?");
					System.out.println(" ");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						indianNonVegMainCourse();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						
						break;
					}
				} else if (c == 'n' || c == 'N') {
					System.out.println("Choose another item");
					indianNonVegMainCourse();
				} else {
					System.err.println("Please choose correct option");
					indianNonVegMainCourse();
				}
				break;
			case 6:
				System.out.println("Price of Reshmi Kabab is Rs 200");
				System.out.println("Choose Y to order or N to go back");
				char x = sc.next().charAt(0);
				if (x == 'y' || x == 'Y') {
					System.out.println("Order has been confirmed");
					a.add("Reshmi Kabab,200");
					totalBill = totalBill + 200;
					System.out.println(" ");
					System.out.println("Do you want to order more?");
					System.out.println(" ");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						indianNonVegMainCourse();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
					
						break;
					}
				} else if (x == 'n' || x == 'N') {
					System.out.println("Choose another item");
					indianNonVegMainCourse();
				} else {
					System.err.println("Please choose correct option");
					indianNonVegMainCourse();
				}
				break;
			case 7:
				System.out.println("Price of Mutton Curry is Rs 130");
				System.out.println("Choose Y to order or N to go back");
				char b = sc.next().charAt(0);
				if (b == 'y' || b == 'Y') {
					System.out.println("Order has been confirmed");
					a.add("Mutton Curry,130");
					totalBill = totalBill + 130;
					System.out.println(" ");
					System.out.println("Do you want to order more?");
					System.out.println(" ");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						indianNonVegMainCourse();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
						
						break;
					}
				} else if (b == 'n' || b == 'N') {
					System.out.println("Choose another item");
					indianNonVegMainCourse();
				} else {
					System.err.println("Please choose correct option");
					indianNonVegMainCourse();
				}
				break;
			case 8:
				System.out.println("Price of Fish Tikka Masala is Rs 160");
				System.out.println("Choose Y to order or N to go back");
				char d = sc.next().charAt(0);
				if (d == 'y' || d == 'Y') {
					System.out.println("Order has been confirmed");
					a.add("Fish Tikka Masala,160");
					totalBill = totalBill + 160;
					System.out.println(" ");
					System.out.println("Do you want to order more?");
					System.out.println(" ");
					System.out.println("Press 1 to order from same");
					System.out.println("Press 2 to go for Main Menu");
					System.out.println("Press 3 to proceed for bill");
					n = sc.nextInt();
					switch (n) {
					case 1:
						indianNonVegMainCourse();
						break;
					case 2:
						menu();
						break;
					case 3:
						System.out.println("Please pay the amount");
					
						break;
					}
				} else if (d == 'n' || d == 'N') {
					System.out.println("Choose another item");
					indianNonVegMainCourse();
				} else {
					System.err.println("Please choose correct option");
					indianNonVegMainCourse();
				}
				break;

			case 9:
				nonVegMainCourse();
				break;
			default:
				System.err.println("Please Select Valid Option");
				indianNonVegMainCourse(); 
	 }
	 }
			public void punjabiNonVegMainCourse()
			{
				Scanner sc = new Scanner(System.in);
				System.out.println("Press 1 for Rogan Josh");
				System.out.println("Press 2 for Kebab");
				System.out.println("Press 3 for Kunna Gosht");
				System.out.println("Press 4 for Kheema");
				System.out.println("Press 5 for Paya");
				System.out.println("Press 6 for Amritsari Fish");
				System.out.println("Press 7 for Zeera Murg");
				System.out.println("Press 8 for Amritsari Special Mutton");
				System.out.println("Press 9 to go back");
				int n = sc.nextInt();
				switch (n) 
				{
				case 1:
					System.out.println("Price of Rogan Josh is Rs 120");
					System.out.println("Choose Y to order or N to go back");
					char ch = sc.next().charAt(0);
					if (ch == 'y' || ch == 'Y') 
					{
						System.out.println("Order has been confirmed");
						a.add("Rogan Josh,120");
						totalBill = totalBill + 120;
						System.out.println(" ");
						System.out.println("Do you want to order more?");
						System.out.println(" ");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n)
						{
						case 1:
							punjabiNonVegMainCourse();
							break;
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
						
							break;
						}
					} 
					else if (ch == 'n' || ch == 'N')
					{
						System.out.println("Choose another item");
						punjabiNonVegMainCourse();
					} 
					else 
					{
						System.err.println("Please choose correct option");
						punjabiNonVegMainCourse();
					}
					break;
				case 2:
					System.out.println("Price of Kebab is Rs 150");
					System.out.println("Choose Y to order or N to go back");
					ch = sc.next().charAt(0);
					if (ch == 'y' || ch == 'Y') 
					{
						System.out.println("Order has been confirmed");
						a.add("Kebab,150");
						totalBill = totalBill + 150;
						System.out.println(" ");
						System.out.println("Do you want to order more?");
						System.out.println(" ");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) 
						{
						case 1:
							punjabiNonVegMainCourse();
							break;
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
						
							break;
						}
					} 
					else if (ch == 'n' || ch == 'N')
					{
						System.out.println("Choose another item");
						punjabiNonVegMainCourse();
					} 
					else
					{
						System.err.println("Please choose correct option");
						punjabiNonVegMainCourse();
					}
					break;
				case 3:
					System.out.println("Price of Kunna Gosht is Rs 200");
					System.out.println("Choose Y to order or N to go back");
					ch = sc.next().charAt(0);
					if (ch == 'y' || ch == 'Y') {
						System.out.println("Order has been confirmed");
						a.add("Kunna Gosht,200");
						totalBill = totalBill + 200;
						System.out.println(" ");
						System.out.println("Do you want to order more?");
						System.out.println(" ");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) {
						case 1:
							punjabiNonVegMainCourse();
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
						
							break;
						}
					} else if (ch == 'n' || ch == 'N') {
						System.out.println("Choose another item");
						punjabiNonVegMainCourse();
					} else {
						System.err.println("Please choose correct option");
						punjabiNonVegMainCourse();
					}
					break;
				case 4:
					System.out.println("Price of Kheema is Rs 220");
					System.out.println("Choose Y to order or N to go back");
					char h = sc.next().charAt(0);
					if (h == 'y' || h == 'Y') {
						System.out.println("Order has been confirmed");
						a.add("kheema,220");
						totalBill = totalBill + 220;
						System.out.println(" ");
						System.out.println("Do you want to order more?");
						System.out.println(" ");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) {
						case 1:
							punjabiNonVegMainCourse();
							break;
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
						
							break;
						}
					} else if (h == 'n' || h == 'N') {
						System.out.println("Choose another item");
						punjabiNonVegMainCourse();
					} else {
						System.err.println("Please choose correct option");
						punjabiNonVegMainCourse();
					}
					break;
				case 5:
					System.out.println("Price of Paya is Rs 260");
					System.out.println("Choose Y to order or N to go back");
					char c = sc.next().charAt(0);
					if (c == 'y' || c == 'Y') {
						System.out.println("Order has been confirmed");
						a.add("Paya,260");
						totalBill = totalBill + 260;
						System.out.println(" ");
						System.out.println("Do you want to order more?");
						System.out.println(" ");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) {
						case 1:
							punjabiNonVegMainCourse();
							break;
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
						
							break;
						}
					} else if (c == 'n' || c == 'N') {
						System.out.println("Choose another item");
						punjabiNonVegMainCourse();
					} else {
						System.err.println("Please choose correct option");
						punjabiNonVegMainCourse();
					}
					break;
				case 6:
					System.out.println("Price of Amritsari Fish is Rs 200");
					System.out.println("Choose Y to order or N to go back");
					char m = sc.next().charAt(0);
					if (m == 'y' || m == 'Y') {
						System.out.println("Order has been confirmed");
						a.add("Amritsari Fish,200");
						totalBill = totalBill + 200;
						System.out.println(" ");
						System.out.println("Do you want to order more?");
						System.out.println(" ");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) {
						case 1:
							punjabiNonVegMainCourse();
							break;
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
						
							break;
						}
					} else if (m == 'n' || m == 'N') {
						System.out.println("Choose another item");
						punjabiNonVegMainCourse();
					} else {
						System.err.println("Please choose correct option");
						punjabiNonVegMainCourse();
					}
					break;
				case 7:
					System.out.println("Price of Zeera Murg is Rs 130");
					System.out.println("Choose Y to order or N to go back");
					char b = sc.next().charAt(0);
					if (b == 'y' || b == 'Y') {
						System.out.println("Order has been confirmed");
						a.add("Zeera Murg,130");
						totalBill = totalBill + 130;
						System.out.println(" ");
						System.out.println("Do you want to order more?");
						System.out.println(" ");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) {
						case 1:
							punjabiNonVegMainCourse();
							break;
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
						
							break;
						}
					} else if (b == 'n' || b == 'N') {
						System.out.println("Choose another item");
						punjabiNonVegMainCourse();
					} else {
						System.err.println("Please choose correct option");
						punjabiNonVegMainCourse();
					}
					break;
				case 8:
					System.out.println("Price of Amritsari Special Mutton is Rs 160");
					System.out.println("Choose Y to order or N to go back");
					char d = sc.next().charAt(0);
					if (d == 'y' || d == 'Y') {
						System.out.println("Order has been confirmed");
						a.add("Amritsari Special Mutton,160");
						totalBill = totalBill + 160;
						System.out.println(" ");
						System.out.println("Do you want to order more?");
						System.out.println(" ");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) {
						case 1:
							punjabiNonVegMainCourse();
							break;
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
						
							break;
						}
					} else if (d == 'n' || d == 'N') {
						System.out.println("Choose another item");
						punjabiNonVegMainCourse();
					} else {
						System.err.println("Please choose correct option");
						punjabiNonVegMainCourse();
					}
					break;

				case 9:
					nonVegMainCourse();
					break;
				default:
					System.err.println("Please Select Valid Option");
					punjabiNonVegMainCourse(); 
			}
		}
			public void northIndianNonVegMainCourse() {
				Scanner sc = new Scanner(System.in);
				System.out.println("Press 1 for Galouti kebab");
				System.out.println("Press 2 for Yakhni Pulao");
				System.out.println("Press 3 for Mutton malai tikka");
				System.out.println("Press 4 for Fish malai tikka");
				System.out.println("Press 5 for Grilled Fish Fry");
				System.out.println("Press 6 for Grilled Mutton with Rasa");
				System.out.println("Press 7 for Butter Mutton");
				System.out.println("Press 8 for Chicken Gravy");
				System.out.println("Press 9 to go back");
				int n = sc.nextInt();
				switch (n) 
				{
				case 1:
					System.out.println("Price of Galouti kebab is Rs 120");
					System.out.println("Choose Y to order or N to go back");
					char ch = sc.next().charAt(0);
					if (ch == 'y' || ch == 'Y') 
					{
						System.out.println("Order has been confirmed");
						a.add("Galouti Kebab,120");
						totalBill = totalBill + 120;
						System.out.println(" ");
						System.out.println("Do you want to order more?");
						System.out.println(" ");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n)
						{
						case 1:
							northIndianNonVegMainCourse();
							break;
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
						
							break;
						}
					} 
					else if (ch == 'n' || ch == 'N')
					{
						System.out.println("Choose another item");
						northIndianNonVegMainCourse();
					} 
					else 
					{
						System.err.println("Please choose correct option");
						northIndianNonVegMainCourse();
					}
					break;
				case 2:
					System.out.println("Price of Yakhni Pulao is Rs 150");
					System.out.println("Choose Y to order or N to go back");
					ch = sc.next().charAt(0);
					if (ch == 'y' || ch == 'Y') 
					{
						System.out.println("Order has been confirmed");
						a.add("Yakhni Pulao,150");
						totalBill = totalBill + 150;
						System.out.println(" ");
						System.out.println("Do you want to order more?");
						System.out.println(" ");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) 
						{
						case 1:
							northIndianNonVegMainCourse();
							break;
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
							
							break;
						}
					} 
					else if (ch == 'n' || ch == 'N')
					{
						System.out.println("Choose another item");
						northIndianNonVegMainCourse();
					} 
					else
					{
						System.err.println("Please choose correct option");
						northIndianNonVegMainCourse();
					}
					break;
				case 3:
					System.out.println("Price of Mutton Malai Tikka is Rs 200");
					System.out.println("Choose Y to order or N to go back");
					ch = sc.next().charAt(0);
					if (ch == 'y' || ch == 'Y') {
						System.out.println("Order has been confirmed");
						a.add("Mutton Malai Tikka,200");
						totalBill = totalBill + 200;
						System.out.println(" ");
						System.out.println("Do you want to order more?");
						System.out.println(" ");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) {
						case 1:
							northIndianNonVegMainCourse();
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
					
							break;
						}
					} else if (ch == 'n' || ch == 'N') {
						System.out.println("Choose another item");
						northIndianNonVegMainCourse();
					} else {
						System.err.println("Please choose correct option");
						northIndianNonVegMainCourse();
					}
					break;
				case 4:
					System.out.println("Price of Fish Malai Tikka is Rs 220");
					System.out.println("Choose Y to order or N to go back");
					char h = sc.next().charAt(0);
					if (h == 'y' || h == 'Y') {
						System.out.println("Order has been confirmed");
						a.add("Fish Malai Tikka,220");
						totalBill = totalBill + 220;
						System.out.println(" ");
						System.out.println("Do you want to order more?");
						System.out.println(" ");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) {
						case 1:
							northIndianNonVegMainCourse();
							break;
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
						
							break;
						}
					} else if (h == 'n' || h == 'N') {
						System.out.println("Choose another item");
						northIndianNonVegMainCourse();
					} else {
						System.err.println("Please choose correct option");
						northIndianNonVegMainCourse();
					}
					break;
				case 5:
					System.out.println("Price of Grilled Fish Fry is Rs 260");
					System.out.println("Choose Y to order or N to go back");
					char c = sc.next().charAt(0);
					if (c == 'y' || c == 'Y') {
						System.out.println("Order has been confirmed");
						a.add("Grilled Fish Fry,260");
						totalBill = totalBill + 260;
						System.out.println(" ");
						System.out.println("Do you want to order more?");
						System.out.println(" ");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) {
						case 1:
							northIndianNonVegMainCourse();
							break;
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
						
							break;
						}
					} else if (c == 'n' || c == 'N') {
						System.out.println("Choose another item");
						northIndianNonVegMainCourse();
					} else {
						System.err.println("Please choose correct option");
						northIndianNonVegMainCourse();
					}
					break;
				case 6:
					System.out.println("Price of Grilled Mutton with Rasa is Rs 200");
					System.out.println("Choose Y to order or N to go back");
					char z = sc.next().charAt(0);
					if (z == 'y' || z == 'Y') {
						System.out.println("Order has been confirmed");
						a.add("Grilled Mutton with Rasa,200");
						totalBill = totalBill + 200;
						System.out.println(" ");
						System.out.println("Do you want to order more?");
						System.out.println(" ");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) {
						case 1:
							northIndianNonVegMainCourse();
							break;
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
							
							break;
						}
					} else if (z == 'n' || z == 'N') {
						System.out.println("Choose another item");
						northIndianNonVegMainCourse();
					} else {
						System.err.println("Please choose correct option");
						northIndianNonVegMainCourse();
					}
					break;
				case 7:
					System.out.println("Price of Butter Mutton is Rs 130");
					System.out.println("Choose Y to order or N to go back");
					char b = sc.next().charAt(0);
					if (b == 'y' || b == 'Y') {
						System.out.println("Order has been confirmed");
						a.add("Butter Masala,130");
						totalBill = totalBill + 130;
						System.out.println(" ");
						System.out.println("Do you want to order more?");
						System.out.println(" ");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) {
						case 1:
							northIndianNonVegMainCourse();
							break;
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
						
							break;
						}
					} else if (b == 'n' || b == 'N') {
						System.out.println("Choose another item");
						northIndianNonVegMainCourse();
					} else {
						System.err.println("Please choose correct option");
						northIndianNonVegMainCourse();
					}
					break;
				case 8:
					System.out.println("Price of Chicken Gravy is Rs 160");
					System.out.println("Choose Y to order or N to go back");
					char d = sc.next().charAt(0);
					if (d == 'y' || d == 'Y') {
						System.out.println("Order has been confirmed");
						a.add("Chicken Gravy,160");
						totalBill = totalBill + 160;
						System.out.println(" ");
						System.out.println("Do you want to order more?");
						System.out.println(" ");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) {
						case 1:
							northIndianNonVegMainCourse();
							break;
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
						
							break;
						}
					} else if (d == 'n' || d == 'N') {
						System.out.println("Choose another item");
						northIndianNonVegMainCourse();
					} else {
						System.err.println("Please choose correct option");
						northIndianNonVegMainCourse();
					}
					break;

				case 9:
					nonVegMainCourse();
					break;
				default:
					System.err.println("Please Select Valid Option");
					northIndianNonVegMainCourse(); 
			}
					
			}
			public void southIndianNonVegMainCourse()
			{
				Scanner sc = new Scanner(System.in);
				System.out.println("Press 1 for Bangdyache Hooman ");
				System.out.println("Press 2 for Kottayam Style Fish Curry");
				System.out.println("Press 3 for Chettinad Prawn Curry");
				System.out.println("Press 4 for Prawns Vindaloo");
				System.out.println("Press 5 for Fried Prawns & Curry ");
				System.out.println("Press 6 for Prawn Ghee Roast ");
				System.out.println("Press 7 for Spicy Chettinad Fish Fry");
				System.out.println("Press 8 for Mutton Kola Urundai ");
				System.out.println("Press 9 to go back");
				int n = sc.nextInt();
				switch (n) 
				{
				case 1:
					System.out.println("Price of Bangdyache Hooman is Rs 120");
					System.out.println("Choose Y to order or N to go back");
					char ch = sc.next().charAt(0);
					if (ch == 'y' || ch == 'Y') 
					{
						System.out.println("Order has been confirmed");
						a.add("Bangdyache Hooman,120");
						totalBill = totalBill + 120;
						System.out.println(" ");
						System.out.println("Do you want to order more?");
						System.out.println(" ");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n)
						{
						case 1:
							southIndianNonVegMainCourse();
							break;
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
						
							break;
						}
					} 
					else if (ch == 'n' || ch == 'N')
					{
						System.out.println("Choose another item");
						southIndianNonVegMainCourse();
					} 
					else 
					{
						System.err.println("Please choose correct option");
						southIndianNonVegMainCourse();
					}
					break;
				case 2:
					System.out.println("Price of Kottayam Style Fish Curry is Rs 150");
					System.out.println("Choose Y to order or N to go back");
					ch = sc.next().charAt(0);
					if (ch == 'y' || ch == 'Y') 
					{
						System.out.println("Order has been confirmed");
						a.add("Kottayam Style Fish Curry,150");
						totalBill = totalBill + 150;
						System.out.println(" ");
						System.out.println("Do you want to order more?");
						System.out.println(" ");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) 
						{
						case 1:
							southIndianNonVegMainCourse();
							break;
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
						
							break;
						}
					} 
					else if (ch == 'n' || ch == 'N')
					{
						System.out.println("Choose another item");
						southIndianNonVegMainCourse();
					} 
					else
					{
						System.err.println("Please choose correct option");
						southIndianNonVegMainCourse();
					}
					break;
				case 3:
					System.out.println("Price of Chettinad Prawn Curry is Rs 200");
					System.out.println("Choose Y to order or N to go back");
					ch = sc.next().charAt(0);
					if (ch == 'y' || ch == 'Y') {
						System.out.println("Order has been confirmed");
						a.add("Chettinad Prawn Curry,200");
						totalBill = totalBill + 200;
						System.out.println(" ");
						System.out.println("Do you want to order more?");
						System.out.println(" ");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) {
						case 1:
							southIndianNonVegMainCourse();
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
					
							break;
						}
					} else if (ch == 'n' || ch == 'N') {
						System.out.println("Choose another item");
						southIndianNonVegMainCourse();
					} else {
						System.err.println("Please choose correct option");
						southIndianNonVegMainCourse();
					}
					break;
				case 4:
					System.out.println("Price of Prawns Vindaloo is Rs 220");
					System.out.println("Choose Y to order or N to go back");
					char h = sc.next().charAt(0);
					if (h == 'y' || h == 'Y') {
						System.out.println("Order has been confirmed");
						a.add("Prawns Vindaloo,220");
						totalBill = totalBill + 220;
						System.out.println(" ");
						System.out.println("Do you want to order more?");
						System.out.println(" ");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) {
						case 1:
							southIndianNonVegMainCourse();
							break;
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
						
							break;
						}
					} else if (h == 'n' || h == 'N') {
						System.out.println("Choose another item");
						southIndianNonVegMainCourse();
					} else {
						System.err.println("Please choose correct option");
						southIndianNonVegMainCourse();
					}
					break;
				case 5:
					System.out.println("Price of Fried Prawns & Curry is Rs 260");
					System.out.println("Choose Y to order or N to go back");
					char c = sc.next().charAt(0);
					if (c == 'y' || c == 'Y') {
						System.out.println("Order has been confirmed");
						a.add("Fried Prawns & Curry,260");
						totalBill = totalBill + 260;
						System.out.println(" ");
						System.out.println("Do you want to order more?");
						System.out.println(" ");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) {
						case 1:
							southIndianNonVegMainCourse();
							break;
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
						
							break;
						}
					} else if (c == 'n' || c == 'N') {
						System.out.println("Choose another item");
						southIndianNonVegMainCourse();
					} else {
						System.err.println("Please choose correct option");
						southIndianNonVegMainCourse();
					}
					break;
				case 6:
					System.out.println("Price of Prawn Ghee Roast is Rs 200");
					System.out.println("Choose Y to order or N to go back");
					char t = sc.next().charAt(0);
					if (t == 'y' || t == 'Y') {
						System.out.println("Order has been confirmed");
						a.add("Prawn Ghee Roast,200");
						totalBill = totalBill + 200;
						System.out.println(" ");
						System.out.println("Do you want to order more?");
						System.out.println(" ");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) {
						case 1:
							southIndianNonVegMainCourse();
							break;
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
							
							break;
						}
					} else if (t == 'n' || t == 'N') {
						System.out.println("Choose another item");
						southIndianNonVegMainCourse();
					} else {
						System.err.println("Please choose correct option");
						southIndianNonVegMainCourse();
					}
					break;
				case 7:
					System.out.println("Price of Spicy Chettinad Fish Fry is Rs 130");
					System.out.println("Choose Y to order or N to go back");
					char b = sc.next().charAt(0);
					if (b == 'y' || b == 'Y') {
						System.out.println("Order has been confirmed");
						a.add("Spicy Chettinad Fish Fry,130");
						totalBill = totalBill + 130;
						System.out.println(" ");
						System.out.println("Do you want to order more?");
						System.out.println(" ");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) {
						case 1:
							southIndianNonVegMainCourse();
							break;
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
							
							break;
						}
					} else if (b == 'n' || b == 'N') {
						System.out.println("Choose another item");
						southIndianNonVegMainCourse();
					} else {
						System.err.println("Please choose correct option");
						southIndianNonVegMainCourse();
					}
					break;
				case 8:
					System.out.println("Price of Mutton Kola Urundai is Rs 160");
					System.out.println("Choose Y to order or N to go back");
					char d = sc.next().charAt(0);
					if (d == 'y' || d == 'Y') {
						System.out.println("Order has been confirmed");
						a.add("Mutton Kola Urundai,160");
						totalBill = totalBill + 160;
						System.out.println(" ");
						System.out.println("Do you want to order more?");
						System.out.println(" ");
						System.out.println("Press 1 to order from same");
						System.out.println("Press 2 to go for Main Menu");
						System.out.println("Press 3 to proceed for bill");
						n = sc.nextInt();
						switch (n) {
						case 1:
							southIndianNonVegMainCourse();
							break;
						case 2:
							menu();
							break;
						case 3:
							System.out.println("Please pay the amount");
						
							break;
						}
					} else if (d == 'n' || d == 'N') {
						System.out.println("Choose another item");
						southIndianNonVegMainCourse();
					} else {
						System.err.println("Please choose correct option");
						southIndianNonVegMainCourse();
					}
					break;

				case 9:
					nonVegMainCourse();
					break;
				default:
					System.err.println("Please Select Valid Option");
					southIndianNonVegMainCourse(); 
			}
			}
}
class Desserts extends Menu {
	public void desserts()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Apple Pie");
		System.out.println("Press 2 for Almond Malai Kulfi");
		System.out.println("Press 3 for Lemon Tart");
		System.out.println("Press 4 for Pistachio Phirni");
		System.out.println("Press 5 for Fudgy Chewy Brownies");
		System.out.println("Press 6 for Low Fat Tiramisu");
		System.out.println("Press 7 for Chocolate Coffee Truffle");
		System.out.println("Press 8 for Hot Cointreau Souffle");
		System.out.println("Press 9 for Eggless Chocolate Mousse");
		System.out.println("Press 0 to go back");
		int n = sc.nextInt();
		switch (n) 
		{
		case 1:
			System.out.println("Price of Apple Pie is Rs 120");
			System.out.println("Choose Y to order or N to go back");
			char ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') 
			{
				System.out.println("Order has been confirmed");
				a.add("Apple Pie,120");
				totalBill = totalBill + 120;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n)
				{
				case 1:
					desserts();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} 
			else if (ch == 'n' || ch == 'N')
			{
				System.out.println("Choose another item");
				desserts();
			} 
			else 
			{
				System.err.println("Please choose correct option");
				desserts();
			}
			break;
		case 2:
			System.out.println("Price of Almond Malai Kulfi is Rs 150");
			System.out.println("Choose Y to order or N to go back");
			ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') 
			{
				System.out.println("Order has been confirmed");
				a.add("Almond Malai Kulfi,150");
				totalBill = totalBill + 150;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) 
				{
				case 1:
					desserts();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} 
			else if (ch == 'n' || ch == 'N')
			{
				System.out.println("Choose another item");
				desserts();
			} 
			else
			{
				System.err.println("Please choose correct option");
				desserts();
			}
			break;
		case 3:
			System.out.println("Price of Lemon Tart is Rs 200");
			System.out.println("Choose Y to order or N to go back");
			ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Lemon Tart,200");
				totalBill = totalBill + 200;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					desserts();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (ch == 'n' || ch == 'N') {
				System.out.println("Choose another item");
				desserts();
			} else {
				System.err.println("Please choose correct option");
				desserts();
			}
			break;
		case 4:
			System.out.println("Price of Pistachio Phirni is Rs 220");
			System.out.println("Choose Y to order or N to go back");
			char h = sc.next().charAt(0);
			if (h == 'y' || h == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Pistachio Phirni,220");
				totalBill = totalBill + 220;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					desserts();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (h == 'n' || h == 'N') {
				System.out.println("Choose another item");
				desserts();
			} else {
				System.err.println("Please choose correct option");
				desserts();
			}
			break;
		case 5:
			System.out.println("Price of Fudgy Chewy Brownies is Rs 260");
			System.out.println("Choose Y to order or N to go back");
			char c = sc.next().charAt(0);
			if (c == 'y' || c == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Fudgy Chewy Brownies,260");
				totalBill = totalBill + 260;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					desserts();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (c == 'n' || c == 'N') {
				System.out.println("Choose another item");
				desserts();
			} else {
				System.err.println("Please choose correct option");
				desserts();
			}
			break;
		case 6:
			System.out.println("Price of Low Fat Tiramisu is Rs 200");
			System.out.println("Choose Y to order or N to go back");
			char i = sc.next().charAt(0);
			if (i == 'y' || i == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Low Fat Tiramisu,200");
				totalBill = totalBill + 200;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					desserts();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
					
					break;
				}
			} else if (i == 'n' || i == 'N') {
				System.out.println("Choose another item");
				desserts();
			} else {
				System.err.println("Please choose correct option");
				desserts();
			}
			break;
		case 7:
			System.out.println("Price of Chocolate Coffee Truffle is Rs 130");
			System.out.println("Choose Y to order or N to go back");
			char b = sc.next().charAt(0);
			if (b == 'y' || b == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Chocolate Coffee Truffle,130");
				totalBill = totalBill + 130;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					desserts();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (b == 'n' || b == 'N') {
				System.out.println("Choose another item");
				desserts();
			} else {
				System.err.println("Please choose correct option");
				desserts();
			}
			break;
		case 8:
			System.out.println("Price of Hot Cointreau Souffle is Rs 160");
			System.out.println("Choose Y to order or N to go back");
			char d = sc.next().charAt(0);
			if (d == 'y' || d == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Hot Cointreau Souffle,160");
				totalBill = totalBill + 160;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					desserts();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (d == 'n' || d == 'N') {
				System.out.println("Choose another item");
				desserts();
			} else {
				System.err.println("Please choose correct option");
				desserts();
			}
			break;

		case 9:
			System.out.println("Price of  Eggless Chocolate Mousse is Rs 160");
			System.out.println("Choose Y to order or N to go back");
			char e = sc.next().charAt(0);
			if (e == 'y' || e == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Eggless Chocolate Mousse,160");
				totalBill = totalBill + 160;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					desserts();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (e == 'n' || e == 'N') {
				System.out.println("Choose another item");
				desserts();
			} else {
				System.err.println("Please choose correct option");
				desserts();
			}
			break;
		case 0:
			desserts();
			break;
		default:
			System.err.println("Please Select Valid Option");
			desserts();
	}
	}
}

class Cold_Drinks extends Menu {
	public void coldDrinks()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Chocolate Shake");
		System.out.println("Press 2 for Coca Cola");
		System.out.println("Press 3 for Lemon Juice");
		System.out.println("Press 4 for Thumbs Up");
		System.out.println("Press 5 for Pepsi");
		System.out.println("Press 6 for Sprite");
		System.out.println("Press 7 for Oreo Shake");
		System.out.println("Press 8 for Strawberry Shake");
		System.out.println("Press 9 for Mojito");
		System.out.println("Press 0 to go back");
		int n = sc.nextInt();
		switch (n) 
		{
		case 1:
			System.out.println("Price of Chocolate Shake is Rs 120");
			System.out.println("Choose Y to order or N to go back");
			char ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') 
			{
				System.out.println("Order has been confirmed");
				a.add("Chocolate Shake,120");
				totalBill = totalBill + 120;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n)
				{
				case 1:
					coldDrinks();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
			
					break;
				}
			} 
			else if (ch == 'n' || ch == 'N')
			{
				System.out.println("Choose another item");
				coldDrinks();
			} 
			else 
			{
				System.err.println("Please choose correct option");
				coldDrinks();
			}
			break;
		case 2:
			System.out.println("Price of Coca Cola is Rs 150");
			System.out.println("Choose Y to order or N to go back");
			ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') 
			{
				System.out.println("Order has been confirmed");
				a.add("Coca Cola,150");
				totalBill = totalBill + 150;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) 
				{
				case 1:
					coldDrinks();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} 
			else if (ch == 'n' || ch == 'N')
			{
				System.out.println("Choose another item");
				coldDrinks();
			} 
			else
			{
				System.err.println("Please choose correct option");
				coldDrinks();
			}
			break;
		case 3:
			System.out.println("Price of Lemon Juice is Rs 200");
			System.out.println("Choose Y to order or N to go back");
			ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Lemon Juice,200");
				totalBill = totalBill + 200;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					coldDrinks();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (ch == 'n' || ch == 'N') {
				System.out.println("Choose another item");
				coldDrinks();
			} else {
				System.err.println("Please choose correct option");
				coldDrinks();
			}
			break;
		case 4:
			System.out.println("Price of Thumbs Up is Rs 220");
			System.out.println("Choose Y to order or N to go back");
			char h = sc.next().charAt(0);
			if (h == 'y' || h == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Thumbs Up,220");
				totalBill = totalBill + 220;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					coldDrinks();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
					
					break;
				}
			} else if (h == 'n' || h == 'N') {
				System.out.println("Choose another item");
				coldDrinks();
			} else {
				System.err.println("Please choose correct option");
				coldDrinks();
			}
			break;
		case 5:
			System.out.println("Price of Pepsi is Rs 160");
			System.out.println("Choose Y to order or N to go back");
			char c = sc.next().charAt(0);
			if (c == 'y' || c == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Pepsi,160");
				totalBill = totalBill + 160;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					coldDrinks();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (c == 'n' || c == 'N') {
				System.out.println("Choose another item");
				coldDrinks();
			} else {
				System.err.println("Please choose correct option");
				coldDrinks();
			}
			break;
		case 6:
			System.out.println("Price of Sprite is Rs 200");
			System.out.println("Choose Y to order or N to go back");
			char k = sc.next().charAt(0);
			if (k == 'y' || k == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Sprite,200");
				totalBill = totalBill + 200;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					coldDrinks();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (k == 'n' || k == 'N') {
				System.out.println("Choose another item");
				coldDrinks();
			} else {
				System.err.println("Please choose correct option");
				coldDrinks();
			}
			break;
		case 7:
			System.out.println("Price of Oreo Shake is Rs 130");
			System.out.println("Choose Y to order or N to go back");
			char b = sc.next().charAt(0);
			if (b == 'y' || b == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Oreo Shake,130");
				totalBill = totalBill + 130;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					coldDrinks();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (b == 'n' || b == 'N') {
				System.out.println("Choose another item");
				coldDrinks();
			} else {
				System.err.println("Please choose correct option");
				coldDrinks();
			}
			break;
		case 8:
			System.out.println("Price of Strawberry Shake is Rs 160");
			System.out.println("Choose Y to order or N to go back");
			char d = sc.next().charAt(0);
			if (d == 'y' || d == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Strawberry Shake,160");
				totalBill = totalBill + 160;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					coldDrinks();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (d == 'n' || d == 'N') {
				System.out.println("Choose another item");
				coldDrinks();
			} else {
				System.err.println("Please choose correct option");
				coldDrinks();
			}
			break;

		case 9:
			System.out.println("Price of Mojito is Rs 160");
			System.out.println("Choose Y to order or N to go back");
			char e = sc.next().charAt(0);
			if (e == 'y' || e == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Mojito,160");
				totalBill = totalBill + 160;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					coldDrinks();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
					payment();
					break;
				}
			} else if (e == 'n' || e == 'N') {
				System.out.println("Choose another item");
				coldDrinks();
			} else {
				System.err.println("Please choose correct option");
				coldDrinks();
			}
			break;
		case 0:
			coldDrinks();
			break;
		default:
			System.err.println("Please Select Valid Option");
			coldDrinks();
	}
	}
}

class Beverages extends Menu {
	public void beverages()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Kingfisher");
		System.out.println("Press 2 for Old Monk");
		System.out.println("Press 3 for Red Label");
		System.out.println("Press 4 for Budweiser");
		System.out.println("Press 5 for Tuborg");
		System.out.println("Press 6 for Carlsberg");
		System.out.println("Press 7 for Foster's");
		System.out.println("Press 8 for Heineken");
		System.out.println("Press 9 for Haywards 5000");
		System.out.println("Press 0 to go back");
		int n = sc.nextInt();
		switch (n) 
		{
		case 1:
			System.out.println("Price of Kingfisher is Rs 120");
			System.out.println("Choose Y to order or N to go back");
			char ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') 
			{
				System.out.println("Order has been confirmed");
				a.add("Kingfisher,120");
				totalBill = totalBill + 120;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n)
				{
				case 1:
					beverages();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} 
			else if (ch == 'n' || ch == 'N')
			{
				System.out.println("Choose another item");
				beverages();
			} 
			else 
			{
				System.err.println("Please choose correct option");
				beverages();
			}
			break;
		case 2:
			System.out.println("Price of Old Monk is Rs 150");
			System.out.println("Choose Y to order or N to go back");
			ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') 
			{
				System.out.println("Order has been confirmed");
				a.add("Old Monk,150");
				totalBill = totalBill + 150;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) 
				{
				case 1:
					beverages();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} 
			else if (ch == 'n' || ch == 'N')
			{
				System.out.println("Choose another item");
				beverages();
			} 
			else
			{
				System.err.println("Please choose correct option");
				beverages();
			}
			break;
		case 3:
			System.out.println("Price of Red Label is Rs 200");
			System.out.println("Choose Y to order or N to go back");
			ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Red Label,200");
				totalBill = totalBill + 200;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					beverages();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (ch == 'n' || ch == 'N') {
				System.out.println("Choose another item");
				beverages();
			} else {
				System.err.println("Please choose correct option");
				beverages();
			}
			break;
		case 4:
			System.out.println("Price of Budweiser is Rs 220");
			System.out.println("Choose Y to order or N to go back");
			char h = sc.next().charAt(0);
			if (h == 'y' || h == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Budweiser,220");
				totalBill = totalBill + 220;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					beverages();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (h == 'n' || h == 'N') {
				System.out.println("Choose another item");
				beverages();
			} else {
				System.err.println("Please choose correct option");
				beverages();
			}
			break;
		case 5:
			System.out.println("Price of Tuborg is Rs 160");
			System.out.println("Choose Y to order or N to go back");
			char c = sc.next().charAt(0);
			if (c == 'y' || c == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Tuborg,160");
				totalBill = totalBill + 160;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					beverages();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
			
					break;
				}
			} else if (c == 'n' || c == 'N') {
				System.out.println("Choose another item");
				beverages();
			} else {
				System.err.println("Please choose correct option");
				beverages();
			}
			break;
		case 6:
			System.out.println("Price of Carlsberg is Rs 200");
			System.out.println("Choose Y to order or N to go back");
			char p = sc.next().charAt(0);
			if (p == 'y' || p == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Carlsberg,200");
				totalBill = totalBill + 200;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					beverages();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (p == 'n' || p == 'N') {
				System.out.println("Choose another item");
				beverages();
			} else {
				System.err.println("Please choose correct option");
				beverages();
			}
			break;
		case 7:
			System.out.println("Price of Foster's is Rs 130");
			System.out.println("Choose Y to order or N to go back");
			char b = sc.next().charAt(0);
			if (b == 'y' || b == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Foster's,130");
				totalBill = totalBill + 130;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					beverages();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
					
					break;
				}
			} else if (b == 'n' || b == 'N') {
				System.out.println("Choose another item");
				beverages();
			} else {
				System.err.println("Please choose correct option");
				beverages();
			}
			break;
		case 8:
			System.out.println("Price of Heineken is Rs 160");
			System.out.println("Choose Y to order or N to go back");
			char d = sc.next().charAt(0);
			if (d == 'y' || d == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Heineken,160");
				totalBill = totalBill + 160;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					beverages();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (d == 'n' || d == 'N') {
				System.out.println("Choose another item");
				beverages();
			} else {
				System.err.println("Please choose correct option");
				beverages();
			}
			break;

		case 9:
			System.out.println("Price of Haywards 5000 is Rs 160");
			System.out.println("Choose Y to order or N to go back");
			char e = sc.next().charAt(0);
			if (e == 'y' || e == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Haywards 5000,160");
				totalBill = totalBill + 160;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					beverages();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (e == 'n' || e == 'N') {
				System.out.println("Choose another item");
				beverages();
			} else {
				System.err.println("Please choose correct option");
				beverages();
			}
			break;
		case 0:
			beverages();
			break;
		default:
			System.err.println("Please Select Valid Option");
			beverages();
	}
	}
}

class Continental extends Menu {
	public void continental()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Paneer Steak");
		System.out.println("Press 2 for East-West Spring Roll");
		System.out.println("Press 3 for Glazed Ham");
		System.out.println("Press 4 for Smokey Kidney Bean Salad");
		System.out.println("Press 5 for Date & Walnet Pie");
		System.out.println("Press 6 for Hot Cross Buns");
		System.out.println("Press 7 for Herbs & Mushroom Stuffed Tomatoes");
		System.out.println("Press 8 for Cheese & Lamb Steaks");
		System.out.println("Press 9 for Salted Caramel Pie");
		System.out.println("Press 0 to go back");
		int n = sc.nextInt();
		switch (n) 
		{
		case 1:
			System.out.println("Price of Paneer Steak is Rs 120");
			System.out.println("Choose Y to order or N to go back");
			char ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') 
			{
				System.out.println("Order has been confirmed");
				a.add("Paneer Steak,120");
				totalBill = totalBill + 120;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n)
				{
				case 1:
					continental();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} 
			else if (ch == 'n' || ch == 'N')
			{
				System.out.println("Choose another item");
				continental();
			} 
			else 
			{
				System.err.println("Please choose correct option");
				continental();
			}
			break;
		case 2:
			System.out.println("Price of East-West Spring Roll is Rs 150");
			System.out.println("Choose Y to order or N to go back");
			ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') 
			{
				System.out.println("Order has been confirmed");
				a.add("East-West Spring Roll,150");
				totalBill = totalBill + 150;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) 
				{
				case 1:
					continental();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} 
			else if (ch == 'n' || ch == 'N')
			{
				System.out.println("Choose another item");
				continental();
			} 
			else
			{
				System.err.println("Please choose correct option");
				continental();
			}
			break;
		case 3:
			System.out.println("Price of Glazed Ham is Rs 200");
			System.out.println("Choose Y to order or N to go back");
			ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Glazed Ham,200");
				totalBill = totalBill + 200;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					continental();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
					
					break;
				}
			} else if (ch == 'n' || ch == 'N') {
				System.out.println("Choose another item");
				continental();
			} else {
				System.err.println("Please choose correct option");
				continental();
			}
			break;
		case 4:
			System.out.println("Price of Smokey Kidney Bean Salad is Rs 220");
			System.out.println("Choose Y to order or N to go back");
			char h = sc.next().charAt(0);
			if (h == 'y' || h == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Smokey Kidney Bean Salad,220");
				totalBill = totalBill + 220;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					continental();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (h == 'n' || h == 'N') {
				System.out.println("Choose another item");
			    continental();
			} else {
				System.err.println("Please choose correct option");
				continental();
			}
			break;
		case 5:
			System.out.println("Price of Date & Walnet Pie is Rs 160");
			System.out.println("Choose Y to order or N to go back");
			char c = sc.next().charAt(0);
			if (c == 'y' || c == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Date & Walnet Pie,160");
				totalBill = totalBill + 160;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					continental();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
		       
					break;
				}
			} else if (c == 'n' || c == 'N') {
				System.out.println("Choose another item");
				continental();
			} else {
				System.err.println("Please choose correct option");
				continental();
			}
			break;
		case 6:
			System.out.println("Price of Hot Cross Buns is Rs 200");
			System.out.println("Choose Y to order or N to go back");
			char f = sc.next().charAt(0);
			if (f == 'y' || f == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Hot Cross Buns,200");
				totalBill = totalBill + 200;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					continental();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
					
					break;
				}
			} else if (f == 'n' || f == 'N') {
				System.out.println("Choose another item");
				continental();
			} else {
				System.err.println("Please choose correct option");
				continental();
			}
			break;
		case 7:
			System.out.println("Price of Herbs & Mushroom Stuffed Tomatoes is Rs 130");
			System.out.println("Choose Y to order or N to go back");
			char b = sc.next().charAt(0);
			if (b == 'y' || b == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Herbs & Mushroom Stuffed Tomatoes,130");
				totalBill = totalBill + 130;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					continental();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (b == 'n' || b == 'N') {
				System.out.println("Choose another item");
				continental();
			} else {
				System.err.println("Please choose correct option");
				continental();
			}
			break;
		case 8:
			System.out.println("Price of Cheese & Lamb Steaks is Rs 160");
			System.out.println("Choose Y to order or N to go back");
			char d = sc.next().charAt(0);
			if (d == 'y' || d == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Cheese & Lamb Steaks,160");
				totalBill = totalBill + 160;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					continental();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
					
					break;
				}
			} else if (d == 'n' || d == 'N') {
				System.out.println("Choose another item");
				continental();
			} else {
				System.err.println("Please choose correct option");
				continental();
			}
			break;

		case 9:
			System.out.println("Price of Salted Caramel Pie is Rs 160");
			System.out.println("Choose Y to order or N to go back");
			char e = sc.next().charAt(0);
			if (e == 'y' || e == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Salted Caramel Pie,160");
				totalBill = totalBill + 160;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					continental();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (e == 'n' || e == 'N') {
				System.out.println("Choose another item");
			    continental();
			} else {
				System.err.println("Please choose correct option");
				continental();
			}
			break;
		case 0:
			continental();
			break;
		default:
			System.err.println("Please Select Valid Option");
			continental();
	}
	}
}

class Thai_Mexican extends Menu {
	public void thaiMexican()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Pad Thai");
		System.out.println("Press 2 for Tom-Yum Soup");
		System.out.println("Press 3 for Green Curry");
		System.out.println("Press 4 for Massaman Curry");
		System.out.println("Press 5 for Som Tam");
		System.out.println("Press 6 for Khao Pad");
		System.out.println("Press 7 for Mango Sticky Rice");
		System.out.println("Press 8 for Khao Soi");
		System.out.println("Press 9 for Moo Ping");
		System.out.println("Press 0 to go back");
		int n = sc.nextInt();
		switch (n) 
		{
		case 1:
			System.out.println("Price of Pad Thai is Rs 120");
			System.out.println("Choose Y to order or N to go back");
			char ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') 
			{
				System.out.println("Order has been confirmed");
				a.add("Pad Thai,120");
				totalBill = totalBill + 120;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n)
				{
				case 1:
					thaiMexican();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} 
			else if (ch == 'n' || ch == 'N')
			{
				System.out.println("Choose another item");
				thaiMexican();
			} 
			else 
			{
				System.err.println("Please choose correct option");
				thaiMexican();
			}
			break;
		case 2:
			System.out.println("Price of Tom-Yum Soup is Rs 150");
			System.out.println("Choose Y to order or N to go back");
			ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') 
			{
				System.out.println("Order has been confirmed");
				a.add("Tom-Yum Soup,150");
				totalBill = totalBill + 150;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) 
				{
				case 1:
					thaiMexican();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} 
			else if (ch == 'n' || ch == 'N')
			{
				System.out.println("Choose another item");
				thaiMexican();
			} 
			else
			{
				System.err.println("Please choose correct option");
				thaiMexican();
			}
			break;
		case 3:
			System.out.println("Price of Green Curry is Rs 200");
			System.out.println("Choose Y to order or N to go back");
			ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Green Curry,200");
				totalBill = totalBill + 200;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					thaiMexican();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (ch == 'n' || ch == 'N') {
				System.out.println("Choose another item");
				thaiMexican();
			} else {
				System.err.println("Please choose correct option");
				thaiMexican();
			}
			break;
		case 4:
			System.out.println("Price of Massaman Curry is Rs 220");
			System.out.println("Choose Y to order or N to go back");
			char h = sc.next().charAt(0);
			if (h == 'y' || h == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Massaman Curry,220");
				totalBill = totalBill + 220;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					thaiMexican();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (h == 'n' || h == 'N') {
				System.out.println("Choose another item");
			    thaiMexican();
			} else {
				System.err.println("Please choose correct option");
			    thaiMexican();
			}
			break;
		case 5:
			System.out.println("Price of Som Tam is Rs 160");
			System.out.println("Choose Y to order or N to go back");
			char c = sc.next().charAt(0);
			if (c == 'y' || c == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Som Tam,160");
				totalBill = totalBill + 160;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					thaiMexican();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
					
					break;
				}
			} else if (c == 'n' || c == 'N') {
				System.out.println("Choose another item");
				thaiMexican();
			} else {
				System.err.println("Please choose correct option");
				thaiMexican();
			}
			break;
		case 6:
			System.out.println("Price of Khao Pad is Rs 200");
			System.out.println("Choose Y to order or N to go back");
			char k = sc.next().charAt(0);
			if (k == 'y' || k == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Khao Pad,200");
				totalBill = totalBill + 200;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					thaiMexican();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
					
					break;
				}
			} else if (k == 'n' || k == 'N') {
				System.out.println("Choose another item");
				thaiMexican();
			} else {
				System.err.println("Please choose correct option");
				thaiMexican();
			}
			break;
		case 7:
			System.out.println("Price of Mango Sticky Rice is Rs 130");
			System.out.println("Choose Y to order or N to go back");
			char b = sc.next().charAt(0);
			if (b == 'y' || b == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Mango Sticky Rice,130");
				totalBill = totalBill + 130;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					thaiMexican();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
					
					break;
				}
			} else if (b == 'n' || b == 'N') {
				System.out.println("Choose another item");
				thaiMexican();
			} else {
				System.err.println("Please choose correct option");
				thaiMexican();
			}
			break;
		case 8:
			System.out.println("Price of Khao Soi is Rs 160");
			System.out.println("Choose Y to order or N to go back");
			char d = sc.next().charAt(0);
			if (d == 'y' || d == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Khao Soi,160");
				totalBill = totalBill + 160;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					thaiMexican();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (d == 'n' || d == 'N') {
				System.out.println("Choose another item");
				thaiMexican();
			} else {
				System.err.println("Please choose correct option");
				thaiMexican();
			}
			break;

		case 9:
			System.out.println("Price of Moo Ping is Rs 160");
			System.out.println("Choose Y to order or N to go back");
			char e = sc.next().charAt(0);
			if (e == 'y' || e == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Moo Ping,160");
				totalBill = totalBill + 160;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
				    thaiMexican();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (e == 'n' || e == 'N') {
				System.out.println("Choose another item");
			    thaiMexican();
			} else {
				System.err.println("Please choose correct option");
				thaiMexican();
			}
			break;
		case 0:
			thaiMexican();
			break;
		default:
			System.err.println("Please Select Valid Option");
			thaiMexican();
	}
	}
}

class Snacks extends Menu {
	public void snacks()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Vada Pav");
		System.out.println("Press 2 for Samosa Pav");
		System.out.println("Press 3 for Kanda Bhaji");
		System.out.println("Press 4 for Chana Masala");
		System.out.println("Press 5 for Sev Puri");
		System.out.println("Press 6 for PaniPuri");
		System.out.println("Press 7 for Bhel");
		System.out.println("Press 8 for Masala Papad");
		System.out.println("Press 9 for Rice Cake");
		System.out.println("Press 0 to go back");
		int n = sc.nextInt();
		switch (n) 
		{
		case 1:
			System.out.println("Price of Vada Pav is Rs 40");
			System.out.println("Choose Y to order or N to go back");
			char ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') 
			{
				System.out.println("Order has been confirmed");
				a.add("Vada Pav,40");
				totalBill = totalBill + 40;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n)
				{
				case 1:
					snacks();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} 
			else if (ch == 'n' || ch == 'N')
			{
				System.out.println("Choose another item");
				snacks();
			} 
			else 
			{
				System.err.println("Please choose correct option");
				snacks();
			}
			break;
		case 2:
			System.out.println("Price of Samosa Pav is Rs 50");
			System.out.println("Choose Y to order or N to go back");
			ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') 
			{
				System.out.println("Order has been confirmed");
				a.add("Samosa Pav,50");
				totalBill = totalBill + 50;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) 
				{
				case 1:
					snacks();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
					
					break;
				}
			} 
			else if (ch == 'n' || ch == 'N')
			{
				System.out.println("Choose another item");
				snacks();
			} 
			else
			{
				System.err.println("Please choose correct option");
				snacks();
			}
			break;
		case 3:
			System.out.println("Price of Kanda Bhaji is Rs 45");
			System.out.println("Choose Y to order or N to go back");
			ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Kanda Bhaji,45");
				totalBill = totalBill + 45;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					snacks();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (ch == 'n' || ch == 'N') {
				System.out.println("Choose another item");
				snacks();
			} else {
				System.err.println("Please choose correct option");
				snacks();
			}
			break;
		case 4:
			System.out.println("Price of Chana Masala is Rs 220");
			System.out.println("Choose Y to order or N to go back");
			char h = sc.next().charAt(0);
			if (h == 'y' || h == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Chana Masala,220");
				totalBill = totalBill + 220;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					snacks();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
					
					break;
				}
			} else if (h == 'n' || h == 'N') {
				System.out.println("Choose another item");
			    snacks();
			} else {
				System.err.println("Please choose correct option");
			    snacks();
			}
			break;
		case 5:
			System.out.println("Price of Sev Puri is Rs 160");
			System.out.println("Choose Y to order or N to go back");
			char c = sc.next().charAt(0);
			if (c == 'y' || c == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Sev Puri,160");
				totalBill = totalBill + 160;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					snacks();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
					
					break;
				}
			} else if (c == 'n' || c == 'N') {
				System.out.println("Choose another item");
				snacks();
			} else {
				System.err.println("Please choose correct option");
				snacks();
			}
			break;
		case 6:
			System.out.println("Price of Pani Puri is Rs 200");
			System.out.println("Choose Y to order or N to go back");
			char j = sc.next().charAt(0);
			if (j == 'y' || j == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Pani Puri,200");
				totalBill = totalBill + 200;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					snacks();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
					
					break;
				}
			} else if (j == 'n' || j == 'N') {
				System.out.println("Choose another item");
				snacks();
			} else {
				System.err.println("Please choose correct option");
				snacks();
			}
			break;
		case 7:
			System.out.println("Price of Bhel is Rs 130");
			System.out.println("Choose Y to order or N to go back");
			char b = sc.next().charAt(0);
			if (b == 'y' || b == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Bhel,130");
				totalBill = totalBill + 130;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					snacks();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
					
					break;
				}
			} else if (b == 'n' || b == 'N') {
				System.out.println("Choose another item");
				snacks();
			} else {
				System.err.println("Please choose correct option");
				snacks();
			}
			break;
		case 8:
			System.out.println("Price of Masala Papad is Rs 160");
			System.out.println("Choose Y to order or N to go back");
			char d = sc.next().charAt(0);
			if (d == 'y' || d == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Masala Papad,160");
				totalBill = totalBill + 160;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					snacks();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (d == 'n' || d == 'N') {
				System.out.println("Choose another item");
				snacks();
			} else {
				System.err.println("Please choose correct option");
				snacks();
			}
			break;

		case 9:
			System.out.println("Price of Rice Cake is Rs 160");
			System.out.println("Choose Y to order or N to go back");
			char e = sc.next().charAt(0);
			if (e == 'y' || e == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Rice Cake,160");
				totalBill = totalBill + 160;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
				    snacks();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
					
					break;
				}
			} else if (e == 'n' || e == 'N') {
				System.out.println("Choose another item");
			    snacks();
			} else {
				System.err.println("Please choose correct option");
				snacks();
			}
			break;
		case 0:
			snacks();
			break;
		default:
			System.err.println("Please Select Valid Option");
			snacks();
	}
	}
}

class Salads extends Menu {
	public void salads()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Press 1 for Sprouted Moong Salad");
		System.out.println("Press 2 for Apple Cucumber Salad");
		System.out.println("Press 3 for Kachumber Salad");
		System.out.println("Press 4 for Sprouted Chana Salad");
		System.out.println("Press 5 for Beetroot and Garlic Salad");
		System.out.println("Press 6 for Cheese & Pineapple Salad");
		System.out.println("Press 7 for Vegetable Salad with Lemony Apple Dressing");
		System.out.println("Press 8 for Beans Salad");
		System.out.println("Press 9 for Sprouts Salad with Veggies");
		System.out.println("Press 0 to go back");
		int n = sc.nextInt();
		switch (n) 
		{
		case 1:
			System.out.println("Price of Sprouted Moong Salad is Rs 120");
			System.out.println("Choose Y to order or N to go back");
			char ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') 
			{
				System.out.println("Order has been confirmed");
				a.add("Sprouted Moong Salad,120");
				totalBill = totalBill + 120;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n)
				{
				case 1:
					salads();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
					
					break;
				}
			} 
			else if (ch == 'n' || ch == 'N')
			{
				System.out.println("Choose another item");
				salads();
			} 
			else 
			{
				System.err.println("Please choose correct option");
				salads();
			}
			break;
		case 2:
			System.out.println("Price of Apple Cucumber Salad is Rs 150");
			System.out.println("Choose Y to order or N to go back");
			ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') 
			{
				System.out.println("Order has been confirmed");
				a.add("Apple Cucumber Salad,150");
				totalBill = totalBill + 150;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) 
				{
				case 1:
					salads();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} 
			else if (ch == 'n' || ch == 'N')
			{
				System.out.println("Choose another item");
				salads();
			} 
			else
			{
				System.err.println("Please choose correct option");
				salads();
			}
			break;
		case 3:
			System.out.println("Price of Kachumber Salad is Rs 200");
			System.out.println("Choose Y to order or N to go back");
			ch = sc.next().charAt(0);
			if (ch == 'y' || ch == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Kachumber Salad,200");
				totalBill = totalBill + 200;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					salads();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
					
					break;
				}
			} else if (ch == 'n' || ch == 'N') {
				System.out.println("Choose another item");
				salads();
			} else {
				System.err.println("Please choose correct option");
				salads();
			}
			break;
		case 4:
			System.out.println("Price of Sprouted Chana Salad is Rs 220");
			System.out.println("Choose Y to order or N to go back");
			char h = sc.next().charAt(0);
			if (h == 'y' || h == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Sprouted Chana Salad,220");
				totalBill = totalBill + 220;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					salads();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
				
					break;
				}
			} else if (h == 'n' || h == 'N') {
				System.out.println("Choose another item");
			    salads();
			} else {
				System.err.println("Please choose correct option");
			    salads();
			}
			break;
		case 5:
			System.out.println("Price of Beetroot and Garlic Salad is Rs 160");
			System.out.println("Choose Y to order or N to go back");
			char c = sc.next().charAt(0);
			if (c == 'y' || c == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Beetroot and Garlic Salad,160");
				totalBill = totalBill + 160;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					salads();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
					
					break;
				}
			} else if (c == 'n' || c == 'N') {
				System.out.println("Choose another item");
				salads();
			} else {
				System.err.println("Please choose correct option");
				salads();
			}
			break;
		case 6:
			System.out.println("Price of Cheese & Pineapple Salad is Rs 200");
			System.out.println("Choose Y to order or N to go back");
			char g = sc.next().charAt(0);
			if (g == 'y' || g == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Cheese & Pineapple Salad,200");
				totalBill = totalBill + 200;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					salads();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
					
					break;
				}
			} else if (g == 'n' || g == 'N') {
				System.out.println("Choose another item");
				salads();
			} else {
				System.err.println("Please choose correct option");
				salads();
			}
			break;
		case 7:
			System.out.println("Price of Vegetable Salad with Lemony Apple Dressing is Rs 130");
			System.out.println("Choose Y to order or N to go back");
			char b = sc.next().charAt(0);
			if (b == 'y' || b == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Vegetable Salad with Lemony Apple Dressing,130");
				totalBill = totalBill + 130;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					salads();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
					
					break;
				}
			} else if (b == 'n' || b == 'N') {
				System.out.println("Choose another item");
				salads();
			} else {
				System.err.println("Please choose correct option");
				salads();
			}
			break;
		case 8:
			System.out.println("Price of Beans Salad is Rs 160");
			System.out.println("Choose Y to order or N to go back");
			char d = sc.next().charAt(0);
			if (d == 'y' || d == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Beans Salad,160");
				totalBill = totalBill + 160;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
					salads();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
					
					break;
				}
			} else if (d == 'n' || d == 'N') {
				System.out.println("Choose another item");
				salads();
			} else {
				System.err.println("Please choose correct option");
				salads();
			}
			break;

		case 9:
			System.out.println("Price for Sprouts Salad with Veggies is Rs 160");
			System.out.println("Choose Y to order or N to go back");
			char e = sc.next().charAt(0);
			if (e == 'y' || e == 'Y') {
				System.out.println("Order has been confirmed");
				a.add("Sprouts Salad with Veggies,160");
				totalBill = totalBill + 160;
				System.out.println(" ");
				System.out.println("Do you want to order more?");
				System.out.println(" ");
				System.out.println("Press 1 to order from same");
				System.out.println("Press 2 to go for Main Menu");
				System.out.println("Press 3 to proceed for bill");
				n = sc.nextInt();
				switch (n) {
				case 1:
				    salads();
					break;
				case 2:
					menu();
					break;
				case 3:
					System.out.println("Please pay the amount");
					
					break;
				}
			} else if (e == 'n' || e == 'N') {
				System.out.println("Choose another item");
			    salads();
			} else {
				System.err.println("Please choose correct option");
				salads();
			}
			break;
		case 0:
			salads();
			break;
		default:
			System.err.println("Please Select Valid Option");
			salads();
			
	}
	}
}


