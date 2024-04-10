package com.cccmant.api_mantenimientos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cccmant.api_mantenimientos.service.UbicacionService;

@RestController
@RequestMapping("/api/v1/ubicaciones")
public class UbicacionController {
    @Autowired
    UbicacionService servicio;

}
