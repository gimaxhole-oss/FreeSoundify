# Free Soundify — Fabric 1.21.11

Projek mod client-side untuk Minecraft Java 1.21.11.

## Efek yang disertakan
- Bunyi tambahan saat GUI dibuka dan ditutup.
- Bunyi klik saat klik pada elemen GUI yang berhasil diproses.
- Aksen bunyi saat mulai memukul atau menggunakan block.
- Cooldown singkat pada bunyi interaksi block supaya tidak terlalu berulang.

## Penting
Ini ialah implementasi buatan sendiri yang mengambil inspirasi daripada penerangan pada gambar rujukan. Ia **bukan salinan kod atau aset asal Soundify** dan belum boleh dianggap sama 100% dengan mod asal.

## Keperluan
- Minecraft Java 1.21.11
- Fabric Loader 0.19.3 atau lebih baharu
- Fabric API 0.141.6+1.21.11
- Java 21 untuk menjalankan Minecraft; Java/Gradle yang sesuai diperlukan untuk membina projek.

## Membina fail JAR
1. Buka projek ini dalam komputer dengan Gradle dan Java yang sesuai.
2. Jalankan `gradle build`.
3. Fail mod akan terhasil dalam `build/libs/` dengan nama `free-soundify-1.0.0.jar`.
4. Salin fail JAR itu ke folder `mods` profil Fabric dalam Zalith Launcher.
5. Pastikan Fabric API juga ada dalam folder `mods`.

## Nota untuk Zalith Launcher
ZIP ini ialah **projek sumber**, bukan fail JAR siap pasang. Ia perlu dibina dahulu. Jangan letakkan ZIP projek ini ke folder `mods`.


## Build automatik melalui GitHub Actions (boleh dibuat dari HP)
1. Ekstrak ZIP projek ini menggunakan ZArchiver.
2. Di laman GitHub, cipta repository baharu dan kosong.
3. Muat naik kandungan folder projek (termasuk folder tersembunyi `.github`). Pastikan `build.gradle` berada di akar repository.
4. Buka tab Actions dan jalankan workflow **Build Free Soundify**.
5. Jika berjaya, buka run yang selesai dan muat turun artifact **FreeSoundify-JAR**.
6. Ekstrak artifact ZIP; fail `.jar` di dalamnya boleh disalin ke folder `mods` profil Fabric.

Nota: ZIP ini masih projek sumber, bukan JAR siap. Workflow perlu dijalankan; jika build gagal, kongsi log ralat untuk diperiksa.
