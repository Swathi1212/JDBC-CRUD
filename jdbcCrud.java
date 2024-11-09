import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class jdbcCrud {
	public static Connection CreateConnection()
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/teckdb","root","root");
		}
		catch(ClassNotFoundException ce)
		{
			System.out.println(ce);
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}
		return con;
	}//End of CreateConnection
	public static void addStudent(int rno,String name,double avg) throws SQLException
	{
		try
		{
			Connection con=CreateConnection();
			String ins_str="insert into student values(?,?,?)";
		PreparedStatement pst=con.prepareStatement(ins_str);
			pst.setInt(1, rno);
			pst.setDouble(3,avg);
			pst.setString(2, name);
			pst.executeUpdate();
			con.close();
			System.out.println("Success!");
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}//End of addStudent
	public static void updateStudent(int rno,String newName,Double newAvg)
	{
		try{
		Connection con =CreateConnection();
		String update_Str="UPDATE student SET sname=?,avgmarks=? where rno=?";
		PreparedStatement pst=con.prepareStatement(update_Str);
		pst.setString(1, newName);
		pst.setDouble(2, newAvg);
		pst.setInt(3, rno);
		pst.executeUpdate();
		con.close();
		System.out.println("Updated");
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}//end of updateStudent()
	public static void showAllStudents()
	{
		try
		{
			Connection con=CreateConnection();
			String str ="select * from student";
			PreparedStatement pst=con.prepareStatement(str);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+
				rs.getString(2)+" "+
				rs.getDouble(3));
			}
			con.close();	
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}//end of showAllStudent
	public static void showStudentByRno(int rno)
	{
		try
		{
			Connection con=CreateConnection();
			String str="select * from student where rno=?";
			PreparedStatement pst=con.prepareStatement(str);
			pst.setInt(1,rno);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3));
			}
			con.close();
			
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}//end of showStudentByRno
	public static void deleteStudent(int rno)
	{
		try
		{
			Connection con=CreateConnection();
			String str="delete from student where rno=?";
			PreparedStatement pst=con.prepareStatement(str);
			pst.setInt(1, rno);;
			int n=pst.executeUpdate();
			if(n==0)
			{
				System.out.println("roll number not found");
			}
			else
			{
				System.out.println("Successfully Deleted "+n+" record/s");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
	}//End of deleteStudent

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception
	{
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter rollnumber: ");
		int rno=sc.nextInt();
		sc.nextLine();
		System.out.println("done!!!!");
		System.out.println("Enter name: ");
		String name=sc.nextLine();
		System.out.println("done!!!");
		System.out.println("Enter avg marks: ");
		Double avg=sc.nextDouble();
		System.out.println("done!!!");
		addStudent(rno,name,avg);
		
		//updateStudent(1313,"moses",92.0);

		showAllStudents();
		
		//showStudentByRno(1212);
		//deleteStudent(1212);
	}

}


