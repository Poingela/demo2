CREATE TABLE [dbo].[student] (
    [id]   BIGINT       NOT NULL,
    [name] VARCHAR (50) NULL,
    [age]  INT          NULL,
    CONSTRAINT [PK_student] PRIMARY KEY CLUSTERED ([id] ASC)
);