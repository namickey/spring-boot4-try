# Spring Blog - プロジェクト概要

## アプリケーション概要

**「Spring Blog」** - 記事の投稿・管理ができるシンプルなブログシステム

Spring Boot 4.0 を使った Web サンプルアプリケーション。

---

## 技術スタック

| 役割 | 技術 |
|------|------|
| フレームワーク | Spring Boot 4.0.7 |
| テンプレートエンジン | Thymeleaf |
| データアクセス | MyBatis (mybatis-spring-boot-starter) |
| DB | H2（開発・本番共通） |
| ビルド | Maven (Maven Wrapper / mvnw) |
| Java | Java 21 |

---

## 機能一覧

### 記事管理

- 記事一覧表示
- 記事詳細表示
- 記事投稿
- 記事編集・削除

---

## 画面一覧

```
/ ...................... 記事一覧
/articles/{id} ........ 記事詳細
/articles/new ......... 記事投稿フォーム
/articles/{id}/edit ... 記事編集フォーム
```

---

## データモデル

```
Article
├── id
├── title
├── content
├── createdAt
└── updatedAt
```

---

## データアクセス方針（MyBatis）

- Mapper インターフェース + SQL で実装
- DDL は `src/main/resources/schema-all.sql` で管理
- 初期データは `src/main/resources/data-all.sql` で管理
- SQL は XML マッパー (`src/main/resources/mapper/*.xml`) で記述
