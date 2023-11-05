package com.backend.estudioParcial.dao.impl;

import com.backend.estudioParcial.dao.IDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PacienteDaoH2 implements IDao<Package> {


    private DomicilioDaoH2 domicilioDaoH2;
    @Override
    public Package registrar(Package aPackage) {
        return null;
    }

    @Override
    public List<Package> listarTodos() {

        Connection connection = null;
        List<Paciente> pacientes = new ArrayList<>();




        return null;
    }

    private Paciente crearObjetoPaciente(ResultSet resultSet){

        Domicilio domicilio = new DomicilioDaoH2().buscarPorId
        return new Paciente(resultSet.getInt("id"), resultSet.getNString("nombre"), resultSet.getNString("apellido"), resultSet.getInt("dni"), resultSet.getDate("fecha").toLocalDate(), domicilio);

    }

}
