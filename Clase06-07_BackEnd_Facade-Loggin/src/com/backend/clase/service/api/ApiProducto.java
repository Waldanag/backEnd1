package com.backend.clase.service.api;

import com.backend.clase.model.Producto;
import org.apache.log4j.Logger;

public class ApiProducto {

    private static final Logger LOGGER = Logger.getLogger(ApiProducto.class);
    public static int calcularDescuentoProducto(Producto producto){
        int descuento = producto.getTipo().equalsIgnoreCase("latas") ? 10 : 0;
        LOGGER.info("Descuento correspondiente por producto: \n" + producto + "\nDescuento: " + descuento);
        return descuento;
    }

}
