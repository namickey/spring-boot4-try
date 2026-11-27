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
    username      VARCHAR(100)  NOT NULL PRIMARY KEY,
    roles         VARCHAR(100),
    password      VARCHAR(100)  NOT NULL,
    password_init INT           NOT NULL DEFAULT 0,
    email         VARCHAR(100),
    lockout       INT           NOT NULL DEFAULT 0,
    locked_at     TIMESTAMP,
    failed_count  INT           NOT NULL DEFAULT 0,
    last_login_at TIMESTAMP,
    created_at    TIMESTAMP     NOT NULL,
    updated_at    TIMESTAMP     NOT NULL,
    version_no    INT           NOT NULL DEFAULT 0
);

DROP TABLE IF EXISTS password_historys CASCADE;

CREATE TABLE password_historys (
    username     VARCHAR(100)  NOT NULL,
    edited_at    TIMESTAMP     NOT NULL,
    password     VARCHAR(100)  NOT NULL,
    created_at   TIMESTAMP     NOT NULL,
    updated_at   TIMESTAMP     NOT NULL,
    PRIMARY KEY(username, edited_at, password)
);
