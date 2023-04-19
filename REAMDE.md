# Evaluating the Pngquant

[NineBreakHomePageのスクリーンショット画像が大きすぎる](https://github.com/kazurayam/NineBreakHomePage/issues/62)


[PNG圧縮ツールpngquantの使い方を解説](https://qiita.com/YutaManaka/items/bb5f634f7233e6a4ff49)

https://pngquant.org/

## やってみた

```
$ ls -la
total 122848
drwxr-xr-x  8 kazuakiurayama  staff       256  4 19 17:27 .
drwxr-xr-x  4 kazuakiurayama  staff       128  4 19 17:25 ..
-rw-r--r--  1 kazuakiurayama  staff   1958860  4 19 17:27 36d37ce9da868a38de0306b2eef61c7e29bc7fa7.png
-rw-r--r--  1 kazuakiurayama  staff  16431923  4 19 17:25 71c08bd06b8540bc90f00d78ffc3474b6b5bd16c.png
-rw-r--r--  1 kazuakiurayama  staff  30059506  4 19 17:26 85fce7ffec419dc0e190238d222bab7f28605be3.png
-rw-r--r--  1 kazuakiurayama  staff   4421991  4 19 17:26 9d302388f498655ff83b7bf09300b9349da180a4.png
-rw-r--r--  1 kazuakiurayama  staff   5836625  4 19 17:26 b2b76409ff6e9009d4f2f51e686c1c292448a5f3.png
-rw-r--r--  1 kazuakiurayama  staff   4181715  4 19 17:27 dbbb8ecfe2d956cfc9b6960011608d0fff363917.png
:~/tmp/store/NineBreak/20230419_172442/objects
$ pngquant ./*.png
:~/tmp/store/NineBreak/20230419_172442/objects
$ ls -la
total 188552
drwxr-xr-x  14 kazuakiurayama  staff       448  4 19 21:14 .
drwxr-xr-x   4 kazuakiurayama  staff       128  4 19 17:25 ..
-rw-r--r--   1 kazuakiurayama  staff   1233052  4 19 21:14 36d37ce9da868a38de0306b2eef61c7e29bc7fa7-fs8.png
-rw-r--r--   1 kazuakiurayama  staff   1958860  4 19 17:27 36d37ce9da868a38de0306b2eef61c7e29bc7fa7.png
-rw-r--r--   1 kazuakiurayama  staff   8769633  4 19 21:14 71c08bd06b8540bc90f00d78ffc3474b6b5bd16c-fs8.png
-rw-r--r--   1 kazuakiurayama  staff  16431923  4 19 17:25 71c08bd06b8540bc90f00d78ffc3474b6b5bd16c.png
-rw-r--r--   1 kazuakiurayama  staff  14035092  4 19 21:14 85fce7ffec419dc0e190238d222bab7f28605be3-fs8.png
-rw-r--r--   1 kazuakiurayama  staff  30059506  4 19 17:26 85fce7ffec419dc0e190238d222bab7f28605be3.png
-rw-r--r--   1 kazuakiurayama  staff   2697787  4 19 21:14 9d302388f498655ff83b7bf09300b9349da180a4-fs8.png
-rw-r--r--   1 kazuakiurayama  staff   4421991  4 19 17:26 9d302388f498655ff83b7bf09300b9349da180a4.png
-rw-r--r--   1 kazuakiurayama  staff   3499577  4 19 21:14 b2b76409ff6e9009d4f2f51e686c1c292448a5f3-fs8.png
-rw-r--r--   1 kazuakiurayama  staff   5836625  4 19 17:26 b2b76409ff6e9009d4f2f51e686c1c292448a5f3.png
-rw-r--r--   1 kazuakiurayama  staff   2616970  4 19 21:14 dbbb8ecfe2d956cfc9b6960011608d0fff363917-fs8.png
-rw-r--r--   1 kazuakiurayama  staff   4181715  4 19 17:27 dbbb8ecfe2d956cfc9b6960011608d0fff363917.png
```

サイズが約４割減少した。
いいんじゃないか。
使える。

