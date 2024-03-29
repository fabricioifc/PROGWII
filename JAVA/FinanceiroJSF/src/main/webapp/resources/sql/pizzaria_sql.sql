-- MySQL Script generated by MySQL Workbench
-- seg 18 set 2017 13:37:14 -03
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema teste
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema teste
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `teste` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema pizzaria
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema pizzaria
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pizzaria` ;
USE `pizzaria` ;

-- -----------------------------------------------------
-- Table `pizzaria`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizzaria`.`Cliente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `telefone` VARCHAR(20) NULL,
  `endereco` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pizzaria`.`Pizzaria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizzaria`.`Pizzaria` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `preco_peq` DOUBLE NULL,
  `preco_med` DOUBLE NULL,
  `preco_grd` DOUBLE NULL,
  `preco_borda` DOUBLE NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pizzaria`.`Ingrediente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizzaria`.`Ingrediente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pizzaria`.`Pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizzaria`.`Pedido` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `valor` DOUBLE NULL,
  `dthrcadastro` TIMESTAMP NULL,
  `Cliente_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Pedido_Cliente1_idx` (`Cliente_id` ASC),
  CONSTRAINT `fk_Pedido_Cliente1`
    FOREIGN KEY (`Cliente_id`)
    REFERENCES `pizzaria`.`Cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pizzaria`.`Pizza`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizzaria`.`Pizza` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NULL,
  `Pizzaria_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Pizza_Pizzaria1_idx` (`Pizzaria_id` ASC),
  CONSTRAINT `fk_Pizza_Pizzaria1`
    FOREIGN KEY (`Pizzaria_id`)
    REFERENCES `pizzaria`.`Pizzaria` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pizzaria`.`PedidoItem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizzaria`.`PedidoItem` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `borda` TINYINT(1) NULL,
  `Pizza_id` INT NOT NULL,
  `Pedido_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_PedidoItem_Pizza1_idx` (`Pizza_id` ASC),
  INDEX `fk_PedidoItem_Pedido1_idx` (`Pedido_id` ASC),
  CONSTRAINT `fk_PedidoItem_Pizza1`
    FOREIGN KEY (`Pizza_id`)
    REFERENCES `pizzaria`.`Pizza` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PedidoItem_Pedido1`
    FOREIGN KEY (`Pedido_id`)
    REFERENCES `pizzaria`.`Pedido` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `pizzaria`.`PizzaIngrediente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pizzaria`.`PizzaIngrediente` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `Pizza_id` INT NOT NULL,
  `Ingrediente_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_PizzaIngrediente_Pizza1_idx` (`Pizza_id` ASC),
  INDEX `fk_PizzaIngrediente_Ingrediente1_idx` (`Ingrediente_id` ASC),
  CONSTRAINT `fk_PizzaIngrediente_Pizza1`
    FOREIGN KEY (`Pizza_id`)
    REFERENCES `pizzaria`.`Pizza` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PizzaIngrediente_Ingrediente1`
    FOREIGN KEY (`Ingrediente_id`)
    REFERENCES `pizzaria`.`Ingrediente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
