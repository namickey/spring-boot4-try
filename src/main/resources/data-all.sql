INSERT INTO articles (title, content, created_at, updated_at) VALUES
('Spring Boot 4.0 へようこそ', 'このブログは Spring Boot 4.0 と MyBatis、Thymeleaf を使ったサンプルアプリケーションです。', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('MyBatis で始めるデータアクセス', 'Mapper インターフェースと XML マッパーを組み合わせることで、SQL を直接記述しながら型安全にデータアクセスできます。', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Thymeleaf テンプレートの基本', 'Thymeleaf を使うと、HTML をそのままテンプレートとして扱いながらサーバーサイドでレンダリングできます。', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO accounts (username, roles, password, password_init, email, lockout, locked_at, failed_count, last_login_at, created_at, updated_at) VALUES
('root', null, '$2a$12$dOrsbzXOAt5wL7JRNn5bW.mMzRnxQJZuWMYDMUDfy0QS24XFpJeYO', 0, 'root@xxx', 0, null, 0, null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('user', null, '$2a$12$dOrsbzXOAt5wL7JRNn5bW.mMzRnxQJZuWMYDMUDfy0QS24XFpJeYO', 0, 'user@xxx', 0, null, 0, null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('a', null, '$2a$12$dOrsbzXOAt5wL7JRNn5bW.mMzRnxQJZuWMYDMUDfy0QS24XFpJeYO', 1, 'user@xxx', 0, null, 0, null, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
