import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.mch01jdbc.studentManagement.Student;
import com.mch01jdbc.studentManagement.StudentDao;

public class Start {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println("Welcome to student management console based application ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("PRESS 1 TO ADD STUDENT ");
			System.out.println("PRESS 2 TO DELETE STUDENT ");
			System.out.println("PRESS 3 TO DISPLAY STUDENT ");
			System.out.println("PRESS 4 TO EXIT APPLICATION ");
			int choice = Integer.parseInt(br.readLine());

			if (choice == 1) {
				System.out.println("ENTER STUDENT NAME : ");
				String name = br.readLine();
				System.out.println("ENTER STUDENT PHONE NUMBER :");
				String phone = br.readLine();
				System.out.println("ENTER STUDENT CITY : ");
				String city = br.readLine();

				Student st = new Student(name, phone, city);
				Boolean answer = StudentDao.insertStudentToDB(st);
				if (answer) {
					System.out.println("Student added successfully... ");
				} else {
					System.out.println("Something went wrong ...");
				}
				System.out.println(st);

			} else if (choice == 2) {
				System.out.println("Enter student id to delete :");
				int studentID = Integer.parseInt(br.readLine());
				Boolean answer = StudentDao.deleteStudentFromDB(studentID);
				if (answer) {
					System.out.println("Student deleted successfully... ");
				} else {
					System.out.println("Something went wrong ...");
				}

			} else if (choice == 3) {
				StudentDao.displayInformation();

			} else if (choice == 4) {
				break;
			} else {
				// default
			}
		}
	}
}
