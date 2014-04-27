import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class Baglanti {
	
	public static void Baglan(){
		try
		{
			String connectionString = "jdbc:mysql:///DatabaseIsmi";
			Class.forName("com.mysql.jdbc.Driver");
			Connection baglanti = (Connection) DriverManager.getConnection(connectionString);
			try{
				String SQL = "SELECT * FROM tabloAdi";
				Statement durum = (Statement) baglanti.createStatement();
				ResultSet rs = (ResultSet) durum.executeQuery(SQL);
				
				while(rs.next()){
					System.out.println(rs.getString("tablodakiAlanAdi"));
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Baglan();

	}

}
