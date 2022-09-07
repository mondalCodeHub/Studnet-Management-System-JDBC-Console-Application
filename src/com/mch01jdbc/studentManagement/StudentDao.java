package com.mch01jdbc.studentManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {
	// insertData ( insertStudentToDB )::
	public static boolean insertStudentToDB(Student st) {
		boolean f = false;
		try {
			// CONNECTION ESTABLISHED (JDBCCode:createConnection ):: 01
			Connection con = ConnectionProvider.createConnection();
			String q = "insert into students(sname,sphone,scity) values(?,?,?)";

			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setString(1, st.getName());
			pstmt.setString(2, st.getPhone());
			pstmt.setString(3, st.getCity());

			pstmt.executeUpdate();
			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	// deleteData ( deleteStudentFromDB ):: 02
	public static boolean deleteStudentFromDB(int studentID) {

		boolean f = false;
		try {
			// CONNECTION ESTABLISHED (JDBCCode:createConnection )
			Connection con = ConnectionProvider.createConnection();
			String q = "delete from students where sid=?";

			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setInt(1, studentID);

			pstmt.executeUpdate();
			f = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	// showDBInformation ( displayInformation ):: 03
	public static void displayInformation() {
		try {

			Connection con = ConnectionProvider.createConnection();
			String q = "select *from students";
			Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery(q);

			while (set.next()) {
				int id = set.getInt(1);
				String name = set.getString(2);
				String phone = set.getString(3);
				String city = set.getString("scity");

				System.out.println("ID : " + id);
				System.out.println("NAME : " + name);
				System.out.println("PHONE : " + phone);
				System.out.println("CITY : " + city);
				System.out.println("------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
