-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-10-2021 a las 02:49:10
-- Versión del servidor: 10.4.19-MariaDB
-- Versión de PHP: 8.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `candy's_spa`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `citas`
--

CREATE TABLE `citas` (
  `idCita` int(11) NOT NULL,
  `idEmpleado` int(11) NOT NULL,
  `idServicio` int(11) NOT NULL,
  `idCliente` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `citas`
--

INSERT INTO `citas` (`idCita`, `idEmpleado`, `idServicio`, `idCliente`, `fecha`, `hora`) VALUES
(1, 1, 1, 1, '2021-06-22', '08:44:00'),
(2, 1, 1, 1, '2021-06-19', '04:30:00');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `idCliente` int(11) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `apellido` varchar(60) NOT NULL,
  `telefono` varchar(12) NOT NULL,
  `correo` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`idCliente`, `nombre`, `apellido`, `telefono`, `correo`) VALUES
(1, 'Silent', 'Hill', '911333333333', '1@client.com');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `idEmpleado` int(11) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `apellido` varchar(60) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `telefono` varchar(12) NOT NULL,
  `estado` varchar(14) NOT NULL,
  `correo` varchar(30) CHARACTER SET armscii8 NOT NULL,
  `password` varchar(100) NOT NULL,
  `idTipo_empleado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`idEmpleado`, `nombre`, `apellido`, `direccion`, `telefono`, `estado`, `correo`, `password`, `idTipo_empleado`) VALUES
(1, 'Admini', 'Admin', 'Dirección del local', '3333333333', 'Activo', 'admin@spa.com', 'd0a1582bb6b4b070685ce108411b2926', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `especializar`
--

CREATE TABLE `especializar` (
  `idEspecializa` int(11) NOT NULL,
  `idEmpleado` int(11) NOT NULL,
  `idServicio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `insumos`
--

CREATE TABLE `insumos` (
  `IdInsumo` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `insumos`
--

INSERT INTO `insumos` (`IdInsumo`, `idProducto`, `cantidad`) VALUES
(1, 1, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `listar`
--

CREATE TABLE `listar` (
  `idListar` int(11) NOT NULL,
  `idEmpleado` int(11) NOT NULL,
  `idServicio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notas_venta`
--

CREATE TABLE `notas_venta` (
  `idNota_venta` int(11) NOT NULL,
  `idCita` int(11) NOT NULL,
  `fecha` datetime NOT NULL,
  `estado` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `notas_venta`
--

INSERT INTO `notas_venta` (`idNota_venta`, `idCita`, `fecha`, `estado`) VALUES
(1, 1, '2021-06-19 04:30:00', 'PAGADO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `idProducto` int(11) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `marca` varchar(30) NOT NULL,
  `costo` double NOT NULL,
  `precio` double NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `idTipo_producto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`idProducto`, `nombre`, `marca`, `costo`, `precio`, `descripcion`, `idTipo_producto`) VALUES
(1, 'Aceite de manzana', 'LaManzanee', 900, 120, 'Aceite corporal con aroma a manzana', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicios`
--

CREATE TABLE `servicios` (
  `idServicio` int(11) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `precio` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `servicios`
--

INSERT INTO `servicios` (`idServicio`, `nombre`, `descripcion`, `precio`) VALUES
(1, 'Masaje express', 'Masaje de media hora en el área de la espalda, hombros y cabeza.', 300);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_empleado`
--

CREATE TABLE `tipo_empleado` (
  `idTipo_empleado` int(11) NOT NULL,
  `nombre` varchar(20) NOT NULL,
  `descripcion` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipo_empleado`
--

INSERT INTO `tipo_empleado` (`idTipo_empleado`, `nombre`, `descripcion`) VALUES
(1, 'Administrador', 'Nivel de usuario donde se puede administrar todo el sistema.'),
(2, 'Almacenista', 'Encargado de organizar y almacenar los producto que vayan llegando.'),
(3, 'Recepcionista', 'Encargado de la agenda de citas, pagos y impresión de tickets'),
(4, 'Masajista', 'Puesto del empleado común, da al cliente el servicio de masaje y su determinada especialidad');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_producto`
--

CREATE TABLE `tipo_producto` (
  `idTipo_producto` int(11) NOT NULL,
  `categoria` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tipo_producto`
--

INSERT INTO `tipo_producto` (`idTipo_producto`, `categoria`) VALUES
(1, 'Lubricantes');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `citas`
--
ALTER TABLE `citas`
  ADD PRIMARY KEY (`idCita`),
  ADD KEY `idEmpleado` (`idEmpleado`,`idServicio`,`idCliente`),
  ADD KEY `idCliente` (`idCliente`),
  ADD KEY `idServicio` (`idServicio`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`idCliente`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`idEmpleado`),
  ADD KEY `idTipo_empleado` (`idTipo_empleado`);

--
-- Indices de la tabla `especializar`
--
ALTER TABLE `especializar`
  ADD PRIMARY KEY (`idEspecializa`),
  ADD KEY `idEmpleado` (`idEmpleado`),
  ADD KEY `idServicio` (`idServicio`);

--
-- Indices de la tabla `insumos`
--
ALTER TABLE `insumos`
  ADD PRIMARY KEY (`IdInsumo`),
  ADD KEY `idProducto` (`idProducto`);

--
-- Indices de la tabla `listar`
--
ALTER TABLE `listar`
  ADD PRIMARY KEY (`idListar`),
  ADD KEY `idEmpleado` (`idEmpleado`,`idServicio`),
  ADD KEY `idServicio` (`idServicio`);

--
-- Indices de la tabla `notas_venta`
--
ALTER TABLE `notas_venta`
  ADD PRIMARY KEY (`idNota_venta`),
  ADD KEY `idCita` (`idCita`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`idProducto`),
  ADD KEY `idTipo_producto` (`idTipo_producto`);

--
-- Indices de la tabla `servicios`
--
ALTER TABLE `servicios`
  ADD PRIMARY KEY (`idServicio`);

--
-- Indices de la tabla `tipo_empleado`
--
ALTER TABLE `tipo_empleado`
  ADD PRIMARY KEY (`idTipo_empleado`);

--
-- Indices de la tabla `tipo_producto`
--
ALTER TABLE `tipo_producto`
  ADD PRIMARY KEY (`idTipo_producto`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `citas`
--
ALTER TABLE `citas`
  MODIFY `idCita` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `clientes`
--
ALTER TABLE `clientes`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `empleados`
--
ALTER TABLE `empleados`
  MODIFY `idEmpleado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `especializar`
--
ALTER TABLE `especializar`
  MODIFY `idEspecializa` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `insumos`
--
ALTER TABLE `insumos`
  MODIFY `IdInsumo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `listar`
--
ALTER TABLE `listar`
  MODIFY `idListar` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `notas_venta`
--
ALTER TABLE `notas_venta`
  MODIFY `idNota_venta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `servicios`
--
ALTER TABLE `servicios`
  MODIFY `idServicio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `tipo_empleado`
--
ALTER TABLE `tipo_empleado`
  MODIFY `idTipo_empleado` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `tipo_producto`
--
ALTER TABLE `tipo_producto`
  MODIFY `idTipo_producto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `citas`
--
ALTER TABLE `citas`
  ADD CONSTRAINT `citas_ibfk_1` FOREIGN KEY (`idEmpleado`) REFERENCES `empleados` (`idEmpleado`),
  ADD CONSTRAINT `citas_ibfk_2` FOREIGN KEY (`idCliente`) REFERENCES `clientes` (`idCliente`),
  ADD CONSTRAINT `citas_ibfk_3` FOREIGN KEY (`idServicio`) REFERENCES `servicios` (`idServicio`);

--
-- Filtros para la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD CONSTRAINT `empleados_ibfk_1` FOREIGN KEY (`idTipo_empleado`) REFERENCES `tipo_empleado` (`idTipo_empleado`);

--
-- Filtros para la tabla `especializar`
--
ALTER TABLE `especializar`
  ADD CONSTRAINT `especializar_ibfk_1` FOREIGN KEY (`idEmpleado`) REFERENCES `empleados` (`idEmpleado`),
  ADD CONSTRAINT `especializar_ibfk_2` FOREIGN KEY (`idServicio`) REFERENCES `servicios` (`idServicio`);

--
-- Filtros para la tabla `insumos`
--
ALTER TABLE `insumos`
  ADD CONSTRAINT `insumos_ibfk_1` FOREIGN KEY (`idProducto`) REFERENCES `productos` (`idProducto`);

--
-- Filtros para la tabla `listar`
--
ALTER TABLE `listar`
  ADD CONSTRAINT `listar_ibfk_1` FOREIGN KEY (`idEmpleado`) REFERENCES `empleados` (`idEmpleado`),
  ADD CONSTRAINT `listar_ibfk_2` FOREIGN KEY (`idServicio`) REFERENCES `servicios` (`idServicio`);

--
-- Filtros para la tabla `notas_venta`
--
ALTER TABLE `notas_venta`
  ADD CONSTRAINT `notas_venta_ibfk_1` FOREIGN KEY (`idCita`) REFERENCES `citas` (`idCita`);

--
-- Filtros para la tabla `productos`
--
ALTER TABLE `productos`
  ADD CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`idTipo_producto`) REFERENCES `tipo_producto` (`idTipo_producto`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
