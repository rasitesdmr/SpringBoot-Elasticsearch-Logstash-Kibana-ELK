# 🎯 ELK NEDİR ?

<p align ="center">
<img src = "elk1">
</p>

* ELK, Elasticsearch, Logstash ve Kibana'nın baş harflerinden oluşan bir kısaltmadır ve bu üç açık kaynaklı aracın
  birleşimini ifade eder.

* ELK, büyük miktarda veriyi depolamak, analiz etmek ve görselleştirmek için kullanılan popüler bir log yönetimi ve
  analitik platformudur.

* ELK ya neden ihtiyaç duyarız ?
  
1-)Büyük veri analizi: Günümüzde şirketler ve organizasyonlar, büyük miktarda veriyle başa çıkmak zorundadır. ELK, bu
  verileri hızlı ve etkili bir şekilde analiz etmeyi, anlamayı ve değerlendirmeyi sağlar.

2-) Log yönetimi: Sistemler, uygulamalar ve ağlar sürekli olarak log üretir. Bu logları yönetmek ve analiz etmek
  karmaşık ve zorlu bir görev olabilir. ELK, bu süreci basitleştirir ve daha düzenli hale getirir.

3-) Performans izleme: ELK, sistem performansını ve uygulama hatalarını gerçek zamanlı olarak izlemeye ve analiz etmeye
yardımcı olur. Bu, daha hızlı ve etkili bir şekilde sorunları tespit etmek ve çözmek için kullanılabilir.

4-) Güvenlik analizi: ELK, güvenlik olaylarını ve ihlallerini izlemeye ve analiz etmeye yardımcı olur. Bu, güvenlik
açıklarının ve tehditlerin belirlenmesi ve önlenmesi için önemlidir.

5-) Ölçeklenebilirlik: ELK stack, büyük miktarda veriyi işlemek için yüksek düzeyde ölçeklenebilir bir çözüm sunar. Bu,
artan veri hacimleri ve kullanıcı talepleriyle başa çıkmak için önemlidir.

6-) Merkezi izleme ve yönetim: ELK, farklı kaynaklardan gelen verileri tek bir platformda toplayarak, merkezi bir izleme
ve yönetim noktası sağlar. Bu, veri analizi ve yönetimi süreçlerini daha etkili ve verimli hale getirir.

7-) Görselleştirme: Kibana, verilere dayalı anlaşılır ve etkileşimli görselleştirmeler sunarak, kullanıcıların daha iyi
içgörüler elde etmelerine ve verilerin daha iyi anlaşılmasına olanak tanır.

8-) Kolay entegrasyon: ELK stack, çeşitli uygulamalar, sistemler ve hizmetlerle kolayca entegre edilebilir. Bu, ELK'nin
mevcut altyapı ve süreçlere hızlı ve kolay bir şekilde adapte edilmesini sağlar.

* Peki nedir bu Elasticsearch , Logstash , Kibana .

## 📌 Elasticsearch Nedir ?

<p align ="center">
<img src = "elk2">
</p>

* ELK yığınının kalbi ve merkezi depolama sistemidir.

* Elasticsearch, dağıtık, gerçek zamanlı ve çok yönlü bir arama ve analitik motorudur.

* Büyük verileri hızlı bir şekilde işlemek ve aramak için ölçeklenebilir ve kullanıcı dostu bir yapı sunar.

* Elasticsearch, verileri indeksler ve yapılandırır, böylece son kullanıcılar verileri hızlı bir şekilde sorgulayabilir.

| Terms      | Explanation                                                                                                                                                                                                                                                                          |
|------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `Node`     | Bir Elasticsearch örneğidir ve genellikle tek bir sunucuda çalışır. Birden fazla düğüm (node), bir Elasticsearch kümesini (cluster) oluşturmak için bir araya gelir. Node'lar, veri saklama, sorgulama ve işleme işlemlerini gerçekleştirir.                                         |
| `Cluster`  | Birden fazla düğümün (node) bir araya gelerek oluşturduğu, genellikle aynı veri kümesini saklayan ve paylaşan bir yapıdır. Cluster, yüksek düzeyde ölçeklenebilirlik, hız ve güvenilirlik sağlamak için düğümler arasında veri ve işlemleri dağıtır.                                 |
| `Index`    | Elasticsearch'te, belgelerin (dokümanlar) yapılandırıldığı ve saklandığı temel veri yapısıdır. Bir index, belgeleri ve onların özelliklerini (field) sorgulamak ve aramak için kullanılabilir. İndeksler, belgeleri hızlı bir şekilde bulmak için optimize edilmiştir.               |
| `Document` | Elasticsearch'te saklanan ve indekslenen temel veri birimidir. Belgeler (dokümanlar), JSON formatında verileri içerir ve belirli bir yapıya (mapping) sahiptir. Belge içindeki her veri parçası bir field olarak adlandırılır.                                                       |
| `Shard`    | Elasticsearch'te, bir index'in birden fazla parçaya bölünmüş hali olarak tanımlanır. Shard'lar, veri ve işlemleri düğümler arasında dağıtmak için kullanılır. Bu, yüksek düzeyde ölçeklenebilirlik ve performans sağlar. Shard'lar iki türe ayrılır: primary shard ve replica shard. |

## 📌 Logstash Nedir ?

<p align ="center">
<img src = "elk3">
</p>

* Log yönetimi ve veri toplama aracıdır. Logstash, farklı kaynaklardan (örn. sunucular, uygulamalar, veritabanları)
  gelen verileri toplar, işler ve Elasticsearch'e gönderir.

* Veri toplama, filtreleme ve dönüştürme gibi işlemleri gerçekleştirir, böylece Elasticsearch verileri daha etkili bir
  şekilde saklayabilir ve sorgulayabilir.

| Terms                | Explanation                                                                                                                                                                                                                                                                                                                                                                                                                                     |
|----------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `Input (Giriş) `     | Logstash'in veri almak için kullandığı giriş noktalarıdır. Girişler, veriyi çeşitli kaynaklardan (örneğin, log dosyaları, sistem olay günlükleri, ağ trafiği veya mesaj kuyrukları gibi) alır. Logstash, farklı türde veri kaynakları için çok sayıda giriş eklentisi sunar.                                                                                                                                                                    |
| `Codec (Kodlayıcı) ` | Logstash, gelen veriyi kodlamak ve/veya çözmek için kodlayıcıları kullanır. Kodlayıcılar, verinin uygun biçimde işlenmesini ve depolanmasını sağlar. Örneğin, JSON, XML veya düz metin gibi veri formatları için farklı kodlayıcılar kullanılabilir.                                                                                                                                                                                            |
| `Filter (Filtre) `   | Logstash, verileri işlemek, dönüştürmek ve düzenlemek için filtreleri kullanır. Filtreler, veriyi analiz etmeye, anlamaya ve hataları tespit etmeye yardımcı olur. Logstash, çeşitli filtre eklentileri sunarak verilerin farklı şekillerde işlenmesine olanak tanır. Örnek filtreler arasında grok (log mesajlarını ayrıştırmak için), mutate (veri dönüşümü gerçekleştirmek için) ve date (tarih bilgilerini standartlaştırmak için) bulunur. |
| `Output (Çıkış) `    | Logstash'in veriyi depolamak veya başka bir hedefe göndermek için kullandığı çıkış noktalarıdır. Çıkışlar, veriyi Elasticsearch, Kafka, syslog, e-posta veya başka bir depolama ve analiz sistemine gönderebilir. Logstash, çok sayıda çıkış eklentisi ile birlikte gelir ve farklı hedeflere veri iletmeye imkan tanır.                                                                                                                        |

## 📌 Kibana Nedir ?

<p align ="center">
<img src = "elk4">
</p>

* Veri görselleştirme ve analiz aracıdır. Kibana, Elasticsearch üzerinde saklanan verilere dayalı olarak görsel ve
  etkileşimli grafikler, haritalar ve tablolar oluşturur.

* Bu, kullanıcıların verileri daha iyi anlamalarına ve belirli olaylar, eğilimler veya sorunlar hakkında bilgi
  edinmelerine yardımcı olur.

| Terms                 | Explanation                                                                                                                                                                                                                                                                                                                                                                                                                                      |
|-----------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `Dashboard `          | Görselleştirmelerin (visualization) bir araya getirildiği ve düzenlendiği paneldir. Dashboard'lar, belirli bir amaç veya hikaye anlatmak için birden fazla görselleştirme ve panelden oluşabilir. Kullanıcılar, dashboard'ları kaydedebilir, paylaşabilir ve yeniden kullanabilir.                                                                                                                                                               |
| `Visualization `      | Elasticsearch verilerini görsel olarak temsil etmek için kullanılan bileşendir. Kibana, farklı türde görselleştirme seçenekleri sunar, örneğin, çizgi grafikleri, pasta grafikleri, bar grafikleri, haritalar ve tablolar. Görselleştirmeler, kullanıcıların verilere dayalı bilgi ve içgörü elde etmelerine yardımcı olur.                                                                                                                      |
| `Index Pattern `      | Kibana, Elasticsearch indekslerindeki verilere erişmek ve sorgulamak için index pattern kullanır. Bir index pattern, belirli bir veya birden fazla indeksi tanımlayan bir karakter dizisidir. Index pattern, Kibana'nın hangi indekslerle çalışması gerektiğini belirler ve görselleştirmelerin ve sorguların temelini oluşturur.                                                                                                                |
| `Saved Search `       | Kibana'da gerçekleştirilen ve daha sonra tekrar kullanılabilen bir arama sorgusudur. Saved Search, dashboard'larda kullanılabilir ve belirli bir arama sorgusuna dayalı görselleştirmeler oluşturmak için kullanılabilir.                                                                                                                                                                                                                        |
| `Aggregation `        | Elasticsearch'teki veriler üzerinde özetleme veya istatistiksel analiz gerçekleştirmek için kullanılan işlemdir. Kibana, görselleştirmeler oluştururken bu özetleme işlemlerini kullanır. Aggregation türleri arasında metrik (ortalama, toplam, min, max), bucket (kategorilere ayırma) ve boru hattı (aggregation sonuçları üzerinde işlem yapma) bulunur.                                                                                     |
| `Query `              | Elasticsearch verilerini sorgulamak ve filtrelemek için kullanılan ifadelerdir. Kibana, verileri aramak, görselleştirmeler oluşturmak ve dashboard'larda göstermek için sorguları kullanır.                                                                                                                                                                                                                                                      |
| `Filter `             | Kibana'da, görselleştirmelerde veya dashboard'larda gösterilecek veriyi belirli kriterlere göre sınırlamak için kullanılan koşullardır. Filtreler, veri analizinde daha spesifik ve odaklı sonuçlar elde etmek için kullanılabilir.                                                                                                                                                                                                              |
