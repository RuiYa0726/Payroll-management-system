USE [master]
GO
/****** Object:  Database [PayrollSystem]    Script Date: 2018/6/11 15:09:14 ******/
CREATE DATABASE [PayrollSystem]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'PayrollSystem', FILENAME = N'C:\Program Files (x86)\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\PayrollSystem.mdf' , SIZE = 7168KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'PayrollSystem_log', FILENAME = N'C:\Program Files (x86)\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\PayrollSystem_log.ldf' , SIZE = 2048KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [PayrollSystem] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [PayrollSystem].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [PayrollSystem] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [PayrollSystem] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [PayrollSystem] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [PayrollSystem] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [PayrollSystem] SET ARITHABORT OFF 
GO
ALTER DATABASE [PayrollSystem] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [PayrollSystem] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [PayrollSystem] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [PayrollSystem] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [PayrollSystem] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [PayrollSystem] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [PayrollSystem] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [PayrollSystem] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [PayrollSystem] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [PayrollSystem] SET  DISABLE_BROKER 
GO
ALTER DATABASE [PayrollSystem] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [PayrollSystem] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [PayrollSystem] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [PayrollSystem] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [PayrollSystem] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [PayrollSystem] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [PayrollSystem] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [PayrollSystem] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [PayrollSystem] SET  MULTI_USER 
GO
ALTER DATABASE [PayrollSystem] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [PayrollSystem] SET DB_CHAINING OFF 
GO
ALTER DATABASE [PayrollSystem] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [PayrollSystem] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [PayrollSystem] SET DELAYED_DURABILITY = DISABLED 
GO
USE [PayrollSystem]
GO
/****** Object:  Table [dbo].[Salary]    Script Date: 2018/6/11 15:09:14 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Salary](
	[ID] [char](30) NOT NULL,
	[STName] [char](30) NULL,
	[Department] [char](100) NULL,
	[Time1] [char](50) NOT NULL,
	[Initial] [float] NULL,
	[Accumulation] [float] NULL,
	[Social] [float] NULL,
	[Tax] [float] NULL,
	[Overtime] [float] NULL,
	[Final] [float] NULL,
	[Yearbonus] [float] NULL,
	[Annual] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC,
	[Time1] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Sheet1$]    Script Date: 2018/6/11 15:09:14 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Sheet1$](
	[ID] [nvarchar](255) NULL,
	[STName] [nvarchar](255) NULL,
	[Department] [nvarchar](255) NULL,
	[Time1] [nvarchar](255) NULL,
	[Initial] [float] NULL,
	[Accumulation] [float] NULL,
	[Social ] [float] NULL,
	[Tax] [float] NULL,
	[Overtime] [float] NULL,
	[Final] [float] NULL,
	[Yearbonus] [float] NULL,
	[Annual] [float] NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Staff]    Script Date: 2018/6/11 15:09:14 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Staff](
	[ID] [char](30) NOT NULL,
	[STPassword] [char](50) NULL,
	[STRank] [char](30) NULL,
	[STName] [char](30) NULL,
	[Email] [char](50) NULL,
	[Department] [char](100) NULL,
	[Question1] [char](100) NULL,
	[Answer1] [char](100) NULL,
	[Question2] [char](100) NULL,
	[Answer2] [char](100) NULL,
	[Question3] [char](100) NULL,
	[Answer3] [char](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
USE [master]
GO
ALTER DATABASE [PayrollSystem] SET  READ_WRITE 
GO
