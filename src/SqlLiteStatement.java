import java.sql.*;

public class SqlLiteStatement {

    public static void main(String... args) {

        //int dept_no = Integer.parseInt(args[0]);
        //String dnombre = args[1];
        //String loc = args[2];

        int dept_no = 50; //Integer.parseInt(args[0]);
        String dnombre = "Prueba"; //args[1];
        String loc = "XXX"; //args[2];

        System.out.println(dept_no + " " + dnombre + " " + loc);
        insertarDepartamento(dept_no, dnombre, loc);
    }

    static String connectionUrl = "jdbc:sqlite:file:C:/AD/sqlite/ejemplo.db";

    public static int insertarDepartamento(int dept_no, String dnombre, String loc) {
        try {
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Departamentos VALUES (?,?,?)");
            stmt.setInt(1, dept_no);
            stmt.setString(2, dnombre);
            stmt.setString(3, loc);
            int affectedRows = stmt.executeUpdate();
            conn.close();
            return affectedRows;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getSQLState());
        }
        return 0;
    }
}
