package com.backend.clase;

import org.apache.log4j.Logger;

import java.sql.*;

public class Animal {

    public static void main(String[] args) {
        Logger LOGGER = Logger.getLogger(Animal.class);

        String create = "DROP TABLE IF EXISTS ANIMALES; CREATE TABLE ANIMALES (ID INT AUTO_INCREMENT PRIMARY KEY, NOMBRE VARCHAR(50) NOT NULL, TIPO VARCHAR(50) NOT NULL)";
        String insert = "INSERT INTO ANIMALES (NOMBRE, TIPO) VALUES ('Firulais', 'Perro'), ('Lola', 'Vaca'), ('Homero', 'Perro'), ('Pepe', 'Sapo'), ('Tuki', 'Loro')";
        String delete = "DELETE FROM ANIMALES WHERE ID = 1";
        String select = "SELECT * FROM ANIMALES";

        Connection connection = null;
        try {
            connection = getConnection();
            //crear table
            Statement statement = connection.createStatement();
            statement.execute(create);
            //insertar registros
            statement.execute(insert);
            //hacer un select para obtener registros
            ResultSet resultSet = statement.executeQuery(select);
            //recorrer el resultado
            while (resultSet.next()){
                LOGGER.info("Animal: " + resultSet.getNString("nombre") + " - " + resultSet.getNString(3));
            }
            //eliminar un elemento
            statement.execute(delete);
            LOGGER.info("-----------------------------");

            resultSet = statement.executeQuery(select);
            //recorrer el resultado
            while (resultSet.next()){
                LOGGER.info("Animal: " + resultSet.getNString("nombre") + " - " + resultSet.getNString(3));
            }
        } catch (Exception exception){
            LOGGER.error(exception.getMessage());
        } finally {
            try {
                connection.close();
            } catch (Exception e){
                LOGGER.error(e.getMessage());
            }
        }
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        //indicar el driver a utilizar
        Class.forName("org.h2.Driver");
        //crear la conexion
        return DriverManager.getConnection("jdbc:h2:~/c1clase8", "sa", "sa");
    }

}
