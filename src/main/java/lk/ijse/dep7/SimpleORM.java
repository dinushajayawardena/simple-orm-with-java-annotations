package lk.ijse.dep7;

import lk.ijse.dep7.annotation.Table;
import lk.ijse.dep7.util.DBConnection;

import java.lang.reflect.Field;
import java.sql.*;
import java.text.MessageFormat;
import java.util.ArrayList;

@Table("customer")
public class SimpleORM {

    public static void main(String[] args) {

        GenerateTables.init(Customer.class);
        GenerateTables.init(Student.class);
    }

}

class GenerateTables {

    private static Connection connection = DBConnection.getInstance().getConnection();
    private static final String DB_NAME = "dep7_simple_orm";

    public static void init(Class anyClass) {
        Field[] declaredFields = anyClass.getDeclaredFields();

        String className = (anyClass.getSimpleName()).toLowerCase();


        if(declaredFields.length != 0){

            int length = declaredFields.length;
            ArrayList<String> columns = new ArrayList<>();
            ArrayList<String> columnsType = new ArrayList<>();

            for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName() + " - " + declaredField.getType().getSimpleName());
                columns.add(declaredField.getName());
                columnsType.add(declaredField.getType().getSimpleName());
            }

            try {
                Statement statement = connection.createStatement();
                PreparedStatement pstm = connection.prepareStatement("SHOW TABLES LIKE ?");
//                pstm.setString(1, "");
                pstm.setString(1, className);

                ResultSet rst = pstm.executeQuery();

                if(rst.next()) throw new RuntimeException("Table " + className +" already exists");

                StringBuilder sql = new StringBuilder();
                String dataType = "";
                String sqlDataType = "";
                sql.append(MessageFormat.format("CREATE TABLE {0}", className));
                sql.append(" (");

                for (int i = 0; i < length; i++) {

                    switch (dataType){
                        case "String":
                            sqlDataType = "VARCHAR(50) NOT NULL";
                            break;
                        case "int":
                            sqlDataType = "INT NOT NULL";
                            break;
                        default:
                            sqlDataType = "VARCHAR(50) NOT NULL";
                    }

                    sql.append(MessageFormat.format("{0} {1}", columns.get(i), sqlDataType));
                    if(!(i == length - 1))  sql.append(", ");
                }
                sql.append(");");
                System.out.println(sql);

                statement.execute(String.valueOf(sql));

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
