package com.backend.clase.service.facade;

import com.backend.clase.model.Producto;
import com.backend.clase.model.Tarjeta;

public interface IDescuento {

    int calcularDesuento(Producto producto, Tarjeta tarjeta, int cantidad);

}
