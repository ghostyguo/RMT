# RMT

這是寫給 RMT 地震研究用的 Java 程式, 功能是抓取 RMT 圖檔作為紀錄, 存檔後可以用 ffmpeg 轉成影片. 使用這個程式需先安裝兩個必要程式:  

* Java JDK : 提供 Java 執行環境, 下載位置是 http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html , 先點選下方的 Accept License Agreement, 然後再選擇 win32 或 win64 版本, 直接安裝即可.  

* wget for windows: 提供抓取網路檔案的功能, 下載位置是 http://downloads.sourceforge.net/gnuwin32/wget-1.11.4-1-setup.exe.  

下載後直接執行 RMT.bat 即可. 要製作影片時, 將選定時間範圍的所有影片複製到 ffmpeg\pictures 目錄下, 進入 dos 視窗, 先切換到 ffmpeg 目錄, 執行 ff-setenv.bat 設定執行環境, 然後再執行 ff-conv.bat 即可編成影片檔輸出.
