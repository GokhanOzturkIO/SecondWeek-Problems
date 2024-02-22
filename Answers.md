# 1- Temel Türler & Null Güvenliği

## 1.1- `val` ile `var` arasındaki fark nedir?
val: Bir kere değer ataması yapıldıktan sonra değeri sadece okunabilir. Tekrardan değer ataması yapılamaz. Read only diye geçer. <p>
var: Değerine istenildiği kadar tekrardan atama yapılabilir. Re-assignable olarak geçer.

## 1.2- Bir `var` değişkeni `val` gibi davranmasını nasıl sağlayabiliriz `val` kelimesini kullanmadan? Bunu neden yapmak isteriz? Örnek bir senaryo verin.
Bir class içerisinde var olarak kullanılan değişkenin set method'unu private yaparak val'a benzetebiliriz. Bu şekilde class içerisinde değişkenin değeri değiştirilebilir fakat class dışından değeri okunabilirken değiştirilemez. Bunu tam olarak anlattığım şekilde dışarından sadece değerinin okunması fakat değiştirilmemesi için kullanabiliriz.

