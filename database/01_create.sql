/*
Created: 27.10.2015
Modified: 13.11.2015
Model: Split
Database: SQLite 3.7
*/

-- Create tables section -------------------------------------------------

-- Table currency

CREATE TABLE currency
(
  _id INTEGER NOT NULL
        CONSTRAINT Key2 PRIMARY KEY AUTOINCREMENT,
  iso_code TEXT NOT NULL,
  name TEXT NOT NULL,
  symbol TEXT NOT NULL,
  country TEXT NOT NULL,
  usage_count INTEGER,
  CONSTRAINT id UNIQUE (_id),
  CONSTRAINT iso_code UNIQUE (iso_code)
);

CREATE INDEX Index_usage ON currency (usage_count);

CREATE INDEX Index_name ON currency (name);

CREATE INDEX Index_country ON currency (country);

-- Table project_user

CREATE TABLE project_user
(
  _id INTEGER NOT NULL
        CONSTRAINT Key1 PRIMARY KEY AUTOINCREMENT,
  project_id INTEGER NOT NULL,
  name TEXT NOT NULL,
  is_contact INTEGER NOT NULL DEFAULT 0,
  CONSTRAINT id UNIQUE (_id),
  CONSTRAINT Relationship7 FOREIGN KEY (project_id) REFERENCES project (_id)
);

CREATE INDEX index_projectuser_name ON project_user (name);

CREATE INDEX IX_Relationship7 ON project_user (project_id);

-- Table project

CREATE TABLE project
(
  _id INTEGER NOT NULL
        CONSTRAINT Key3 PRIMARY KEY AUTOINCREMENT,
  state_id INTEGER NOT NULL,
  name TEXT NOT NULL,
  created TEXT NOT NULL,
  CONSTRAINT id UNIQUE (_id),
  CONSTRAINT Relationship10 FOREIGN KEY (state_id) REFERENCES project_state (_id)
);

CREATE INDEX IX_Relationship10 ON project (state_id);

CREATE INDEX Index_created ON project (created);

-- Table expense

CREATE TABLE expense
(
  _id INTEGER NOT NULL
        CONSTRAINT Key4 PRIMARY KEY AUTOINCREMENT,
  project_id INTEGER NOT NULL,
  subcategory_id INTEGER,
  name TEXT,
  created TEXT NOT NULL,
  CONSTRAINT id UNIQUE (_id),
  CONSTRAINT Relationship11 FOREIGN KEY (project_id) REFERENCES project (_id),
  CONSTRAINT Relationship28 FOREIGN KEY (subcategory_id) REFERENCES expense_subcategory (_id)
);

CREATE INDEX index_expense_timestamp ON expense (created DESC);

CREATE INDEX IX_Relationship11 ON expense (project_id);

CREATE INDEX IX_Relationship28 ON expense (subcategory_id);

-- Table project_state

CREATE TABLE project_state
(
  _id INTEGER NOT NULL
        CONSTRAINT Key5 PRIMARY KEY AUTOINCREMENT,
  name TEXT NOT NULL,
  CONSTRAINT id UNIQUE (_id),
  CONSTRAINT name UNIQUE (name)
);

-- Table balancegroup

CREATE TABLE balancegroup
(
  _id INTEGER NOT NULL
        CONSTRAINT Key6 PRIMARY KEY AUTOINCREMENT,
  project_id INTEGER NOT NULL,
  CONSTRAINT id UNIQUE (_id),
  CONSTRAINT Relationship6 FOREIGN KEY (project_id) REFERENCES project (_id)
);

CREATE INDEX IX_Relationship6 ON balancegroup (project_id);

-- Table group_has_user

CREATE TABLE group_has_user
(
  balance_group_id INTEGER NOT NULL,
  project_user_id INTEGER NOT NULL,
  CONSTRAINT Key7 PRIMARY KEY (balance_group_id,project_user_id),
  CONSTRAINT Relationship8 FOREIGN KEY (balance_group_id) REFERENCES balancegroup (_id),
  CONSTRAINT Relationship9 FOREIGN KEY (project_user_id) REFERENCES project_user (_id)
);

-- Table blob

CREATE TABLE blob
(
  _id INTEGER NOT NULL
        CONSTRAINT Key8 PRIMARY KEY AUTOINCREMENT,
  value blob NOT NULL,
  CONSTRAINT id UNIQUE (_id)
);

-- Table metadata

CREATE TABLE metadata
(
  _id INTEGER NOT NULL
        CONSTRAINT Key9 PRIMARY KEY AUTOINCREMENT,
  value_type_id INTEGER,
  name TEXT NOT NULL,
  CONSTRAINT id UNIQUE (_id),
  CONSTRAINT name UNIQUE (name),
  CONSTRAINT Relationship12 FOREIGN KEY (value_type_id) REFERENCES value_type (_id)
);

CREATE INDEX IX_Relationship12 ON metadata (value_type_id);

-- Table value_type

CREATE TABLE value_type
(
  _id INTEGER NOT NULL
        CONSTRAINT Key10 PRIMARY KEY AUTOINCREMENT,
  name TEXT NOT NULL,
  CONSTRAINT id UNIQUE (_id),
  CONSTRAINT name UNIQUE (name)
);

-- Table additional_data

CREATE TABLE additional_data
(
  expense_id INTEGER NOT NULL,
  metadata_id INTEGER NOT NULL,
  value TEXT NOT NULL,
  CONSTRAINT Key11 PRIMARY KEY (expense_id,metadata_id),
  CONSTRAINT Relationship13 FOREIGN KEY (expense_id) REFERENCES expense (_id),
  CONSTRAINT Relationship14 FOREIGN KEY (metadata_id) REFERENCES metadata (_id)
);

-- Table payed_by

CREATE TABLE payed_by
(
  expense_id INTEGER NOT NULL,
  project_user_id INTEGER NOT NULL,
  value REAL NOT NULL,
  CONSTRAINT Key12 PRIMARY KEY (expense_id,project_user_id),
  CONSTRAINT Relationship15 FOREIGN KEY (expense_id) REFERENCES expense (_id),
  CONSTRAINT Relationship16 FOREIGN KEY (project_user_id) REFERENCES project_user (_id)
);

-- Table payed_for

CREATE TABLE payed_for
(
  expense_id INTEGER NOT NULL,
  project_user_id INTEGER NOT NULL,
  weight REAL,
  value REAL,
  CONSTRAINT Key13 PRIMARY KEY (expense_id,project_user_id),
  CONSTRAINT Relationship17 FOREIGN KEY (expense_id) REFERENCES expense (_id),
  CONSTRAINT Relationship18 FOREIGN KEY (project_user_id) REFERENCES project_user (_id)
);

-- Table project_use_currency

CREATE TABLE project_use_currency
(
  project_id INTEGER NOT NULL,
  currency_id INTEGER NOT NULL,
  is_default boolean NOT NULL DEFAULT false,
  exchange_rate REAL,
  CONSTRAINT Key14 PRIMARY KEY (project_id,currency_id),
  CONSTRAINT Relationship19 FOREIGN KEY (project_id) REFERENCES project (_id),
  CONSTRAINT Relationship20 FOREIGN KEY (currency_id) REFERENCES currency (_id)
);

-- Table setting

CREATE TABLE setting
(
  _id INTEGER NOT NULL
        CONSTRAINT Key15 PRIMARY KEY AUTOINCREMENT,
  value_type_id INTEGER NOT NULL,
  name TEXT NOT NULL,
  value TEXT,
  CONSTRAINT id UNIQUE (_id),
  CONSTRAINT name UNIQUE (name),
  CONSTRAINT Relationship21 FOREIGN KEY (value_type_id) REFERENCES value_type (_id)
);

CREATE INDEX IX_Relationship21 ON setting (value_type_id);

-- Table centralise_balance

CREATE TABLE centralise_balance
(
  project_id INTEGER NOT NULL,
  project_user_id INTEGER NOT NULL,
  CONSTRAINT Key16 PRIMARY KEY (project_id,project_user_id),
  CONSTRAINT Relationship22 FOREIGN KEY (project_id) REFERENCES project (_id),
  CONSTRAINT Relationship23 FOREIGN KEY (project_user_id) REFERENCES project_user (_id)
);

-- Table balance

CREATE TABLE balance
(
  project_id INTEGER NOT NULL,
  to_user INTEGER NOT NULL,
  from_user INTEGER NOT NULL,
  value REAL,
  CONSTRAINT Key17 PRIMARY KEY (project_id,to_user,from_user),
  CONSTRAINT Relationship24 FOREIGN KEY (project_id) REFERENCES project (_id),
  CONSTRAINT Relationship25 FOREIGN KEY (to_user) REFERENCES project_user (_id),
  CONSTRAINT Relationship26 FOREIGN KEY (from_user) REFERENCES project_user (_id)
);

CREATE INDEX IX_Relationship26 ON balance (from_user);

-- Table expense_category

CREATE TABLE expense_category
(
  _id INTEGER NOT NULL
        CONSTRAINT Key18 PRIMARY KEY AUTOINCREMENT,
  name TEXT NOT NULL,
  CONSTRAINT _id UNIQUE (_id),
  CONSTRAINT name UNIQUE (name)
);

CREATE UNIQUE INDEX Index_expense_category_name ON expense_category (name);

-- Table expense_subcategory

CREATE TABLE expense_subcategory
(
  _id INTEGER NOT NULL
        CONSTRAINT Key19 PRIMARY KEY AUTOINCREMENT,
  category_id INTEGER,
  name TEXT,
  CONSTRAINT _id UNIQUE (_id),
  CONSTRAINT Relationship27 FOREIGN KEY (category_id) REFERENCES expense_category (_id)
);

CREATE INDEX Index_expense_subcategory_name ON expense_subcategory (name);

CREATE INDEX IX_Relationship27 ON expense_subcategory (name,category_id);


