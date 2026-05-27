# SchoolViewer Android App

中学受験における「英語入試・帰国生入試」情報をAndroid端末から閲覧するためのアプリです。

このアプリは、Webアプリ版と同じバックエンドAPIに接続し、学校情報の一覧表示、学校名検索、詳細表示をAndroid端末上で行えるようにしたものです。

## 概要

SchoolViewerは、`helidon-school-app` のデータをAndroidアプリから閲覧するためのクライアントアプリです。

Webブラウザからのアクセスだけでなく、AndroidスマートフォンやAndroidエミュレータからも学校情報を確認できます。

主な用途は以下です。

- 中学受験における英語入試情報の確認
- 帰国生入試・英語入試を実施する学校の検索
- 学校ごとの試験日、定員、科目などの確認
- Webアプリと同じデータソースを使ったAndroid向け表示

## 主な機能

- 学校情報の一覧表示
- 学校名による検索
- 学校詳細画面の表示
- 最新データの再読み込み
- HelidonバックエンドAPIとの連携
- Jetpack ComposeによるAndroid UI

## システム構成

```text
Android App
  |
  | Retrofit
  v
Helidon Backend API
  |
  v
School Data

Androidアプリは、以下のバックエンドAPIに接続します。

https://helidon-school-app.onrender.com/

学校情報の取得には、主に以下のAPIを使用します。

GET /api/schools
GET /api/schools?name={schoolName}
技術スタック
Kotlin
Android
Jetpack Compose
Material 3
Android Navigation Compose
ViewModel
Kotlin Coroutines
Retrofit
Gson Converter
Gradle Kotlin DSL
Android要件
minSdk: 26
targetSdk: 35
compileSdk: 35
Java / Kotlin JVM target: 17
ディレクトリ構成
app/
├── build.gradle.kts
├── proguard-rules.pro
└── src/
    ├── main/
    │   ├── AndroidManifest.xml
    │   └── java/com/yonishik/schoolviewer/
    │       ├── MainActivity.kt
    │       ├── data/
    │       ├── model/
    │       ├── network/
    │       └── ui/
    ├── androidTest/
    └── test/
主要ファイル
MainActivity.kt

アプリのエントリーポイントです。

Jetpack Composeを使って、学校一覧画面、検索欄、詳細画面への遷移、更新ボタンなどを構成しています。

network/ApiClient.kt

Retrofitの設定を行うファイルです。

バックエンドAPIのベースURLを定義し、SchoolApi を生成します。

network/SchoolApi.kt

学校情報を取得するAPIインターフェースです。

GET /api/schools
GET /api/schools?name={name}

に対応しています。

ビルド方法

Android Studioでこのリポジトリを開きます。

git clone https://github.com/bull2023x/SchoolViewer.git
cd SchoolViewer

Android Studioでプロジェクトを開いた後、Gradle Syncを実行してください。

その後、以下のいずれかで起動できます。

Android StudioのRunボタンから実行
Android Emulatorで実行
実機Android端末で実行
コマンドラインでのビルド

Debug APKを作成する場合:

./gradlew :app:assembleDebug

Release APKを作成する場合:

./gradlew :app:assembleRelease
API接続先の変更

API接続先は以下のファイルで設定されています。

app/src/main/java/com/yonishik/schoolviewer/network/ApiClient.kt

ローカル開発環境のAPIに接続する場合は、例として以下のように変更できます。

private const val BASE_URL = "http://10.0.2.2:8080/"

Android EmulatorからホストPC上のローカルサーバーへ接続する場合、localhost ではなく 10.0.2.2 を使用します。

本番環境では以下のようなURLを使用します。

private const val BASE_URL = "https://helidon-school-app.onrender.com/"
Webアプリ版との関係

このAndroidアプリは、Webアプリ版と同じ学校データを利用するAndroidクライアントです。

Web App
Android App
   |
   v
Common Helidon Backend API

そのため、バックエンド側の学校データが更新されると、Androidアプリ側でも最新データを取得できます。

注意事項
このアプリはバックエンドAPIへのネットワーク接続を必要とします。
Render上の無料プラン等を利用している場合、初回アクセス時にAPIの起動に時間がかかることがあります。
APIのURLを変更した場合は、アプリを再ビルドしてください。
公開リポジトリに署名鍵、パスワード、APIトークンなどの機密情報を含めないでください。
今後の改善案
学校種別・地域・試験区分による絞り込み
お気に入り登録
オフラインキャッシュ
詳細画面の情報表示改善
Webアプリ版とのUI統一
GitHub ActionsによるAPK自動ビルド
Repository
SchoolViewer

Android app module:

app/
License

This project is provided for demonstration and educational purposes.


追加方法は、ローカルPCで `SchoolViewer` のルートにいる状態なら、以下です。

```bash
cd app
nano README.

