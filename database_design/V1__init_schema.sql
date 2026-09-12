-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Table `rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rol` (
  `id_rol` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre_rol` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_rol`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usuario` (
  `id_usuario` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre_usuario` VARCHAR(100) NOT NULL,
  `apellido_usuario` VARCHAR(100) NOT NULL,
  `correo` VARCHAR(150) NOT NULL,
  `password` VARCHAR(150) NOT NULL,
  `activo` TINYINT(1) NOT NULL DEFAULT 1,
  `id_rol_fk` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE INDEX `id_usuario_UNIQUE` (`id_usuario` ASC),
  INDEX `fk_usuario_rol_idx` (`id_rol_fk` ASC),
  CONSTRAINT `fk_usuario_rol`
    FOREIGN KEY (`id_rol_fk`)
    REFERENCES `rol` (`id_rol`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `grupo_muscular`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `grupo_muscular` (
  `id_grupo_muscular` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre_grupo_muscular` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_grupo_muscular`),
  UNIQUE INDEX `nombre_grupo_muscular_UNIQUE` (`nombre_grupo_muscular` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ejercicio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ejercicio` (
  `id_ejercicio` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre_ejercicio` VARCHAR(100) NOT NULL,
  `descripcion_tecnica` TEXT NOT NULL,
  `enlace_video` VARCHAR(255) NOT NULL,
  `id_grupo_muscular_fk` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_ejercicio`),
  UNIQUE INDEX `nombre_ejercicio_UNIQUE` (`nombre_ejercicio` ASC),
  INDEX `fk_ejercicio_grupo_muscular1_idx` (`id_grupo_muscular_fk` ASC),
  CONSTRAINT `fk_ejercicio_grupo_muscular1`
    FOREIGN KEY (`id_grupo_muscular_fk`)
    REFERENCES `grupo_muscular` (`id_grupo_muscular`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `objetivo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `objetivo` (
  `id_objetivo` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre_objetivo` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_objetivo`),
  UNIQUE INDEX `nombre_objetivo_UNIQUE` (`nombre_objetivo` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `rutina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `rutina` (
  `id_rutina` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre_rutina` VARCHAR(100) NOT NULL,
  `id_objetivo_fk` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_rutina`),
  UNIQUE INDEX `nombre_rutina_UNIQUE` (`nombre_rutina` ASC),
  INDEX `fk_rutina_objetivo1_idx` (`id_objetivo_fk` ASC),
  CONSTRAINT `fk_rutina_objetivo1`
    FOREIGN KEY (`id_objetivo_fk`)
    REFERENCES `objetivo` (`id_objetivo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `detalle_rutina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `detalle_rutina` (
  `id_programa_entrenamiento` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `series` INT NOT NULL,
  `repeticiones` INT NOT NULL,
  `descanso_segundos` INT NOT NULL,
  `dia_semana` ENUM('LUNES', 'MARTES', 'MIERCOLES', 'JUEVES', 'VIERNES', 'SABADO', 'DOMINGO') NOT NULL,
  `orden_ejercicio` INT UNSIGNED NOT NULL,
  `id_ejercicio_fk` INT UNSIGNED NOT NULL,
  `id_rutina_fk` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_programa_entrenamiento`),
  INDEX `fk_programa_entrenamiento_ejercicio1_idx` (`id_ejercicio_fk` ASC),
  INDEX `fk_programa_entrenamiento_rutina1_idx` (`id_rutina_fk` ASC),
  CONSTRAINT `fk_programa_entrenamiento_ejercicio1`
    FOREIGN KEY (`id_ejercicio_fk`)
    REFERENCES `ejercicio` (`id_ejercicio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_programa_entrenamiento_rutina1`
    FOREIGN KEY (`id_rutina_fk`)
    REFERENCES `rutina` (`id_rutina`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `categoria` (
  `id_categoria` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre_categoria` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id_categoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `marca_fabricante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `marca_fabricante` (
  `id_marca_fabricante` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre_marca_fabricante` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`id_marca_fabricante`),
  UNIQUE INDEX `nombre_marca_fabricante_UNIQUE` (`nombre_marca_fabricante` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `impuesto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `impuesto` (
  `id_impuesto` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre_impuesto` VARCHAR(150) NOT NULL,
  `porcentaje_impuesto` DECIMAL(5,2) NOT NULL,
  PRIMARY KEY (`id_impuesto`),
  UNIQUE INDEX `nombre_impuesto_UNIQUE` (`nombre_impuesto` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `proveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `proveedor` (
  `id_proveedor` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `nombre_proveedor` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`id_proveedor`),
  UNIQUE INDEX `nombre_proveedor_UNIQUE` (`nombre_proveedor` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `suplemento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `suplemento` (
  `id_suplemento` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `codigo_barras` VARCHAR(50) NOT NULL,
  `sku_interno` VARCHAR(50) NOT NULL,
  `nombre_suplemento` VARCHAR(100) NOT NULL,
  `descripcion_suplemento` TEXT NOT NULL,
  `precio_venta_actual` DECIMAL(10,2) NOT NULL,
  `stock_actual` INT NOT NULL,
  `stock_minimo` INT NOT NULL,
  `stock_maximo` INT NOT NULL,
  `url_imagen` VARCHAR(255) NOT NULL,
  `id_categoria_fk` INT UNSIGNED NOT NULL,
  `id_marca_fabricante_fk` INT UNSIGNED NOT NULL,
  `id_impuesto_fk` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_suplemento`),
  UNIQUE INDEX `codigo_barras_UNIQUE` (`codigo_barras` ASC),
  UNIQUE INDEX `sku_interno_UNIQUE` (`sku_interno` ASC),
  UNIQUE INDEX `nombre_suplemento_UNIQUE` (`nombre_suplemento` ASC),
  INDEX `fk_suplemento_categoria1_idx` (`id_categoria_fk` ASC),
  INDEX `fk_suplemento_marca_fabricante1_idx` (`id_marca_fabricante_fk` ASC),
  INDEX `fk_suplemento_impuesto1_idx` (`id_impuesto_fk` ASC),
  CONSTRAINT `fk_suplemento_categoria1`
    FOREIGN KEY (`id_categoria_fk`)
    REFERENCES `categoria` (`id_categoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_suplemento_marca_fabricante1`
    FOREIGN KEY (`id_marca_fabricante_fk`)
    REFERENCES `marca_fabricante` (`id_marca_fabricante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_suplemento_impuesto1`
    FOREIGN KEY (`id_impuesto_fk`)
    REFERENCES `impuesto` (`id_impuesto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `compra` (
  `id_compra` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `fecha_compra` DATETIME NOT NULL,
  `numero_factura_externa` VARCHAR(50) NOT NULL,
  `id_proveedor_fk` INT UNSIGNED NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_compra`),
  UNIQUE INDEX `numero_factura_externa_UNIQUE` (`numero_factura_externa` ASC),
  INDEX `fk_compra_proveedor1_idx` (`id_proveedor_fk` ASC),
  CONSTRAINT `fk_compra_proveedor1`
    FOREIGN KEY (`id_proveedor_fk`)
    REFERENCES `proveedor` (`id_proveedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `detalle_compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `detalle_compra` (
  `id_detalle_compra` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `cantidad_comprada` INT UNSIGNED NOT NULL,
  `precio_coste_unitario` DECIMAL(10,2) UNSIGNED NOT NULL,
  `porcentaje_impuesto_aplicado` DECIMAL(5,2) UNSIGNED NOT NULL,
  `id_compra_fk` INT UNSIGNED NOT NULL,
  `id_suplemento_fk` INT UNSIGNED NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_detalle_compra`),
  INDEX `fk_detalle_compra_compra1_idx` (`id_compra_fk` ASC),
  INDEX `fk_detalle_compra_suplemento1_idx` (`id_suplemento_fk` ASC),
  CONSTRAINT `fk_detalle_compra_compra1`
    FOREIGN KEY (`id_compra_fk`)
    REFERENCES `compra` (`id_compra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_compra_suplemento1`
    FOREIGN KEY (`id_suplemento_fk`)
    REFERENCES `suplemento` (`id_suplemento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = '			\n';


-- -----------------------------------------------------
-- Table `venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `venta` (
  `id_venta` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `fecha_venta` DATETIME NOT NULL,
  `canal_venta` VARCHAR(50) NOT NULL,
  `estado_venta` ENUM('PENDIENTE', 'PAGADA', 'ANULADA', 'DEVUELTA') NOT NULL,
  `metodo_pago` ENUM('EFECTIVO', 'TARJETA', 'TRANSFERENCIA') NOT NULL,
  `numero_factura_interna` VARCHAR(50) NOT NULL,
  `id_cliente_fk` INT UNSIGNED NULL,
  `id_empleado_fk` INT UNSIGNED NOT NULL,
  `create_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_venta`),
  INDEX `fk_venta_usuario1_idx` (`id_cliente_fk` ASC),
  INDEX `fk_venta_usuario2_idx` (`id_empleado_fk` ASC),
  UNIQUE INDEX `numero_factura_interna_UNIQUE` (`numero_factura_interna` ASC),
  CONSTRAINT `fk_venta_usuario1`
    FOREIGN KEY (`id_cliente_fk`)
    REFERENCES `usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_venta_usuario2`
    FOREIGN KEY (`id_empleado_fk`)
    REFERENCES `usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `detalle_venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `detalle_venta` (
  `id_detalle_venta` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `cantidad_vendida` INT UNSIGNED NOT NULL,
  `precio_unitario_venta` DECIMAL(10,2) UNSIGNED NOT NULL,
  `porcentaje_impuesto_aplicado` DECIMAL(5,2) UNSIGNED NOT NULL,
  `id_venta_fk` INT UNSIGNED NOT NULL,
  `id_suplemento_fk` INT UNSIGNED NOT NULL,
  `create_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_detalle_venta`),
  INDEX `fk_detalle_venta_venta1_idx` (`id_venta_fk` ASC),
  INDEX `fk_detalle_venta_suplemento1_idx` (`id_suplemento_fk` ASC),
  CONSTRAINT `fk_detalle_venta_venta1`
    FOREIGN KEY (`id_venta_fk`)
    REFERENCES `venta` (`id_venta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_detalle_venta_suplemento1`
    FOREIGN KEY (`id_suplemento_fk`)
    REFERENCES `suplemento` (`id_suplemento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `movimiento_inventario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movimiento_inventario` (
  `id_movimiento_inventario` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `fecha_movimiento` DATETIME NOT NULL,
  `tipo_movimiento` ENUM('COMPRA', 'VENTA', 'MERMA', 'AJUSTE') NOT NULL,
  `cantidad_movimiento` INT NOT NULL,
  `id_suplemento_fk` INT UNSIGNED NOT NULL,
  `id_detalle_compra_fk` INT UNSIGNED NULL,
  `detalle_venta_id_detalle_venta` INT UNSIGNED NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_movimiento_inventario`),
  INDEX `fk_movimiento_inventario_suplemento1_idx` (`id_suplemento_fk` ASC),
  INDEX `fk_movimiento_inventario_detalle_compra1_idx` (`id_detalle_compra_fk` ASC),
  INDEX `fk_movimiento_inventario_detalle_venta1_idx` (`detalle_venta_id_detalle_venta` ASC),
  CONSTRAINT `fk_movimiento_inventario_suplemento1`
    FOREIGN KEY (`id_suplemento_fk`)
    REFERENCES `suplemento` (`id_suplemento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_movimiento_inventario_detalle_compra1`
    FOREIGN KEY (`id_detalle_compra_fk`)
    REFERENCES `detalle_compra` (`id_detalle_compra`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_movimiento_inventario_detalle_venta1`
    FOREIGN KEY (`detalle_venta_id_detalle_venta`)
    REFERENCES `detalle_venta` (`id_detalle_venta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `usuario_rutina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `usuario_rutina` (
  `id_usuario_rutina` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `fecha_inicio` DATETIME NOT NULL,
  `activa` TINYINT(1) NULL,
  `id_usuario_fk` INT UNSIGNED NOT NULL,
  `id_rutina_fk` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id_usuario_rutina`),
  INDEX `fk_usuario_rutina_usuario1_idx` (`id_usuario_fk` ASC),
  INDEX `fk_usuario_rutina_usuario2_idx` (`id_rutina_fk` ASC),
  CONSTRAINT `fk_usuario_rutina_usuario1`
    FOREIGN KEY (`id_usuario_fk`)
    REFERENCES `usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_rutina_usuario2`
    FOREIGN KEY (`id_rutina_fk`)
    REFERENCES `usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sesion_entrenamiento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sesion_entrenamiento` (
  `id_sesion_entrenamiento` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `fecha_sesion_entrenamiento` DATETIME NOT NULL,
  `id_cliente_fk` INT UNSIGNED NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_sesion_entrenamiento`),
  INDEX `fk_sesion_entrenamiento_usuario1_idx` (`id_cliente_fk` ASC),
  CONSTRAINT `fk_sesion_entrenamiento_usuario1`
    FOREIGN KEY (`id_cliente_fk`)
    REFERENCES `usuario` (`id_usuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `registro_serie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `registro_serie` (
  `id_registro_serie` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_sesion_entrenamiento_fk` INT UNSIGNED NOT NULL,
  `id_ejercicio_fk` INT UNSIGNED NOT NULL,
  `peso_levantado` DECIMAL(5,2) UNSIGNED NOT NULL,
  `repeticiones_logradas` INT UNSIGNED NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_registro_serie`),
  INDEX `fk_registro_serie_sesion_entrenamiento1_idx` (`id_sesion_entrenamiento_fk` ASC),
  INDEX `fk_registro_serie_ejercicio1_idx` (`id_ejercicio_fk` ASC),
  CONSTRAINT `fk_registro_serie_sesion_entrenamiento1`
    FOREIGN KEY (`id_sesion_entrenamiento_fk`)
    REFERENCES `sesion_entrenamiento` (`id_sesion_entrenamiento`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_registro_serie_ejercicio1`
    FOREIGN KEY (`id_ejercicio_fk`)
    REFERENCES `ejercicio` (`id_ejercicio`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
