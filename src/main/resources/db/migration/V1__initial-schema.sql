CREATE TABLE IF NOT EXISTS chat (
             id UUID NOT NULL PRIMARY KEY,
              created_by VARCHAR(255) NOT NULL,
             created_timestamp TIMESTAMPTZ NOT NULL
    );