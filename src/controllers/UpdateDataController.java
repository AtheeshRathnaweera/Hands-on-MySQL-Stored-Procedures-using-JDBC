package controllers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author atheesh27
 */
public class UpdateDataController {

    public static void updateStudent(Connection conn, String firstName, String lastName, String address, int studentId) {

        try (CallableStatement statement = conn.prepareCall("{call update_student(?, ?, ?, ?)}")) {

            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, address);
            statement.setInt(4, studentId);

            int affectedCount = statement.executeUpdate();
            statement.close();

            if (affectedCount > 0) {
                System.out.println("UpdateController : updateStudent : student update successfully ! " + Integer.toString(affectedCount));
            }else{
                System.out.println("UpdateController : updateStudent : nothing updated ! ");
            }

        } catch (SQLException ex) {
            System.out.println("UpdateController : updateStudent : error occured : " + ex.toString());
        }
    }
    
    public static void updateClass(Connection conn, String grade, String name, int classId) {

        try (CallableStatement statement = conn.prepareCall("{call update_class(?, ?, ?)}")) {

            statement.setString(1, grade);
            statement.setString(2, name);
            statement.setInt(3, classId);

            int affectedCount = statement.executeUpdate();
            statement.close();

            if (affectedCount > 0) {
                System.out.println("UpdateController : updateClass : class update successfully ! " + Integer.toString(affectedCount));
            }else{
                System.out.println("UpdateController : updateClass : nothing updated ! ");
            }

        } catch (SQLException ex) {
            System.out.println("UpdateController : updateClass : error occured : " + ex.toString());
        }
    }
    
    

}
