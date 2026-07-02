# spring-boot4-try

Spring Boot 4.0 を使ったシンプルなブログシステム「エンジニアBlog」です。
記事の一覧表示・詳細表示・投稿・編集・削除ができます。

## 技術スタック

- Spring Boot 4.0.7
- Thymeleaf
- MyBatis (mybatis-spring-boot-starter)
- H2 Database
- Java 21 / Maven (Maven Wrapper)

## 必要環境

- Java 21

Maven はリポジトリに含まれる Maven Wrapper (`mvnw` / `mvnw.cmd`) を使うため、別途インストールは不要です。

## 起動方法

```bash
# macOS / Linux
./mvnw spring-boot:run

# Windows
mvnw.cmd spring-boot:run
```

起動後、以下の URL にアクセスします。

- アプリ本体: http://localhost:8080/
- H2 コンソール: http://localhost:8080/h2-console
  - JDBC URL: `jdbc:h2:file:./data/blog`
  - ユーザー名: `sa`
  - パスワード: (空欄)

初回起動時に `schema-all.sql` / `data-all.sql` によりテーブル作成とサンプルデータ投入が自動的に行われます。
データは `./data/blog.mv.db` に保存されます（`.gitignore` 対象）。

## 画面一覧

| パス | 内容 |
|------|------|
| `/` | 記事一覧 |
| `/articles/{id}` | 記事詳細 |
| `/articles/new` | 記事投稿フォーム |
| `/articles/{id}/edit` | 記事編集フォーム |

