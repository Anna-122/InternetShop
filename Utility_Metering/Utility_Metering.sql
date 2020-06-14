-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Хост: localhost
-- Время создания: Июн 11 2020 г., 16:32
-- Версия сервера: 5.7.30-0ubuntu0.18.04.1
-- Версия PHP: 7.2.24-0ubuntu0.18.04.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `Utility_Metering`
--

-- --------------------------------------------------------

--
-- Структура таблицы `Receipts`
--

CREATE TABLE `Receipts` (
  `Receipts_ID` int(11) NOT NULL,
  `Tenants_ID` int(11) NOT NULL,
  `TypeOfService_ID` int(11) NOT NULL,
  `Subsidy` int(11) NOT NULL,
  `Privilege` int(11) NOT NULL,
  `BillingDate` date NOT NULL,
  `PaymentSign` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `Street`
--

CREATE TABLE `Street` (
  `Street_ID` int(11) NOT NULL,
  `StreetName` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `Tenants`
--

CREATE TABLE `Tenants` (
  `Tenant_ID` int(11) NOT NULL,
  `Name` tinytext NOT NULL,
  `Surname` tinytext NOT NULL,
  `MiddleName` tinytext NOT NULL,
  `LivingArea` int(11) NOT NULL,
  `NumberOfResiden` tinyint(4) NOT NULL,
  `NumberOfContract` int(11) NOT NULL,
  `Address_Street_ID` int(11) NOT NULL,
  `Address_House` tinytext NOT NULL,
  `Address_Flat` tinytext NOT NULL,
  `Bankbook` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `TypeOfService`
--

CREATE TABLE `TypeOfService` (
  `Service_ID` int(11) NOT NULL,
  `ServiceName` text NOT NULL,
  `ServiceCost` double NOT NULL,
  `Unit` tinytext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `Receipts`
--
ALTER TABLE `Receipts`
  ADD PRIMARY KEY (`Receipts_ID`),
  ADD KEY `fk_Receipts_1_idx` (`TypeOfService_ID`),
  ADD KEY `fk_Receipts_2_idx` (`Tenants_ID`);

--
-- Индексы таблицы `Street`
--
ALTER TABLE `Street`
  ADD PRIMARY KEY (`Street_ID`);

--
-- Индексы таблицы `Tenants`
--
ALTER TABLE `Tenants`
  ADD PRIMARY KEY (`Tenant_ID`),
  ADD KEY `Street_idx` (`Address_Street_ID`);

--
-- Индексы таблицы `TypeOfService`
--
ALTER TABLE `TypeOfService`
  ADD PRIMARY KEY (`Service_ID`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `Receipts`
--
ALTER TABLE `Receipts`
  MODIFY `Receipts_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `Street`
--
ALTER TABLE `Street`
  MODIFY `Street_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `Tenants`
--
ALTER TABLE `Tenants`
  MODIFY `Tenant_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `TypeOfService`
--
ALTER TABLE `TypeOfService`
  MODIFY `Service_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `Receipts`
--
ALTER TABLE `Receipts`
  ADD CONSTRAINT `fk_Receipts_1` FOREIGN KEY (`TypeOfService_ID`) REFERENCES `TypeOfService` (`Service_ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_Receipts_2` FOREIGN KEY (`Tenants_ID`) REFERENCES `Tenants` (`Tenant_ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `Street`
--
ALTER TABLE `Street`
  ADD CONSTRAINT `Street_ibfk_1` FOREIGN KEY (`Street_ID`) REFERENCES `Tenants` (`Address_Street_ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
