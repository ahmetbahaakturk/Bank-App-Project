Bu README dosyasını daha profesyonel bir şekilde tasarlayarak, yazı fontunu büyüttüm ve bazı kısımlarını düzelttim:

---

# Sıradan Bank

Java Swing kullanılarak geliştirilen Sıradan Bank, banka otomasyon işlemlerini kullanıcı dostu bir arayüz ile gerçekleştirir. Bu uygulama, müşterilerin hesap işlemlerini yönetmelerini sağlar ve temel bankacılık fonksiyonlarını içerir. Müşteri bilgilerini güvenli bir şekilde yönetir.

---

## UML Diyagramı

![Resim A.0: Giriş UML Diyagramı](https://github.com/ahmetbahaakturk/Bank-App-Project/assets/116023192/fb5c1058-0276-4276-b888-cbcae4efc517)

---

## Veritabanı Yapısı

- **User (Kullanıcı):**
    - Kullanıcıları temsil eden tablodur.
    - Bir kullanıcının birden fazla Transaction (işlem) ile ilişkisi vardır. İlişkiler iki şekilde olur: Kullanıcı gönderen konumunda olabilir ya da alıcı konumunda olabilir.
    - Ayrıca, bir kullanıcının birden fazla BankResource (banka hesabı) ile ilişkisi vardır.

- **Transaction (İşlem):**
    - Banka işlemlerini temsil eden tablodur. Currency (kur) ve Receipt (makbuz) tablolarıyla ilişkisi bulunmaktadır.

- **BankResource (Banka Kaynağı):**
    - Kullanıcının banka hesaplarını temsil eder. Kullanıcı, farklı kurlara sahip hesaplara sahip olabilir.

- **Currency (Kur):**
    - Kur değerlerini temsil eden tablodur.

---

## Uygulama Nasıl Çalışır?

- **Giriş Sayfası:**
    - Kullanıcı uygulamayı ilk açtığında, giriş sayfası ile karşılaşır. Kayıtlı kullanıcılar, giriş yaparak ana sayfaya yönlendirilir.
    - Eğer kullanıcı henüz kayıtlı değilse, kayıt olma sayfasına yönlendirilir.

![Screenshot 2024-04-28 215633](https://github.com/ahmetbahaakturk/Bank-App-Project/assets/116023192/7a5cb91e-de21-472d-822d-ab655d5c1d35)

- **Kayıt Olma Sayfası:**
    - Kullanıcılar bu sayfada sisteme kayıt olabilir. Kayıt işlemi tamamlandıktan sonra, giriş sayfasına yönlendirilir.

![Screenshot 2024-04-28 215936](https://github.com/ahmetbahaakturk/Bank-App-Project/assets/116023192/660d6bee-183b-4adc-929e-8e0a172c2519)

- **Ana Sayfa:**
    - Ana sayfada, kullanıcı hesaplarındaki bakiyeleri görüntüleyebilir. Toplam kaynağı TL cinsinden görebilir ve son işlemleri inceleyebilir.
    - Bu sayfada ayrıca "Karanlık Mod" geçiş tuşu da bulunmaktadır; kullanıcı bu tuşa basarak temalar arasında geçiş yapabilir.

![Screenshot 2024-04-28 220036](https://github.com/ahmetbahaakturk/Bank-App-Project/assets/116023192/4bad55d4-cc04-423e-9b0e-b31afe0bd583)
![Screenshot 2024-04-28 220139](https://github.com/ahmetbahaakturk/Bank-App-Project/assets/116023192/8613348e-58ca-473a-a08f-423f963a8d80)

- **Para Yatırma ve Çekme:**
    - Kullanıcı, bu sayfada para yatırmak veya çekmek istediği kuru seçer ve işlem yapmak istediği miktarı girer. Ayrıca mevcut bakiyesini de görüntüleyebilir.

![Screenshot 2024-04-28 220204](https://github.com/ahmetbahaakturk/Bank-App-Project/assets/116023192/f106bf18-0990-4c21-87c2-17507dde8ca0)

- **Para Transferi:**
    - Bu sayfada, kullanıcı başka bir kişiye para göndermek için alıcının T.C. Kimlik No.sunu ve göndermek istediği miktarı girer. Ayrıca, işlem açıklaması da ekleyebilir.

![Screenshot 2024-04-28 220234](https://github.com/ahmetbahaakturk/Bank-App-Project/assets/116023192/a4999167-eb8b-4bac-add5-e065e0a172dc)

- **Döviz Değişimi:**
    - Kullanıcı bu sayfada kendi hesapları arasında döviz değişimi yapabilir.

![Screenshot 2024-04-28 220417](https://github.com/ahmetbahaakturk/Bank-App-Project/assets/116023192/efe2884b-252a-4f66-a777-f3d890be1c46)

---

Bu şekilde, okunabilirliği artırmak ve profesyonel bir izlenim bırakmak için başlıkları belirgin hale getirdim ve font boyutunu artırdım. Ayrıca görsel içerikleri daha iyi bir şekilde yapılandırarak uygulamanın nasıl çalıştığını adım adım açıkladım.