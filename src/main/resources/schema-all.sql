DROP TABLE IF EXISTS articles CASCADE;

CREATE TABLE articles (
    id         BIGINT AUTO_INCREMENT PRIMARY KEY,
    title      VARCHAR(200)  NOT NULL,
    content    TEXT          NOT NULL,
    created_at TIMESTAMP     NOT NULL,
    updated_at TIMESTAMP     NOT NULL,
    version_no INT           NOT NULL DEFAULT 0
);

DROP TABLE IF EXISTS accounts CASCADE;

CREATE TABLE accounts (
    username   VARCHAR(100)  NOT NULL PRIMARY KEY,
    roles      VARCHAR(100),
    password   VARCHAR(100)  NOT NULL,
    email      VARCHAR(100),
    lockout    CHAR(1),
    locked_at  TIMESTAMP,
    failed_count INT NOT NULL DEFAULT 0,
    created_at TIMESTAMP     NOT NULL,
    updated_at TIMESTAMP     NOT NULL,
    version_no INT           NOT NULL DEFAULT 0
);
