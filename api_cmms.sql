-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-04-2024 a las 01:14:24
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `api_cmms`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cmms_controlcorrectivo`
--

CREATE TABLE `cmms_controlcorrectivo` (
  `Codigo` int(11) NOT NULL,
  `Fecha` varchar(255) NOT NULL,
  `P1` varchar(255) NOT NULL,
  `P2` varchar(255) NOT NULL,
  `P3` varchar(255) NOT NULL,
  `P4` varchar(255) NOT NULL,
  `P5` varchar(255) NOT NULL,
  `N1` text DEFAULT NULL,
  `N2` text DEFAULT NULL,
  `N3` text DEFAULT NULL,
  `N4` text DEFAULT NULL,
  `N5` text DEFAULT NULL,
  `CodigoEquipo` int(11) DEFAULT NULL,
  `IdentificacionTecnico` bigint(20) DEFAULT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cmms_controlpreventivo`
--

CREATE TABLE `cmms_controlpreventivo` (
  `Codigo` int(11) NOT NULL,
  `Fecha` varchar(255) NOT NULL,
  `P1` varchar(255) NOT NULL,
  `P2` varchar(255) NOT NULL,
  `P3` varchar(255) NOT NULL,
  `P4` varchar(255) NOT NULL,
  `P5` varchar(255) NOT NULL,
  `P6` varchar(255) NOT NULL,
  `P7` varchar(255) NOT NULL,
  `P8` varchar(255) NOT NULL,
  `P9` varchar(255) NOT NULL,
  `CodigoEquipo` int(11) DEFAULT NULL,
  `IdentificacionTecnico` bigint(20) DEFAULT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cmms_equipos`
--

CREATE TABLE `cmms_equipos` (
  `Codigo` int(11) NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  `Imagen` varchar(255) DEFAULT NULL,
  `Costo` bigint(12) NOT NULL,
  `Modelo` varchar(255) NOT NULL,
  `NumeroSerial` varchar(255) NOT NULL,
  `FechaCompra` text NOT NULL,
  `FechaGarantia` text NOT NULL,
  `Fabricante` text DEFAULT NULL,
  `UbicacionCodigo` int(11) DEFAULT NULL,
  `PlanMantenimiento` varchar(255) NOT NULL,
  `ProveedorIdentificacion` int(11) DEFAULT NULL,
  `UsuarioIdentificacion` bigint(20) DEFAULT NULL,
  `Notas` text DEFAULT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cmms_fallas`
--

CREATE TABLE `cmms_fallas` (
  `Codigo` int(11) NOT NULL,
  `Motivo` text NOT NULL,
  `Fecha` text NOT NULL,
  `CodigoEquipo` int(11) DEFAULT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cmms_mantenimientos`
--

CREATE TABLE `cmms_mantenimientos` (
  `Codigo` int(11) NOT NULL,
  `FechaInicio` varchar(255) NOT NULL,
  `FechaFinal` varchar(255) NOT NULL,
  `FallaCodigo` int(11) DEFAULT NULL,
  `TecnicoIdentificacion` bigint(20) DEFAULT NULL,
  `ControlPCodigo` int(11) DEFAULT NULL,
  `Descripcion` text NOT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cmms_ordencorretiva`
--

CREATE TABLE `cmms_ordencorretiva` (
  `Codigo` int(11) NOT NULL,
  `FechaInicio` text NOT NULL,
  `FechaFinal` text NOT NULL,
  `Descripcion` text NOT NULL,
  `Costo` int(11) NOT NULL,
  `Prioridad` varchar(255) NOT NULL,
  `CantidadRepuestos` int(11) DEFAULT NULL,
  `RepuestosUno` int(11) DEFAULT NULL,
  `RepuestosDos` int(11) DEFAULT NULL,
  `RepuestosTres` int(11) DEFAULT NULL,
  `RepuestosCuatro` int(11) DEFAULT NULL,
  `IdentificacionTecnico` bigint(20) DEFAULT NULL,
  `CodigoEquipo` int(11) DEFAULT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cmms_proveedores`
--

CREATE TABLE `cmms_proveedores` (
  `Identificacion` int(11) NOT NULL,
  `RazonSocial` varchar(255) NOT NULL,
  `Telefono` bigint(20) NOT NULL,
  `CorreoElectronico` varchar(255) NOT NULL,
  `Notas` text DEFAULT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cmms_repuestos`
--

CREATE TABLE `cmms_repuestos` (
  `Codigo` int(11) NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  `Imagen` varchar(255) DEFAULT NULL,
  `Cantidad` int(11) NOT NULL,
  `CostoUnitario` bigint(12) NOT NULL,
  `ProveedorIdentificacion` int(11) DEFAULT NULL,
  `CodigoEquipo` int(11) DEFAULT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cmms_tecnicos`
--

CREATE TABLE `cmms_tecnicos` (
  `Identificacion` bigint(20) NOT NULL,
  `Nombres` varchar(255) NOT NULL,
  `Apellidos` varchar(255) NOT NULL,
  `Telefono` bigint(20) NOT NULL,
  `CorreoElectronico` varchar(255) NOT NULL,
  `HorasLaborales` int(11) DEFAULT NULL,
  `Contraseña` varchar(255) NOT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cmms_ubicaciones`
--

CREATE TABLE `cmms_ubicaciones` (
  `Codigo` int(11) NOT NULL,
  `Nombre` varchar(255) NOT NULL,
  `Sede` varchar(255) NOT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cmms_usuarios`
--

CREATE TABLE `cmms_usuarios` (
  `Codigo` bigint(20) NOT NULL,
  `Nombres` varchar(255) NOT NULL,
  `Apellidos` varchar(255) NOT NULL,
  `CorreoElectronico` varchar(255) DEFAULT NULL,
  `UbicacionCodigo` int(11) DEFAULT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cmms_controlcorrectivo`
--
ALTER TABLE `cmms_controlcorrectivo`
  ADD PRIMARY KEY (`Codigo`),
  ADD KEY `CodigoEquipo` (`CodigoEquipo`),
  ADD KEY `IdentificacionTecnico` (`IdentificacionTecnico`);

--
-- Indices de la tabla `cmms_controlpreventivo`
--
ALTER TABLE `cmms_controlpreventivo`
  ADD PRIMARY KEY (`Codigo`),
  ADD KEY `CodigoEquipo` (`CodigoEquipo`),
  ADD KEY `IdentificacionTecnico` (`IdentificacionTecnico`);

--
-- Indices de la tabla `cmms_equipos`
--
ALTER TABLE `cmms_equipos`
  ADD PRIMARY KEY (`Codigo`),
  ADD KEY `UbicacionCodigo` (`UbicacionCodigo`),
  ADD KEY `ProveedorIdentificacion` (`ProveedorIdentificacion`),
  ADD KEY `UsuarioIdentificacion` (`UsuarioIdentificacion`);

--
-- Indices de la tabla `cmms_fallas`
--
ALTER TABLE `cmms_fallas`
  ADD PRIMARY KEY (`Codigo`),
  ADD KEY `CodigoEquipo` (`CodigoEquipo`);

--
-- Indices de la tabla `cmms_mantenimientos`
--
ALTER TABLE `cmms_mantenimientos`
  ADD PRIMARY KEY (`Codigo`),
  ADD KEY `TecnicoIdentificacion` (`TecnicoIdentificacion`),
  ADD KEY `ControlPCodigo` (`ControlPCodigo`),
  ADD KEY `Mantenimientos_ibfk_2` (`FallaCodigo`);

--
-- Indices de la tabla `cmms_ordencorretiva`
--
ALTER TABLE `cmms_ordencorretiva`
  ADD PRIMARY KEY (`Codigo`),
  ADD KEY `IdentificacionTecnico` (`IdentificacionTecnico`),
  ADD KEY `CodigoEquipo` (`CodigoEquipo`),
  ADD KEY `RepuestoUno` (`RepuestosUno`) USING BTREE,
  ADD KEY `RepuestosDos` (`RepuestosDos`),
  ADD KEY `RepuestosTres` (`RepuestosTres`),
  ADD KEY `RepuestoCuatro` (`RepuestosCuatro`);

--
-- Indices de la tabla `cmms_proveedores`
--
ALTER TABLE `cmms_proveedores`
  ADD PRIMARY KEY (`Identificacion`);

--
-- Indices de la tabla `cmms_repuestos`
--
ALTER TABLE `cmms_repuestos`
  ADD PRIMARY KEY (`Codigo`),
  ADD KEY `ProveedorIdentificacion` (`ProveedorIdentificacion`),
  ADD KEY `CodigoEquipo` (`CodigoEquipo`);

--
-- Indices de la tabla `cmms_tecnicos`
--
ALTER TABLE `cmms_tecnicos`
  ADD PRIMARY KEY (`Identificacion`);

--
-- Indices de la tabla `cmms_ubicaciones`
--
ALTER TABLE `cmms_ubicaciones`
  ADD PRIMARY KEY (`Codigo`);

--
-- Indices de la tabla `cmms_usuarios`
--
ALTER TABLE `cmms_usuarios`
  ADD PRIMARY KEY (`Codigo`),
  ADD KEY `UbicacionCodigo` (`UbicacionCodigo`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cmms_controlcorrectivo`
--
ALTER TABLE `cmms_controlcorrectivo`
  ADD CONSTRAINT `Correctivo_ibfk_1` FOREIGN KEY (`CodigoEquipo`) REFERENCES `cmms_equipos` (`Codigo`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `Correctivo_ibfk_2` FOREIGN KEY (`IdentificacionTecnico`) REFERENCES `cmms_tecnicos` (`Identificacion`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Filtros para la tabla `cmms_controlpreventivo`
--
ALTER TABLE `cmms_controlpreventivo`
  ADD CONSTRAINT `Preventivo_ibfk_1` FOREIGN KEY (`IdentificacionTecnico`) REFERENCES `cmms_tecnicos` (`Identificacion`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `Preventivo_ibfk_2` FOREIGN KEY (`CodigoEquipo`) REFERENCES `cmms_equipos` (`Codigo`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Filtros para la tabla `cmms_equipos`
--
ALTER TABLE `cmms_equipos`
  ADD CONSTRAINT `Equipos_ibfk_1` FOREIGN KEY (`ProveedorIdentificacion`) REFERENCES `cmms_proveedores` (`Identificacion`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `Equipos_ibfk_2` FOREIGN KEY (`UbicacionCodigo`) REFERENCES `cmms_ubicaciones` (`Codigo`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `Equipos_ibfk_3` FOREIGN KEY (`UsuarioIdentificacion`) REFERENCES `cmms_usuarios` (`Codigo`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Filtros para la tabla `cmms_fallas`
--
ALTER TABLE `cmms_fallas`
  ADD CONSTRAINT `Fallas_ibfk_1` FOREIGN KEY (`CodigoEquipo`) REFERENCES `cmms_equipos` (`Codigo`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Filtros para la tabla `cmms_mantenimientos`
--
ALTER TABLE `cmms_mantenimientos`
  ADD CONSTRAINT `Mantenimientos_ibfk_1` FOREIGN KEY (`ControlPCodigo`) REFERENCES `cmms_controlpreventivo` (`Codigo`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `Mantenimientos_ibfk_2` FOREIGN KEY (`FallaCodigo`) REFERENCES `cmms_fallas` (`Codigo`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `Mantenimientos_ibfk_3` FOREIGN KEY (`TecnicoIdentificacion`) REFERENCES `cmms_tecnicos` (`Identificacion`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Filtros para la tabla `cmms_ordencorretiva`
--
ALTER TABLE `cmms_ordencorretiva`
  ADD CONSTRAINT `Orden_ibfk_1` FOREIGN KEY (`CodigoEquipo`) REFERENCES `cmms_equipos` (`Codigo`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `Orden_ibfk_2` FOREIGN KEY (`IdentificacionTecnico`) REFERENCES `cmms_tecnicos` (`Identificacion`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `Orden_ibfk_3` FOREIGN KEY (`RepuestosUno`) REFERENCES `cmms_repuestos` (`Codigo`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `Orden_ibfk_4` FOREIGN KEY (`RepuestosDos`) REFERENCES `cmms_repuestos` (`Codigo`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `Orden_ibfk_5` FOREIGN KEY (`RepuestosTres`) REFERENCES `cmms_repuestos` (`Codigo`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `Orden_ibfk_6` FOREIGN KEY (`RepuestosCuatro`) REFERENCES `cmms_repuestos` (`Codigo`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Filtros para la tabla `cmms_repuestos`
--
ALTER TABLE `cmms_repuestos`
  ADD CONSTRAINT `Repuestos_ibfk_1` FOREIGN KEY (`CodigoEquipo`) REFERENCES `cmms_equipos` (`Codigo`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `Repuestos_ibfk_2` FOREIGN KEY (`ProveedorIdentificacion`) REFERENCES `cmms_proveedores` (`Identificacion`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Filtros para la tabla `cmms_usuarios`
--
ALTER TABLE `cmms_usuarios`
  ADD CONSTRAINT `Usuario_ibfk_1` FOREIGN KEY (`UbicacionCodigo`) REFERENCES `cmms_ubicaciones` (`Codigo`) ON DELETE SET NULL ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
