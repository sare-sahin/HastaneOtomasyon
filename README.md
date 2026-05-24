🚀 HASTANE OTOMASYON SİSTEMİ


PROJENİN AMACI:
Bu proje hastanelerdeki randevu, doktor, hasta ve tıbbi kayıt süreçlerini optimize etmek amacıyla geliştirilmiş, güvenlik ve veri tutarlılığını odak noktasına alan full-stack bir web uygulamasıdır.

🛠️ KULLANILAN TEKNOLOJİLER & MİMARİ
• Backend: Java 17, Spring Boot, Spring Data JPA
• Güvenlik: Spring Security (JWT / Role-Based Access Control - Admin, Doctor, Patient)
• Veritabanı: PostgreSQL / MySQL
• Frontend: React.js / Angular
• Araçlar & Versiyon Yönetimi: Maven, Git, GitHub (Gitflow prensiplerine uygun commit yönetimi)

🎯 Öne Çıkan Teknik Detaylar
• Gelişmiş Güvenlik Katmanı: Spring Security kullanılarak, hastaların kişisel verilerinin korunması amacıyla katı bir yetkilendirme mekanizması kuruldu. Yetkisiz erişim denemeleri (401/03) custom exception handler yapıları ile yönetildi.
• Veritabanı İlişkileri: Çoktan çoğa (ManyToMany) ve bire çok (OneToMany) ilişkiler performans optimizasyonu (Lazy Loading) gözetilerek kurgulandı.
• Temiz Kod (Clean Code): Katmanlı mimari (Controller, Service, Repository, DTO) kullanılarak kodun okunabilirliği ve test edilebilirliği artırıldı.
