-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-06-2024 a las 18:07:25
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
  `codigo` bigint(20) NOT NULL,
  `fecha` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `p1` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `p2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `p3` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `p4` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `p5` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `n1` text CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `n2` text CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `n3` text CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `n4` text CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `n5` text CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `codigo_equipo` int(11) DEFAULT NULL,
  `identificacion_tecnico` bigint(20) DEFAULT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cmms_controlpreventivo`
--

CREATE TABLE `cmms_controlpreventivo` (
  `codigo` int(11) NOT NULL,
  `fecha` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `p1` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `p2` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `p3` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `p4` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `p5` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `p6` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `p7` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `p8` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `p9` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `codigo_equipo` int(11) DEFAULT NULL,
  `identificacion_tecnico` bigint(20) DEFAULT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cmms_equipos`
--

CREATE TABLE `cmms_equipos` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `costo` bigint(12) NOT NULL,
  `modelo` varchar(255) NOT NULL,
  `numero_serial` varchar(255) NOT NULL,
  `fecha_compra` text NOT NULL,
  `fecha_garantia` text NOT NULL,
  `fabricante` text DEFAULT NULL,
  `ubicacion_codigo` int(11) DEFAULT NULL,
  `plan_mantenimiento` varchar(255) NOT NULL,
  ` 	proveedor_identificacion` int(11) DEFAULT NULL,
  `usuario_identificacion` bigint(20) DEFAULT NULL,
  `notas` text DEFAULT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `proveedor_identificacion` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cmms_fallas`
--

CREATE TABLE `cmms_fallas` (
  `codigo` int(11) NOT NULL,
  `motivo` text NOT NULL,
  `fecha` text NOT NULL,
  `codigo_equipo` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cmms_mantenimientos`
--

CREATE TABLE `cmms_mantenimientos` (
  `codigo` bigint(20) NOT NULL,
  `fecha_inicio` varchar(255) NOT NULL,
  `fecha_final` varchar(255) NOT NULL,
  `falla_codigo` int(11) DEFAULT NULL,
  `tecnico_identificacion` bigint(20) DEFAULT NULL,
  `controlipcodigo` int(11) DEFAULT NULL,
  `descripcion` text NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cmms_ordencorretiva`
--

CREATE TABLE `cmms_ordencorretiva` (
  `codigo` bigint(20) NOT NULL,
  `fecha_inicio` text NOT NULL,
  `fecha_final` text NOT NULL,
  `descripcion` text NOT NULL,
  `costo` bigint(20) DEFAULT NULL,
  `prioridad` varchar(255) NOT NULL,
  `cantidad_repuestos` bigint(20) DEFAULT NULL,
  `r1` int(11) DEFAULT NULL,
  `r2` int(11) DEFAULT NULL,
  `r3` int(11) DEFAULT NULL,
  `r4` int(11) DEFAULT NULL,
  `identificación_tecnico` bigint(20) DEFAULT NULL,
  `codigo_equipo` int(11) DEFAULT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cmms_proveedores`
--

CREATE TABLE `cmms_proveedores` (
  `identificacion` int(11) NOT NULL,
  `razon_social` varchar(255) NOT NULL,
  `telefono` bigint(20) NOT NULL,
  `correo_electronico` varchar(255) NOT NULL,
  `notas` text DEFAULT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cmms_repuestos`
--

CREATE TABLE `cmms_repuestos` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `imagen` varchar(255) DEFAULT NULL,
  `cantidad` bigint(20) DEFAULT NULL,
  `costo_unitario` bigint(12) NOT NULL,
  `proveedor_identificacion` int(11) DEFAULT NULL,
  `codigo_equipo` int(11) DEFAULT NULL,
  `createdAt` datetime NOT NULL,
  `updatedAt` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cmms_tecnicos`
--

CREATE TABLE `cmms_tecnicos` (
  `identificacion` bigint(20) NOT NULL,
  `rol` varchar(255) NOT NULL,
  `nombres` varchar(255) NOT NULL,
  `apellidos` varchar(255) NOT NULL,
  `telefono` bigint(20) NOT NULL,
  `correo_electronico` varchar(255) NOT NULL,
  `horas_laborales` bigint(20) DEFAULT NULL,
  `contraseña` varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `cmms_tecnicos`
--

INSERT INTO `cmms_tecnicos` (`identificacion`, `rol`, `nombres`, `apellidos`, `telefono`, `correo_electronico`, `horas_laborales`, `contraseña`, `created_at`, `updated_at`) VALUES
(1115866620, 'ADMIN', 'Neyris', 'Bohorquez', 3013466434, 'ejemplo@gmail.com', 40, '$2a$10$CvDx4urgJTc9WbEhd6SvAOHr3pj118LYFQ2JtZh2V1nr69L1EDNES', '2024-06-05 14:48:08', '2024-06-05 14:48:08');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cmms_ubicaciones`
--

CREATE TABLE `cmms_ubicaciones` (
  `codigo` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `sede` varchar(255) NOT NULL,
  `created_at` datetime DEFAULT current_timestamp(),
  `updated_at` datetime DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `cmms_ubicaciones`
--

INSERT INTO `cmms_ubicaciones` (`codigo`, `nombre`, `sede`, `created_at`, `updated_at`) VALUES
(0, 'Ubicación de prueba', 'Sede de prueba', '2024-04-17 14:53:08', '2024-04-17 14:53:08');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cmms_usuarios`
--

CREATE TABLE `cmms_usuarios` (
  `codigo` bigint(20) NOT NULL,
  `nombres` varchar(255) NOT NULL,
  `apellidos` varchar(255) NOT NULL,
  `correo_electronico` varchar(255) DEFAULT NULL,
  `ubicacion_codigo` int(11) DEFAULT NULL,
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
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `CodigoEquipo` (`codigo_equipo`),
  ADD KEY `IdentificacionTecnico` (`identificacion_tecnico`);

--
-- Indices de la tabla `cmms_controlpreventivo`
--
ALTER TABLE `cmms_controlpreventivo`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `CodigoEquipo` (`codigo_equipo`),
  ADD KEY `IdentificacionTecnico` (`identificacion_tecnico`);

--
-- Indices de la tabla `cmms_equipos`
--
ALTER TABLE `cmms_equipos`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `UbicacionCodigo` (`ubicacion_codigo`),
  ADD KEY `ProveedorIdentificacion` (` 	proveedor_identificacion`),
  ADD KEY `UsuarioIdentificacion` (`usuario_identificacion`);

--
-- Indices de la tabla `cmms_fallas`
--
ALTER TABLE `cmms_fallas`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `CodigoEquipo` (`codigo_equipo`);

--
-- Indices de la tabla `cmms_mantenimientos`
--
ALTER TABLE `cmms_mantenimientos`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `TecnicoIdentificacion` (`tecnico_identificacion`),
  ADD KEY `ControlPCodigo` (`controlipcodigo`),
  ADD KEY `Mantenimientos_ibfk_2` (`falla_codigo`);

--
-- Indices de la tabla `cmms_ordencorretiva`
--
ALTER TABLE `cmms_ordencorretiva`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `IdentificacionTecnico` (`identificación_tecnico`),
  ADD KEY `CodigoEquipo` (`codigo_equipo`),
  ADD KEY `RepuestoUno` (`r1`) USING BTREE,
  ADD KEY `RepuestosDos` (`r2`),
  ADD KEY `RepuestosTres` (`r3`),
  ADD KEY `RepuestoCuatro` (`r4`);

--
-- Indices de la tabla `cmms_proveedores`
--
ALTER TABLE `cmms_proveedores`
  ADD PRIMARY KEY (`identificacion`);

--
-- Indices de la tabla `cmms_repuestos`
--
ALTER TABLE `cmms_repuestos`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `ProveedorIdentificacion` (`proveedor_identificacion`),
  ADD KEY `CodigoEquipo` (`codigo_equipo`);

--
-- Indices de la tabla `cmms_tecnicos`
--
ALTER TABLE `cmms_tecnicos`
  ADD PRIMARY KEY (`identificacion`);

--
-- Indices de la tabla `cmms_ubicaciones`
--
ALTER TABLE `cmms_ubicaciones`
  ADD PRIMARY KEY (`codigo`);

--
-- Indices de la tabla `cmms_usuarios`
--
ALTER TABLE `cmms_usuarios`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `UbicacionCodigo` (`ubicacion_codigo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cmms_controlcorrectivo`
--
ALTER TABLE `cmms_controlcorrectivo`
  MODIFY `codigo` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `cmms_mantenimientos`
--
ALTER TABLE `cmms_mantenimientos`
  MODIFY `codigo` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `cmms_ordencorretiva`
--
ALTER TABLE `cmms_ordencorretiva`
  MODIFY `codigo` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `cmms_usuarios`
--
ALTER TABLE `cmms_usuarios`
  MODIFY `codigo` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9999999;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cmms_controlcorrectivo`
--
ALTER TABLE `cmms_controlcorrectivo`
  ADD CONSTRAINT `Correctivo_ibfk_1` FOREIGN KEY (`codigo_equipo`) REFERENCES `cmms_equipos` (`codigo`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `Correctivo_ibfk_2` FOREIGN KEY (`identificacion_tecnico`) REFERENCES `cmms_tecnicos` (`Identificacion`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Filtros para la tabla `cmms_controlpreventivo`
--
ALTER TABLE `cmms_controlpreventivo`
  ADD CONSTRAINT `Preventivo_ibfk_1` FOREIGN KEY (`identificacion_tecnico`) REFERENCES `cmms_tecnicos` (`Identificacion`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `Preventivo_ibfk_2` FOREIGN KEY (`codigo_equipo`) REFERENCES `cmms_equipos` (`codigo`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Filtros para la tabla `cmms_equipos`
--
ALTER TABLE `cmms_equipos`
  ADD CONSTRAINT `Equipos_ibfk_1` FOREIGN KEY (` 	proveedor_identificacion`) REFERENCES `cmms_proveedores` (`Identificacion`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `Equipos_ibfk_2` FOREIGN KEY (`ubicacion_codigo`) REFERENCES `cmms_ubicaciones` (`codigo`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `Equipos_ibfk_3` FOREIGN KEY (`usuario_identificacion`) REFERENCES `cmms_usuarios` (`Codigo`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Filtros para la tabla `cmms_fallas`
--
ALTER TABLE `cmms_fallas`
  ADD CONSTRAINT `Fallas_ibfk_1` FOREIGN KEY (`codigo_equipo`) REFERENCES `cmms_equipos` (`codigo`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Filtros para la tabla `cmms_mantenimientos`
--
ALTER TABLE `cmms_mantenimientos`
  ADD CONSTRAINT `Mantenimientos_ibfk_1` FOREIGN KEY (`controlipcodigo`) REFERENCES `cmms_controlpreventivo` (`Codigo`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `Mantenimientos_ibfk_2` FOREIGN KEY (`falla_codigo`) REFERENCES `cmms_fallas` (`codigo`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `Mantenimientos_ibfk_3` FOREIGN KEY (`tecnico_identificacion`) REFERENCES `cmms_tecnicos` (`Identificacion`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Filtros para la tabla `cmms_ordencorretiva`
--
ALTER TABLE `cmms_ordencorretiva`
  ADD CONSTRAINT `Orden_ibfk_1` FOREIGN KEY (`codigo_equipo`) REFERENCES `cmms_equipos` (`codigo`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `Orden_ibfk_2` FOREIGN KEY (`identificación_tecnico`) REFERENCES `cmms_tecnicos` (`Identificacion`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `Orden_ibfk_3` FOREIGN KEY (`R1`) REFERENCES `cmms_repuestos` (`Codigo`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `Orden_ibfk_4` FOREIGN KEY (`R2`) REFERENCES `cmms_repuestos` (`Codigo`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `Orden_ibfk_5` FOREIGN KEY (`R3`) REFERENCES `cmms_repuestos` (`Codigo`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `Orden_ibfk_6` FOREIGN KEY (`R4`) REFERENCES `cmms_repuestos` (`Codigo`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Filtros para la tabla `cmms_repuestos`
--
ALTER TABLE `cmms_repuestos`
  ADD CONSTRAINT `Repuestos_ibfk_1` FOREIGN KEY (`codigo_equipo`) REFERENCES `cmms_equipos` (`codigo`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `Repuestos_ibfk_2` FOREIGN KEY (`proveedor_identificacion`) REFERENCES `cmms_proveedores` (`Identificacion`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Filtros para la tabla `cmms_usuarios`
--
ALTER TABLE `cmms_usuarios`
  ADD CONSTRAINT `Usuario_ibfk_1` FOREIGN KEY (`ubicacion_codigo`) REFERENCES `cmms_ubicaciones` (`codigo`) ON DELETE SET NULL ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
