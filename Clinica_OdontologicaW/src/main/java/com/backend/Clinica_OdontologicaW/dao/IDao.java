package com.backend.Clinica_OdontologicaW.dao;

import java.util.List;

public interface IDao <T>{
    T registrar(T t);
    T actualizar(T t);
    List<T> listarTodos();
    T buscarPorId(int id);
}
