# DBproject

## 目錄
- [專案簡介](#專案簡介)
- [安裝與配置](#安裝與配置)
- [先決條件](#先決條件)
- [使用方法](#使用方法)
- [查詢結果](#查詢結果)

## 專案簡介
DBproject是用來處理資料庫相關的程式。透過連上學號所對應的資料庫，可以看到該資料庫的所有表，且能做簡單的查詢指令等，並實作所要求的五項查詢

組員：411177005徐柏鈞、411177011林士祐

註：ERD與relation schema皆放在\src\resource\中

## 安裝與配置
點擊Code並下載成zip檔，解壓縮後執行DBproject.jar即可

### 先決條件
- 需要安裝JAVA並設立環境變數 JDK版本：21

## 使用方法
![image](https://github.com/abc7559485/DBproject/assets/153478133/81a385d3-901d-4094-a249-7d595ef8a951)

1. 點擊連線並輸入帳號與密碼(若沒連線會無法進行其他操作)
2. 專案帳號：411177005、密碼：411177005
3. 連線過後可對資料庫進行查詢(查詢一~五)
4. 最下方文字框可以輸入基本查詢語句，按下ENTER或"查詢"鍵以顯示查詢
5. 右方會顯示當前資料庫有哪些表，可以透過點擊去查詢有哪些資料
6. 表格會顯示在中間，且其下方會顯示當前的查詢或在哪個表

登入成功畫面

![image](https://github.com/abc7559485/DBproject/assets/153478133/5d8225eb-3fec-4c06-8a80-16b9a5e794cb)

查表畫面

![image](https://github.com/abc7559485/DBproject/assets/153478133/4085e874-caac-44e7-bd8d-9f84f78ccd12)

## 查詢結果

查詢一：•	Suppose that it is found that transmissions made by supplier Getrag between two given dates are defective. Find the VIN of each car containing such a transmission and the customer to which it was sold. If your design allows, suppose the defective transmissions all come from only one of Getrag’s plants.

![image](https://github.com/abc7559485/DBproject/assets/153478133/a5faab2c-3e8c-428c-9d00-5c651248d9ee)

查詢二：•	Find the dealer who has sold the most (by dollar-amount) in the past year.

![image](https://github.com/abc7559485/DBproject/assets/153478133/c172578a-f422-4b1a-a070-b49f75edcec6)


查詢三：•	Find the top 2 brands by unit sales in the past year.

![image](https://github.com/abc7559485/DBproject/assets/153478133/e1cb41b8-0944-4d51-bd9e-d429fbefe437)


查詢四：•	In what month(s) do SUVs sell best?

![image](https://github.com/abc7559485/DBproject/assets/153478133/72e9897e-1a7a-428a-9b4e-e536f3b5f03d)


查詢五：•	Find those dealers who keep a vehicle in inventory for the longest average time.

![image](https://github.com/abc7559485/DBproject/assets/153478133/a8206f82-109e-4729-99a1-a155de520b9e)
