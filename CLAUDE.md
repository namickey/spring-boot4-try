# Spring Blog - プロジェクト概要

## アプリケーション概要

**「Spring Blog」** - 記事の投稿・管理ができるシンプルなブログシステム

Spring Boot 4.1 を使った Web サンプルアプリケーション。

---

## 技術スタック

| 役割 | 技術 |
|------|------|
| フレームワーク | Spring Boot 4.1 |
| テンプレートエンジン | Thymeleaf |
| 認証 | Spring Security |
| データアクセス | MyBatis (mybatis-spring-boot-starter) |
| DB | H2（開発・本番共通） |
| バリデーション | Bean Validation |
| ビルド | Maven (Maven Wrapper / mvnw) |
| Java | Java 21 |

---

## 機能一覧

### 認証
- ログイン / ログアウト
- ユーザーは `data.sql` で初期登録（登録画面なし）

### 記事管理

| 機能 | 誰が使えるか |
|------|------------|
| 記事一覧表示 | 全員（未ログインでも可） |
| 記事詳細表示 | 全員 |
| 記事投稿 | ログインユーザー |
| 記事編集・削除 | 投稿者本人のみ |

---

## 画面一覧

```
/ ...................... 記事一覧
/articles/{id} ........ 記事詳細
/articles/new ......... 記事投稿フォーム
/articles/{id}/edit ... 記事編集フォーム
/login ................ ログイン
```

---

## データモデル

```
User
├── id
├── username
└── password (BCrypt)

Article
├── id
├── title
├── content
├── author (User)
├── createdAt
└── updatedAt
```

---

## データアクセス方針（MyBatis）

- Mapper インターフェース + SQL で実装
- DDL は `src/main/resources/schema.sql` で管理
- 初期データは `src/main/resources/data.sql` で管理
- SQL は XML マッパー (`src/main/resources/mapper/*.xml`) で記述
