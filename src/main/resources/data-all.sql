INSERT INTO articles (title, content, created_at, updated_at) VALUES
('Spring Boot 4.0 へようこそ', 'このブログは Spring Boot 4.0 と MyBatis、Thymeleaf を使ったサンプルアプリケーションです。', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('MyBatis で始めるデータアクセス', 'Mapper インターフェースと XML マッパーを組み合わせることで、SQL を直接記述しながら型安全にデータアクセスできます。', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('Thymeleaf テンプレートの基本', 'Thymeleaf を使うと、HTML をそのままテンプレートとして扱いながらサーバーサイドでレンダリングできます。', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into user_info values('root', 'USER,DATA_MANAGER', '$2a$12$dOrsbzXOAt5wL7JRNn5bW.mMzRnxQJZuWMYDMUDfy0QS24XFpJeYO', 'root@xxx', '2025-10-30', 0);
insert into user_info values('user', 'USER', '$2a$12$dOrsbzXOAt5wL7JRNn5bW.mMzRnxQJZuWMYDMUDfy0QS24XFpJeYO', 'data@xxx', '2025-10-30', 0);
